package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.MapActors.Game_Map_Manager;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.UI_Elements.WarningMessage;

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
		
		/**
		 * Set the currentFixCard to this to keep track of the first city clicked on, set firstfixcity to 
		 * true to show that the next city clicked on is the first in the fix sequence, make trains untouchable
		 * so that you can click cities behind trains
		 * 
		 * Go to Game_Map_Station.onClicked() to follow implementation
		 */
	}
}