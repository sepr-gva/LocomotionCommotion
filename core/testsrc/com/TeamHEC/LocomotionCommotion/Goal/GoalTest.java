package com.TeamHEC.LocomotionCommotion.Goal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.TeamHEC.LocomotionCommotion.Mocking.GdxTestRunner;

@RunWith(GdxTestRunner.class)
public class GoalTest {
	GoalFactory gf;
	Goal newgoal;
	
	@Before
	public void setUp() throws Exception {
		gf = new GoalFactory();
		newgoal = gf.CreateRandomGoal();		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGoal() {		
		assertTrue(newgoal != null);		
	}

	@Test
	public void testStartdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsSpecial() {
		fail("Not yet implemented");
	}

	@Test
	public void testRewards() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSStation() {
		assertTrue(newgoal.getSStation() != null);
	}

	@Test
	public void testGetFStation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMission() {
		fail("Not yet implemented");
	}

}
