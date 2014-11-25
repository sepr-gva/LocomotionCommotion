package com.TeamHEC.LocomotionCommotion.Map;

import com.TeamHEC.LocomotionCommotion.Event.Event;
import com.TeamHEC.LocomotionCommotion.Train.Train;

public class MapObj {
	
	public Train[] trains;
	public Event currentEvent;
	
	public MapObj()
	{
		trains = new Train[3];
		currentEvent = new Event();
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