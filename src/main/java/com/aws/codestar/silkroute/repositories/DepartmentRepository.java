package com.aws.codestar.silkroute.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aws.codestar.silkroute.models.Department;
import com.aws.codestar.silkroute.models.Product;

import java.util.Set;

@Repository
@Transactional
public interface DepartmentRepository extends CrudRepository<Department, Long> {

	
	public Department findByDepartmentName(String deparmentName);
	
	public List <Department> findDepartmentsByProductsIn(Set<Product> products);
}
