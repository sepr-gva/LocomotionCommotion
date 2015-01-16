package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Train.Train;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class TeleportCard extends Card{

	/*
		Teleport a train from one station to another...
	
	 Each card needs a implement method but also needs feedback from the UI
	 so the user can choose a train and a new station...
	 
	*/
	
	private static final long serialVersionUID = 1L;
	
	public TeleportCard(Player player)
	{
		super(player, Game_TextureManager.getInstance().game_card_teleportcard);
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
