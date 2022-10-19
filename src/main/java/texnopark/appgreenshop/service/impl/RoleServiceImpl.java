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
import texnopark.appgreenshop.entity.Permission;
import texnopark.appgreenshop.entity.Role;
import texnopark.appgreenshop.repository.PermissionRepository;
import texnopark.appgreenshop.repository.RoleRepository;
import texnopark.appgreenshop.service.RoleService;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public RoleServiceImpl(RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public HttpEntity<?> save(RoleDto dto) {
        Set<Permission> permissions = new HashSet<>();
        for (Long permissionsId : dto.getPermissionsId()) {
            Permission permission = permissionRepository.findById(permissionsId).orElse(null);
            if (permission != null) {
                permissions.add(permission);
            }
        }
        Role role = new Role(
                dto.getName(),
                permissions,
                dto.getDescription());
        Role saveRole = roleRepository.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveRole);
    }
}
