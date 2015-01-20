package com.TeamHEC.LocomotionCommotion.Player;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

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

/**
 * 
 * @author Elliot Bray <eb1033@york.ac.uk>
 *
 */

@RunWith(GdxTestRunner.class)
public class PlayerTest {
	
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
		
		testStation = new Station("Prague", 1000, new Coal(500), 100, new Line[]{Line.Orange, Line.Yellow, Line.Brown}, 50, 471f, 300f);
		tester.getTrains().add(new OilTrain(0, true, new Route(testStation), tester));
		tester.purchaseStation(testStation);
	}

	@Test
	public void testPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testPurchaseStation() {
		assertTrue("Station 1 was not purchased correctly", tester.getStations().get(0) == testStation);
		assertTrue("incorrect gold value was removed", tester.getGold() == (1000 - testStation.getBaseValue()));
		assertTrue("Lines are added incorrectly", tester.getLines()[0] == 0);
		assertTrue("Lines are added incorrectly", tester.getLines()[1] == 0);
		assertTrue("Lines are added incorrectly", tester.getLines()[2] == 0);
		assertTrue("Lines are added incorrectly", tester.getLines()[3] == 1);
		assertTrue("Lines are added incorrectly", tester.getLines()[4] == 0);
		assertTrue("Lines are added incorrectly", tester.getLines()[5] == 0);
		assertTrue("Lines are added incorrectly", tester.getLines()[6] == 1);
		assertTrue("Lines are added incorrectly", tester.getLines()[7] == 1);
		Station testStation2 = new Station("Berlin", 950, new Nuclear(500), 100, new Line[]{Line.Yellow, Line.Red, Line.Red}, 50, 731f, 560f);
		tester.addGold(1000);
		tester.getTrains().add(new OilTrain(0, true, new Route(testStation2), tester));
		tester.purchaseStation(testStation2);
		assertTrue("Station 2 was not purchased correctly", tester.getStations().get(1) == testStation2);
		assertTrue("Lines are added incorrectly", tester.getLines()[0] == 1);
		assertTrue("Lines are added incorrectly", tester.getLines()[1] == 0);
		assertTrue("Lines are added incorrectly", tester.getLines()[2] == 0);
		assertTrue("Lines are added incorrectly", tester.getLines()[3] == 2);
		assertTrue("Lines are added incorrectly", tester.getLines()[4] == 0);
		assertTrue("Lines are added incorrectly", tester.getLines()[5] == 0);
		assertTrue("Lines are added incorrectly", tester.getLines()[6] == 1);
		assertTrue("Lines are added incorrectly", tester.getLines()[7] == 1);
	}

	@Test
	public void testSellStation() {
		//SELL STATION IS CURRENTLY COMMENTED OUT DUE TO NOT BEING SUPPORTED HOWEVER IT WAS TESTING SUCCESSFULLY
		/*
		Station testStation2 = new Station("Berlin", 950, new Nuclear(500), 100, new Line[]{Line.Yellow, Line.Red, Line.Red}, 50, 731f, 560f);
		tester.addGold(950);
		tester.getTrains().add(new OilTrain(0, true, new Route(testStation2), tester));
		tester.purchaseStation(testStation2);
		assertTrue("Station 1 was not purchased correctly", tester.getStations().get(0) == testStation);
		assertTrue("Station 2 was not purchased correctly", tester.getStations().get(1) == testStation2);
		tester.sellStation(testStation);
		assertTrue("Station 1 was not sold correctly", tester.getStations().contains(testStation) == false);
		assertTrue("incorrect gold was refunded", tester.getGold() == 700);
		assertTrue("both stations were removed", tester.getStations().contains(testStation2));
		tester.sellStation(testStation);
		assertFalse("station was sold when not owned", tester.getGold() == 1400);
		*/		
	}
	
	@Test
	public void testLineBonuses() {
		Station testStation2 = new Station("Berlin", 950, new Nuclear(500), 100, new Line[]{Line.Yellow, Line.Black, Line.Red}, 50, 731f, 560f);
		tester.addGold(950);
		tester.getTrains().add(new OilTrain(0, true, new Route(testStation2), tester));
		tester.purchaseStation(testStation2);
		tester.lineBonuses();
		assertTrue("Resource out != 100", tester.getStations().get(0).getBaseResourceOut() == 100);
		assertTrue("scaling of base value fails", (int)(tester.getStations().get(0).getBaseResourceOut() * 0.05) == 5);
		assertTrue("bonuses ere incorrectly set", tester.getStations().get(0).getResourceOutMod() == (int)(tester.getStations().get(0).getBaseResourceOut() * 0.05 * 4));
		assertTrue("bonuses ere incorrectly set", tester.getStations().get(1).getResourceOutMod() == (int)(tester.getStations().get(1).getBaseResourceOut() * 0.05 * 4));
		tester.sellStation(testStation);
		tester.sellStation(testStation2);
		
		Station testStation3 = new Station("London", 850, new Coal(500), 100, new Line[]{Line.Green, Line.Green, Line.Green}, 50, 471f, 300f);
		tester.getTrains().add(new OilTrain(0, true, new Route(testStation3), tester));
		tester.purchaseStation(testStation3);
		Station testStation4 = new Station("Paris", 850, new Coal(500), 100, new Line[]{Line.Green, Line.Green, Line.Green}, 50, 471f, 300f);
		tester.getTrains().add(new OilTrain(0, true, new Route(testStation4), tester));
		tester.addGold(850);
		tester.purchaseStation(testStation4);
		Station testStation5 = new Station("Berlin", 850, new Coal(500), 100, new Line[]{Line.Green, Line.Green, Line.Green}, 50, 471f, 300f);
		tester.getTrains().add(new OilTrain(0, true, new Route(testStation5), tester));
		tester.addGold(850);
		tester.purchaseStation(testStation5);
		tester.lineBonuses();
		
		assertTrue("bonuses ere incorrectly set", tester.getStations().get(1).getResourceOutMod() == (int)(tester.getStations().get(2).getBaseResourceOut() * 0.05 * 4));
		
	}
}
