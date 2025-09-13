package com.eccentric.auth.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private final String SECRECT_KEY = "NCghF+VKMk9N/eosOApLlL4lgGvprJKw7f7HT8Yh3qWyjpakpZyjDcbEHLkxhC4EgJqecA/nlM6bdmZTnIV/kA==";
	private final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // one day 24 hours

	public String generateToken(String username, String role) {
		return Jwts.builder()
			.setSubject(username)
			.claim("role", role)
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
			.signWith(SignatureAlgorithm.HS256, SECRECT_KEY)
			.compact();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(SECRECT_KEY).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String extractUsername(String token) {
		return Jwts.parser()
			.setSigningKey(SECRECT_KEY)
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
	}
}
