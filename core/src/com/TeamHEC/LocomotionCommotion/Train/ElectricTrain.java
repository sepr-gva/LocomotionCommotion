package com.TeamHEC.LocomotionCommotion.Train;

import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;

/**
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 */

public class ElectricTrain extends Train{
	
	private static final long serialVersionUID = 1L;
	private static final int BASE_SPEED = 15;
	private static final int BASE_CARRIAGE_LIMIT = 3;
	private static final int VALUE = 500;

	public ElectricTrain(int speedMod, int carriageLimitMod, boolean inStation, Route route, Player player)
	{
		// Name, Fuel, baseSpeed, speedMod, baseCarriageLimit, carriageLimitMod, value, inStation
		super("Electrix", new Electric(200), BASE_SPEED, speedMod, BASE_CARRIAGE_LIMIT, carriageLimitMod, VALUE, inStation,
				route, player);
		fuelPerTurn = 30;
	}
}
