package com.spring.store.service.sales;

import com.spring.store.dto.*;
import com.spring.store.entity.Bill;
import com.spring.store.entity.Employee;
import com.spring.store.entity.Product;
import com.spring.store.entity.Sales;
import com.spring.store.exception.EntityNotFoundException;
import com.spring.store.mapper.BillMapper;
import com.spring.store.mapper.ProductMapper;
import com.spring.store.mapper.SalesMapper;
import com.spring.store.repository.bill.BillRepository;
import com.spring.store.repository.sales.SalesRepository;
import com.spring.store.service.product.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService{
    private SalesMapper salesMapper;
    private BillMapper billMapper;
    private ProductMapper productMapper;
    private SalesRepository salesRepository;
    private BillRepository billRepository;
    private ProductService productService;

    public SalesServiceImpl(SalesMapper salesMapper, BillMapper billMapper, ProductMapper productMapper, SalesRepository salesRepository, BillRepository billRepository, ProductService productService) {
        this.salesMapper = salesMapper;
        this.billMapper = billMapper;
        this.productMapper = productMapper;
        this.salesRepository = salesRepository;
        this.billRepository = billRepository;
        this.productService = productService;
    }

    @Override
    public List<SalesDto> findAll() {
        return salesMapper.mapToSalesDtos(salesRepository.findAll());
    }

    @Override
    public SalesDto findById(Long id) {
        Optional<Sales> sales=salesRepository.findById(id);
        if(!sales.isPresent())
            throw new EntityNotFoundException("no sales with id :"+id);
        return salesMapper.mapToSalesDto(sales.get());
    }

    @Override
    @Transactional
    public BillDto SalesProduct(List<SalesProductDto> salesProductDtos,BigDecimal discount){
        BillDto billDto=getBillFromProducts(salesProductDtos,null,discount);
        Bill bill =billRepository.save(billMapper.mapToBill(billDto));
        for(SalesProductDto salesProductDto : salesProductDtos){
            Product product=productMapper.mapToProductFromSalesProductDto(salesProductDto);
            Sales sales = getSales(salesProductDto, product, bill);
            salesRepository.save(sales);
            int amount = productService.getProductAmountById(product.getId());
            productService.updateAmountById(product.getId(), amount-product.getAmount());
        }
        return billDto;
    }

    private static Sales getSales(SalesProductDto salesProductDto, Product product, Bill bill) {
        Sales sales=new Sales();
        sales.setProduct(product);
        sales.setBill(bill);
        sales.setDiscount(product.getDiscount());
        sales.setDateTime(LocalDateTime.now());
        sales.setPricePerOne(salesProductDto.getSellPrice());
        sales.setTotalPrice(salesProductDto.getSellPrice().subtract(salesProductDto.getDiscount()));
        return sales;
    }

    private BillDto getBillFromProducts (List<SalesProductDto> salesProductDtos, Employee employee, BigDecimal discount){
        BillDto billDto=new BillDto();
        BigDecimal totalSellPrice = salesProductDtos.stream()
                .map(SalesProductDto::getSellPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        billDto.setTotalPrice(totalSellPrice);
        billDto.setDiscount(discount);
        billDto.setTotalPriceWithDiscount(totalSellPrice.subtract(discount.multiply(totalSellPrice)).divide(new BigDecimal(100)));
        billDto.setBillNumber(getBillNumber(10));
        billDto.setBillNumberPreDay(getBllNumberPreDay());
        billDto.setDateTime(LocalDateTime.now());
        billDto.setEmployee(employee);
        return billDto;
    }
    private String getBillNumber(int len) {
        String billNumber = "";
        String generatorValue = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        for (int i = 0; i < len; i++) {
            int idx = (int) (Math.random() * generatorValue.length());
            billNumber += generatorValue.charAt(idx);
        }

        return billNumber;
    }
    private int getBllNumberPreDay(){
        Optional<Bill> billOptional=billRepository.findTopByOrderByDateTimeDesc();
        Bill bill=null;
        if(!billOptional.isPresent())
            return 1;
        bill=billOptional.get();
        if(bill.getDateTime()== LocalDateTime.now())
            return bill.getBillNumberPreDay()+1;
     return 1;
     }

}
