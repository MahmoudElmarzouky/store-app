package com.spring.store.service.sales;

import com.spring.store.dto.SalesDto;

import java.util.List;

public interface SalesService {
    List<SalesDto> findAll();
    SalesDto save(SalesDto salesDto);
    public SalesDto findById(Long id);
}
