package com.spring.store.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {

    private Long id;

    private String name;
    private BigDecimal buyPrice;
    private BigDecimal sellPrice;
    private BigDecimal discount;
    private int amount;
    private String serialNumber;
    private CategoryDto categoryDto;
}
