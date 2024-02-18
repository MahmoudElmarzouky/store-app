package com.spring.store.controller.sales;

import com.spring.store.dto.BillDto;
import com.spring.store.dto.RoleDto;
import com.spring.store.dto.SalesDto;
import com.spring.store.dto.SalesProductDto;
import com.spring.store.service.sales.SalesService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SalesController {
private SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }
    @GetMapping("/sales")
    public ResponseEntity<?> getSales(){
        List<SalesDto> salesDtos=salesService.findAll();
        return new ResponseEntity<>(salesDtos, HttpStatus.OK);
    }
    @PostMapping("/salesProduct")
    public ResponseEntity<?> salesProduct(@RequestBody List<SalesProductDto> salesProductDto, @RequestParam BigDecimal discount){
        BillDto billDto=salesService.SalesProduct(salesProductDto,discount);
        return new ResponseEntity<>(billDto, HttpStatus.OK);
    }
}
