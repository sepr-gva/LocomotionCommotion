package com.TeamHEC.LocomotionCommotion.Map;

import java.io.Serializable;
import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Event.Event;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_Station;
import com.TeamHEC.LocomotionCommotion.Resource.Fuel;
import com.TeamHEC.LocomotionCommotion.Train.Train;

public class MapObj implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public Train[] trains;
	public Event currentEvent;
	
	private Game_Map_Station actor;
	
	public ArrayList<Connection> connections = new ArrayList<Connection>();
	
	public float x, y;
	
	public MapObj(float x, float y)
	{
		this.x = x;
		this.y = y;
		
		trains = new Train[3];
		currentEvent = new Event(); 
		
		actor = new Game_Map_Station(this, x, y); // REK = 215, 820
	}
	
	public Game_Map_Station getActor()
	{
		return actor;
	}
	
	public Train[] getTrains()
	{
		return trains;
	}
	
	public Event getEvent()
	{
		return currentEvent;
	}
	
	// ==========  Methods overridden in station =============
	
	public String getName()
	{
		return "Overriden by Station";
	}
	
	public int getTotalRent()
	{
		return -1;
	}
	
	public String getFuelString()
	{
		return null;
	}
	
	public Fuel getFuelType()
	{
		return null;
	}
}