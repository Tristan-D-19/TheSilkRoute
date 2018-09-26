package com.aws.codestar.silkroute.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.aws.codestar.silkroute.models.Department;
import com.aws.codestar.silkroute.models.Product;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.DepartmentRepository;
import com.aws.codestar.silkroute.repositories.ProductRepository;

@Service
@Repository
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private DepartmentRepository depRepo;
	
	public List<Product> searchForProduct(String keyword) {
		test_inventory();
		List <Product> products =	prodRepo.findByProductNameIgnoreCaseContaining(keyword);
	
	return products;
	}
	
	public void test_inventory() {
		List<Department> deps = new ArrayList<Department>();
		Department engineering = new Department("Engineering","engineering and IOT");
		Department webdev = new Department("Web Development", "website development, full stack, word press, and all web frameworks");
		Department graphicDesign = new Department("Graphic Design", "Logos, banners, and all designs");
		depRepo.save(engineering);
		depRepo.save(webdev);
		depRepo.save(graphicDesign);
		
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
		
		prodRepo.save(product1);
		prodRepo.save(product2);
		prodRepo.save(product3);
	}
	
	public Product getProduct(long id) {
		Product product = prodRepo.findOne(id);
		
		return product;
	}
}
