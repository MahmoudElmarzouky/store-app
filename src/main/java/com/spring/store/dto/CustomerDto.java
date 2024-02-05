package com.spring.store.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto {
    private Long id;
    private String name;
    private String phone;
    private LocalDate date;
}
