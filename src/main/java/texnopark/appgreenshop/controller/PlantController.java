/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/4/2022
 * Time:9:21 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import texnopark.appgreenshop.annotation.ApiPageable;
import texnopark.appgreenshop.dto.PlantCreateDto;
import texnopark.appgreenshop.service.PlantService;

@RestController
@RequestMapping(value = "api/v1/plants/")
public class PlantController {
    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping
    public HttpEntity<?> save(@RequestBody PlantCreateDto dto) {
        return plantService.save(dto);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> findBYId(@PathVariable("id") Long id) {
        return plantService.findById(id);
    }

    @GetMapping
    public HttpEntity<?> findAll() {
        return plantService.findAll();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteById(@PathVariable("id") Long id) {
        return plantService.deleteById(id);
    }

    @DeleteMapping
    public HttpEntity<?> deleteList() {
        return plantService.deleteList();
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable("id") Long id, PlantCreateDto dto) {
        return plantService.edit(id, dto);
    }

    @ApiPageable
    @GetMapping("/page/list")
    public HttpEntity<?> findAllPageable(@RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "category_name", required = false) String categoryName,
                                         @RequestParam(value = "size", required = false) String size,
                                         @ApiIgnore Pageable pageable) {
        // Pageable
        return plantService.findAllPageable(name, categoryName, size, pageable);
    }
}
