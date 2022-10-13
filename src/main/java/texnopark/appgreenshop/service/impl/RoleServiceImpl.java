/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/13/2022
 * Time:2:52 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import texnopark.appgreenshop.dto.RoleDto;
import texnopark.appgreenshop.entity.Role;
import texnopark.appgreenshop.repository.RoleRepository;
import texnopark.appgreenshop.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public HttpEntity<?> save(RoleDto dto) {
        Role role = new Role();
        role.setName(dto.getName());
        role.setDescription(dto.getDescription());
        Role saveRole = roleRepository.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body("Name: " + saveRole.getName());
    }
}
