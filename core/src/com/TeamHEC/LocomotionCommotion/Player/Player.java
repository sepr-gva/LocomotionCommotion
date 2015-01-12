package com.TeamHEC.LocomotionCommotion.Player;

import java.io.Serializable;
import java.util.ArrayList;


import java.util.HashMap;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Card.CardFactory;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
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
import com.TeamHEC.LocomotionCommotion.Train.Route;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 * @author Callum Hewitt <ch1194@york.ac.uk>
 *
 */

public class Player implements Serializable{

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
	public int[] lines = new int[8];
	protected ArrayList<PlayerListener> listeners = new ArrayList<PlayerListener>();
	
	private HashMap<String, Fuel> playerFuel;
	
	public boolean isPlayer1;
	
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
		for (int i=0; i<3; i++)
		{	
			if (((i > 0) && (station.getLineType()[i] != station.getLineType()[i-1])) || (i==0))
				//Line is an array of 3 line colours, this loop will add the first line colour
				//then if a station is on another line of a different colour it will add that
				//hence when i > 0 (checking the second colour) AND is a different colour to the previous colour
				//add that colour to the players lines
			{
				switch(station.getLineType()[i])
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
				case Brown:
					lines[6] += 1;
				case Orange:
					lines[7] += 1;
				}
			}
		}
		station.purchaseStation(this);
	}
	
	public void sellStation(Station station)
	{
		for (int i=0; i<3; i++)
		{	
			if (((i > 0) && (station.getLineType()[i] != station.getLineType()[i-1])) || (i==0))
			{
				//same method as in purchase station
				switch(station.getLineType()[i])
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
				case Brown:
					lines[6] -= 1;
				case Orange:
					lines[7] -= 1;
				}
			}
		}
		this.addGold((int)(station.getTotalValue() * 0.7));
		station.setOwner(null);
		stations.remove(station);
		station.purchaseStation(null);
	}
	
	public void stationTax()
	{
		for (int i=0; i < trains.size(); i++)
		{
			Route trainRoute = trains.get(i).getRoute();
			if (trainRoute.inStation())
			{
				Station currentStation = trainRoute.getStation();
				if (currentStation.getOwner() != this && currentStation.getOwner() == null)
				{
					this.subGold(currentStation.getTotalRent());
				}
			}
		}
	}
	
	private void lineBonuses()
	{
		//bonuses subject to change
		for (int i = 0; i < 6; i++)
		{
			switch(i)
			{
				case 0:
					//red bonus
					//nested case statements to give specific bonuses?
					/*
					switch(lines[i])
					{
						case 1:
							this.addFuel("coal", 50); //will fill in and uncomment once bonuses are decided
						case 2:
						case 3:
						case 4:
						//case 5: //?
					}
					*/
				case 1:
					//blue bonus
				case 2:
					//green bonus
				case 3:
					//yellow bonus
				case 4:
					//purple bonus
				case 5:
					//black bonus
				case 6:
					//brown bonus
				case 7:
					//orange bonus
			}
		}
	}
	
	public void stationRewards()
	{
		for (int i = 0; i < stations.size(); i++)
		{
			Station currentStation = stations.get(i);
			this.addFuel(currentStation.getResourceType().toString(), currentStation.getTotalResourceOut());
		}
		lineBonuses();
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
}
