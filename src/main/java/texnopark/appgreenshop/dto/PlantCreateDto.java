/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/4/2022
 * Time:9:24 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantCreateDto {
    private String name;
    private String description;
    private Long categoryId;
}
