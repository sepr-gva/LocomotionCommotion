package com.TeamHEC.LocomotionCommotion.Train;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
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
	Route route;
	
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
				
		//train = new CoalTrain(0, true, new Route(WorldMap.getInstance().REYKJAVIK), player);
		//train.route.addConnection(train.route.getAdjacentConnections().get(0));
		
		//train.route.getTrainPos();
		
		route = new Route(WorldMap.getInstance().REYKJAVIK);
		route.addConnection(route.getAdjacentConnections().get(0));
	}

	@Test
	public void testGetTrainPos() {
		assertTrue("Train coordinates match start of route",
				route.getTrainPos().x == WorldMap.getInstance().REYKJAVIK.x && route.getTrainPos().y == WorldMap.getInstance().REYKJAVIK.y);
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
