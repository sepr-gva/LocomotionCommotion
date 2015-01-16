package com.TeamHEC.LocomotionCommotion.Game;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Oil;
import com.TeamHEC.LocomotionCommotion.Resource.Resource;
import com.TeamHEC.LocomotionCommotion.Train.CoalTrain;
import com.TeamHEC.LocomotionCommotion.Train.ElectricTrain;
import com.TeamHEC.LocomotionCommotion.Train.NuclearTrain;
import com.TeamHEC.LocomotionCommotion.Train.OilTrain;
import com.TeamHEC.LocomotionCommotion.Train.Route;
import com.TeamHEC.LocomotionCommotion.Train.Train;

/**
 * 
 * @author Callum Hewitt <ch1194@york.ac.uk>
 *
 */

public class CoreGame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Privates
	private WorldMap gameMap;
	private Player player1;
	private Player player2;
	private int turnCount;
	private int turnLimit;
	private Player playerTurn;

	/**
	 * Initialises a Game object. This represents one instance of a game.
	 * 
	 * @param Player1Name
	 *            The name of Player1
	 * @param Player2Name
	 *            The name of Player2
	 * @param Player1StationStart
	 *            Player1 should have selected a station to buy at the beginning
	 *            of the game. This is their selected Station's object.
	 * @param Player2StationStart
	 *            Player2 should have selected a station to buy at the beginning
	 *            of the game. This is their selected Station's object.
	 * @param turnLimit
	 *            The number of turns before the end of the game.
	 */
	public CoreGame(String Player1Name, String Player2Name,
			Station Player1StationStart, Station Player2StationStart,
			int turnLimit) {
		// Initialise Players
		HashMap<String, Resource> player1Resources = getBaseResources(Player1StationStart);
		HashMap<String, Resource> player2Resources = getBaseResources(Player2StationStart);

		player1 = new Player(Player1Name, 0,
				(Gold) player1Resources.get("gold"),
				(Coal) player1Resources.get("coal"),
				(Electric) player1Resources.get("electric"),
				(Nuclear) player1Resources.get("nuclear"),
				(Oil) player1Resources.get("oil"),
				new ArrayList<Card>(), new ArrayList<Goal>(),
				new ArrayList<Train>());

		player2 = new Player(Player2Name, 0,
				(Gold) player2Resources.get("gold"),
				(Coal) player2Resources.get("coal"),
				(Electric) player2Resources.get("electric"),
				(Nuclear) player2Resources.get("nuclear"),
				(Oil) player2Resources.get("oil"),
				new ArrayList<Card>(), new ArrayList<Goal>(),
				new ArrayList<Train>());

		player1.isPlayer1 = true;
		player2.isPlayer1 = false;

		// Create players First Train depending on the station selected:
		createFirstTrain(player1, Player1StationStart);
		createFirstTrain(player2, Player2StationStart);
		
		player1.purchaseStation(Player1StationStart);
		player2.purchaseStation(Player2StationStart);

		// Initialise Map and other Game Resources

		gameMap = WorldMap.getInstance();
		turnCount = 0;
		this.turnLimit = turnLimit;

		// Make decision on who goes first

		if (flipCoin() == 1)
			playerTurn = player2;
		else
			playerTurn = player1;

		// Start Game
		StartTurn();
	}

	/**
	 * Used during initialisation to assign a player a train based on their startStation fuel type
	 * @param player The player to be assigned a train
	 * @param startStation The player's starting station.
	 */
	private void createFirstTrain(Player player, Station startStation) {
		String fuelType = startStation.getResourceString();
		Train train = null;

		if (fuelType.equals("Coal"))
			train = new CoalTrain(0, true, new Route(startStation), player);
		else if (fuelType.equals("Nuclear"))
			train = new NuclearTrain(0, true, new Route(startStation),
					player);
		else if (fuelType.equals("Electric"))
			train = new ElectricTrain(0, true, new Route(startStation),
					player);
		else if (fuelType.equals("Oil"))
			train = new OilTrain(0, true, new Route(startStation), player);
		else
			train = new OilTrain(0, true, new Route(startStation), player);

		player.trains.add(train);
		// GameScreen.getStage().getActors().add(train.getActor());
		train.getActor().setZIndex(1);
	}

	// {{ Turn System
	/**
	 * Randomly returns either 0 or 1. It's used in determining which player
	 * will go first in this game.
	 */
	private int flipCoin() {
		Random coin = new Random();
		return coin.nextInt(2);
	}

	/**
	 * Ends the turn of a player. It will increase the turn count and switch the
	 * player's turns.
	 */

	public void EndTurn() {

		playerTurn.lineBonuses();
		turnCount = (turnCount + 1);
		if (playerTurn == player1)
			playerTurn = player2;
		else
			playerTurn = player1;
		StartTurn();
	}

	/**
	 * Starts a players turn. It will check for the end game condition.
	 */
	public void StartTurn() {
		if (getTurnCount() == getTurnLimit())
			EndGame();
		else {
			// Proceed with the turn:
			playerTurn.lineBonuses();
			playerTurn.stationRewards();
		}
	}

	/**
	 * Ends the current game.
	 */
	private void EndGame() {

	}

	/**
	 * Generates the resources a player will start with based on their start
	 * location
	 * 
	 * @param station
	 *            A player's starting location.
	 */
	public HashMap<String, Resource> getBaseResources(Station station) {
		Gold gold = new Gold(1000);

		// NEED TO CHOOSE STATION FIRST!
		// gold.subValue(station.getTotalValue());

		Coal coal = new Coal(200);
		Oil oil = new Oil(200);
		Electric electric = new Electric(200);
		Nuclear nuclear = new Nuclear(200);

		HashMap<String, Resource> dict = new HashMap<String, Resource>();

		dict.put("gold", gold); // Base gold amount minus the value of the
		dict.put("coal", coal);
		dict.put("oil", oil);
		dict.put("electric", electric);
		dict.put("nuclear", nuclear);

		return dict;
	}
	
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

	/**
	 * Saves the game to a .json file which can be loaded at a later date.
	 * @param gameName The name you want to assign to the game.
	 * @return A JSON string representing the current CoreGame state.
	 */
	public String saveGameJSON(String gameName) {
		String finalJson = "{\n";
		finalJson += "\"playerTurn\": \"" + playerTurn.name + "\",\n";
		finalJson += "\"turnCount\": " + turnCount + ",\n";
		finalJson += "\"map\": " + saveMapJSON() + ",\n";
		finalJson += "\"player1\": " + savePlayerJSON(player1) + ",\n";
		finalJson += "\"player2\": " + savePlayerJSON(player2) + ",\n";
		return finalJson = finalJson + "}\n";
	}
	
	/**
	 * Called during saveGameJSON. Used to save a player's state.
	 * @param player The player to be saved.
	 * @return A JSON string representing the player
	 */
	private String savePlayerJSON(Player player) {
		String finalJson = "{\n";
		finalJson += "\"playerName\": \"" + player.getName() + "\",\n";
		finalJson += "\"points\": " + player.points + ",\n";
		finalJson += "\"resources\": " + savePlayerResourceJSON(player) + ",\n";
		// finalJson += "\"trains\": " + savePlayerTrainJSON(player) + ",\n";
		return finalJson = finalJson + "\n}";
	}

	/**
	 * Called during savePlayerJSON. Used to save a player's resources.
	 * @param player The player whose resources will be saved.
	 * @return A JSON string representing the player's resources
	 */
	private String savePlayerResourceJSON(Player player) {
		String finalJson = "{\n";
		finalJson += "\"gold\": " + player.getGold() + ",\n";
		finalJson += "\"coal\": " + player.getFuel("Coal") + ",\n";
		finalJson += "\"electric\": " + player.getFuel("Electric") + ",\n";
		finalJson += "\"oil\": " + player.getFuel("Oil") + ",\n";
		finalJson += "\"nuclear\": " + player.getFuel("Nuclear") + ",\n";
		finalJson += "\"cards\": " + savePlayerCardJSON(player) + ",\n";
		finalJson += "\"goals\": " + savePlayerGoalJSON(player) + ",\n";
		return finalJson = finalJson + "}\n";
	}

	/**
	 * Called during savePlayerJSON. Used to save a player's cards.
	 * @param player The player whose cards will be saved.
	 * @return A JSON string representing the player's cards
	 */
	private String savePlayerCardJSON(Player player) {
		String finalJson = "[\n";
		Card[] cards = player.getCards().toArray(
				new Card[player.getCards().size()]);
		for (int i = 0; i < cards.length; i++) {
			Card card = cards[i];
			finalJson += "{\ncardName\": \"" + card.getName() + "\",\n"
					+ "\"cardDescription\": \"" + card.getDescription()
					+ "\",\n" + "\"owner\": \"" + card.getOwner().getName()
					+ "\",\n" + "\"cardValue\": " + card.getValue() + ",\n},";
		}
		return finalJson = finalJson + "]\n";
	}

	/**
	 * Called during savePlayerJSON. Used to save a player's goals.
	 * @param player The player whose goals will be saved.
	 * @return A JSON string representing the player's goals
	 */
	private String savePlayerGoalJSON(Player player) {
		String finalJson = "{\n";
		Goal[] goals = player.getGoals().toArray(
				new Goal[player.getGoals().size()]);
		for (int i = 0; i < goals.length; i++) {
			Goal goal = goals[i];
			finalJson += "{\n\"sStation\": \"" + goal.getSStation() + "\",\n"
					+ "\"fStation\": \"" + goal.getFStation() + "\",\n"
					+ "\"special\": " + goal.isSpecial() + ",\n"
					+ "\"reward\": " + goal.getReward() + ",\n"
					+ "\"startDate\": " + goal.getStartDate() + ",\n"
					+ "\"route\": \"" + goal.getRoute() + "\"\n},";
		}
		return finalJson = finalJson + "]\n";
	}
	
	/**
	 * Called during saveGameJSON. Used to save the WorldMap state.
	 * @return A JSON string representing the WorldMap.
	 */
	public String saveMapJSON() {
		String finalJson = "{\n";
		finalJson += "\"station\": " + saveMapStationJSON() + "\",\n";
		return finalJson = finalJson + "}\n";
	}

	/**
	 * Called during saveMapJSON. Used to save the Stations states.
	 * @return A JSON string representing the Stations on the WorldMap.
	 */
	public String saveMapStationJSON() {
		String finalJson = "{\n";
		Station[] stations = gameMap.stationsList
				.toArray(new Station[gameMap.stationsList.size()]);
		for (int i = 0; i < stations.length; i++) {
			Station station = stations[i];
			finalJson += "{\n\"name\": \"" + station.getName() + "\",\n"
					+ "\"owner\": \"" + station.getOwner() + "\",\n"
					+ "\"valueMod\": " + station.getValueMod() + ",\n"
					+ "\"fuelOutMod\": " + station.getResourceOutMod() + ",\n"
					+ "\"rentValueMod\": " + station.getRentValueMod() + ",\n}";
		}
		return finalJson = finalJson + "}\n";
	}
	
	/**
	 * Launches a save dialog asking the user to specify a save game location
	 * and serializes the game object to that location. This is one of two save options.
	 * The other is saving as a JSON file.
	 * @param gameName The name you want to assign to the game.
	 */
	public void saveGameSerialize(String gameName) {
		try {
			File saveLocation = new File(System.getProperty("user.home")
					+ System.getProperty("file.separator")
					+ "LocomotionCommotion"
					+ System.getProperty("file.separator") + gameName + ".ser");
			saveLocation.getParentFile().mkdirs();
			saveLocation.createNewFile();
			FileOutputStream fout = new FileOutputStream(saveLocation);

			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this);
			oos.close();
			fout.close();
			System.out.println("Done");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
