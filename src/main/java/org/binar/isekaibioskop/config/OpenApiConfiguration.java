package org.binar.isekaibioskop.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Isekai Bioskop RESTful API")
                        .description("OpenAPI for Isekai Bioskop RESTful API")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Miftahul Huda Guntara (Railway Server)")
                                .email("hudalgtr99@gmail.com")
                                .url("ad8395c4-4962-4fd9-a5a7-364ffd7476eb")
                        )
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                        .externalDocs(new ExternalDocumentation()
                        .description("Github Isekai Bioskop RESTful API (Github Server)")
                        .url("miftahulhudaguntara_reservasi_bioskop"));
    }

}