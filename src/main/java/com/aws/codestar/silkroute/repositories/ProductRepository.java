package com.aws.codestar.silkroute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aws.codestar.silkroute.models.Department;
import com.aws.codestar.silkroute.models.Product;
import java.util.List;
import java.lang.String;
import com.aws.codestar.silkroute.models.User;


@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findDistinctProductByDepartmentsIn(List<Department> departments);
	
	List<Product> findByProductName(String productname);
	
	List<Product> findBySeller(User seller);
	
	List<Product> findByPrice(double price);
	
	List<Product> findByDepartmentsIgnoreCaseContaining(List<Department> departments);
	
	List<Product> findByProductNameIgnoreCaseContaining(String productname);
	
//	@Query("select u from tsr_product u where u.departments like %:input%")
//    List<Product> findAllByInputIgnoreCase(@Param("input") String input);
}

