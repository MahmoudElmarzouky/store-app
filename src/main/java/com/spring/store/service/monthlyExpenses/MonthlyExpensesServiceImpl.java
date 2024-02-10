package com.spring.store.service.monthlyExpenses;

import com.spring.store.dto.MonthlyExpensesDto;
import com.spring.store.entity.MonthlyExpenses;
import com.spring.store.exception.EntityNotFoundException;
import com.spring.store.mapper.MonthlyExpensesMapper;
import com.spring.store.repository.monthlyExpenses.MonthlyExpensesRepository;
import com.spring.store.service.monthlyExpenses.MonthlyExpensesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonthlyExpensesServiceImpl implements MonthlyExpensesService {
    private MonthlyExpensesMapper monthlyExpensesMapper;
    private MonthlyExpensesRepository monthlyExpensesRepository;

    public MonthlyExpensesServiceImpl(MonthlyExpensesMapper monthlyExpensesMapper, MonthlyExpensesRepository monthlyExpensesRepository) {
        this.monthlyExpensesMapper = monthlyExpensesMapper;
        this.monthlyExpensesRepository = monthlyExpensesRepository;
    }

    @Override
    public List<MonthlyExpensesDto> findAll() {
        return monthlyExpensesMapper.mapToMonthlyExpensesDtos(monthlyExpensesRepository.findAll());
    }

    @Override
    public MonthlyExpensesDto save(MonthlyExpensesDto monthlyExpensesDto) {
        monthlyExpensesDto.setId(0L);
        MonthlyExpenses monthlyExpenses= monthlyExpensesRepository.save(monthlyExpensesMapper.mapToMonthlyExpenses(monthlyExpensesDto));
        return monthlyExpensesMapper.mapToMonthlyExpensesDto(monthlyExpenses);
    }

    @Override
    public MonthlyExpensesDto findById(Long id) {
        Optional<MonthlyExpenses> monthlyExpenses=monthlyExpensesRepository.findById(id);
        if(!monthlyExpenses.isPresent())
            throw new EntityNotFoundException("no monthlyExpenses with id :"+id);
        return monthlyExpensesMapper.mapToMonthlyExpensesDto(monthlyExpenses.get());
    }

    @Override
    public void deleteById(Long id) {
        Optional<MonthlyExpenses> monthlyExpenses=monthlyExpensesRepository.findById(id);
        if(!monthlyExpenses.isPresent())
            throw new EntityNotFoundException("can not delete , no monthlyExpenses with id :"+id);
        monthlyExpensesRepository.deleteById(id);
    }

    @Override
    public MonthlyExpensesDto update(MonthlyExpensesDto monthlyExpensesDto) {
        Optional<MonthlyExpenses> monthlyExpenses=monthlyExpensesRepository.findById(monthlyExpensesDto.getId());
        if(!monthlyExpenses.isPresent())
            throw new EntityNotFoundException("can not update,no monthlyExpenses with id :"+monthlyExpensesDto.getId());
        MonthlyExpenses monthlyExpensesUpdated= monthlyExpensesRepository.save(monthlyExpensesMapper.mapToMonthlyExpenses(monthlyExpensesDto));
        return monthlyExpensesMapper.mapToMonthlyExpensesDto(monthlyExpensesUpdated);
    }
}
