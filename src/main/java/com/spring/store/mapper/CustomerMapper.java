package com.spring.store.mapper;

import com.spring.store.dto.CustomerDto;
import com.spring.store.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerDto mapToCustomerDto(Customer customer);
    Customer mapToCustomer(CustomerDto customerDto);
    List<CustomerDto> mapToCustomerDtos(List<Customer> customers);
}
