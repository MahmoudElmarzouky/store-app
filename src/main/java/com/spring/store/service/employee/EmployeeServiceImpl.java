package com.spring.store.service.employee;

import com.spring.store.dto.EmployeeDto;
import com.spring.store.entity.Employee;
import com.spring.store.exception.EntityNotFoundException;
import com.spring.store.mapper.EmployeeMapper;
import com.spring.store.repository.employee.EmployeeRepository;
import com.spring.store.service.employee.EmployeeService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeMapper employeeMapper;
    private EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;


    public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<EmployeeDto> findAll() {
        return employeeMapper.mapToEmployeeDtos(employeeRepository.findAll());
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        employeeDto.setId(0L);
        employeeDto.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        Employee employee= employeeRepository.save(employeeMapper.mapToEmployee(employeeDto));
        return employeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto findById(Long id) {
        Optional<Employee> employee=employeeRepository.findById(id);
        if(!employee.isPresent())
            throw new EntityNotFoundException("no employee with id :"+id);
        return employeeMapper.mapToEmployeeDto(employee.get());
    }

    @Override
    public void deleteById(Long id) {
        Optional<Employee> employee=employeeRepository.findById(id);
        if(!employee.isPresent())
            throw new EntityNotFoundException("can not delete , no employee with id :"+id);
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        Optional<Employee> employee=employeeRepository.findById(employeeDto.getId());
        if(!employee.isPresent())
            throw new EntityNotFoundException("can not update,no employee with id :"+employeeDto.getId());
        Employee employeeUpdated= employeeRepository.save(employeeMapper.mapToEmployee(employeeDto));
        return employeeMapper.mapToEmployeeDto(employeeUpdated);
    }
}
