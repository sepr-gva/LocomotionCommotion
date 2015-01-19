package com.TeamHEC.LocomotionCommotion.Goal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.TeamHEC.LocomotionCommotion.Goal.Graph.Dijkstra;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;

public class DijkstraTest {
	WorldMap wm = WorldMap.getInstance();
	Station sstation = wm.AMSTERDAM;
	Station fstation = wm.OSLO;		
	Dijkstra d = new Dijkstra();
	
	@Before
	public void setUp() throws Exception {
		d.initialiseGraph();
		
		double rew = d.lookUpNode(fstation).minDistance;
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testDijkstra() {
		fail("Not yet implemented");
	}

	@Test
	public void testComputePaths() {
		d.computePaths(d.lookUpNode(this.sstation));
		assertTrue((d.lookUpNode(fstation).minDistance) != null);
	}

	@Test
	public void testGetShortestPathTo() {
		fail("Not yet implemented");
	}

	@Test
	public void testLookUpNode() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitialiseGraph() {
		fail("Not yet implemented");
	}

}
