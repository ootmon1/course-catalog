package com.dxn.security;

public class SecurityConstants {

	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 3600000;	// 60 minutes
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String TOKEN_TYPE = "Bearer";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users/sign-up";
	public static final String LOGIN_URL = "/users/login";
}
