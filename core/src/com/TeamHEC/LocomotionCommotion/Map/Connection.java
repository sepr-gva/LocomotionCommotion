package com.TeamHEC.LocomotionCommotion.Map;

import com.badlogic.gdx.math.Vector2;

public class Connection{
	
	private MapObj startMapObj, endMapObj;
	private float length;
	
	private Vector2 vector;

	/**
	 * A connection between two adjacent MapObjs in the Map.
	 * Defubes the distance between them (length0 and direction (vector) 
	 * @param startMapObj Where the connection begins
	 * @param endMapObj Where the connection ends
	 */
	public Connection(MapObj startMapObj, MapObj endMapObj)
	{
		this.startMapObj = startMapObj;
		this.endMapObj = endMapObj;
		
		float dX =  endMapObj.x - startMapObj.x;
		float dY =  endMapObj.y - startMapObj.y;
		
		// Creates a vector so we can find the length and normalise for direction:
		vector = new Vector2(dX, dY);
		
		length = vector.len();
		vector.nor();
	}
	
	/**
	 * @return the length between the start and end of a connection
	 */
	public float getLength()
	{
		return length;
	}
	
	/**
	 * @return A normalised vector of the direction needed to reach the end of the connection
	 */
	public Vector2 getVector()
	{
		return vector;
	}
	
	/**
	 * @return the start of a connection
	 */
	public MapObj getStartMapObj()
	{
		return startMapObj;
	}
	/**
	 * @return the destination of a connection
	 */
	public MapObj getDestination()
	{
		return endMapObj;
	}
}