package com.spring.store.mapper;


import com.spring.store.dto.RoleDto;
import com.spring.store.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleDto mapToRoleDto(Role role);
    Role mapToRole(RoleDto roleDto);
    List<RoleDto> mapToRoleDto(List<Role> roles);
}
