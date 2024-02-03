package com.spring.store.mapper;

import com.spring.store.dto.CategoryDto;
import com.spring.store.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryDto mapToCategoryDto(Category category);
    Category mapToCategory(CategoryDto categoryDto);
    List<CategoryDto> mapToCategoryDto(List<Category> categories);
}
