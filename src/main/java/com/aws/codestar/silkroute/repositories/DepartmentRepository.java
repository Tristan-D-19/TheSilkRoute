package com.aws.codestar.silkroute.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aws.codestar.silkroute.models.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

	
	public  Department findByDepartmentName(String deparmentName);
}
