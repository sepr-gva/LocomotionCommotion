package com.TeamHEC.LocomotionCommotion.Map;

import java.io.Serializable;
import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Event.Event;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_MapObj;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Train.Train;

public class MapObj implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public Train[] trains;
	public Event currentEvent;
	
	public Game_Map_MapObj actor;

	public ArrayList<Connection> connections = new ArrayList<Connection>();
	
	public float x, y;
	
	protected ArrayList<StationListener> listeners = new ArrayList<StationListener>();
	
	protected Player player1;//the players station will listen too
	protected Player player2;//will need name changes later, not sure this listener stuff is still gonna be used
	
	public Station stationObj;
		
	public MapObj(float x, float y)
	{
		this.x = x;
		this.y = y;
		
		trains = new Train[3];
		currentEvent = new Event(); 
	}
	
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