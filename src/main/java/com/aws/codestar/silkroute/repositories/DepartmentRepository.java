package com.aws.codestar.silkroute.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aws.codestar.silkroute.models.Department;
import com.aws.codestar.silkroute.models.Product;

import java.util.Set;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

	
	public  Department findByDepartmentName(String deparmentName);
	
	List<Department> findByProducts(Set<Product> products);
}
