package com.aws.codestar.silkroute.models;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;


/**
 * This class is a representation of the user for TSR. This class contains all data relating to all users.  
 */
// @Entity
public class User {

    // @Id
    // @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String address;
    private String city; 
    private int zipcode; 
    private String state; 
    private int phone;
	private int user_type;
	private String date_joined;
	private boolean is_active;
	private long profile_pic;

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

	public int getUser_type()
	{
		return this.user_type;
	}

	public void setUser_type(int userType)
	{
		this.user_type = userType;
	}

	public String getDate_joined(){
		return date_joined;
	}
	public void setDate_joined(String dateJoined) {
		this.date_joined = dateJoined;
	}

	public boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
	public long getProfilePic() {
		return profile_pic;
	}
	public void setProfilePic(long pic) {
		this.profile_pic = pic;
	}
    @Override
    public String toString() {
        return String.format(
                "User[id=%d, firstName='%s', lastName='%s']",
                id, first_name, last_name);
    }

}