package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class GoldCard extends Card{

	private static final long serialVersionUID = 1L;

	public GoldCard()
	{
		super("100 Gold Coins", "Cash in to win 100 Gold coins", 50, null, Game_TextureManager.game_card_goldcard);
	}
	
	@Override
	public void implementCard()
	{
		getOwner().addGold(100);
		GameScreen.gold+=100;
		// Need to destroy card instance here or something
	}
}