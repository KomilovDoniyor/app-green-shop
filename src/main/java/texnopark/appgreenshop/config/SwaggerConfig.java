/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/13/2022
 * Time:10:38 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securityContexts(Collections.singletonList(contexts()))
                .securitySchemes(List.of(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("texnopark.appgreenshop"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext contexts() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("App Green Shop")
                .description("This project for selling Plants")
                .license("Apache Version 2.0")
                .version("1.0")
                .licenseUrl("https://example.com")
                .contact(new Contact("Texnopark",
                        "https://swagger.io/docs/open-source-tools/swagger-ui/usage/configuration/",
                        "komiloff.doniyor2505@gmail.com"))
                .build();
    }
}
