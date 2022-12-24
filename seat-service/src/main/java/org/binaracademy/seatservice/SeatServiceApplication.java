package org.binaracademy.seatservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
public class SeatServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeatServiceApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper (){
		return new ModelMapper();
	}
}
