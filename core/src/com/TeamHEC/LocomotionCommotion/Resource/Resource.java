package com.TeamHEC.LocomotionCommotion.Resource;

public class Resource {

	private int value;
	private String type;
	
	public Resource(int value, String type)
	{
		this.value = value;
		this.type = type;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public String getType()
	{
		return type;
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