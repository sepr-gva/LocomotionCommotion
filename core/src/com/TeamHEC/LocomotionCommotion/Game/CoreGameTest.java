package com.TeamHEC.LocomotionCommotion.Game;

import static org.junit.Assert.*;
import junit.framework.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Map.Line;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Train.Train;

public class CoreGameTest {
	
	String player1Name;
	String player2Name;
	Station Player1Start;
	Station Player2Start;	
	ArrayList<Station> player1StationList;
	ArrayList<Station> player2StationList;	
	int turnLimit;
	CoreGame tester;
	
	public CoreGameTest()
	{
		player1Name = "Alice";
		player2Name = "Ben";
		Player1Start = new Station("London", 100, new Coal(100), 100, Line.Red, 100);
		Player2Start = new Station("Amsterdam", 200, new Nuclear(200), 200, Line.Blue, 200);	
		
		player1StationList = new ArrayList<Station>();
		player2StationList = new ArrayList<Station>();		
		
		turnLimit = 50;	
		tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
	}
		
	/**
	 * Gets the field value from an instance.  The field we wish to retrieve is
	 * specified by passing the name.  The value will be returned, even if the
	 * field would have private or protected access.
	 */
	private Object getField( Object instance, String name ) throws Exception
	{
		Class c = instance.getClass();

		// Retrieve the field with the specified name
		Field f = c.getDeclaredField( name );

		// *MAGIC* make sure the field is accessible, even if it
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
	private Object executeMethod( Object instance, String name, Object[] params ) throws Exception
	{
		Class c 	= instance.getClass();

		// Fetch the Class types of all method parameters
		Class[] types 	= new Class[params.length];

		for ( int i = 0; i < params.length; i++ )
			types[i] = params[i].getClass();

		Method m        = c.getDeclaredMethod( name, types );

		// *MAGIC* make sure the method is accessible
		m.setAccessible( true );

		return m.invoke( instance, params );
	}
	
	@Test
	public void testCoreGame() throws Exception {
		//Setup
		player1StationList.add(Player1Start);
		player2StationList.add(Player2Start);
		
		int baseGold = 200;
		int baseCarriage = 200;
		int baseCoal = 200;
		int baseOil = 200;
		int baseElectric = 200;
		int baseNuclear = 200;
		
		//Good Execution
		//Execute		
		assertTrue("player1Name was incorrectly set", tester.getPlayer1().name == player1Name);
		assertTrue("player2Name was incorrectly set", tester.getPlayer2().name == player2Name);
		
		assertTrue("player1's Gold was incorrectly set", tester.getPlayer1().getGold() == baseGold - Player1Start.getTotalValue());	
		assertTrue("player2's Gold was incorrectly set", tester.getPlayer2().getGold() == baseGold - Player2Start.getTotalValue());	
		assertTrue("player1's Coal was incorrectly set", tester.getPlayer1().getFuel("Coal") == baseCoal);
		assertTrue("player2's Coal was incorrectly set", tester.getPlayer2().getFuel("Coal") == baseCoal);
		assertTrue("player1's Oil was incorrectly set", tester.getPlayer1().getFuel("Oil") == baseOil);
		assertTrue("player2's Oil was incorrectly set", tester.getPlayer2().getFuel("Oil") == baseOil);
		assertTrue("player1's Electric was incorrectly set", tester.getPlayer1().getFuel("Electric") == baseElectric);
		assertTrue("player2's Electric was incorrectly set", tester.getPlayer2().getFuel("Electric") == baseElectric);
		assertTrue("player1's Nuclear was incorrectly set", tester.getPlayer1().getFuel("Nuclear") == baseNuclear);
		assertTrue("player2's Nuclear was incorrectly set", tester.getPlayer2().getFuel("Nuclear") == baseNuclear);
		assertTrue("player1's Nuclear was incorrectly set", tester.getPlayer1().getCarriage() == baseCarriage);
		assertTrue("player2's Nuclear was incorrectly set", tester.getPlayer2().getCarriage() == baseCarriage);
				
		assertTrue("player1's Station list was incorrectly set", tester.getPlayer1().getStations() == player1StationList);
		assertTrue("player2's Station list was incorrectly set", tester.getPlayer2().getStations() == player2StationList);
		assertTrue("player1's Goal list was incorrectly set", tester.getPlayer1().getGoals() == new ArrayList<Goal>());
		assertTrue("player1's Train list was incorrectly set", tester.getPlayer1().getTrains() == new ArrayList<Train>());
		
		assertTrue("turnCount was not zero", tester.getTurnCount() == 0);
		assertTrue("turnLimit was not equal to " + turnLimit, tester.getTurnLimit() == 50);
		assertTrue("playerTurn was not null", tester.getPlayerTurn() != null);
		assertTrue("gameMap was not initialsed", (CoreGame) getField(tester, "gameMap") != null);		
	}
	
	@Test
	public void testFlipCoin() throws Exception {
		for(int i=0; i<10000; i++)
		{
			int x = (Integer) executeMethod(tester, "flipCoin", new Object[] {} );
			assertTrue(x == 0 || x == 1);					
		}
	}

	@Test
	public void testEndTurn() {
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
		fail("Not yet implemented");
	}

	@Test
	public void testGetBaseResources() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGameMap() {
		fail("Not yet implemented");
		
	}

	@Test
	public void testGetPlayer2() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTurnCount() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTurnLimit() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayerTurn() throws Exception {
		fail("Not yet implemented");
	}

}
