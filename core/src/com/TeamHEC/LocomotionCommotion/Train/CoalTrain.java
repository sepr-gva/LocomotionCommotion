package com.TeamHEC.LocomotionCommotion.Train;

public class CoalTrain extends Train {

	/*
	  The Slowest of all the train types but the cheapest fuel available 
	 
	 */
	
	public CoalTrain(int baseSpeed, int baseCarriageLimit, int value,boolean inStation)
	{
		super(baseSpeed, baseCarriageLimit, value, inStation);
	}
}
