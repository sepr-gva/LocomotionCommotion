package com.TeamHEC.LocomotionCommotion.Goal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoalFactoryTest {
	GoalFactory gf = new GoalFactory();
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGoalFactory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenCard() {
		assertTrue(gf.genCard() != null);
		//assertThat(gf.genCard(), instanceOf(Card.class));
		
	}

	@Test
	public void testCreateRandomGoal() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLength() {
		fail("Not yet implemented");
	}

}
