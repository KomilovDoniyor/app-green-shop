/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/4/2022
 * Time:7:03 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import texnopark.appgreenshop.entity.template.AbsEntity;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category extends AbsEntity {

    @Column(nullable = false, unique = true)
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

}
