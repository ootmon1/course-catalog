package com.dxn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxn.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByIdIn(List<Long> userIds);

	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);
}
