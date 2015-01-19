

package com.TeamHEC.LocomotionCommotion.Goal;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.TeamHEC.LocomotionCommotion.Goal.Graph.Dijkstra;
import com.TeamHEC.LocomotionCommotion.Goal.Graph.Node;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
import com.TeamHEC.LocomotionCommotion.Mocking.GdxTestRunner;
@RunWith(GdxTestRunner.class)
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
		//don't know if needed for test
	}

	@Test
	public void testComputePaths() {
		d.computePaths(d.lookUpNode(this.sstation));
		double rew = d.lookUpNode(this.fstation).minDistance;
		assertTrue(rew != null);//[1]
		assertThat(rew, instanceOf(double.class));  //[2]
		//[1] not really sure why this is an error
		//[2] check that ComputePaths returns a double
	}

	@Test
	public void testGetShortestPathTo() {
		  //not going to be used in this assessment
									// left it in with dox for other group to use
									//if they please
	}

	@Test
	public void testLookUpNode() {
		Station st = wm.AMSTERDAM;
		Node n = d.lookUpNode(st);
		//[1] would be nice to have a test that asserts it is of type Node
		assertTrue(n!=null); //test to assert that the lookup node isnotnull
		assertThat(n, instanceOf(Node.class)); //i thought this would accomplish 1
		}

	@Test
	public void testInitialiseGraph() {
		d.initialiseGraph();
		assertTrue(d.nodeList.length != 0 ); //changed visibility of nodelist to 
											// public for this test 
		//couldnt think of a better test
		
	}

}
