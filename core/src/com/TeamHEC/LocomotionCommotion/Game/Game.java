package com.TeamHEC.LocomotionCommotion.Game;

import com.TeamHEC.LocomotionCommotion.Map.Map;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Carriage;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Oil;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;
import com.TeamHEC.LocomotionCommotion.Resource.Resource;

/**
 * 
 * @author Callum Hewitt <ch1194@york.ac.uk>
 *
 */

public class Game {
	
	//Privates
	private Map gameMap;
	private Player player1;
	private Player player2;
	
	private enum PlayerTurn
	{
		player1,
		player2
	}
		
	/**
	 * Initialises a Game object. This represents one instance of a game.
	 */
	public Game(String Player1Name, String Player2Name, Station Player1StationStart, Station Player2StationStart)
	{
		Resource[] player1Resources = getBaseResources(Player1StationStart);
		Resource[] player2Resources = getBaseResources(Player2StationStart);
		
		//Initialise Players
		//player1 = new Player(Player1Name, 0)
		//player2 = new Player(Player2Name, 0)
	}
	
	public void EndTurn()
	{
		 
	}
	
	public void StartTurn()
	{
		
	}
	
	public Resource[] getBaseResources(Station station)
	{
		//Temporary
		Gold gold = new Gold(200);
		Coal coal = new Coal(200);
		Oil oil = new Oil(200);
		Electric electric = new Electric(200);
		
		return new Resource[] { gold, coal, oil, electric };
		
	}
	
}
