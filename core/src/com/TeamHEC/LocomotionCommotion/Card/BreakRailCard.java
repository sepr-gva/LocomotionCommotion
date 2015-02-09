package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_TextureManager;
import com.badlogic.gdx.graphics.Texture;

public class BreakRailCard extends Card {

	public BreakRailCard(Player player) {
		super(player, Game_TextureManager.getInstance().game_card_breakrailcard, "Break Rail");
	}
	
	@Override
	public void implementCard(){
	}

}
