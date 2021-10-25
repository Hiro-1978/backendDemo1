package com.spingboot.backendDemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackendDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(BackendDemo1Application.class, args);
	}

}
