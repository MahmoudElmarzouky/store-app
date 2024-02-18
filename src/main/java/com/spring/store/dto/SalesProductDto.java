package com.spring.store.dto;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalesProductDto {
    private Long id;
    private String name;
    private BigDecimal sellPrice;
    private BigDecimal discount;
    private int amount;
}
