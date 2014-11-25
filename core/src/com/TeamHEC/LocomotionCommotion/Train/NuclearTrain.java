package com.TeamHEC.LocomotionCommotion.Train;

import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class NuclearTrain extends Train{
	
	private static final int BASE_SPEED = 10;
	private static final int BASE_CARRIAGE_LIMIT = 5;
	private static final int VALUE = 750;

	public NuclearTrain(int speedMod, int carriageLimitMod, boolean inStation)
	{
		super("Atom Bomb", new Nuclear(200), BASE_SPEED, speedMod, BASE_CARRIAGE_LIMIT, carriageLimitMod, VALUE, inStation);
		fuelPerTurn = 50;
	}
}
