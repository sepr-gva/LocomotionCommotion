package com.TeamHEC.LocomotionCommotion.Train;

import com.TeamHEC.LocomotionCommotion.Resource.Oil;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class OilTrain extends Train{
	
	private static final int BASE_SPEED = 3;
	private static final int BASE_CARRIAGE_LIMIT = 2;
	private static final int VALUE = 350;

	public OilTrain(int speedMod, int carriageLimitMod, boolean inStation)
	{
		super("Diesel Weasel", new Oil(200), BASE_SPEED, speedMod, BASE_CARRIAGE_LIMIT, carriageLimitMod, VALUE, inStation);
		fuelPerTurn = 20;
	}
}
