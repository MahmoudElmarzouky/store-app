package com.spring.store.dto;

import com.spring.store.entity.Bill;
import com.spring.store.entity.Customer;
import com.spring.store.entity.Product;
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
public class SalesDto {
    private Long id;
    private BigDecimal pricePerOne;
    private BigDecimal discount;
    private BigDecimal totalPrice;
    private LocalDateTime dateTime;
    private Long productId;
    private Long billId;
    private Long customerId;
}
