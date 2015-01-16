package com.TeamHEC.LocomotionCommotion.Train;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.Mocking.GdxTestRunner;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Oil;

@RunWith(GdxTestRunner.class)
public class TrainTest {

	CoalTrain coalTrain;
	OilTrain oilTrain;
	ElectricTrain electricTrain;
	NuclearTrain nuclearTrain;
	
	@Before
	public void setUp()	{
	Player owner = new Player(
			"Alice", 
			0, 
			new Gold(1000), 
			new Coal(1000), 
			new Electric(1000), 
			new Nuclear(1000), 
			new Oil(1000), 
			new ArrayList<Card>(), 
			new ArrayList<Goal>(), 
			new ArrayList<Train>());	
	
	coalTrain = new CoalTrain(0,true, new Route(new MapObj(0, 0)), owner);
	oilTrain = new OilTrain(0,true, new Route(new MapObj(0, 0)), owner);
	electricTrain = new ElectricTrain(0,true, new Route(new MapObj(0, 0)), owner);
	nuclearTrain = new NuclearTrain(0,true, new Route(new MapObj(0, 0)), owner);
	}
	
	@Test
	public void testTrain() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValue() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSpeed() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPricePerTurn() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCarriageCapacity() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFuelType() throws Exception {		
		assertTrue(coalTrain.getFuelType() == "Coal");
		assertTrue(oilTrain.getFuelType() == "Oil");
		assertTrue(electricTrain.getFuelType() == "Electric");
		assertTrue(nuclearTrain.getFuelType() == "Nuclear");
	}

	@Test
	public void testSetSpeedMod() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFuelPerTurn() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCarriageLimitMod() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testIncreaseCarriageLimit() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testSetInStation() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testIsInStation() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveTrain() throws Exception {
		fail("Not yet implemented");
	}
}
