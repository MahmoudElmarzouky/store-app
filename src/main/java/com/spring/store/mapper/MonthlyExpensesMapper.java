package com.spring.store.mapper;


import com.spring.store.dto.MonthlyExpensesDto;
import com.spring.store.entity.MonthlyExpenses;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MonthlyExpensesMapper {
    MonthlyExpensesDto mapToMonthlyExpensesDto(MonthlyExpenses monthlyExpenses);
    MonthlyExpenses mapToMonthlyExpenses(MonthlyExpensesDto monthlyExpensesDto);
    List<MonthlyExpensesDto> mapToMonthlyExpensesDtos(List<MonthlyExpenses> monthlyExpenses);
}
