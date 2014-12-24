package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;

/**
 * 
 * @author  Robert Precious <rp825@york.ac.uk>
 * Just making the cards work.
 *
 */

public class CoalCard extends Card{

	private static final long serialVersionUID = 1L;

	public CoalCard()
	{
		super("100 Coal", "Cash in to win 100 Coal", 50, null, Game_TextureManager.game_card_coalcard);
	}
	
	@Override
	public void implementCard()
	{
		getOwner().addFuel("Coal", 100);
		GameScreen.coal += 100;
		// Need to destroy card instance here or something
	}
}