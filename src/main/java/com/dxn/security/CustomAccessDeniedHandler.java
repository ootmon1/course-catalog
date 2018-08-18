package com.dxn.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	private static final Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
	
	@Override
	public void handle(HttpServletRequest req, HttpServletResponse res,
			AccessDeniedException e) throws IOException, ServletException {
		
		logger.error("Responding with unauthorized error. Message - {}", e.getMessage());
		
		res.sendError(HttpServletResponse.SC_FORBIDDEN, "Sorry, you don't have permission to access this resource.");
	}
}
