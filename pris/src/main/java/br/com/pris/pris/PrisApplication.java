package br.com.pris.pris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

import br.com.pris.pris.config.SecurityConfig;

@SpringBootApplication
public class PrisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrisApplication.class, args);
	}

}
