package br.com.springsecurity.jwt.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// passa a requisição para frente

		Authentication auth = TokenUtil.decodeToken(request);

		if (request.getHeader("Authorization") != null) {
			if (auth != null) {
				// se token for válido, passa a authentication para o contexto do spring security
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}

		System.out.println("DEBUG - Requisição passou pelo filtro");

		// passa a requisição para a frente
		filterChain.doFilter(request, response);
	}

}
