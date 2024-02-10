package com.spring.store.service.employee;

import com.spring.store.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findAll();
    EmployeeDto save(EmployeeDto categoryDto);
    EmployeeDto findById(Long id);
    void deleteById(Long id);
    EmployeeDto update(EmployeeDto categoryDto);
}
