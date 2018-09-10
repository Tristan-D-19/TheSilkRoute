package com.aws.codestar.silkroute.models;

import javax.persistence.ColumnResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;

@Entity
public class UserType{

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
    @SequenceGenerator(name = "user_type_id_gen", sequenceName = "user_type_id_gen", initialValue = 50000000, allocationSize = 100)
    private long type_id;
	
	@Column(name="type_name")
    private String type_name;

	
	public long getType_id()
	{
		return this.type_id;
	}

	public void setType_id(long type_id)
	{
		this.type_id = type_id;
	}

	public String getType_name()
	{
		return this.type_name;
	}

	public void setType_name(String type_name)
	{
		this.type_name = type_name;
	}



}