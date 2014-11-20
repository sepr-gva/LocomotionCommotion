package com.TeamHEC.LocomotionCommotion.Player;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Player.Shop;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Carriage;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Oil;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;
import com.TeamHEC.LocomotionCommotion.Train.Train;

public class Player {

	public String playerName;
	public int points;
	public Gold gold;
	public Coal coal;
	public Oil oil;
	public Electric electric;
	public Nuclear nuclear;
	public ArrayList<Card> cards;
	private Shop shop;
	public ArrayList<Goal> goals;
	public ArrayList<Train> trains;
	public Carriage carriages;
	public ArrayList<Station> stations;
	
	public Player(String playerName, int points, Gold gold, Coal coal, Electric electric, Nuclear nuclear, Oil oil, 
				Carriage carriage, ArrayList<Card> cards, Shop shop, ArrayList<Goal> goals, ArrayList<Train> trains,
				ArrayList<Station> stations)
	{
		this.playerName = playerName;
		this.points = points;
		this.gold = gold;
		this.coal = coal;
		this.oil = oil;
		this.electric = electric;
		this.nuclear = nuclear;
		this.cards = cards;
		this.shop = shop;
		this.goals = goals;
		this.trains = trains;
		this.carriages = carriage;
		this.stations = stations;
	}
	
	// We don't need these get/setters if they're public:
	public int getGold()
	{
		return gold.getValue();
	}
	
	public void setGold(int value)
	{
		gold.setValue(value);
	}
	
	public void accessShop()
	{
		
	}
	
	public void accessGoals()
	{
		
	}
}
