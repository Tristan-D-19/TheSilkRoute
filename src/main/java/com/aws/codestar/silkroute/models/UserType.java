package com.aws.codestar.silkroute.models;

import javax.persistence.ColumnResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;

@Entity
@Table(name="tsr_user_type")
public class UserType{

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 @GeneratedValue(strategy=GenerationType.AUTO)
//    @SequenceGenerator(name = "user_type_id_gen", sequenceName = "user_type_id_gen", initialValue = 50000000, allocationSize = 100)
    private long typeId;
	
	@Column(name="type_name")
    private String typeName;

	@Column(name="user_type")
	private int userType;
	
	public UserType() {
	this.typeName = "customer";
	this.userType = 0;
	}
	
	
	public long getTypeId()
	{
		return this.typeId;
	}

	public void setTypeId(long typeId)
	{
		this.typeId = typeId;
	}

	public String getTypeName()
	{
		return this.typeName;
	}

	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}


	public int getUserType() {
		return userType;
	}


	public void setUserType(int userType) {
		this.userType = userType;
	}



}