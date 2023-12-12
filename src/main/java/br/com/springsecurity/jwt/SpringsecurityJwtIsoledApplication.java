package br.com.springsecurity.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringsecurityJwtIsoledApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityJwtIsoledApplication.class, args);
	}

}
