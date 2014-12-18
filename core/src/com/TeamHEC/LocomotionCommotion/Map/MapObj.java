package com.TeamHEC.LocomotionCommotion.Map;

import java.io.Serializable;
import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Event.Event;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.badlogic.gdx.graphics.Texture;

public class MapObj implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public Train[] trains;
	public Event currentEvent;
	
	// could use this somehow for selecting MapObjs?
	private Texture blipImage = Game_TextureManager.mapBlip;
	
	public ArrayList<Connection> connections = new ArrayList<Connection>();
	
	public float x, y;
	
	public MapObj()
	{
		trains = new Train[3];
		currentEvent = new Event(); 
	}
	
	public void showBlip()
	{
		// texture. add ?
	}
	
	public void hideBlip()
	{
		// Texture.remove ?
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