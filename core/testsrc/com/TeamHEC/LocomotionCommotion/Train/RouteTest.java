package com.TeamHEC.LocomotionCommotion.Train;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Map.Connection;
import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
import com.TeamHEC.LocomotionCommotion.MapActors.Game_Map_Manager;
import com.TeamHEC.LocomotionCommotion.Mocking.GdxTestRunner;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Oil;

@RunWith(GdxTestRunner.class)
public class RouteTest {
	
	Train train;
	
	@Before
	public void setUp() throws Exception {
		
		
		String name = "Player 1";
		int points = 0;
		Gold gold = new Gold(1000);
		Coal coal = new Coal(200);
		Oil oil = new Oil(200);
		Electric electric = new Electric(200);
		Nuclear nuclear = new Nuclear(200);
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<Goal> goals = new ArrayList<Goal>();
		ArrayList<Train> trains = new ArrayList<Train>();
		
		Player player = new Player(
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
		
		Game_Map_Manager gmm = new Game_Map_Manager();
	//	gmm.create(stage);
		
		train = new CoalTrain(0, true, new Route(WorldMap.getInstance().REYKJAVIK), player);
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
	}

	@Test
	public void testRouteArrayListOfConnectionIntFloat() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdjacentConnections() {
		assertTrue("Adjacent connection to reykjavik is OSLO", train.route.getRoute().get(0) == WorldMap.getInstance().REYKJAVIK.connections.get(0));
	}

	@Test
	public void testAddConnection() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveConnection() {
		fail("Not yet implemented");
	}

	@Test
	public void testAbortRoute() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancelRoute() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTrainPos() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotalLength() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLengthRemaining() {
		fail("Not yet implemented");
	}

	@Test
	public void testInStation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStation() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
