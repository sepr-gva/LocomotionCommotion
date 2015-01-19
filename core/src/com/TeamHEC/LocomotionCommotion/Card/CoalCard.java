package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Player.Player;

/**
 *  
 * @author Callum Hewitt <ch1194@york.ac.uk> 
 *
 */

public class CoalCard extends ResourceCard{

	private static final long serialVersionUID = 1L;

	public CoalCard(Player player)
	{
		super(player, Game_TextureManager.getInstance().game_card_coalcard, "Coal" );
	}
}