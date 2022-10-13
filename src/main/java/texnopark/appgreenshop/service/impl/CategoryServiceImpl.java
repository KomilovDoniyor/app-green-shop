/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/4/2022
 * Time:9:41 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import texnopark.appgreenshop.dto.CategoryCreateDto;
import texnopark.appgreenshop.entity.Category;
import texnopark.appgreenshop.repository.CategoryRepository;
import texnopark.appgreenshop.response.Response;
import texnopark.appgreenshop.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public HttpEntity<?> save(CategoryCreateDto dto) {
        Response response = new Response();
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        if (dto.getParentId() != null) {
            Category parent = findByParentId(dto.getParentId());
            if (parent != null) {
                category.setParent(parent);
            }
        }
        Category savedCategory = categoryRepository.save(category);
        response.setStatus(true);
        response.setData(savedCategory);
        return ResponseEntity.ok(response);
    }

    private Category findByParentId(Long parentId) {
        Optional<Category> categoryOptional = categoryRepository.findById(parentId);
        return categoryOptional.orElse(null);
    }

    @Override
    public HttpEntity<?> findAll() {
        List<Category> allCategory = categoryRepository.findAll();
        return ResponseEntity.ok(allCategory);
    }

    @Override
    public HttpEntity<?> findById(Long id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            return ResponseEntity.status(HttpStatus.OK).body(category);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
    }

    @Override
    public HttpEntity<?> deleteById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            categoryRepository.deleteById(category.getId());
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
    }

    @Override
    public HttpEntity<?> editedById(Long id, CategoryCreateDto dto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setName(dto.getName());
            Category parent = findByParentId(dto.getParentId());
            category.setParent(parent);
            category.setDescription(dto.getDescription());
            Category savedCategory = categoryRepository.save(category);
            return ResponseEntity.status(HttpStatus.OK).body(savedCategory);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
    }
}
