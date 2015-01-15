package com.TeamHEC.LocomotionCommotion.Player;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.Line;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
import com.TeamHEC.LocomotionCommotion.Resource.Carriage;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;
import com.TeamHEC.LocomotionCommotion.Resource.Fuel;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Oil;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.Train.CoalTrain;
import com.TeamHEC.LocomotionCommotion.Train.ElectricTrain;
import com.TeamHEC.LocomotionCommotion.Train.NuclearTrain;
import com.TeamHEC.LocomotionCommotion.Train.OilTrain;
import com.TeamHEC.LocomotionCommotion.Train.Route;



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
	Carriage carriages;
	ArrayList<Station> stations = new ArrayList<Station>();
	int[] lines = new int[8];
	Player tester;

	HashMap<String, Fuel> playerFuel;

	@Before
	public void setUp() throws Exception {
		name = "Player 1";
		points = 0;
		gold = new Gold(200);
		coal = new Coal(200);
		oil = new Oil(200);
		electric = new Electric(200);
		nuclear = new Nuclear(200);
		carriages = new Carriage(5);
		cards = new ArrayList<Card>();
		goals = new ArrayList<Goal>();
		trains = new ArrayList<Train>();
		/*tester = new Player(
				name,
				points,
				gold,
				coal,
				electric,
				nuclear,
				oil,
				carriages,
				cards,	
				goals,
				trains);
		trains.add(new OilTrain(0, 0, true, new Route(stations.get(0)), tester));
		stations.add(new Station("London", 850, new Coal(500), 10, new Line[]{Line.Black, Line.Black, Line.Black}, 50, 471f, 300f));
		*/
	}

	@After
	public void tearDown() throws Exception {
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
	public void testPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFuel() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddFuel() {
		fail("Not yet implemented");
	}

	@Test
	public void testSubFuel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGold() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddGold() {
		fail("Not yet implemented");
	}

	@Test
	public void testSubGold() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCarriage() {
		fail("Not yet implemented");
	}

	@Test
	public void testPurchaseRandomCard() {
		fail("Not yet implemented");
	}

	@Test
	public void testPurchaseCard() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumCards() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCards() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumStations() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStations() {
		fail("Not yet implemented");
	}

	@Test
	public void testPurchaseStation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSellStation() {
		fail("Not yet implemented");
	}

	@Test
	public void testStationPassed() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testLineBonuses() {
		tester = new Player(name, points, gold, coal, electric, nuclear, oil, carriages, cards,	goals, trains);
		trains.add(new OilTrain(0, 0, true, new Route(stations.get(0)), tester));
		stations.add(new Station("London", 850, new Coal(500), 10, new Line[]{Line.Black, Line.Black, Line.Black}, 50, 471f, 300f));
		assertTrue("bonuses were incorrectly set", tester.stations.get(0).getRentValueMod() == ((int)tester.stations.get(0).getRentValue() * 0.05));
	}

	@Test
	public void testStationRewards() {
		fail("Not yet implemented");
	}

	@Test
	public void testAccessShop() {
		fail("Not yet implemented");
	}

	@Test
	public void testAccessGoals() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGoals() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTrains() {
		fail("Not yet implemented");
	}

}
