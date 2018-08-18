//package com.dxn.user;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.dxn.model.ApplicationUser;
//import com.dxn.repository.UserRepository;
//import com.dxn.security.JWTTokenProvider;
//
//@RestController
//public class UserController {
//	
//	private UserRepository userRepository;
//	
//	private AuthenticationManager authenticationManager;
//	
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	public UserController(UserRepository userRepository,
//			AuthenticationManager authenticationManager, BCryptPasswordEncoder bCryptPasswordEncoder) {
//		
//		this.userRepository = userRepository;
//		this.authenticationManager = authenticationManager;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/users/sign-up")
//	public void signUp(@RequestBody ApplicationUser applicationUser) {
//		
//		applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
//		
//		userRepository.save(applicationUser);
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/users/login")
//	public String login(@RequestBody ApplicationUser applicationUser) {
//		
//		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//				applicationUser.getUsername(), applicationUser.getPassword()));
//		
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		
//		return JWTTokenProvider.generateToken(authentication);
//	}
//	
//
//}
