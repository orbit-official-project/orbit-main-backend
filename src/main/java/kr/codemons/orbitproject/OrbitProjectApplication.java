package kr.codemons.orbitproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@EnableJpaAuditing
@SpringBootApplication
public class OrbitProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrbitProjectApplication.class, args);
	}
}
