package com.spring.store.controller.product;


import com.spring.store.dto.ProductDto;
import com.spring.store.dto.SalesProductDto;
import com.spring.store.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProducts(){
        List<ProductDto> productDtos=productService.findAll();
      return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }
    @GetMapping("/salesProducts")
    public ResponseEntity<?> getSalesProducts(){
        List<SalesProductDto> productDtos=productService.getSalesProducts();
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
        ProductDto productDto=productService.findById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto){
        ProductDto product =productService.save(productDto);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PutMapping("/products")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto){
        ProductDto product =productService.update(productDto);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
        return new ResponseEntity<>("Product Deleted !!", HttpStatus.OK);
    }
    @GetMapping("/products/isAmountAvailable")
    public ResponseEntity<?> isAmountAvailable(@RequestParam Long id,@RequestParam int amount){
        Boolean isAvailable=productService.isAmountAvailable(id,amount);
        return new ResponseEntity<>("isAmountAvailable : "+isAvailable, HttpStatus.OK);
    }
}
