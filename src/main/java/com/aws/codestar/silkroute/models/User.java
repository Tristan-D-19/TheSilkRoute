package com.aws.codestar.silkroute.models;
import java.sql.Date;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
import javax.persistence.*;

/**
 * This class is a representation of the user for TSR. This class contains all data relating to all users.  
 */
 @Entity
public class User {

     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     @SequenceGenerator(name = "user_id_gen", sequenceName = "user_id_gen", initialValue = 50000000, allocationSize = 100)
    private Long id;
     
     @Column(name="first_name")
    private String first_name;
     
     @Column(name="last_name")
    private String last_name;
     
     @Column(name="email")
    private String email;
     @Column(name="password")
    private String password;
     @Column(name="address")
    private String address;
     @Column(name="city")
    private String city;
     @Column(name="zipcode")
    private int zipcode; 
     @Column(name="state")
    private String state; 
     @Column(name="phone")
    private int phone;
     
     @OneToOne
	private UserType user_type;
     @Column(name="date_joined")
	private Date date_joined;
     
     @Column(name="is_active")
	private boolean is_active;
     
     @OneToOne 
     private Picture profile_pic;
     

    //Constructor 

	//-----------------------------------------------------------------------------------------------
      public User() {}

      public User(String email, String firstName, String lastName, String password ) {
          this.first_name = firstName;
          this.last_name = lastName;
          this.password = password;
          this.email = email;
      }
  
	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFirst_name()
	{
		return this.first_name;
	}

	public void setFirstname(String firstName)
	{
		this.first_name = firstName;
	}

	public String getLastname()
	{
		return this.last_name;
	}

	public void setLastname(String lastName)
	{
		this.last_name = lastName;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return this.city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public int getZipcode()
	{
		return this.zipcode;
	}

	public void setZipcode(int zipcode)
	{
		this.zipcode = zipcode;
	}

	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public int getPhone()
	{
		return this.phone;
	}

	public void setPhone(int phone)
	{
		this.phone = phone;
	}

	public UserType getUser_type()
	{
		return this.user_type;
	}

	public void setUser_type(UserType userType)
	{
		this.user_type = userType;
	}

	public Date getDate_joined(){
		return date_joined;
	}
	public void setDate_joined(Date dateJoined) {
		this.date_joined = dateJoined;
	}

	public boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
	public Picture getProfilePic() {
		return profile_pic;
	}
	public void setProfilePic(Picture pic) {
		this.profile_pic = pic;
	}
    @Override
    public String toString() {
        return String.format(
                "User[id=%d, firstName='%s', lastName='%s']",
                id, first_name, last_name);
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (obj instanceof User) {
    		User other = (User) obj;
    		boolean same_id = (this.id == other.getId());
    	    boolean same_f_name = (this.first_name == other.getFirst_name());
    	    boolean same_l_name = (this.last_name == other.getLastname());
    	    boolean same_email = (this.email == other.getEmail());
    	    boolean same_pass = (this.password == other.getPassword());
    	    boolean same_address = (this.address == other.getAddress());
    	    boolean same_city = (this.city == other.getCity());
    	    boolean same_zip = (this.zipcode == other.getZipcode());
    	    boolean same_phone = (this.phone == other.getPhone());
    	    boolean same_u_type = (this.user_type == other.getUser_type());
    	    boolean same_date_joined = (this.date_joined == other.getDate_joined());
    	    boolean same_pic = (this.profile_pic == other.getProfilePic());
    	    	
    	    if(same_address && same_city && same_date_joined && same_email && 
    	    		same_f_name && same_l_name && same_id && same_pass && same_phone &&
    	    		same_u_type && same_zip && same_pic) return true;
    	    		else return false;
    	}
    	else return false;
    
    }

}