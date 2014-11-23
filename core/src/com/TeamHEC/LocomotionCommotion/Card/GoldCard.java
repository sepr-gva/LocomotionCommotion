package com.TeamHEC.LocomotionCommotion.Card;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class GoldCard extends Card{

	// This is just an example, we shouldn't really be able to buy this in the shop
	
	public GoldCard()
	{
		super("100 Gold Coins", "Cash in to win 100 Gold coins", 50, null);
	}
	
	// This might be able to go into the super class somehow, but then again if we
	// call the method the same thing in each subclass it might be okay:
	public void implementCard()
	{
		getOwner().setGold(getOwner().getGold() + 100);
		// Need to destroy card instance here or something
	}
}