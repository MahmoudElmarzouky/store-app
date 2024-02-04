package com.spring.store.controller.product;


import com.spring.store.dto.ProductDto;
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
        List<ProductDto> categoryDtos=productService.findAll();
      return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
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
    public ResponseEntity<?> deleteCProduct(@PathVariable Long id){
        productService.deleteById(id);
        return new ResponseEntity<>("Product Deleted !!", HttpStatus.OK);
    }
}
