package com.spring.store.service.bill;

import com.spring.store.dto.BillDto;

import java.util.List;

public interface BillService {
    List<BillDto> findAll();
    BillDto save(BillDto billDto);
    BillDto findById(Long id);
    void deleteById(Long id);
    BillDto update(BillDto billDto);
}
