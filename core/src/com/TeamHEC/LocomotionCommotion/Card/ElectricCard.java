package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Player.Player;

public class ElectricCard extends ResourceCard {

	private static final long serialVersionUID = 1L;

	public ElectricCard(Player player) {
		super(player, Game_TextureManager.getInstance().game_card_electriccard, "Electric");
	}

}
