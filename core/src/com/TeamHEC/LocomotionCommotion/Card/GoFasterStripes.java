package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Train.SpeedUpgrade;
import com.TeamHEC.LocomotionCommotion.Train.Train;

public class GoFasterStripes extends Card {

	private static final long serialVersionUID = 1L;

	public GoFasterStripes()
	{
		super("Go Faster Stripes",
				"Impress your friends and increases your Train speed by 10 with these fetching stripes", 50, null, null);
	}
	
	@Override
	public void implementCard()
	{
		// Need to choose the train somehow:
		Train train = getOwner().trains.get(0);
		SpeedUpgrade speedUpgrade = new SpeedUpgrade(train);
		train.addUpgrade(speedUpgrade);
	}
}