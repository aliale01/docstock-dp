package com.alex.repo;

import com.alex.repo.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfig.class)
public class RepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepoApplication.class, args);
	}
}