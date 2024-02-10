package com.spring.store.controller.bill;

import com.spring.store.dto.BillDto;
import com.spring.store.service.bill.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillController {
    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/bills")
    public ResponseEntity<?> getCategories(){
        List<BillDto> billDtos=billService.findAll();
      return new ResponseEntity<>(billDtos, HttpStatus.OK);
    }
    @GetMapping("/bills/{id}")
    public ResponseEntity<?> getBill(@PathVariable Long id){
        BillDto billDto=billService.findById(id);
        return new ResponseEntity<>(billDto, HttpStatus.OK);
    }
    @PostMapping("/bills")
    public ResponseEntity<?> addBill(@RequestBody BillDto billDto){
        BillDto bill =billService.save(billDto);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }
    @PutMapping("/bills")
    public ResponseEntity<?> updateBill(@RequestBody BillDto billDto){
        BillDto bill =billService.update(billDto);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }
    @DeleteMapping("/bills/{id}")
    public ResponseEntity<?> deleteBill(@PathVariable Long id){
         billService.deleteById(id);
        return new ResponseEntity<>("Bill Deleted !!", HttpStatus.OK);
    }
}
