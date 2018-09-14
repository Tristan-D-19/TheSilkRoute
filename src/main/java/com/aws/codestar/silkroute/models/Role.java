package com.aws.codestar.silkroute.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
    private long roleId;
	
	@Column(name="role")
    private String role;

	@Column(name="role_access")
	private int roleAccess;
	
	@ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "roles")
	private Set<User> users;
	 
	
	protected Role() {
		
	}
	
	public Role(int roleAccess, String role) {
	this.role = role;
	this.roleAccess = roleAccess;
	}

	
	public long getRoleId()
	{
		return this.roleId;
	}

	public void setRoleId(long roleId)
	{
		this.roleId = roleId;
	}

	public String getRole()
	{
		return this.role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}


	public int getRoleAccess() {
		return roleAccess;
	}

	
	public Set<User> getUsers() {
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public void setRoleAccess(int roleAccess) {
		this.roleAccess = roleAccess;
	}



}