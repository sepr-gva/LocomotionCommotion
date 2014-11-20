package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Event.EventListener;
import com.TeamHEC.LocomotionCommotion.Player.Player;

public class CardFactory implements EventListener{

	/*
	 Hard-coded list of card effects, will randomly choose an effect. There will be unique cards
	 associated to special goals.
	 
	 Once generated, it will either be associated with a goal object or directly with the player.
	 
	 Every time a player purchases a new station, CardFactory will generate a new Card object and associate it
	 directly with the player.
	 	A) create a stationPurchased listener
	 	
	 Example card effect:
	 	- Teleport trains from one station to another...
	 */
	
	// need to go over how this would be implemented: http://stackoverflow.com/questions/6270132/create-a-custom-event-in-java
	
	@Override
	public void stationPurchased(Player byPlayer) {
		// TODO Auto-generated method stub
		
	}
}
