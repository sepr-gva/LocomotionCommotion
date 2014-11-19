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
	// surely we don't need both addValue and subValue methods? just use setValue?
}