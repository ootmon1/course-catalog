package com.dxn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxn.model.Role;
import com.dxn.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(RoleName roleName);
}
