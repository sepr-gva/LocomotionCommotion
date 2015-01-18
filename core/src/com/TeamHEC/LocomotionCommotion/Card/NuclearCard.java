package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Player.Player;

public class NuclearCard extends ResourceCard {

	private static final long serialVersionUID = 1L;

	public NuclearCard(Player player) {
		super(player, Game_TextureManager.getInstance().game_card_nuclearcard, "Nuclear");
	}

}
