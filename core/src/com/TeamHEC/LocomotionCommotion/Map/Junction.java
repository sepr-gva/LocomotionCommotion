package com.TeamHEC.LocomotionCommotion.Map;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_Junction;

/**
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 */
public class Junction extends MapObj {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a Junction using it's coordinates as parameters
	 */
	public Junction(float xPos, float yPos)
	{
		super(xPos, yPos);
		actor = new Game_Map_Junction(this, x, y);
	}
}
