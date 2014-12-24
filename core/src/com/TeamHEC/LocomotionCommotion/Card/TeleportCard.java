package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
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
	
	public TeleportCard()
	{
		// Name, Description, Value, Owner:
		super("Teleport", "Teleport a Train from one station to another!", 100, null, null);
	}
	
	// Needs testing obviously but you could do it somehow like this:
	@Override
	public void implementCard()
	{
		// Need a way to choose the train:
		Train train = getOwner().getTrains().get(0);
		
		// Need a way to choose station:
		MapObj chosenLocation = WorldMap.getInstance().stationsList.get(0);
		
		train.route.getRoute().clear();
		train.route.setRouteIndex(0);
		train.route.setConnectionedTravelled(0);
		
		train.route.setCurrentMapObj(chosenLocation);
	}
}
