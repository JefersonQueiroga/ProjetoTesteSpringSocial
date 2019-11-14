package edu.ifrn.teste.SpringSocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"edu.ifrn.teste.SpringSocial.model",
		"edu.ifrn.teste.SpringSocial.config",
		"edu.ifrn.teste.SpringSocial.security",
		"edu.ifrn.teste.SpringSocial.controller",
		"edu.ifrn.testeSpringSocial.repository"})
public class TesteSpringSocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteSpringSocialApplication.class, args);
	}

}
