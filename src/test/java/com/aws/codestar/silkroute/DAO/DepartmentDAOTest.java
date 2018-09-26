package com.aws.codestar.silkroute.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.aws.codestar.silkroute.models.Department;
import com.aws.codestar.silkroute.models.Product;
import com.aws.codestar.silkroute.models.User;
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
		departmentRepo.deleteAll();
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
		departmentRepo.deleteAll();
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
	
//	@Test 
	public void should_find_dep_by_products() {
		departmentRepo.deleteAll();
		List<Department> deps = new ArrayList<Department>();
		
		Department engineering = new Department("Engineering","engineering and IOT");
		Department webdev = new Department("Web Development", "website development, full stack, word press, and all web frameworks");
		Department graphicDesign = new Department("Graphic Design", "Logos, banners, and all designs");
		
		deps.add(engineering);
		deps.add(webdev);
		deps.add(graphicDesign);
		User user = new User("test@gmail.com", "first", "last", "password");
		Product product1 = new Product(user, "Website", "fully functional website", 200);
		product1.setDepartments(deps);
		Product product2 = new Product(user, "Website", "fully functional website", 200);
		product2.setDepartments(deps);
		Product product3 = new Product(user, "Website", "fully functional website", 200);
		product3.setDepartments(deps);
		entityManager.persist(product1);
		entityManager.persist(product2);
		entityManager.persist(product3);
		entityManager.persist(user);
		Set<Product> prods = new HashSet<Product>();
//		List<Product> prods = new ArrayList<Product>();
		prods.add(product1);
		prods.add(product2);
		prods.add(product3);
		
		
		entityManager.persist(engineering);
		entityManager.persist(webdev);
		entityManager.persist(graphicDesign);
		
		Iterable <Department> foundDeparments = departmentRepo.findDepartmentsByProductsIn(prods);
//		Iterable<Department> foundDeparments =  departmentRepo.findAll();
		assertThat(foundDeparments).hasSize(3).contains(engineering, webdev, graphicDesign);
	}
}
