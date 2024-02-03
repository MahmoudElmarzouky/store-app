package com.spring.store.controller.category;

import com.spring.store.dto.CategoryDto;
import com.spring.store.service.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories(){
        List<CategoryDto> categoryDtos=categoryService.findAll();
      return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }
    @GetMapping("/categories/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id){
        CategoryDto categoryDto=categoryService.findById(id);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }
    @PostMapping("/categories")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto category =categoryService.save(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @PutMapping("/categories")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto category =categoryService.update(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
         categoryService.deleteById(id);
        return new ResponseEntity<>("Category Deleted !!", HttpStatus.OK);
    }
}
