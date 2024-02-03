package com.spring.store.service.category;

import com.spring.store.dto.CategoryDto;
import com.spring.store.entity.Category;
import com.spring.store.exception.EntityNotFoundException;
import com.spring.store.mapper.CategoryMapper;
import com.spring.store.repository.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryMapper categoryMapper;
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper,CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryMapper.mapToCategoryDto(categoryRepository.findAll());
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        categoryDto.setId(0L);
        Category category= categoryRepository.save(categoryMapper.mapToCategory(categoryDto));
        return categoryMapper.mapToCategoryDto(category);
    }

    @Override
    public CategoryDto findById(Long id) {
        Optional<Category> category=categoryRepository.findById(id);
        if(!category.isPresent())
            throw new EntityNotFoundException("no category with id :"+id);
        return categoryMapper.mapToCategoryDto(category.get());
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        Category category= categoryRepository.save(categoryMapper.mapToCategory(categoryDto));
        return categoryMapper.mapToCategoryDto(category);
    }
}
