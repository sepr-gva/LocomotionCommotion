package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_TextureManager;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 * Teleports a card
 */

public class TeleportCard extends Card{

	/*
		Teleport a train from one station to another...
	
	 Each card needs a implement method but also needs feedback from the UI
	 so the user can choose a train and a new station...
	 
	*/
		
	public TeleportCard(Player player)
	{
		super(player, Game_TextureManager.getInstance().game_card_teleportcard, "Teleport");
	}
	
	@Override
	public void implementCard()
	{
		// Need a way to choose the train:
		Train train = getOwner().getTrains().get(0);
		
		// Need a way to choose station:
		MapObj chosenLocation = WorldMap.getInstance().stationsList.get(0);
		
		train.route.getRoute().clear();
		train.route.setRouteIndex(0);
		train.route.setConnectionTravelled(0);
		
		train.route.setCurrentMapObj(chosenLocation);
	}
}
