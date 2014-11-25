package com.TeamHEC.LocomotionCommotion.Map;

public class Track extends MapObj {
	
	private boolean isJunction;
	
	public Track()
	{
		isJunction = false;
	}
	
	public Track(boolean isJunction)
	{
		this.isJunction = isJunction;
	}
	
	public boolean isJunction()
	{
		return isJunction;
	}
}