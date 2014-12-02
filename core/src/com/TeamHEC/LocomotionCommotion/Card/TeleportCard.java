package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Map.Station;
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeleportCard()
	{
		// Name, Description, Value, Owner:
		super("Teleport", "Teleport a Train from one station to another!", 100, null);
	}
	
	public Train getSelectedTrain()
	{
		return null;
	}
	
	public Station getStartStation()
	{
		return null;
	}
	
	public Station getSelectedStation()
	{
		return null;
	}
}
