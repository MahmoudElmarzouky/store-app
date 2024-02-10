package com.spring.store.service.monthlyExpenses;

import com.spring.store.dto.MonthlyExpensesDto;

import java.util.List;

public interface MonthlyExpensesService {
    List<MonthlyExpensesDto> findAll();
    MonthlyExpensesDto save(MonthlyExpensesDto monthlyExpensesDto);
    MonthlyExpensesDto findById(Long id);
    void deleteById(Long id);
    MonthlyExpensesDto update(MonthlyExpensesDto monthlyExpensesDto);
}
