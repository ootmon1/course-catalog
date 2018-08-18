package com.dxn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dxn.payload.UserIdentityAvailability;
import com.dxn.payload.UserSummary;
import com.dxn.repository.UserRepository;
import com.dxn.security.CurrentUser;
import com.dxn.security.UserPrincipal;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("/me")
	@PreAuthorize("hasRole('USER')")
	public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
		
		return new UserSummary(currentUser.getId(), currentUser.getUsername());
	}
	
	@GetMapping("/checkUsernameAvailability")
	public UserIdentityAvailability checkUsernameAvailability(
			@RequestParam(value = "username") String username) {
		
		Boolean isAvailable = !userRepository.existsByUsername(username);
		return new UserIdentityAvailability(isAvailable);
	}
}
