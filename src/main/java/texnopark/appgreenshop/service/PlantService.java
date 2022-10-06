/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/4/2022
 * Time:9:29 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.service;


import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import texnopark.appgreenshop.dto.PlantCreateDto;

public interface PlantService {
    HttpEntity<?> save(PlantCreateDto dto);

    HttpEntity<?> findById(Long id);

    HttpEntity<?> findAll();

    HttpEntity<?> deleteById(Long id);

    HttpEntity<?> deleteList();

    HttpEntity<?> edit(Long id, PlantCreateDto dto);

    HttpEntity<?> findAllPageable(Pageable pageable);
}
