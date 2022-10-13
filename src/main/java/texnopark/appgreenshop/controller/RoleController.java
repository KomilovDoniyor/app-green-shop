/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/13/2022
 * Time:2:44 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import texnopark.appgreenshop.dto.RoleDto;
import texnopark.appgreenshop.service.RoleService;

@RestController
@RequestMapping(value = "/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public HttpEntity<?> save(@RequestBody RoleDto dto){
        return roleService.save(dto);
    }

}
