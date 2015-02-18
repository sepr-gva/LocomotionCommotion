package com.TeamHEC.LocomotionCommotion.Player;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.Line;
import com.TeamHEC.LocomotionCommotion.Mocking.GdxTestRunner;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;
import com.TeamHEC.LocomotionCommotion.Resource.Fuel;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Oil;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.Train.OilTrain;
import com.TeamHEC.LocomotionCommotion.Train.Route;


@RunWith(GdxTestRunner.class)
public class PlayerPointsTest {
	
		String name;
		int points;
		Gold gold;
		Coal coal;
		Oil oil;
		Electric electric;
		Nuclear nuclear;
		ArrayList<Card> cards;
		Shop shop;
		ArrayList<Goal> goals;
		ArrayList<Train> trains;
		ArrayList<Station> stations = new ArrayList<Station>();
		int[] lines = new int[8];
		Player tester;
		Station testStation;
	
		HashMap<String, Fuel> playerFuel;
	
		@Before
		public void setUp() throws Exception {
			name = "Player 1";
			points = 0;
			gold = new Gold(1000);
			coal = new Coal(200);
			oil = new Oil(200);
			electric = new Electric(200);
			nuclear = new Nuclear(200);
			cards = new ArrayList<Card>();
			goals = new ArrayList<Goal>();
			trains = new ArrayList<Train>();
			
			tester = new Player(
					name,
					points,
					gold,
					coal,
					electric,
					nuclear,
					oil,
					cards,	
					goals,
					trains);
			
		}
		
		/**
		 * Tests that at least 5 points are being added on per 1000 gold 
		 */
		@Test
		public void testPoints(){
			Random rand = new Random();
			for (int i = 0; i < 1000; i++){
				int amount = rand.nextInt(2000);
				int oldpoints = tester.getPoints();
				tester.addGold(amount);
				assertTrue("Points have not been added", tester.getPoints() == oldpoints + (int)(Math.log(amount)));
			}
		}
		
	}