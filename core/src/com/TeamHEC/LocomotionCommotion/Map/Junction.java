package com.TeamHEC.LocomotionCommotion.Map;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_Junction;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_Station;

public class Junction extends MapObj {
	
	private static final long serialVersionUID = 1L;

	public Junction(float xPos, float yPos)
	{
		super(xPos, yPos);
		actor = new Game_Map_Junction(this, x, y);
	}
}
