package com.aws.codestar.silkroute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.models.Role;
import java.util.Set;

import javax.transaction.Transactional;

import java.util.List;
import java.lang.String;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findRoleByUsersIn(Set<User> users);
	
	public Role findByRoleAccess(int role);
	
	public Role findByRole(String role);
}
