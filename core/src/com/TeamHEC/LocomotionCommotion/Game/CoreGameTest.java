package com.TeamHEC.LocomotionCommotion.Game;

import static org.junit.Assert.*;
import junit.framework.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import com.TeamHEC.LocomotionCommotion.Map.Line;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;

public class CoreGameTest {

	@Test
	public void testCoreGame() {
		//Setup
		String player1Name = "Alice";
		String player2Name = "Ben";
		Station Player1Start = new Station("London", 100, new Coal(100), 100, Line.Red, 100);
		Station Player2Start = new Station("Amsterdam", 200, new Nuclear(200), 200, Line.Blue, 200);
		int turnLimit = 50;
		
		int baseGold = 200;
		int baseCarriage = 200;
		int baseCoal = 200;
		int baseOil = 200;
		int baseElectric = 200;
		int baseNuclear = 200;
		
		//Good Execution
		//Execute
		CoreGame tester = new CoreGame(player1Name, player2Name, Player1Start, Player2Start, turnLimit);
		assertTrue("player1Name was incorrectly set", tester.getPlayer1().playerName == player1Name);
		assertTrue("player2Name was incorrectly set", tester.getPlayer2().playerName == player2Name);
		
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
		
		assertTrue("player1's Station list was incorrectly set", tester.getPlayer1().get
		
		fail("Not yet implemented");
	}

	@Test
	public void testEndTurn() {
		fail("Not yet implemented");
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
