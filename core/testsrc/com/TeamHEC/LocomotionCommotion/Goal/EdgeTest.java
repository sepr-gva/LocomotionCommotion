package com.TeamHEC.LocomotionCommotion.Goal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.TeamHEC.LocomotionCommotion.Goal.Graph.Node;
import com.TeamHEC.LocomotionCommotion.Goal.Graph.Edge;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;

public class EdgeTest {
	WorldMap wm = WorldMap.getInstance();
	Station yo = wm.AMSTERDAM;
	Node n = new Node(yo);
	Edge e = new Edge(n, 37); //had to change node to public for this test
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEdge() {
		assertTrue(e.target != null);
		assertThat(e.target, instanceOf(Node.class)); //agen shud werk 
		assertThat(e.weight, instanceOf(float.class));
		assertTrue(e.weight == 37);
		
		//Stop checking class types. And add error messages.
		
		
	}

}
