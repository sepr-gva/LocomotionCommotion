package com.TeamHEC.LocomotionCommotion.Train;

import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Oil;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class OilTrain extends Train{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BASE_SPEED = 5;
	private static final int BASE_CARRIAGE_LIMIT = 2;
	private static final int VALUE = 350;

	public OilTrain(int speedMod, int carriageLimitMod, boolean inStation, Route route, Player player)
	{
		super("Diesel Weasel", new Oil(200), BASE_SPEED, speedMod, BASE_CARRIAGE_LIMIT, carriageLimitMod, VALUE, inStation,
				route, player);
		fuelPerTurn = 20;
	}
}
