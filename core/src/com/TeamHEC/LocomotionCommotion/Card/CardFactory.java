package com.TeamHEC.LocomotionCommotion.Card;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Event.EventListener;
import com.TeamHEC.LocomotionCommotion.Player.Player;

/*
- Hard-coded list of card effects, will randomly choose an effect.
- There will be unique cards associated to special goals.

Once generated, it will either be associated with a goal object or directly with the player.
 - Given as a reward after completing goals

Every time a player purchases a new station, CardFactory will generate a new Card object and associate it
directly with the player.
	A) create a stationPurchased listener
*/

public class CardFactory implements EventListener{
	
	// Single instance of CardFactory:
	public static CardFactory INSTANCE = new CardFactory();
	public static CardFactory getInstance()
	{
		return INSTANCE;
	}
	
	// list of available cards:
	public ArrayList<String> cardList = new ArrayList<String>();
	
	private final String TELEPORT = "Teleport";
	private final String GOLD_COINS = "100 Gold Coins";
	
	private CardFactory()
	{
		cardList.add(TELEPORT);
		cardList.add(GOLD_COINS);
	}

	// returns a card from the existing list:
	public Card createCard()
	{
		String chosenCard = chooseCard();
		Card newCard = null;
		
		if(chosenCard.equals(TELEPORT))
			newCard = new TeleportCard();
		else if(chosenCard.equals(GOLD_COINS))
			newCard = new GoldCard();
			
		return newCard;
	}
	
	public String chooseCard()
	{
		return cardList.get(getIntBetween(0, cardList.size()));
	}
	
	public int getIntBetween(int low, int high)
	{
		return (int)(low + (Math.random() * (high - low)));
	}
	
	// need to go over how this would be implemented:
	// http://stackoverflow.com/questions/6270132/create-a-custom-event-in-java
	@Override
	public void stationPurchased(Player byPlayer)
	{

	}
}
