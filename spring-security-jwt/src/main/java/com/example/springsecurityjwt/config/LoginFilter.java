package com.example.springsecurityjwt.config;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//@Component
public class LoginFilter extends OncePerRequestFilter {
	
	private UserDetailsService userDetailService;
	private PasswordEncoder passwordEncoder;
	private JWTHelper jwtHelper;
	
	
	public LoginFilter(UserDetailsService userDetailService, PasswordEncoder passwordEncoder, JWTHelper jwtHelper) {
		super();
		this.userDetailService = userDetailService;
		this.passwordEncoder = passwordEncoder;
		this.jwtHelper = jwtHelper;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String username=request.getHeader("username");
		String password=request.getHeader("password");
		UserDetails user=userDetailService.loadUserByUsername(username);
		if(passwordEncoder.matches(password,user.getPassword())) {
			String token=jwtHelper.createToken(user);
			response.setHeader(HttpHeaders.AUTHORIZATION, token);
			
		}else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().print("Username Password combo is not valid");
		}
		

	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String uri=request.getRequestURI();
		String method=request.getMethod();
		boolean login="POST".equals(method) && "/login".equals(uri);
		return !login;
	}

}
