package com.spring.store.service.customer;

import com.spring.store.dto.CustomerDto;
import com.spring.store.entity.Customer;
import com.spring.store.exception.EntityNotFoundException;
import com.spring.store.mapper.CustomerMapper;
import com.spring.store.repository.customer.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerMapper customerMapper;
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerMapper.mapToCustomerDtos(customerRepository.findAll());
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        customerDto.setId(0L);
        Customer customer= customerRepository.save(customerMapper.mapToCustomer(customerDto));
        return customerMapper.mapToCustomerDto(customer);
    }

    @Override
    public CustomerDto findById(Long id) {
        Optional<Customer> customer=customerRepository.findById(id);
        if(!customer.isPresent())
            throw new EntityNotFoundException("no customer with id :"+id);
        return customerMapper.mapToCustomerDto(customer.get());
    }

    @Override
    public void deleteById(Long id) {
        Optional<Customer> customer=customerRepository.findById(id);
        if(!customer.isPresent())
            throw new EntityNotFoundException("can not delete , no customer with id :"+id);
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDto update(CustomerDto customerDto) {
        Optional<Customer> customer=customerRepository.findById(customerDto.getId());
        if(!customer.isPresent())
            throw new EntityNotFoundException("can not update,no category with id :"+customerDto.getId());
        Customer customerUpdated= customerRepository.save(customerMapper.mapToCustomer(customerDto));
        return customerMapper.mapToCustomerDto(customerUpdated);
    }
}
