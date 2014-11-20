package com.TeamHEC.LocomotionCommotion.Player;

import java.util.List;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Resource.Carriage;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Resource;
import com.TeamHEC.LocomotionCommotion.Train.Train;

public class Player {

	public String playerName;
	public int points;
	public Gold gold;
	public Coal coal;
	public Electric electric;
	public Nuclear nuclear;
	public List<Card> cards;
	private Shop shop;
	public List<Goal> goals;
	public List<Train> trains;
	public Carriage carriages;
	public List<Station> stations;
	
	public Player(String playerName, int points, Gold gold, Coal coal, Electric electric, Nuclear nuclear,
				  List<Card> cards, Shop shop, List<Goal> goals, List<Train> trains, Carriage carriages,
				  List<Station> stations)
	{
		this.playerName = playerName;
		this.points = points;
		this.gold = gold;
		this.coal = coal;
		this.electric = electric;
		this.nuclear = nuclear;
		this.cards = cards;
		this.shop = shop;
		this.goals = goals;
		this.trains = trains;
		this.carriages = carriages;
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
