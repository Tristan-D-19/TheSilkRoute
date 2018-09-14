package com.aws.codestar.silkroute.models;
import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;


@Entity
@Table(name="tsr_picture")

public class Picture{

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pictureId;
	 
	 
	 @ManyToOne(cascade = {CascadeType.ALL})
    private User user;
 
	 @Column(name="creation_date", nullable=false)
	private Date creationDate;
	 
	 @Column(name="image", nullable=false)
	private String imageUrl;

	 protected Picture() {
		 
	 }
	
	public Picture(User user, String imageUrl) {
		this.creationDate = new Date(Calendar.getInstance().getTime().getTime());
		this.user = user;
		this.imageUrl = imageUrl;
	}
	
	public String getImageUrl()
	{
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl)
	{
		this.imageUrl = imageUrl;
	}
	public User getUser() {
			return user;
		}
	
		public void setUser(User user) {
			this.user = user;
		}
	public long getPictureId()
	{
		return this.pictureId;
	}

	public void setPictureId(long pictureId)
	{
		this.pictureId = pictureId;
	}

	
	public Date getCreationDate()
	{
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
	}
}