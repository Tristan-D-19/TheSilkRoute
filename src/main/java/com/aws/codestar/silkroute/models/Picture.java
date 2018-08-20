package com.aws.codestar.silkroute.models;

public class Picture{

    private long picture_id;
    private long owner_id;
    private String creation_date;

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

	public String getCreation_date()
	{
		return this.creation_date;
	}

	public void setCreation_date(String creation_date)
	{
		this.creation_date = creation_date;
	}
}