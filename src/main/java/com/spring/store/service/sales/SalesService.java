package com.spring.store.service.sales;

import com.spring.store.dto.BillDto;
import com.spring.store.dto.ProductDto;
import com.spring.store.dto.SalesDto;
import com.spring.store.dto.SalesProductDto;
import com.spring.store.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface SalesService {
    List<SalesDto> findAll();
    public SalesDto findById(Long id);
    public BillDto SalesProduct(List<SalesProductDto> salesProductDtos, BigDecimal discount);
}
