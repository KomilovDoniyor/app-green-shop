/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/13/2022
 * Time:5:04 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditConfig {

    @Bean
    AuditorAware<Long> auditorAware(){
        return new SpringSecurityAuditConfig();
    }
}
