package com.spring.store.controller.employee;


import com.spring.store.dto.EmployeeDto;
import com.spring.store.service.employee.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getEmployees(){
        List<EmployeeDto> employeeDtos=employeeService.findAll();
      return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id){
        EmployeeDto employeeDto=employeeService.findById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
    @PostMapping("/employees")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employee =employeeService.save(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PutMapping("/employees")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employee =employeeService.update(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteCEmployee(@PathVariable Long id){
        employeeService.deleteById(id);
        return new ResponseEntity<>("Employee Deleted !!", HttpStatus.OK);
    }
}
