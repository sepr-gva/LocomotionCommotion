package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;

/**
 * 
 * @author  Robert Precious <rp825@york.ac.uk>
 * Just making the cards work.
 *
 */

public class OilCard extends Card{

	// This is just an example, we shouldn't really be able to buy this in the shop
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OilCard()
	{
		super("100 Oil", "Cash in to win 100 Oil", 50, null,Game_TextureManager.game_card_oilcard);
	}
	
	// This might be able to go into the super class somehow, but then again if we
	// call the method the same thing in each subclass it might be okay:
	public void implementCard()
	{
		//getOwner().addFuel("Oil", 100);
		GameScreen.oil+=100;
		// Need to destroy card instance here or something
	}
	
}