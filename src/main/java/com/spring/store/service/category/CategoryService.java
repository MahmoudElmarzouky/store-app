package com.spring.store.service.category;

import com.spring.store.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto findById(Long id);
    void deleteById(Long id);
    CategoryDto update(CategoryDto categoryDto);
}
