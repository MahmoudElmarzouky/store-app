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
public class BillDto {
    private Long id;
    private BigDecimal totalPrice;
    private BigDecimal discount;
    private BigDecimal totalPriceWithDiscount;
    private LocalDateTime dateTime;
    private String billNumber;
    private int billNumberPreDay;
    private Employee employee;

}
