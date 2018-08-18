//package com.dxn.security;
//
//import java.util.Date;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Component
//public class JWTTokenProvider {
//
//	public static String generateToken(Authentication auth) {
//		
//		return Jwts.builder()
//				.setSubject(((User) auth.getPrincipal()).getUsername())
//				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
//				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET.getBytes())
//				.compact();
//				
//	}
//}
