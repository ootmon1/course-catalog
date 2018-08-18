package com.dxn.payload;

import com.dxn.security.SecurityConstants;

public class JwtAuthenticationResponse {

	private String accessToken;
	private String[] roles;
	private String tokenType = SecurityConstants.TOKEN_TYPE;
	
	public JwtAuthenticationResponse(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public JwtAuthenticationResponse(String accessToken, String[] roles) {
		this.accessToken = accessToken;
		this.roles = roles;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
}
