package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_TextureManager;

public class NuclearCard extends ResourceCard {

	private static final long serialVersionUID = 1L;

	public NuclearCard(Player player) {
		super(player, Game_TextureManager.getInstance().game_card_nuclearcard, "Nuclear");
	}

}
