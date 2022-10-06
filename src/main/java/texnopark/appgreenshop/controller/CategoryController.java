/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/4/2022
 * Time:9:43 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import texnopark.appgreenshop.dto.CategoryCreateDto;
import texnopark.appgreenshop.service.CategoryService;

@RestController
@RequestMapping(value = "api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public HttpEntity<?> save(@RequestBody CategoryCreateDto dto) {
        return categoryService.save(dto);
    }

    @GetMapping
    public HttpEntity<?> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteById(@PathVariable("id") Long id) {
        return categoryService.deleteById(id);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable("id") Long id, @RequestBody CategoryCreateDto dto) {
        return categoryService.editedById(id, dto);
    }
}
