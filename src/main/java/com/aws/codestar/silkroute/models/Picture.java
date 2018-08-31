package com.aws.codestar.silkroute.models;

import java.sql.Date;
import java.sql.Blob;
public class Picture{

    private long picture_id;
    private long owner_id;
    private Date creation_date;
	private Blob image;

	
	public Blob getImage()
	{
		return this.image;
	}

	public void setImage(Blob image)
	{
		this.image = image;
	}

	public long getPicture_id()
	{
		return this.picture_id;
	}

	public void setPicture_id(long picture_id)
	{
		this.picture_id = picture_id;
	}

	public long getOwner_id()
	{
		return this.owner_id;
	}

	public void setOwner_id(long owner_id)
	{
		this.owner_id = owner_id;
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