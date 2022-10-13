/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/10/2022
 * Time:3:17 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.dto;

import lombok.Data;
import texnopark.appgreenshop.entity.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class RegisterDto {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String firstname;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String lastname;

    @Email
    @NotNull
    private String email;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private Set<Long> rolesIdSet;
}
