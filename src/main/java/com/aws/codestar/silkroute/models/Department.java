package com.aws.codestar.silkroute.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;

@Entity
public class Department{

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
     @SequenceGenerator(name = "department_id_gen", sequenceName = "department_id_gen", initialValue = 50000000, allocationSize = 100)
    private long department_id;
	 
	 @Column(name="department_name")
    private String department_name;
	 
	 @Column(name="description")
    private String description; 
    

	public long getDepartment_id()
	{
		return this.department_id;
	}

	public void setDepartment_id(long department_id)
	{
		this.department_id = department_id;
	}

	public String getDepartment_name()
	{
		return this.department_name;
	}

	public void setDepartment_name(String department_name)
	{
		this.department_name = department_name;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

}