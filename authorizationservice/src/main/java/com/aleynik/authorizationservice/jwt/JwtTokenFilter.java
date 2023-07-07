package com.aleynik.authorizationservice.jwt;

import com.aleynik.authorizationservice.entity.Account;
import com.aleynik.authorizationservice.entity.Role;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
	@Autowired
	private JwtTokenUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
				HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (!hasAuthorizationBearer(request)) {
			filterChain.doFilter(request, response);
			return;
		}

		String token = getAccessToken(request);

		if (!jwtUtil.validateAccessToken(token)) {
			filterChain.doFilter(request, response);
			return;
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!");
		setAuthenticationContext(token, request);
		System.out.println(SecurityContextHolder.getContext());
		filterChain.doFilter(request, response);
		System.out.println("!!!!!!!!!!!!!!!!!!!");
	}

	private boolean hasAuthorizationBearer(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
			return false;
		}

		return true;
	}

	private String getAccessToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		String token = header.split(" ")[1].trim();
		return token;
	}

	private void setAuthenticationContext(String token, HttpServletRequest request) {
		UserDetails userDetails = getUserDetails(token);
		UsernamePasswordAuthenticationToken
			authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		authentication.setDetails(
				new WebAuthenticationDetailsSource().buildDetails(request));
		System.out.println(authentication);
		System.out.println("11111");
		try {
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

	private UserDetails getUserDetails(String token) {
		Account userDetails = new Account();
		Claims claims = jwtUtil.parseClaims(token);
		String subject = (String) claims.get(Claims.SUBJECT);
		String roles = (String) claims.get("roles");
		System.out.println("SUBJECT: " + subject);
		System.out.println("roles: " + roles);
		roles = roles.replace("[", "").replace("]", "");
		String[] roleNames = roles.split(",");
		
		for (String aRoleName : roleNames) {
			userDetails.addRole(new Role(aRoleName));
		}
		
		String[] jwtSubject = subject.split(",");

		userDetails.setId(UUID.fromString(jwtSubject[0]));
		userDetails.setLogin(jwtSubject[1]);

		return userDetails;
	}
}
