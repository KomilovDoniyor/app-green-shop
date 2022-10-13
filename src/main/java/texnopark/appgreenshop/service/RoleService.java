package texnopark.appgreenshop.service;

import org.springframework.http.HttpEntity;
import texnopark.appgreenshop.dto.RoleDto;

public interface RoleService {
    HttpEntity<?> save(RoleDto dto);
}
