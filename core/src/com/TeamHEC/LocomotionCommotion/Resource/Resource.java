package com.TeamHEC.LocomotionCommotion.Resource;

public class Resource {
	
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
	// surely we don't need both addValue and subValue methods? just use setValue?
	
	// Callum: It makes life easier when using the class and doesn't take much to do. 
}