//package com.dxn.user;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.dxn.model.ApplicationUser;
//import com.dxn.repository.UserRepository;
//
//import static java.util.Collections.emptyList;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	private UserRepository userRepository;
//	
//	public UserDetailsServiceImpl(UserRepository userRepository) {
//		
//		this.userRepository = userRepository;
//	}
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		ApplicationUser applicationUser = userRepository.findByUsername(username)
//				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//		
//		return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
//	}
//}
