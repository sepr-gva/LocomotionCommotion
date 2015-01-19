package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_TextureManager;

/**
 * 
 * @author  Callum Hewitt <ch1194@york.ac.uk>
 *
 */

public class OilCard extends ResourceCard{

	private static final long serialVersionUID = 1L;

	public OilCard(Player player)
	{
		super(player, Game_TextureManager.getInstance().game_card_oilcard, "Oil");
	}

}