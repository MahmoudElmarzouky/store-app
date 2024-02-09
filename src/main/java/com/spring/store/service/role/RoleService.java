package com.spring.store.service.role;

import com.spring.store.dto.CategoryDto;
import com.spring.store.dto.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();
    RoleDto save(RoleDto categoryDto);
    RoleDto findById(Long id);
    void deleteById(Long id);
    RoleDto update(RoleDto roleDto);
}
