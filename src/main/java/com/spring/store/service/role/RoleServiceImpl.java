package com.spring.store.service.role;

import com.spring.store.dto.RoleDto;
import com.spring.store.entity.Role;
import com.spring.store.exception.EntityNotFoundException;
import com.spring.store.mapper.RoleMapper;
import com.spring.store.repository.role.RoleRepository;
import com.spring.store.service.role.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleMapper roleMapper;
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleMapper roleMapper, RoleRepository roleRepository) {
        this.roleMapper = roleMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDto> findAll() {
        return roleMapper.mapToRoleDto(roleRepository.findAll());
    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        roleDto.setId(0L);
        Role role= roleRepository.save(roleMapper.mapToRole(roleDto));
        return roleMapper.mapToRoleDto(role);
    }

    @Override
    public RoleDto findById(Long id) {
        Optional<Role> role=roleRepository.findById(id);
        if(!role.isPresent())
            throw new EntityNotFoundException("no role with id :"+id);
        return roleMapper.mapToRoleDto(role.get());
    }

    @Override
    public void deleteById(Long id) {
        Optional<Role> role=roleRepository.findById(id);
        if(!role.isPresent())
            throw new EntityNotFoundException("can not delete , no role with id :"+id);
        roleRepository.deleteById(id);
    }

    @Override
    public RoleDto update(RoleDto roleDto) {
        Optional<Role> role=roleRepository.findById(roleDto.getId());
        if(!role.isPresent())
            throw new EntityNotFoundException("can not update,no role with id :"+roleDto.getId());
        Role roleUpdated= roleRepository.save(roleMapper.mapToRole(roleDto));
        return roleMapper.mapToRoleDto(roleUpdated);
    }
}
