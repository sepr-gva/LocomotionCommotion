package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Map.Junction;

public class Game_Map_Junction extends Game_Map_MapObj{
	
	private Junction junction;
	public float offset = 0;
	
	public Game_Map_Junction(Junction junction, float actorX, float actorY)
	{
		super(actorX, actorY, Game_Map_TextureManager.getInstance().junction, Game_Map_TextureManager.getInstance().junctionx2);
		
		this.junction = junction;
	}
}
