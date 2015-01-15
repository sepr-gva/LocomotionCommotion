package com.TeamHEC.LocomotionCommotion.Train;

import org.junit.Assert;
import org.junit.Test;

import com.TeamHEC.LocomotionCommotion.Map.MapObj;

public class TrainTest {

	CoalTrain coalTrain = new CoalTrain(1,2,true, new Route(new MapObj(0, 0)), null);
	OilTrain oilTrain = new OilTrain(1,2,true, new Route(new MapObj(0, 0)), null);
	ElectricTrain electricTrain = new ElectricTrain(1,2,true, new Route(new MapObj(0, 0)), null);
	NuclearTrain nuclearTrain = new NuclearTrain(1,2,true, new Route(new MapObj(0, 0)), null);
	
	@Test
	public void testTrain() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetName() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetValue() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetSpeed() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetPricePerTurn() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetCarriageCapacity() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetFuelType() throws Exception {
		//reset
		coalTrain = new CoalTrain(1,2,true, new Route(new MapObj(0, 0)), null);
		oilTrain = new OilTrain(1,2,true, new Route(new MapObj(0, 0)), null);
		electricTrain = new ElectricTrain(1,2,true, new Route(new MapObj(0, 0)), null);
		nuclearTrain = new NuclearTrain(1,2,true, new Route(new MapObj(0, 0)), null);
		
		//execute
		Assert.assertTrue(coalTrain.getFuelType() == "Coal");
		Assert.assertTrue(oilTrain.getFuelType() == "Oil");
		Assert.assertTrue(electricTrain.getFuelType() == "Electric");
		Assert.assertTrue(nuclearTrain.getFuelType() == "Nuclear");
	}

	@Test
	public void testSetSpeedMod() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSetFuelPerTurn() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSetCarriageLimitMod() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testIncreaseCarriageLimit() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSetInStation() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testIsInStation() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testMoveTrain() throws Exception {
		throw new RuntimeException("not yet implemented");
	}
}
