package com.spring.store.service.salaryHistory;

import com.spring.store.dto.SalaryHistoryDto;

import java.util.List;

public interface SalaryHistoryService {
    List<SalaryHistoryDto> findAll();
    SalaryHistoryDto save(SalaryHistoryDto salaryHistoryDto);
    SalaryHistoryDto findById(Long id);
    void deleteById(Long id);
    SalaryHistoryDto update(SalaryHistoryDto salaryHistoryDto);
}
