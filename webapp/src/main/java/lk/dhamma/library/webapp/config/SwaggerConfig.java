package lk.dhamma.library.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("lk.dhamma.library.webapp"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My REST API for a simple Library System",
                "REST API developing to learn PRIDE Archive API",
                "1.0.0",
                "Terms of service",
                new Contact(
                        "Suresh Hewapathirana",
                        "https://www.linkedin.com/in/suresh-hewapathirana-2758a069/",
                        "sureshhewabi@gmail.com"),
                "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0.htmlL", Collections.emptyList());
    }
}
