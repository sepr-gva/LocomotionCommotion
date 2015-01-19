package com.TeamHEC.LocomotionCommotion.Card;

import java.util.Random;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Player.Shop;

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
		Random random = new Random();
		getOwner().addGold(Shop.cardPrice/2 + random.nextInt(Shop.cardPrice));
	}
}