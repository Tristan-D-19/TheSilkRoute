package com.aws.codestar.silkroute.models;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Blob;

@Entity
@Table(name="tsr_picture")
public class Picture{

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 @GeneratedValue(strategy=GenerationType.AUTO)
//     @SequenceGenerator(name = "pic_id_gen", sequenceName = "pic_id_gen", initialValue = 50000000, allocationSize = 100)
    private long pictureId;
	 
	 
	 @ManyToOne
    private User user;
 
	 @Column(name="creation_date", nullable=false)
	private Date creationDate;
	 
	 @Column(name="image", nullable=false)
	private Blob image;

	
	public Picture() {
		
	}
	
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