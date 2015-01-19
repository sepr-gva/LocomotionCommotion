package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class GoldCard extends Card{

	private static final long serialVersionUID = 1L;

	public GoldCard(Player player)
	{
		super(player, Game_TextureManager.getInstance().game_card_goldcard, "Gold");
	}
	
	@Override
	public void implementCard()
	{
		getOwner().addGold(100);
		GameScreen.gold+=100;
		// Need to destroy card instance here or something
	}
}