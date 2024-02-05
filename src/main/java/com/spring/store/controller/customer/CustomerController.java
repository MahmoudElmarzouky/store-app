package com.spring.store.controller.customer;

import com.spring.store.dto.CustomerDto;
import com.spring.store.service.customer.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getCustomers(){
        List<CustomerDto> customerDtos=customerService.findAll();
      return new ResponseEntity<>(customerDtos, HttpStatus.OK);
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id){
        CustomerDto customerDto=customerService.findById(id);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }
    @PostMapping("/customers")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto customer =customerService.save(customerDto);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @PutMapping("/customers")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto customer=customerService.update(customerDto);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
         customerService.deleteById(id);
        return new ResponseEntity<>("Customer Deleted !!", HttpStatus.OK);
    }
}
