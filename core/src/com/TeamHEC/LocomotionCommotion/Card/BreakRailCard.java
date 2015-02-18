package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.MapActors.Game_Map_Manager;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.UI_Elements.WarningMessage;

public class BreakRailCard extends Card {

	public MapObj firstObj = null;
	
	public BreakRailCard(Player player) {
		super(player, Game_TextureManager.getInstance().game_card_breakrailcard, "Break Rail");
	}
	
	@Override
	public void implementCard(){
		
		WarningMessage.fireWarningWindow("CHOOSE FIRST STATION", "Choose the start city of the connection you want to break.");
		
		Game_Map_Manager.currentBreakCard = this;
		
		Game_Map_Manager.firstBreakCity = true;
	
		Game_Map_Manager.trainsUntouchable();
		
		/**
		 * Set the currentBreakCard to this to keep track of the first city clicked on, set firstbreakcity to 
		 * true to show that the next city clicked on is the first in the break sequence, make trains untouchable
		 * so that you can click cities behind trains
		 * 
		 * Go to Game_Map_Station.onClicked() to follow implementation
		 */
	}

}
