package com.TeamHEC.LocomotionCommotion.Player;

import java.io.Serializable;
import java.util.ArrayList;


import java.util.HashMap;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Card.CardFactory;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Map.Line;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Player.Shop;
import com.TeamHEC.LocomotionCommotion.Resource.Fuel;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Carriage;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Oil;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;
import com.TeamHEC.LocomotionCommotion.Train.Train;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 * @author Callum Hewitt <ch1194@york.ac.uk>
 *
 */

public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public int points;
	private Gold gold;
	private Coal coal;
	private Oil oil;
	private Electric electric;
	private Nuclear nuclear;
	public ArrayList<Card> cards;
	private Shop shop;
	public ArrayList<Goal> goals;
	public ArrayList<Train> trains;
	public Carriage carriages;
	public ArrayList<Station> stations;
	public int[] lines = new int[6];
	protected ArrayList<PlayerListener> listeners = new ArrayList<PlayerListener>();
	
	private HashMap<String, Fuel> playerFuel;
	
	public Player(String name, int points, Gold gold, Coal coal, Electric electric, Nuclear nuclear, Oil oil, 
				Carriage carriage, ArrayList<Card> cards, ArrayList<Goal> goals, ArrayList<Train> trains,
				ArrayList<Station> stations)
	{
		this.name = name;
		this.points = points;
		this.gold = gold;
		this.coal = coal;
		this.oil = oil;
		this.electric = electric;
		this.nuclear = nuclear;
		this.cards = cards;
		this.shop = new Shop(this);
		this.goals = goals;
		this.trains = trains;
		this.carriages = carriage;
		this.stations = stations;
		for (int i = 0; i<6;i++)
		{
			this.lines[i] = 0;
		}
		
		playerFuel = new HashMap<String, Fuel>();
		
		playerFuel.put("Coal", this.coal);
		playerFuel.put("Electric", this.electric);
		playerFuel.put("Nuclear", this.nuclear);
		playerFuel.put("Oil", this.oil);
	}
		
	public String getName()
	{
		return name;
	}
	
	//Fuel	
	public int getFuel(String fuelType)
	{
		return playerFuel.get(fuelType).getValue();
	}

	public void addFuel(String fuelType, int quantity)
	{
		playerFuel.get(fuelType).addValue(quantity);
	}
	
	public void subFuel(String fuelType, int quantity)
	{
		playerFuel.get(fuelType).subValue(quantity);
	}

	//Gold
	public int getGold()
	{
		return gold.getValue();
	}

	public void addGold(int value)
	{
		gold.setValue(gold.getValue() + value);
	}
	
	public void subGold(int value)
	{
		gold.setValue(gold.getValue() - value);
	}
	
	//Carriages
	public int getCarriage() {		
		return carriages.getValue();
	}
	
	//Cards
	// Specific cards should be purchased in the shop
	// This can be used after completing Goals
	// (Could be implemented in Goal class)
	public void purchaseRandomCard()
	{
		if(getNumCards() < 3)
		{
			Card mCard = CardFactory.getInstance().createRandomCard();
			mCard.setOwner(this);
			cards.add(mCard);
		}
	}
	
	// Called when a card is purchased in the shop
	public void purchaseCard(Card card)
	{
		if(getNumCards() < 3)
		{
			card.setOwner(this); // Card has association with player
			cards.add(card); // Adds card to the players list of owned cards
		}
	}
	
	public int getNumCards()
	{
		return cards.size();
	}
	
	public ArrayList<Card> getCards()
	{
		return cards;
	}
	
	//Stations
	public int getNumStations()
	{
		return stations.size();
	}	

	public ArrayList<Station> getStations()
	{
		return stations;
	}
	
	public void purchaseStation(Station station)
	{
		stations.add(station);
		this.subGold(station.getTotalValue());
		switch(station.getLineType())
		{ //keeps track of how many of a line the player owns
		case Red:
			lines[0] += 1;			
		case Blue:
			lines[1] += 1;
		case Green:
			lines[2] += 1;
		case Yellow:
			lines[3] += 1;
		case Purple: 
			lines[4] += 1;
		case Black:
			lines[5] += 1;
		}
		for (PlayerListener listener: listeners)
		{
			listener.stationPurchased(station, this);
		}
	}
	
	
	
	public void sellStation(Station station)
	{
		switch(station.getLineType())
		{ //keeps track of how many of a line the player owns
		case Red:
			lines[0] -= 1;			
		case Blue:
			lines[1] -= 1;
		case Green:
			lines[2] -= 1;
		case Yellow:
			lines[3] -= 1;
		case Purple: 
			lines[4] -= 1;
		case Black:
			lines[5] -= 1;
		}
		this.addGold((int)(station.getTotalValue() * 0.7));
		stations.remove(station);
		
	}
	
	public void lineBonuses()
	{
		//bonuses subject to change
		//for now they only give gold
		for (int i = 0; i < 6; i++)
		{
			this.addGold(10 * lines[i]); //adds 10 gold per station on each line for now
			//will add more once map is sorted and lines and bonuses are chosen
		}
	}
	
	//Shop
	public void accessShop()
	{
		shop.openShop();
	}

	//Goals
	public void accessGoals(){}
	
	public ArrayList<Goal> getGoals()
	{
		return goals;
	}
	
	//Trains
	public ArrayList<Train> getTrains()
	{
		return trains;
	}
	
	//Listener
	public void addListener(PlayerListener listener)
	{
		listeners.add(listener);
	}	
}
