package com.spring.store.dto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MonthlyExpensesDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime dateTime;
    private String notice;
}