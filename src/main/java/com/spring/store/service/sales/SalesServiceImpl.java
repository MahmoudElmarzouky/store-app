package com.spring.store.service.sales;

import com.spring.store.dto.SalesDto;
import com.spring.store.entity.Sales;
import com.spring.store.exception.EntityNotFoundException;
import com.spring.store.mapper.SalesMapper;
import com.spring.store.repository.sales.SalesRepository;
import com.spring.store.service.sales.SalesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService{
    private SalesMapper salesMapper;
    private SalesRepository salesRepository;

    public SalesServiceImpl(SalesMapper salesMapper, SalesRepository salesRepository) {
        this.salesMapper = salesMapper;
        this.salesRepository = salesRepository;
    }

    @Override
    public List<SalesDto> findAll() {
        return salesMapper.mapToSalesDtos(salesRepository.findAll());
    }

    @Override
    public SalesDto save(SalesDto salesDto) {
        salesDto.setId(0L);
        Sales sales= salesRepository.save(salesMapper.mapToSales(salesDto));
        return salesMapper.mapToSalesDto(sales);
    }

    @Override
    public SalesDto findById(Long id) {
        Optional<Sales> sales=salesRepository.findById(id);
        if(!sales.isPresent())
            throw new EntityNotFoundException("no sales with id :"+id);
        return salesMapper.mapToSalesDto(sales.get());
    }

}
