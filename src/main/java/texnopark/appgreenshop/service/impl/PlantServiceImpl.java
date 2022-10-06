/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/4/2022
 * Time:9:29 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import texnopark.appgreenshop.dto.PlantCreateDto;
import texnopark.appgreenshop.entity.Category;
import texnopark.appgreenshop.entity.Plant;
import texnopark.appgreenshop.repository.CategoryRepository;
import texnopark.appgreenshop.repository.PlantRepository;
import texnopark.appgreenshop.response.Response;
import texnopark.appgreenshop.service.PlantService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {
    private final PlantRepository plantRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public HttpEntity<?> save(PlantCreateDto dto) {
        Plant plant = new Plant();
        plant.setName(dto.getName());
        plant.setDescription(dto.getDescription());
        Optional<Category> byId = categoryRepository.findById(dto.getCategoryId());
        if (byId.isPresent()) {
            Category category = byId.get();
            plant.setCategory(category);
            Plant savePlant = plantRepository.save(plant);
            return ResponseEntity.status(HttpStatus.CREATED).body(savePlant);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto.getCategoryId());
    }

    @Override
    public HttpEntity<?> findById(Long id) {
        Optional<Plant> plantOptional = plantRepository.findById(id);
        if (plantOptional.isPresent()) {
            Plant plant = plantOptional.get();
            return ResponseEntity.status(HttpStatus.FOUND).body(plant);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
    }

    @Override
    public HttpEntity<?> findAll() {
        List<Plant> plantList = plantRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(plantList);
    }

    @Override
    public HttpEntity<?> deleteById(Long id) {
        Optional<Plant> optionalPlant = plantRepository.findById(id);
        if (optionalPlant.isPresent()) {
            Plant plant = optionalPlant.get();
            plantRepository.deleteById(plant.getId());
            return ResponseEntity.status(HttpStatus.OK).body(plant.getId());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
    }

    @Override
    public HttpEntity<?> deleteList() {
        plantRepository.deleteAll();
        return ResponseEntity.ok("Successfully deleted");
    }

    @Override
    public HttpEntity<?> edit(Long id, PlantCreateDto dto) {
        Optional<Plant> editById = plantRepository.findById(id);
        if (editById.isPresent()) {
            Plant plant = editById.get();
            plant.setName(dto.getName());
            plant.setDescription(dto.getDescription());
            Optional<Category> categoryOptional = categoryRepository.findById(dto.getCategoryId());
            if (categoryOptional.isPresent()) {
                Category category = categoryOptional.get();
                plant.setCategory(category);
            }
            Plant savedPlant = plantRepository.save(plant);
            return ResponseEntity.status(HttpStatus.OK).body(savedPlant);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
    }

    @Override
    public HttpEntity<?> findAllPageable(Pageable pageable) {
        //Pageable pageable = PageRequest.of(0,2,Sort.by("createdAt"));
        Page<Plant> page = plantRepository.findAll(pageable);
        List<Plant> plants = page.getContent();
        Response response = new Response(true,"Plant List", Collections.singletonList(plants));
        response.getMap().put("size", page.getSize());
        response.getMap().put("total_page", page.getTotalPages());
        response.getMap().put(("total_content"), page.getTotalElements());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
