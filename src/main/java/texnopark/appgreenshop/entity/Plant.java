/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/4/2022
 * Time:6:59 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import texnopark.appgreenshop.entity.template.AbsEntity;
import texnopark.appgreenshop.enums.PlantSize;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plants")
public class Plant extends AbsEntity {

    @Column(nullable = false, unique = true)
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Bu related bo'lgan plant id
    @ManyToOne
    @JoinColumn(name = "related_id")
    private Plant related;

    @Enumerated(value = EnumType.STRING)
    private PlantSize size;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Plant parent;

    private LocalDateTime createdAt;

}
