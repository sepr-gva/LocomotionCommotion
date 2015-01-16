package com.TeamHEC.LocomotionCommotion.Goal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoalTest {
	GoalFactory gf = new GoalFactory();
	Goal newgoal = gf.CreateRandomGoal();
	@Before
	public void setUp() throws Exception {
		GoalFactory gf = new GoalFactory();
		Goal newgoal = gf.CreateRandomGoal();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGoal() {
		GoalFactory gf = new GoalFactory();
		Goal newgoal = gf.CreateRandomGoal();
		assertTrue(newgoal != null);
		
	}

	@Test
	public void testStartdate() {
		
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
		GoalFactory gf = new GoalFactory();
		Goal newgoal = gf.CreateRandomGoal();
		assertTrue(newgoal.GetSStation() != null);
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
