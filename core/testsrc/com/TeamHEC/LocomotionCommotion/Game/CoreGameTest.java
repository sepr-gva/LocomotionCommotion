package com.TeamHEC.LocomotionCommotion.Game;

import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.TeamHEC.LocomotionCommotion.Game.CoreGame;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Map.Line;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Resource;
import com.TeamHEC.LocomotionCommotion.Train.CoalTrain;
import com.TeamHEC.LocomotionCommotion.Train.NuclearTrain;
import com.TeamHEC.LocomotionCommotion.Train.Route;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.Mocking.GdxTestRunner;

/**
 * 
 * @author Callum Hewitt <ch1194@york.ac.uk>
 *
 */

@RunWith(GdxTestRunner.class)
public class CoreGameTest {
	
	String player1Name;
	String player2Name;
	Station Player1Start;
	Station Player2Start;	
	ArrayList<Station> player1StationList;
	ArrayList<Station> player2StationList;	
	int turnLimit;
	CoreGame tester;
	int baseGold;
	int baseCarriage;	
	int baseCoal;
	int baseOil;
	int baseElectric;
	int baseNuclear;
	
	@Before
	public void setUp()
	{				
		
		Line[] line1 = new Line[3];
		Line[] line2 = new Line[3];
		line1[0] = Line.Red;
		line1[1] = Line.Blue;
		line1[2] = Line.Black;
		line2[0] = Line.Green;
		line2[1] = Line.Yellow;
		line2[2] = Line.Orange;
		
		player1Name = "Alice";
		player2Name = "Ben";
		Player1Start = new Station("London", 100, new Coal(100), 100, line1, 100, 0.01f, 0.01f);
		Player2Start = new Station("Amsterdam", 200, new Nuclear(200), 200, line2, 200, 0.01f, 0.01f);	
		
		player1StationList = new ArrayList<Station>();
		player2StationList = new ArrayList<Station>();		
		
		turnLimit = 50;	
		
		player1StationList.add(Player1Start);
		player2StationList.add(Player2Start);
		
		baseGold = 200;
		baseCarriage = 200;
		baseCoal = 200;
		baseOil = 200;
		baseElectric = 200;
		baseNuclear = 200;
	}
	
	// {{ Private Accessors
	
	/**
	 * Gets the field value from an instance.  The field we wish to retrieve is
	 * specified by passing the name.  The value will be returned, even if the
	 * field would have private or protected access.
	 */
	@SuppressWarnings("rawtypes")
	private Object getField( Object instance, String name ) throws Exception
	{
		Class c = instance.getClass();

		// Retrieve the field with the specified name
		Field f = c.getDeclaredField( name );

		// Make sure the field is accessible, even if it
		// would be private or protected
		f.setAccessible( true );

		// Return the value of the field for the instance
		return f.get( instance );
	}

	/**
	 * Executes a method on an object instance.  The name and parameters of
	 * the method are specified.  The method will be executed and the value
	 * of it returned, even if the method would have private or protected access.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object executeMethod( Object instance, String name, Object[] params ) throws Exception
	{
		Class c 	= instance.getClass();

		// Fetch the Class types of all method parameters
		Class[] types 	= new Class[params.length];

		for ( int i = 0; i < params.length; i++ )
			types[i] = params[i].getClass();

		Method m        = c.getDeclaredMethod( name, types );

		// Make sure the method is accessible
		m.setAccessible( true );

		return m.invoke( instance, params );
	}
	
	// }} Private Accessors
	
	@Test
	public void testCoreGame() throws Exception {
		//Reset
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		
		//Good Execution
		//Execute		
		assertTrue("player1Name was incorrectly set", tester.getPlayer1().name == player1Name);
		assertTrue("player2Name was incorrectly set", tester.getPlayer2().name == player2Name);
		
		assertTrue("player1's Gold was incorrectly set", tester.getPlayer1().getGold() == baseGold - Player1Start.getTotalValue());	
		assertTrue("player2's Gold was incorrectly set", tester.getPlayer2().getGold() == baseGold - Player2Start.getTotalValue());	
		if(tester.getPlayerTurn() == tester.getPlayer1())		
			assertTrue("player1's Coal was incorrectly set", tester.getPlayer1().getFuel("Coal") == baseCoal + Player1Start.getBaseResourceOut());
		else
			assertTrue("player1's Coal was incorrectly set", tester.getPlayer1().getFuel("Coal") == baseCoal);			
		assertTrue("player2's Coal was incorrectly set", tester.getPlayer2().getFuel("Coal") == baseCoal);
		assertTrue("player1's Oil was incorrectly set", tester.getPlayer1().getFuel("Oil") == baseOil);
		assertTrue("player2's Oil was incorrectly set", tester.getPlayer2().getFuel("Oil") == baseOil);
		assertTrue("player1's Electric was incorrectly set", tester.getPlayer1().getFuel("Electric") == baseElectric);
		assertTrue("player2's Electric was incorrectly set", tester.getPlayer2().getFuel("Electric") == baseElectric);
		assertTrue("player1's Nuclear was incorrectly set", tester.getPlayer1().getFuel("Nuclear") == baseNuclear);
		if(tester.getPlayerTurn() == tester.getPlayer2())		
			assertTrue("player2's Nuclear was incorrectly set", tester.getPlayer2().getFuel("Nuclear") == baseNuclear + Player2Start.getBaseResourceOut());
		else
			assertTrue("player2's Nuclear was incorrectly set", tester.getPlayer2().getFuel("Nuclear") == baseNuclear);
		assertTrue("player1's Carriage was incorrectly set", tester.getPlayer1().getCarriage() == baseCarriage);
		assertTrue("player2's Carriage was incorrectly set", tester.getPlayer2().getCarriage() == baseCarriage);
				
		assertTrue("player1's Station list was incorrectly set", tester.getPlayer1().getStations().equals(player1StationList));
		assertTrue("player2's Station list was incorrectly set", tester.getPlayer2().getStations().equals(player2StationList));
		assertTrue("player1's Goal list was incorrectly set", tester.getPlayer1().getGoals().equals(new ArrayList<Goal>()));
		assertTrue("player2's Goal list was incorrectly set", tester.getPlayer2().getGoals().equals(new ArrayList<Goal>()));
		assertTrue("player1's Train list was incorrectly set", tester.getPlayer1().getTrains().size() == 1);
		assertTrue("player2's Train list was incorrectly set", tester.getPlayer2().getTrains().size() == 1);
		
		assertTrue("turnCount was not zero", tester.getTurnCount() == 0);
		assertTrue("turnLimit was not equal to " + turnLimit, tester.getTurnLimit() == 50);
		assertTrue("playerTurn was not null", tester.getPlayerTurn() != null);
		assertTrue("gameMap was not initialsed", (WorldMap) getField(tester, "gameMap") != null);		
	}
	
	@Test
	public void testFlipCoin() throws Exception {
		//Reset
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		
		for(int i=0; i<10000; i++)
		{
			int x = (Integer) executeMethod(tester, "flipCoin", new Object[] {} );
			assertTrue(x == 0 || x == 1);					
		}
	}

	@Test
	public void testEndTurn() {
		//Reset
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		
		//Setup
		Player initialPlayer = tester.getPlayerTurn();
		int initialCount = tester.getTurnCount();
		
		//Execute
		tester.EndTurn();
		assertTrue(initialPlayer.getName() != tester.getPlayerTurn().getName());
		assertTrue(tester.getTurnCount() == initialCount + 1);
		tester.EndTurn();
		assertTrue(initialPlayer.getName() == tester.getPlayerTurn().getName());
		assertTrue(tester.getTurnCount() == initialCount + 2);			
	}

	@Test
	public void testStartTurn() {
		//Reset
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		
		fail("Not yet implemented");
	}
	
	@Test
	public void testEndGame() {
		//Reset
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		
		fail("Not yet implemented");
	}

	@Test
	public void testGetBaseResources() {
		//Reset
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		
		HashMap<String, Resource> checker = tester.getBaseResources(Player1Start);
		
		assertTrue("Gold was incorrectly set", checker.get("gold").getValue() == baseGold - Player1Start.getTotalValue());	
		assertTrue("Carriage was incorrectly set", checker.get("carriage").getValue() == baseCarriage);
		assertTrue("Coal was incorrectly set", checker.get("coal").getValue() == baseCoal);
		assertTrue("Oil was incorrectly set", checker.get("oil").getValue() == baseOil);
		assertTrue("Electric was incorrectly set", checker.get("electric").getValue() == baseElectric);
		assertTrue("Nuclear was incorrectly set", checker.get("nuclear").getValue() == baseNuclear);
	}

	@Test
	public void testGetGameMap() throws Exception {
		//Reset
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		
		assertTrue(tester.getGameMap() == (WorldMap) getField(tester, "gameMap"));
	}
	
	@Test
	public void testGetPlayer1() throws Exception {
		//Reset
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		
		assertTrue(tester.getPlayer1() == (Player) getField(tester, "player1"));
	}

	@Test
	public void testGetPlayer2() throws Exception {
		//Reset
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		
		assertTrue(tester.getPlayer2() == (Player) getField(tester, "player2"));
	}
	
	@Test
	public void testGetTurnCount() throws Exception {
		//Reset
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		
		assertTrue(tester.getTurnCount() == (Integer) getField(tester, "turnCount"));
	}

	@Test
	public void testGetTurnLimit() throws Exception {
		//Reset
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		
		assertTrue(tester.getTurnLimit() == (Integer) getField(tester, "turnLimit"));
	}
	
	@Test
	public void testGetPlayerTurn() throws Exception {
		//Reset
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		
		assertTrue(tester.getPlayerTurn() == (Player) getField(tester, "playerTurn"));
	}

	@Test
	public void testSaveGame() throws Exception {
		//Reset
		String error = "";
		boolean success = false;
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		try
		{
			tester.saveGame("myGame");
			success = true;
		}
		catch (Exception ex)
		{
			success = false;
			error = ex.getMessage();
		}
		
		assertTrue("saveGame did not execute successfully. " + error, success);		
		
		File f = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "LocomotionCommotion" + System.getProperty("file.separator") + "myGame" + ".ser");
		assertTrue("The expected file did not exist",f.exists());
	}

	@Test
	public void testSaveGameJSON() throws Exception {
		//Reset
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		String output = tester.saveGameJSON("ThisGameName");
		writer.println(output);
		writer.close();
		
	}

}
