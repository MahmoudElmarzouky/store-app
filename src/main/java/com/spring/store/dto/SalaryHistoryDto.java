package com.spring.store.dto;

import com.spring.store.entity.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalaryHistoryDto {
    private Long id;
    private BigDecimal baseSalary;
    private BigDecimal deduction;
    private BigDecimal bonus;
    private BigDecimal totalSalary;
    private LocalDateTime dateTime;
    private EmployeeDto employee;
}
