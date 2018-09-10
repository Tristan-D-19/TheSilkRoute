package com.aws.codestar.silkroute.models;
//import java.sql.Date;
import java.util.Date;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
import javax.annotation.Nullable;
import javax.persistence.*;

/**
 * This class is a representation of the user for TSR. This class contains all data relating to all users.  
 */
 @Entity
 @Table(name="tsr_user")
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @GeneratedValue(strategy=GenerationType.AUTO)
//     @SequenceGenerator(name = "user_id_gen", sequenceName = "user_id_gen", initialValue = 50000000, allocationSize = 100)
    private Long userId;
     
     @Column(name="first_name", nullable=false)
    private String firstName;
     
     @Column(name="last_name", nullable=false)
    private String lastName;
     
     @Column(name="email", nullable=false)
    private String email;
     
     @Column(name="password", nullable=false)
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
	private UserType userType;
     
     @Column(name="date_joined", nullable=false)
	private Date dateJoined;
     
     @Column(name="is_active", nullable=false)
	private boolean active;
     
     @OneToOne 
     private Picture profilePic;
     

     
    //Constructor 

     protected User() {
    	 
     }
	//-----------------------------------------------------------------------------------------------
     

      public User(String email, String firstName, String lastName, String password ) {
          this.firstName = firstName;
          this.lastName = lastName;
          this.password = password;
          this.email = email;
      }
  
	public Long getUserId()
	{
		return this.userId;
	}

	public void setUserId(Long id)
	{
		this.userId = id;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
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

	public UserType getUserType()
	{
		return this.userType;
	}

	public void setUserType(UserType userType)
	{
		this.userType = userType;
	}

	public Date getDateJoined(){
		return dateJoined;
	}
	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean is_active) {
		this.active = is_active;
	}
	
	public Picture getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(Picture pic) {
		this.profilePic = pic;
	}
    @Override
    public String toString() {
        return String.format(
                "User[id=%d, firstName='%s', lastName='%s']",
                userId, firstName, lastName);
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (obj instanceof User) {
    		User other = (User) obj;
    		boolean same_id = (this.userId == other.getUserId());
    	    boolean same_f_name = (this.firstName == other.getFirstName());
    	    boolean same_l_name = (this.lastName == other.getLastName());
    	    boolean same_email = (this.email == other.getEmail());
    	    boolean same_pass = (this.password == other.getPassword());
    	    boolean same_address = (this.address == other.getAddress());
    	    boolean same_city = (this.city == other.getCity());
    	    boolean same_zip = (this.zipcode == other.getZipcode());
    	    boolean same_phone = (this.phone == other.getPhone());
    	    boolean same_u_type = (this.userType == other.getUserType());
    	    boolean same_date_joined = (this.dateJoined == other.getDateJoined());
    	    boolean same_pic = (this.profilePic == other.getProfilePic());
    	    	
    	    if(same_address && same_city && same_date_joined && same_email && 
    	    		same_f_name && same_l_name && same_id && same_pass && same_phone &&
    	    		same_u_type && same_zip && same_pic) return true;
    	    		else return false;
    	}
    	else return false;
    
    }

}