package com.TeamHEC.LocomotionCommotion.Train;

import com.TeamHEC.LocomotionCommotion.Resource.Coal;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class CoalTrain extends Train {

	private static final int BASE_SPEED = 1;
	private static final int BASE_CARRIAGE_LIMIT = 1;
	private static final int VALUE = 200;
		
	public CoalTrain(int speedMod, int carriageLimitMod, boolean inStation)
	{
		super("Steam Machine", new Coal(200), BASE_SPEED, speedMod, BASE_CARRIAGE_LIMIT, carriageLimitMod, VALUE, inStation);
		fuelPerTurn = 10;
	}
}
