package com.aws.codestar.silkroute.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.models.Role;
import com.aws.codestar.silkroute.repositories.RoleRepository;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleDAOTest {

	@Autowired 
	private TestEntityManager entityManager;
	
	@Autowired
	private RoleRepository userTypeRepo;
	
	@Test
	public void should_find_no_user_types_if_repo_is_empty(){
		userTypeRepo.deleteAll();
		
		Iterable<Role> roles = userTypeRepo.findAll();
		assertThat(roles).isEmpty();
	}
	
	@Test 
	public void should_create_admin_user_type() {
		Role admin = new Role(1, "Admin");
		userTypeRepo.save(admin);
		assertThat(admin).hasFieldOrPropertyWithValue("roleAccess", 1);
	}

	@Test
	public void should_create_non_admin_user_type() {
		Role customer = new Role(0, "customer");
		userTypeRepo.save(customer);
		assertThat(customer).hasFieldOrPropertyWithValue("roleAccess", 0);
	}
	
	@Test 
	public void should_delete_user_types() {
		entityManager.persist(new Role(1, "Admin"));
		entityManager.persist(new Role(0, "customer"));
		entityManager.persist(new Role(-1, "pending"));
		userTypeRepo.deleteAll();
		assertThat(userTypeRepo.findAll()).isEmpty();
	}
	
	@Test
	public void should_find_all_user_types() {
		
		Iterable<Role> roles = userTypeRepo.findAll();
		assertThat(roles).hasSize(2);
		
	}
	
	@Test
	public void should_find_user_type_by_id() {
		Role admin = new Role(1, "Admin");
		entityManager.persist(admin);
		Role foundType = userTypeRepo.findOne(admin.getRoleId());
		assertThat(foundType).isEqualTo(admin);
	}
	
	
//	@Test
	public void should_find_all_admin_users(){
	Role admin = new Role(1, "Admin");	
	Set<User> users = new HashSet<User>();	
	User user1 = new User("test1", "first", "last", "password");
	User user2 = new User("test2", "first", "last", "password");
	User user3 = new User("test3", "first", "last", "password");
	User user4 = new User("test4", "first", "last", "password");
	User user5 = new User("test5", "first", "last", "password");	
	users.add(user1);
	users.add(user2);
	users.add(user3);
	users.add(user4);
	users.add(user5);	
	admin.setUsers(users);
	entityManager.persist(admin);
	Role foundType = userTypeRepo.findRoleByUsersIn(users);	
	assertThat(admin).isEqualTo(foundType);
	}
}
