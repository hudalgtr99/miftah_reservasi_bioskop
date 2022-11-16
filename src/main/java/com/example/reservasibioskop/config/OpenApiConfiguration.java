package com.example.reservasibioskop.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

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
                        .url("miftahulhudaguntara_reservasi_bioskop"))
                        .servers(servers());
    }

    private List<Server> servers() {
        List<Server> servers = new ArrayList<>();

        Server serverDevFirst = new Server();
        serverDevFirst.setUrl("http://localhost:8080/");
        serverDevFirst.setDescription("Main server for Dev");

        Server serverDevSecond = new Server();
        serverDevSecond.setUrl("https://github.com/hudalgtr99/v1");
        serverDevSecond.setDescription("Second server for Dev");

        Server serverProduction = new Server();
        serverProduction.setUrl("https://railway.app/project/v1");
        serverProduction.setDescription("Server for Production");

        servers.add(serverDevFirst);
        servers.add(serverProduction);
        servers.add(serverDevSecond);

        return servers;
    }

}