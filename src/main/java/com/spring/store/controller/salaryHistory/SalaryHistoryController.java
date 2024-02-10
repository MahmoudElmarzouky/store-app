package com.spring.store.controller.salaryHistory;

import com.spring.store.dto.SalaryHistoryDto;
import com.spring.store.service.salaryHistory.SalaryHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SalaryHistoryController {
    private SalaryHistoryService salaryHistoryService;

    public SalaryHistoryController(SalaryHistoryService salaryHistoryService) {
        this.salaryHistoryService = salaryHistoryService;
    }

    @GetMapping("/salaryHistories")
    public ResponseEntity<?> getCategories(){
        List<SalaryHistoryDto> salaryHistoryDtos=salaryHistoryService.findAll();
      return new ResponseEntity<>(salaryHistoryDtos, HttpStatus.OK);
    }
    @GetMapping("/salaryHistories/{id}")
    public ResponseEntity<?> getSalaryHistory(@PathVariable Long id){
        SalaryHistoryDto salaryHistoryDto=salaryHistoryService.findById(id);
        return new ResponseEntity<>(salaryHistoryDto, HttpStatus.OK);
    }
    @PostMapping("/salaryHistories")
    public ResponseEntity<?> addSalaryHistory(@RequestBody SalaryHistoryDto salaryHistoryDto){
        SalaryHistoryDto salaryHistory =salaryHistoryService.save(salaryHistoryDto);
        return new ResponseEntity<>(salaryHistory, HttpStatus.OK);
    }
    @PutMapping("/salaryHistories")
    public ResponseEntity<?> updateSalaryHistory(@RequestBody SalaryHistoryDto salaryHistoryDto){
        SalaryHistoryDto salaryHistory =salaryHistoryService.update(salaryHistoryDto);
        return new ResponseEntity<>(salaryHistory, HttpStatus.OK);
    }
    @DeleteMapping("/salaryHistories/{id}")
    public ResponseEntity<?> deleteSalaryHistory(@PathVariable Long id){
         salaryHistoryService.deleteById(id);
        return new ResponseEntity<>("SalaryHistory Deleted !!", HttpStatus.OK);
    }
}
