package com.spring.store.service.salaryHistory;

import com.spring.store.dto.SalaryHistoryDto;
import com.spring.store.entity.SalaryHistory;
import com.spring.store.exception.EntityNotFoundException;
import com.spring.store.mapper.SalaryHistoryMapper;
import com.spring.store.repository.salaryHistory.SalaryHistoryRepository;
import com.spring.store.service.salaryHistory.SalaryHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryHistoryServiceImpl implements SalaryHistoryService {
    private SalaryHistoryMapper salaryHistoryMapper;
    private SalaryHistoryRepository salaryHistoryRepository;

    public SalaryHistoryServiceImpl(SalaryHistoryMapper salaryHistoryMapper, SalaryHistoryRepository salaryHistoryRepository) {
        this.salaryHistoryMapper = salaryHistoryMapper;
        this.salaryHistoryRepository = salaryHistoryRepository;
    }

    @Override
    public List<SalaryHistoryDto> findAll() {
        return salaryHistoryMapper.mapToSalaryHistoryDtos(salaryHistoryRepository.findAll());
    }

    @Override
    public SalaryHistoryDto save(SalaryHistoryDto salaryHistoryDto) {
        salaryHistoryDto.setId(0L);
        SalaryHistory salaryHistory= salaryHistoryRepository.save(salaryHistoryMapper.mapToSalaryHistory(salaryHistoryDto));
        return salaryHistoryMapper.mapToSalaryHistoryDto(salaryHistory);
    }

    @Override
    public SalaryHistoryDto findById(Long id) {
        Optional<SalaryHistory> salaryHistory=salaryHistoryRepository.findById(id);
        if(!salaryHistory.isPresent())
            throw new EntityNotFoundException("no salaryHistory with id :"+id);
        return salaryHistoryMapper.mapToSalaryHistoryDto(salaryHistory.get());
    }

    @Override
    public void deleteById(Long id) {
        Optional<SalaryHistory> salaryHistory=salaryHistoryRepository.findById(id);
        if(!salaryHistory.isPresent())
            throw new EntityNotFoundException("can not delete , no salaryHistory with id :"+id);
        salaryHistoryRepository.deleteById(id);
    }

    @Override
    public SalaryHistoryDto update(SalaryHistoryDto salaryHistoryDto) {
        Optional<SalaryHistory> salaryHistory=salaryHistoryRepository.findById(salaryHistoryDto.getId());
        if(!salaryHistory.isPresent())
            throw new EntityNotFoundException("can not update,no salaryHistory with id :"+salaryHistoryDto.getId());
        SalaryHistory salaryHistoryUpdated= salaryHistoryRepository.save(salaryHistoryMapper.mapToSalaryHistory(salaryHistoryDto));
        return salaryHistoryMapper.mapToSalaryHistoryDto(salaryHistoryUpdated);
    }
}
