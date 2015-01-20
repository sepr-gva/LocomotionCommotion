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
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testNode() {
		assertTrue(n.mapobj == wm.AMSTERDAM);
		assertTrue(n.edges.size() == 0);
		assertTrue(n.minDistance == Double.POSITIVE_INFINITY);
		assertTrue(n.previous == null);
		
		
	}

	@Test
	public void testGetMapObj() {
		assertTrue(n.getMapObj() != null); 
		
		
	}

	@Test
	public void testCompareTo() {
	
	}

}
