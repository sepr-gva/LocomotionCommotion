package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Game.GameScreen;
import com.TeamHEC.LocomotionCommotion.Map.Connection;
import com.TeamHEC.LocomotionCommotion.Map.Junction;
import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
import com.TeamHEC.LocomotionCommotion.MapActors.Game_Map_Manager;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.UI_Elements.GameScreenUI;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.UI_Elements.WarningMessage;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_Shop.Game_ShopManager;
import com.badlogic.gdx.graphics.Texture;

public class FixRailCard extends Card {

	public MapObj firstObj = null;
	
	public FixRailCard(Player player) {
		super(player, Game_TextureManager.getInstance().game_card_fixrailcard, "Fix Rail");
	}
	
	@Override
	public void implementCard(){
		
		WarningMessage.fireWarningWindow("CHOOSE FIRST STATION", "Choose the start city of the connection you want to fix.");
			
		Game_Map_Manager.currentFixCard = this;
			
		Game_Map_Manager.firstFixCity = true;
			
		Game_Map_Manager.trainsUntouchable();
	}
}