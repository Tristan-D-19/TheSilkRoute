package com.aws.codestar.silkroute.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.aws.codestar.silkroute.models.Department;
import com.aws.codestar.silkroute.repositories.DepartmentRepository;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class DepartmentDAOTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	DepartmentRepository departmentRepo;
	
	@Test
	public void should_find_no_departments_if_repo_is_empty() {
		Iterable<Department> departments = departmentRepo.findAll();

		assertThat(departments).isEmpty();
	}
	
	@Test
	public void should_find_dep_by_id() {
		Department dep = new Department( "Graphic Design", "Create and design for clients and other artist in need of graphical work");
		entityManager.persist(dep);
		departmentRepo.findOne(dep.getDepartmentId());
	}
	
	@Test 
	public void shoud_find_department_by_department_name() {
		Department dep = new Department( "Graphic Design", "Create and design for clients and other artist in need of graphical work");
		entityManager.persist(dep);
		Department foundDep = departmentRepo.findByDepartmentName(dep.getDepartmentName());
		assertThat(dep).isEqualTo(foundDep);
	}
	
	@Test
	public void should_create_department() {
		Department dep = new Department( "Graphic Design", "Create and design for clients and other artist in need of graphical work");
		Department createdDep = departmentRepo.save(dep);
		assertThat(dep).isEqualTo(createdDep);
	}
	
}
