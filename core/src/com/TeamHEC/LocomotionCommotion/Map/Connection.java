package com.TeamHEC.LocomotionCommotion.Map;

import com.badlogic.gdx.math.Vector2;

public class Connection{
	
	private MapObj startMapObj, endMapObj;
	private float length;
	
	private Vector2 vector;

	public Connection(MapObj startMapObj, MapObj endMapObj)
	{
		this.startMapObj = startMapObj;
		this.endMapObj = endMapObj;
		
		float dX =  startMapObj.x - endMapObj.x;
		float dY =  startMapObj.y - endMapObj.y;
		vector = new Vector2(dX, dY);
		
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
	
	public Vector2 getVector()
	{
		return vector;
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