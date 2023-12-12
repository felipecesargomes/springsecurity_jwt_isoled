package br.com.springsecurity.jwt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

	// Anota com Bean porque retorna um objeto que implementa a interface SecurityFilterChain
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()  // desabilita o csrf (porque eu vou tratar a autenticação dos usuários)
		.authorizeHttpRequests() //agora as requisições http são passíveis de autorização
	}
	
}
