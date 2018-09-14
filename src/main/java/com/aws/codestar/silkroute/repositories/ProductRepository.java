package com.aws.codestar.silkroute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aws.codestar.silkroute.models.Department;
import com.aws.codestar.silkroute.models.Product;
import java.util.List;
import java.lang.String;
import com.aws.codestar.silkroute.models.User;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findDistinctProductByDepartmentsIn(List<Department> departments);
	
	List<Product> findByProductName(String productname);
	
	List<Product> findBySeller(User seller);
	
	List<Product> findByPrice(double price);
}
