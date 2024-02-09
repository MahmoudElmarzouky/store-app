package com.spring.store.controller.role;

import com.spring.store.dto.RoleDto;
import com.spring.store.service.role.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public ResponseEntity<?> getCategories(){
        List<RoleDto> roleDtos=roleService.findAll();
      return new ResponseEntity<>(roleDtos, HttpStatus.OK);
    }
    @GetMapping("/roles/{id}")
    public ResponseEntity<?> getRole(@PathVariable Long id){
        RoleDto roleDto=roleService.findById(id);
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }
    @PostMapping("/roles")
    public ResponseEntity<?> addRole(@RequestBody RoleDto roleDto){
        RoleDto role =roleService.save(roleDto);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }
    @PutMapping("/roles")
    public ResponseEntity<?> updateRole(@RequestBody RoleDto roleDto){
        RoleDto role =roleService.update(roleDto);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }
    @DeleteMapping("/roles/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Long id){
         roleService.deleteById(id);
        return new ResponseEntity<>("Role Deleted !!", HttpStatus.OK);
    }
}
