package com.spring.store.mapper;

import com.spring.store.dto.SalaryHistoryDto;
import com.spring.store.entity.SalaryHistory;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(uses = {EmployeeMapper.class})
public interface SalaryHistoryMapper {
    SalaryHistoryDto mapToSalaryHistoryDto(SalaryHistory salaryHistory);
    SalaryHistory mapToSalaryHistory(SalaryHistoryDto salaryHistoryDto);
    List<SalaryHistoryDto> mapToSalaryHistoryDtos(List<SalaryHistory> salaryHistories);
}
