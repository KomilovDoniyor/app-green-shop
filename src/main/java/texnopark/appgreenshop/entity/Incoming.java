/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/4/2022
 * Time:7:04 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import texnopark.appgreenshop.entity.template.AbsEntity;
import texnopark.appgreenshop.enums.PlantSize;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "incomes")
public class Incoming extends AbsEntity {
    private PlantSize size;
    private Double price;
    private Double salePrice;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;
    private Integer quantity;
    private Boolean active;
    private LocalDateTime cameAt;
}
