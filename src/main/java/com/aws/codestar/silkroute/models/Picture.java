package com.aws.codestar.silkroute.models;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Blob;

@Entity
public class Picture{

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
     @SequenceGenerator(name = "pic_id_gen", sequenceName = "pic_id_gen", initialValue = 50000000, allocationSize = 100)
    private long picture_id;
	 
	 
	 @ManyToOne
    private User user;
 
	 @Column(name="creation_date")
	private Date creation_date;
	 
	 @Column(name="image")
	private Blob image;

	
	public Blob getImage()
	{
		return this.image;
	}

	public void setImage(Blob image)
	{
		this.image = image;
	}
	public User getUser() {
			return user;
		}
	
		public void setUser(User user) {
			this.user = user;
		}
	public long getPicture_id()
	{
		return this.picture_id;
	}

	public void setPicture_id(long picture_id)
	{
		this.picture_id = picture_id;
	}

	
	public Date getCreation_date()
	{
		return this.creation_date;
	}

	public void setCreation_date(Date creation_date)
	{
		this.creation_date = creation_date;
	}
}