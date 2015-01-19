package com.TeamHEC.LocomotionCommotion.Map;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MapObjTest {
	float x;
	float y;
	String mapObjName;
	MapObj tester;
	
	@Before
	public void setUp() throws Exception {
		x = 0.5f;
		y = 1.0f;
		mapObjName = "FooLand";
		
		tester = new MapObj(x, y, mapObjName);
	}

	@Test
	public void testMapObj() {
		assertTrue("x coordinate did not initialise correctly", x == tester.getActor().actorX);
		assertTrue("y coordinate did not initialise correctly", y == tester.getActor().actorX);
		assertTrue("mapObj Name did not initialise correctly", mapObjName == tester.getName());
		assertTrue("Station did not initialise correctly", tester.getStation() == null);
	}

}
