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
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import texnopark.appgreenshop.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role extends AbsEntity implements GrantedAuthority {

    @Column(nullable = false, unique = true)
    private String name;
    private String description;

    @Override
    public String getAuthority() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return getId() != null && Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
