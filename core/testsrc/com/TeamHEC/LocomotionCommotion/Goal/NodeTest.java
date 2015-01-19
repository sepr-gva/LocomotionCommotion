package com.TeamHEC.LocomotionCommotion.Goal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.TeamHEC.LocomotionCommotion.Goal.Graph.Node;
import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;

public class NodeTest {
	WorldMap wm = WorldMap.getInstance();
	Station yo = wm.AMSTERDAM;
	Node n = new Node(yo);
	
	
	@Before
	public void setUp() throws Exception {
		//wtf is this even
	}

	@After
	public void tearDown() throws Exception {
		//y r u here teardown?
	}

	@Test
	public void testNode() {
		
	}

	@Test
	public void testGetMapObj() {
		assertTrue(n.getMapObj() != null); //k this works
		assertThat((n.getMapObj()), instanceOf(MapObj.class)); 
		//I found assertThat online and its suposed to work
		//gdamniteclipseyusoshit
		
		
	}

	@Test
	public void testCompareTo() {
		// not even sure how necassary it is to have compareTo anyway
	}

}
