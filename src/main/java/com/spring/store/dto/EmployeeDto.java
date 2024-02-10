package com.spring.store.dto;

import com.spring.store.entity.Role;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {
    private Long id;

    private String name;
    private String phone;
    private String email;
    private String userName;
    private String password;
    private boolean active;
    private BigDecimal baseSalary;
    private Set<RoleDto> rolesDto;
}
