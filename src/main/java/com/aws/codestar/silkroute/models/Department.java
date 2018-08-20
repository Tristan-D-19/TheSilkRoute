package com.aws.codestar.silkroute.models;

public class Department{

    private long department_id;
    private String department_name;
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