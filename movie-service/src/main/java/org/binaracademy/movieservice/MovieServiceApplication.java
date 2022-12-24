package org.binaracademy.movieservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
public class MovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper (){
		return new ModelMapper();
	}

}
