package com.spring.store.mapper;

import com.spring.store.dto.EmployeeDto;
import com.spring.store.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {RoleMapper.class})
public interface EmployeeMapper {
    @Mapping(source = "roles",target = "rolesDto")
    EmployeeDto mapToEmployeeDto(Employee employee);
    @Mapping(source = "rolesDto",target = "roles")
    Employee mapToEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> mapToEmployeeDtos(List<Employee> employees);
}
