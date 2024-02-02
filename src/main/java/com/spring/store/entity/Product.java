package com.spring.store.entity;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal buyPrice;
    private BigDecimal sellPrice;
    private BigDecimal discount;
    private int amount;
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
