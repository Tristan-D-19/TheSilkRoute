package com.aws.codestar.silkroute.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;

@Entity
@Table(name="tsr_department")
public class Department{

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 @GeneratedValue(strategy=GenerationType.AUTO)
//     @SequenceGenerator(name = "department_id_gen", sequenceName = "department_id_gen", initialValue = 50000000, allocationSize = 100)
    private long departmentId;
	 
	

	@Column(name="department_name", nullable=false)
    private String departmentName;
	 
	 @Column(name="description", nullable=false)
    private String description; 
    
	 protected Department() {
		 
	 }
	 public Department(long departmentId, String departmentName, String description) {
			super();
			this.departmentId = departmentId;
			this.departmentName = departmentName;
			this.description = description;
		}
	public long getDepartmentId()
	{
		return this.departmentId;
	}

	public void setDepartmentId(long departmentId)
	{
		this.departmentId = departmentId;
	}

	public String getDepartmentName()
	{
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
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