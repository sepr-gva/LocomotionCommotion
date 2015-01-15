package com.TeamHEC.LocomotionCommotion.Map;

import java.io.Serializable;
import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Event.Event;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_MapObj;
import com.TeamHEC.LocomotionCommotion.Train.Train;

public class MapObj implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public Train[] trains;
	public Event currentEvent;
	
	public Game_Map_MapObj actor;

	public ArrayList<Connection> connections = new ArrayList<Connection>();
	
	public float x, y;
	
	/**
	 * Every Station and Junction on the map
	 * @param x xPosition on map
	 * @param y yPosition on map
	 */
	public MapObj(float x, float y)
	{
		this.x = x;
		this.y = y;
		
		trains = new Train[3];
		currentEvent = new Event(); 
	}
	
	/**
	 * @return returns null if not a station, or is overwritten by Station subclass
	 */
	public Station getStation()
	{
		return null;
	}
	/**
	 * 
	 * @return The Actor (UI element) associated with the MapObj
	 */
	public Game_Map_MapObj getActor()
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
}