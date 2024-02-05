package com.spring.store.service.customer;



import com.spring.store.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> findAll();
    CustomerDto save(CustomerDto customerDto);
    CustomerDto findById(Long id);
    void deleteById(Long id);
    CustomerDto update(CustomerDto customerDto);
}
