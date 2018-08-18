//package com.dxn;
//
//import java.util.Collections;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.dxn.model.Course;
//import com.dxn.model.Role;
//import com.dxn.model.RoleName;
//import com.dxn.model.Topic;
//import com.dxn.model.User;
//import com.dxn.repository.CourseRepository;
//import com.dxn.repository.RoleRepository;
//import com.dxn.repository.TopicRepository;
//import com.dxn.repository.UserRepository;
//
//@Component
//public class DbInitializer implements CommandLineRunner {
//	
//	@Autowired
//	private CourseRepository courseRepository;
//	
//	@Autowired
//	private RoleRepository roleRepository;
//	
//	@Autowired
//	private TopicRepository topicRepository;
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		this.roleRepository.deleteAll();
//		this.userRepository.deleteAll();
//		this.topicRepository.deleteAll();
//		this.courseRepository.deleteAll();
//		
//		Role adminRole = roleRepository.save(new Role(RoleName.ROLE_ADMIN));
//		Role userRole = roleRepository.save(new Role(RoleName.ROLE_USER));
//		
//		String password = passwordEncoder.encode("password");
//		
//		userRepository.save(new User("admin", password, Collections.singleton(adminRole)));
//		userRepository.save(new User("user", password, Collections.singleton(userRole)));
//		
//		Topic programming = topicRepository.save(new Topic("Programming", "Programming Description"));
//		Topic english = topicRepository.save(new Topic("English", "English Description"));
//		Topic math = topicRepository.save(new Topic("Math", "Math Description"));
//		Topic science = topicRepository.save(new Topic("Science", "Science Description"));
//		
//		courseRepository.save(new Course("Java", "Java Description", programming));
//		courseRepository.save(new Course("C++", "C++ Description", programming));
//		courseRepository.save(new Course("Literature", "Literature Description", english));
//		courseRepository.save(new Course("Shakespeare", "Shakespeare Description", english));
//		courseRepository.save(new Course("Calculus I", "Calculus I Description", math));
//		courseRepository.save(new Course("Calculus II", "Cal II Description", math));
//		courseRepository.save(new Course("Cal III", "Cal III Description", math));
//		courseRepository.save(new Course("Physics", "Physics Description", science));
//		courseRepository.save(new Course("Chem", "Chem Description", science));
//		courseRepository.save(new Course("Bio", "Bio Description", science));
//		
//		System.out.println("-- Database has been initialized");
//	}
//}
