package com.spring.store.service.product;

import com.spring.store.dto.ProductDto;
import com.spring.store.dto.SalesProductDto;

import java.util.List;

public interface ProductService {
    public List<ProductDto> findAll();
    public ProductDto save(ProductDto productDto);
    public ProductDto findById(Long id);
    public void deleteById(Long id);
    public ProductDto update(ProductDto productDto);

    Boolean isAmountAvailable(Long id, int amount);
    int getProductAmountById(Long id);
    int updateAmountById(Long id,int amount);

    List<SalesProductDto> getSalesProducts();
}
