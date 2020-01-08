package com.liuganchen.indigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IndigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndigoApplication.class, args);
	}

}
