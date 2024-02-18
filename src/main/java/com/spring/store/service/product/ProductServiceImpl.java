package com.spring.store.service.product;


import com.spring.store.dto.ProductDto;
import com.spring.store.dto.SalesProductDto;
import com.spring.store.entity.Product;
import com.spring.store.exception.EntityNotFoundException;

import com.spring.store.mapper.ProductMapper;
import com.spring.store.repository.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    private ProductMapper productMapper;
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> findAll() {
        return productMapper.mapToProductDtos(productRepository.findAll());
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        productDto.setId(0L);
        Product product= productRepository.save(productMapper.mapToProduct(productDto));
        return productMapper.mapToProductDto(product);
    }

    @Override
    public ProductDto findById(Long id) {
        Optional<Product> product=productRepository.findById(id);
        if(!product.isPresent())
            throw new EntityNotFoundException("no product with id :"+id);
        return productMapper.mapToProductDto(product.get());
    }

    @Override
    public void deleteById(Long id) {
        Optional<Product> product=productRepository.findById(id);
        if(!product.isPresent())
            throw new EntityNotFoundException("can not delete , no product with id :"+id);
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        Optional<Product> product=productRepository.findById(productDto.getId());
        if(!product.isPresent())
            throw new EntityNotFoundException("can not update,no product with id :"+productDto.getId());
        Product productUpdated= productRepository.save(productMapper.mapToProduct(productDto));
        return productMapper.mapToProductDto(productUpdated);
    }

    @Override
    public Boolean isAmountAvailable(Long id, int amount) {
        Optional<Product> product=productRepository.findById(id);
        if(!product.isPresent())
            throw new EntityNotFoundException("can not update,no product with id :"+id);
        if(amount>product.get().getAmount())
            return false;
        else
            return true;

    }

    @Override
    public int getProductAmountById(Long id) {
        Optional<Product> product=productRepository.findById(id);
        if(!product.isPresent())
            throw new EntityNotFoundException("no product with id :"+id);
        return productRepository.findAmountByProductId(id);
    }

    @Override
    public int updateAmountById(Long id, int amount) {
        return productRepository.updateProductAmount(id,amount);
    }

    @Override
    public List<SalesProductDto> getSalesProducts() {
        return productMapper.mapToSalesProductDtos(productRepository.findAll());
    }
}
