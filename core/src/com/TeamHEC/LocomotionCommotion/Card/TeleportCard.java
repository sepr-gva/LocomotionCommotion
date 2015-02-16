package com.TeamHEC.LocomotionCommotion.Card;

import java.util.Random;

import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
import com.TeamHEC.LocomotionCommotion.MapActors.Game_Map_Manager;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.UI_Elements.WarningMessage;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 * Teleports a train (currently to London should be changed and worked in with UI so it teleports to a specified location).
 */

public class TeleportCard extends Card{
	
	public Train train = null;
	public Station station = null;
	
	/**
	 * Initialises the card
	 * @param player The owner of the card.
	 */
	public TeleportCard(Player player)
	{
		super(player, Game_TextureManager.getInstance().game_card_teleportcard, "Teleport");
	}
	
	@Override
	/**
	 * Takes the owner's first train in their trains list and moves it to London.
	 * Should be changed in Assessment 3 to teleport either random trains to random locations or a specified train to a specified location.
	 */
	public void implementCard()
	{
		// Need a way to choose the train:
		//Train train = getOwner().getTrains().get(0);
		
		WarningMessage.fireWarningWindow("CHOOSE TRAIN", "Choose the train you want Teleport.");
		Game_Map_Manager.currentTeleportCard = this;
		Game_Map_Manager.teleportTrain = true;
		
		//Randomly selects a station from the list of stations
		//Random rnd = new Random();
		//int randomIndex = rnd.nextInt(WorldMap.getInstance().stationsList.size());
		
		//MapObj chosenLocation = WorldMap.getInstance().stationsList.get(randomIndex);
		
		
		//train.route.getRoute().clear();
		//train.route.setRouteIndex(0);
		//train.route.setConnectionTravelled(0);
		
		//train.route.setCurrentMapObj(station);
	}
}
