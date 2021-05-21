package org.sic.Projet_GestionDesStock.security.Filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sic.Projet_GestionDesStock.security.Constants;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthentication extends UsernamePasswordAuthenticationFilter {

	AuthenticationManager authenticationManager;

	public JWTAuthentication(AuthenticationManager authenticationManagerBean) {
		this.authenticationManager = authenticationManagerBean;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);
		return authenticationManager.authenticate(authenticationToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		User user = (User) authResult.getPrincipal();
		String jwtAccessToken = Jwts.builder().setSubject(user.getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + Constants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, Constants.SECRET).setIssuer(request.getRequestURL().toString())
				.claim("roles", user.getAuthorities()).compact();
		Map<String, String> idtoken = new HashMap<>();
		idtoken.put("access_token", jwtAccessToken);
		System.out.print(jwtAccessToken);
		response.setContentType("application/json");
		response.addHeader(Constants.HEADE_STRING, jwtAccessToken);
		new ObjectMapper().writeValue(response.getOutputStream(), user);

	}
}
