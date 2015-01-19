package com.TeamHEC.LocomotionCommotion.Map;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Resource;

public class StationTest {

	Station tester;
	String name;
	Player owner;
	int baseValue;
	int valueMod;
	Resource resourceType;
	int baseResourceOut;
	int resourceOutMod;
	Line[] line = null;//max number of lines on one station is 3, alter if this changes
	int rentValue;
	int rentValueMod;
	
	@Before
	public void setUp() throws Exception {
		
		
		tester = new Station(null, 0, null, 0, null, 0, 0, 0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStation() {
		fail("Not yet implemented");
	}

}
