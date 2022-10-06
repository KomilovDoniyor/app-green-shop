package texnopark.appgreenshop.service;

import org.springframework.http.HttpEntity;
import texnopark.appgreenshop.dto.CategoryCreateDto;

public interface CategoryService {
    HttpEntity<?> save(CategoryCreateDto dto);

    HttpEntity<?> findAll();

    HttpEntity<?> findById(Long id);

    HttpEntity<?> deleteById(Long id);

    HttpEntity<?> editedById(Long id, CategoryCreateDto dto);
}
