/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/15/2022
 * Time:12:11 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import texnopark.appgreenshop.entity.template.AbsEntity;
import texnopark.appgreenshop.enums.CrudType;
import texnopark.appgreenshop.enums.PermissionGroup;
import texnopark.appgreenshop.enums.PermissionName;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permissions")
public class Permission extends AbsEntity implements GrantedAuthority {

    @Enumerated(EnumType.STRING)
    private PermissionName name;

    @Enumerated(EnumType.STRING)
    private CrudType type;

    @Enumerated(EnumType.STRING)
    private PermissionGroup group;

    private String description;


    @Override
    public String getAuthority() {
        return this.name.name();
    }
}
