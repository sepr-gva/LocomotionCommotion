

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
	double rew;
	
	@Before
	public void setUp() throws Exception {
		d.initialiseGraph();		
		rew = d.lookUpNode(fstation).minDistance;	
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
		//assertTrue(rew != null);//[1]
		//assertThat(rew, instanceOf(double.class));  //[2]
		//[1] not really sure why this is an error
		//[2] check that ComputePaths returns a double
		
		//You don't need to test if its null. Doubles can't be null. 
		//Also you don't need to check if it's a double. It has to return a double it can't return anythign else.
		
		//Just check that the value is > 0 and is not infinite.
		//You also need to add error messages like I have in my tests. It helps with debugging.
	}

	@Test
	public void testGetShortestPathTo() {
		  //not going to be used in this assessment
									// left it in with dox for other group to use
									//if they please
	}

	@Test
	public void testLookUpNode() {		
		Node n = d.lookUpNode(fstation);
		//[1] would be nice to have a test that asserts it is of type Node
		assertTrue(n!=null); //test to assert that the lookup node isnotnull
		//assertThat(n, instanceOf(Node.class)); //i thought this would accomplish 1
		}
	
	//Again, you don't need to test it's type. 
	//You should test that lookUpNode works by making sure it returns a value you expect.
	//And add error messages to all of your assertions.

	@Test
	public void testInitialiseGraph() {
		d.initialiseGraph();
		assertTrue(d.nodeList.length != 0 ); //changed visibility of nodelist to 
											// public for this test 
		//couldnt think of a better test
		
	}

}
