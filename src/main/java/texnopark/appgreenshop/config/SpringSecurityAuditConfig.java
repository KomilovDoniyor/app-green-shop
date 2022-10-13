/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/13/2022
 * Time:5:01 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import texnopark.appgreenshop.entity.User;

import java.util.Optional;

public class SpringSecurityAuditConfig implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null
                && authentication.isAuthenticated()
                && !authentication.getPrincipal().equals("anonymousUser")){
            User principal = (User) authentication.getPrincipal();
            return Optional.of(principal.getId());
        }
        return Optional.empty();
    }
}
