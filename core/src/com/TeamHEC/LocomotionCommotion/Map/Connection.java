package com.TeamHEC.LocomotionCommotion.Map;

public class Connection{
	
	private MapObj startMapObj, endMapObj;
	private float length;

	public Connection(MapObj startMapObj, MapObj endMapObj)
	{
		this.startMapObj = startMapObj;
		this.endMapObj = endMapObj;
		
		float dX =  Math.abs(startMapObj.x - endMapObj.x);
		float dY =  Math.abs(startMapObj.y - endMapObj.y);
		length = (float) Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
	}
	
	public float getLength()
	{
		return length;
	}
	
	public void setLength(float length)
	{
		this.length = length;
	}
	
	public MapObj getStartMapObj()
	{
		return startMapObj;
	}
	
	public MapObj getDestination()
	{
		return endMapObj;
	}
}