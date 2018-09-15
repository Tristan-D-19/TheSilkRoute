package com.aws.codestar.silkroute.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="tsr_department")

public class Department{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long departmentId;
	 	

	@Column(name="department_name", nullable=false)
    private String departmentName;
	 
	 @Column(name="description", nullable=false)
    private String description; 
    
	 @ManyToMany(cascade = {CascadeType.ALL})
	 private Set<Product> products = new HashSet<Product>();
	 
	 
	 protected Department() {
		 
	 }
	 public Department( String departmentName, String description) {
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

	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
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