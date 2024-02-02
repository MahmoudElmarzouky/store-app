package com.spring.store.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalPrice;
    private BigDecimal discount;
    private BigDecimal totalPriceWithDiscount;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    private String billNumber;
    private String billNumberPreDay;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}

