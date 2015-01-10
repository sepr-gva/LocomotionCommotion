package com.TeamHEC.LocomotionCommotion.Resource;

import java.io.Serializable;

public class Resource implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int value;
	
	public Resource(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public void subValue(int subVal) 
	{
		this.value = this.value - subVal;		
	}
	
	public void subValue(Resource subResource)
	{
		this.value = this.value - subResource.getValue();
	}
	
	public void addValue(int addVal) 
	{
		this.value = this.value + addVal;		
	}
	
	public void addValue(Resource addResource)
	{
		this.value = this.value + addResource.getValue();
	}
}