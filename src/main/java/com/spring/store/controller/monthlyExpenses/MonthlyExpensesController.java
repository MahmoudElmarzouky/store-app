package com.spring.store.controller.monthlyExpenses;

import com.spring.store.dto.MonthlyExpensesDto;
import com.spring.store.service.monthlyExpenses.MonthlyExpensesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MonthlyExpensesController {
    private MonthlyExpensesService monthlyExpensesService;

    public MonthlyExpensesController(MonthlyExpensesService monthlyExpensesService) {
        this.monthlyExpensesService = monthlyExpensesService;
    }

    @GetMapping("/monthlyExpenses")
    public ResponseEntity<?> getMonthlyExpensess(){
        List<MonthlyExpensesDto> monthlyExpensesDtos=monthlyExpensesService.findAll();
      return new ResponseEntity<>(monthlyExpensesDtos, HttpStatus.OK);
    }
    @GetMapping("/monthlyExpenses/{id}")
    public ResponseEntity<?> getMonthlyExpenses(@PathVariable Long id){
        MonthlyExpensesDto monthlyExpensesDto=monthlyExpensesService.findById(id);
        return new ResponseEntity<>(monthlyExpensesDto, HttpStatus.OK);
    }
    @PostMapping("/monthlyExpenses")
    public ResponseEntity<?> addMonthlyExpenses(@RequestBody MonthlyExpensesDto monthlyExpensesDto){
        MonthlyExpensesDto monthlyExpenses =monthlyExpensesService.save(monthlyExpensesDto);
        return new ResponseEntity<>(monthlyExpenses, HttpStatus.OK);
    }
    @PutMapping("/monthlyExpenses")
    public ResponseEntity<?> updateMonthlyExpenses(@RequestBody MonthlyExpensesDto monthlyExpensesDto){
        MonthlyExpensesDto monthlyExpenses=monthlyExpensesService.update(monthlyExpensesDto);
        return new ResponseEntity<>(monthlyExpenses, HttpStatus.OK);
    }
    @DeleteMapping("/monthlyExpenses/{id}")
    public ResponseEntity<?> deleteMonthlyExpenses(@PathVariable Long id){
         monthlyExpensesService.deleteById(id);
        return new ResponseEntity<>("MonthlyExpenses Deleted !!", HttpStatus.OK);
    }
}
