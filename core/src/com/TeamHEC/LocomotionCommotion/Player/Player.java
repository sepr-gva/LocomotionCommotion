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
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Oil;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;
import com.TeamHEC.LocomotionCommotion.Train.RouteListener;
import com.TeamHEC.LocomotionCommotion.Train.Train;

/**
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 * @author Callum Hewitt <ch1194@york.ac.uk>
 */

public class Player implements Serializable, RouteListener{

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
	public ArrayList<Station> stations = new ArrayList<Station>();
	public int[] lines = new int[8];
	private CardFactory cardFactory;

	private HashMap<String, Fuel> playerFuel;

	public boolean isPlayer1;

	public Player(String name, int points, Gold gold, Coal coal, Electric electric, Nuclear nuclear, Oil oil, ArrayList<Card> cards, ArrayList<Goal> goals, ArrayList<Train> trains)
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
		cardFactory = new CardFactory(this);

		//this.stations = stations;
		for (int i = 0; i<6;i++)
		{
			this.lines[i] = 0;
		}

		playerFuel = new HashMap<String, Fuel>();

		playerFuel.put("Coal", this.coal);
		playerFuel.put("Electric", this.electric);
		playerFuel.put("Nuclear", this.nuclear);
		playerFuel.put("Oil", this.oil);

		// Registers listeners for Routes:
		for(int i = 0; i < trains.size(); i++)
		{
			trains.get(i).route.register(this);
		}
	}

	public String getName()
	{
		return name;
	}

	//Shop
	public Shop getShop(){
		return shop;
	}
	public void buyCoal(int quantity)
	{
		shop.buyFuel("Coal", quantity);
	}
	public void buyOil(int quantity)
	{
		shop.buyFuel("Oil", quantity);
	}
	public void buyElectric(int quantity)
	{
		shop.buyFuel("Electric", quantity);
	}
	public void buyNuclear(int quantity)
	{
		shop.buyFuel("Nuclear", quantity);
	}
	public void buyCard(int quantity)
	{
		shop.buyCard();
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

	//Cards
	public void addCard(Card card)
	{
		cards.add(card);
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
		boolean validPurchase = false;
		for (int j=0; j < this.trains.size(); j ++)
		{
			if ((this.trains.get(j).isInStation() && this.trains.get(j).route.getStation().getOwner() == null) && (this.trains.get(j).getRoute().getStation() == station))
			{
				if (this.getGold() >= station.getBaseValue())
				{
					validPurchase = true;				

				}
				else
				{
					//not enough gold message
				}
			}
		}
		if (validPurchase)
		{
			stations.add(station);
			this.subGold(station.getBaseValue());
			for (int i=0; i<station.getLineType().length; i++)
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
						break;
					case Blue:
						lines[1] += 1;
						break;
					case Green:
						lines[2] += 1;
						break;
					case Yellow:
						lines[3] += 1;
						break;
					case Purple: 
						lines[4] += 1;
						break;
					case Black:
						lines[5] += 1;
						break;
					case Brown:
						lines[6] += 1;
						break;
					case Orange:
						lines[7] += 1;
						break;
					default:
						throw new IllegalArgumentException("Could not find line for Station: " + station.getName() + " owned by Player " + station.getOwner().name);
					}
				}
			}
			station.purchaseStation(this);
			this.lineBonuses();
		}
		else
		{
			//error message?
		}

	}

	public void sellStation(Station station)
	{
		if (this.stations.contains(station))
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
						break;
					case Blue:
						lines[1] -= 1;
						break;
					case Green:
						lines[2] -= 1;
						break;
					case Yellow:
						lines[3] -= 1;
						break;
					case Purple: 
						lines[4] -= 1;
						break;
					case Black:
						lines[5] -= 1;
						break;
					case Brown:
						lines[6] -= 1;
						break;
					case Orange:
						lines[7] -= 1;
						break;
					default:
						throw new IllegalArgumentException("Could not find line for Station: " + station.getName() + " owned by Player " + station.getOwner().name);
					}
				}
			}
			this.addGold((int)(station.getBaseValue() * 0.7));
			station.setOwner(null);
			stations.remove(station);
			station.purchaseStation(null);
			this.lineBonuses();
		}
	}

	@Override
	public void stationPassed(Station station) {
		// TODO Auto-generated method stub

		// STATION TAX:
		if(station.getOwner() != this && station.getOwner() != null)
		{
			this.subGold(station.getTotalRent());
		}

	}

	public void lineBonuses() //MUST BE CALLED BEFORE YOU ACCESS A STATIONS VALUE, RENT OR RESOURCE AMOUNTS
	{
		for (int i = 0; i<stations.size(); i++)
		{
			Station currentStation = stations.get(i);
			int red = 0;
			int blue = 0;
			int green = 0;
			int yellow = 0;
			int purple = 0;
			int black = 0;
			int brown = 0;
			int orange = 0;



			for (int j = 0; j < currentStation.getLineType().length; j++) //line type length should be 3, so for 0 to 2		
			{
				if (j == 0 || ((j > 0) && (currentStation.getLineType()[j] != currentStation.getLineType()[j-1])))
					//if 0 check line type 
					//if 1 check if it is the same as 0 if not check line type
					//if 2 check if it is the same as 1 if not check line type
					//always configure your line type array to have repeats in 1 and 2 e.g. (Black, Red, Red) NOT (Black, Red, Black) else this will not work
				{
					switch(currentStation.getLineType()[j])
					{	
					case Red:
						red = lines[0];
						if (red == 5)
						{
							red += 3;
						}
						//5
						break;
					case Blue:
						blue = lines[1];
						if (blue == 5)
						{
							blue += 3;
						}
						//5
						break;
					case Green:
						green = lines[2];
						if (green == 3)
						{
							green += 1;
						}
						//3
						break;
					case Yellow:
						yellow = lines[3];
						if (yellow == 4)
						{
							yellow += 2;
						}
						//4
						break;
					case Purple:
						purple = lines[4];
						if (purple == 4)
						{
							purple += 2;
						}
						//4
						break;
					case Black:
						black = lines[5];
						if (black == 5)
						{
							black += 3;
						}
						//5
						break;
					case Brown:
						brown = lines[6];
						if (brown == 5)
						{
							brown += 3;
						}
						//5
						break;
					case Orange:
						orange = lines[7];
						if (orange == 6)
						{
							orange += 4;
						}
						//6
						break;
					default:
						throw new IllegalArgumentException("Could not find line associated with value");
					}
				}
			}
			//owning an entire line is worth an additional reward (3 stations 5%, 4 stations 10%, 5 stations 15%, 6 stations 20%)
			//increase rent, resource and value by 5% per line you have a station connected too, this may be adjusted to due scaling at larger values
			currentStation.setRentValueMod(((red + blue + green + yellow + purple + black + brown + orange) * (int)(currentStation.getBaseRentValue() * 0.05)));
			currentStation.setResourceOutMod(((red + blue + green + yellow + purple + black + brown + orange) * (int)(currentStation.getBaseResourceOut() * 0.05)));
			currentStation.setValueMod(((red + blue + green + yellow + purple + black + brown + orange) * (int)(currentStation.getValueMod() * 0.05)));
		}
	}

	public void stationRewards()
	{

		for (int i = 0; i < stations.size(); i++)
		{
			Station currentStation = stations.get(i);
			this.addFuel(currentStation.getResourceString(), currentStation.getTotalResourceOut());
		}
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
