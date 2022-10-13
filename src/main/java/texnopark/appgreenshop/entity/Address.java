/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/4/2022
 * Time:7:02 PM
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
@Table(name = "addresses")
public class Address extends AbsEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String firstname;
    private String lastname;

}
