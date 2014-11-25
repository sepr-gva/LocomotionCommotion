package com.TeamHEC.LocomotionCommotion.Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Carriage;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Oil;
import com.TeamHEC.LocomotionCommotion.Resource.Resource;
import com.TeamHEC.LocomotionCommotion.Train.Train;

/**
 * 
 * @author Callum Hewitt <ch1194@york.ac.uk>
 *
 */

public class CoreGame implements Serializable{
	
	//Privates
	private WorldMap gameMap;
	private Player player1;
	private Player player2;
	private int turnCount;
	private int turnLimit;	
	private Player playerTurn;
		
	/**
	 * Initialises a Game object. This represents one instance of a game.
	 * @param Player1Name The name of Player1
	 * @param Player2Name The name of Player2
	 * @param Player1StationStart Player1 should have selected a station to buy at the beginning of the game. This is their selected Station's object.
	 * @param Player2StationStart Player2 should have selected a station to buy at the beginning of the game. This is their selected Station's object.
	 * @param turnLimit The number of turns before the end of the game.
	 */
	public CoreGame(String Player1Name, String Player2Name, Station Player1StationStart, Station Player2StationStart, int turnLimit)
	{
		//Initialise Players
		HashMap<String, Resource> player1Resources = getBaseResources(Player1StationStart);
		HashMap<String, Resource> player2Resources = getBaseResources(Player2StationStart);
				
		ArrayList<Station> Player1Stations = new ArrayList<Station>();
		Player1Stations.add(Player1StationStart);
		
		ArrayList<Station> Player2Stations = new ArrayList<Station>();
		Player2Stations.add(Player2StationStart);
		
		
		player1 = new Player(
				Player1Name,
				0, 
				(Gold) player1Resources.get("gold"), 
				(Coal) player1Resources.get("coal"), 
				(Electric) player1Resources.get("electric"),
				(Nuclear) player1Resources.get("nuclear"), 
				(Oil) player1Resources.get("oil"), 
				(Carriage) player1Resources.get("carriage"),
				new ArrayList<Card>(), 				 
				new ArrayList<Goal>(), 
				new ArrayList<Train>(), 				 
				Player1Stations);		
		
		player2 = new Player(
				Player2Name,
				0,
				(Gold) player2Resources.get("gold"),
				(Coal) player2Resources.get("coal"),
				(Electric) player2Resources.get("electric"),
				(Nuclear) player2Resources.get("nuclear"),
				(Oil) player2Resources.get("oil"),
				(Carriage) player2Resources.get("carriage"),
				new ArrayList<Card>(),	
				new ArrayList<Goal>(),
				new ArrayList<Train>(),
				Player2Stations);
		
		//Initialise Map and other Game Resources
		
		gameMap = WorldMap.getInstance();		
		turnCount = 0;
		this.turnLimit = turnLimit;
		
		//Make decision on who goes first
		
		if(flipCoin() == 1)
				playerTurn = player2;
		else
				playerTurn = player1;
		
		//Start Game
		StartTurn();
	}
	
	/*
	 * Randomly returns either 0 or 1. It's used in determining which player will go first in this game.
	 */
	private int flipCoin() {
		Random coin = new Random();
		return coin.nextInt(2);
	}

	/*
	 * Ends the turn of a player. It will increase the turn count and switch the player's turns.
	 */
	public void EndTurn()
	{
		turnCount = (turnCount + 1);
		if(playerTurn == player1)
			playerTurn = player2;
		else
			playerTurn = player1;
		StartTurn();
	}
	
	/*
	 * Starts a players turn. It will check for the end game condition.
	 */
	public void StartTurn()
	{
		if(getTurnCount() == getTurnLimit())
			EndGame();
	}
	
	private void EndGame()
	{
		
	}

	/*
	 * Generates the resources a player will start with based on their start location
	 * @param station A player's starting location.
	 */
	public HashMap<String, Resource> getBaseResources(Station station)
	{
		//Temporary		
		Gold gold = new Gold(200);
		gold.subValue(station.getTotalValue());
		
		Carriage carriage = new Carriage(200);
		Coal coal = new Coal(200);
		Oil oil = new Oil(200);
		Electric electric = new Electric(200);
		Nuclear nuclear = new Nuclear(200);		
				
		HashMap<String, Resource> dict = new HashMap<String, Resource>();
		dict.put("gold", gold); //Base gold amount minus the value of the station bought.
		dict.put("carriage", carriage);
		dict.put("coal", coal);
		dict.put("oil", oil);
		dict.put("electric", electric);
		dict.put("nuclear", nuclear);			
		
		return dict;		
	}
	
	//getters
	public WorldMap getGameMap() {
		return gameMap;
	}	

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}
	
	public int getTurnCount() {
		return turnCount;
	}

	public int getTurnLimit() {
		return turnLimit;
	}

	public Player getPlayerTurn() {
		return playerTurn;
	}

}
