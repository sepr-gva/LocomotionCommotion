package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_TextureManager;

public class ElectricCard extends ResourceCard {

	private static final long serialVersionUID = 1L;

	public ElectricCard(Player player) {
		super(player, Game_TextureManager.getInstance().game_card_electriccard, "Electric");
	}

}
