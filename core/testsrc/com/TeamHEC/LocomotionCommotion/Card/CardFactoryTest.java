package com.TeamHEC.LocomotionCommotion.Card;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Oil;
import com.TeamHEC.LocomotionCommotion.Train.Train;

public class CardFactoryTest {

	Player player;
	CardFactory cardFactory;
	
	@Before
	public void setUp() throws Exception {
		player = new Player(
				"Alice",
				0,
				new Gold(500),
				new Coal(500),
				new Electric(500),
				new Nuclear(500),
				new Oil(500),
				new ArrayList<Card>(),
				new ArrayList<Goal>(),
				new ArrayList<Train>()
				);		
		
		cardFactory = new CardFactory(player);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateAnyCard() {
		//Try multiple times to ensure all cards can be created.
		HashMap<Integer, Card> cardStore = new HashMap<Integer, Card>();
		
		for(int i = 0; i < 5000; i++){
			Card temp = cardFactory.createAnyCard();
			if (temp.equals((Card) new CoalCard(player)))
				cardStore.put(1, temp);
			else if (temp.equals((Card) new OilCard(player)))
				cardStore.put(2, temp);
			else if (temp.equals((Card) new ElectricCard(player)))
				cardStore.put(3, temp);
			else if (temp.equals((Card) new NuclearCard(player)))
				cardStore.put(4, temp);
			else if (temp.equals((Card) new GoldCard(player)))
				cardStore.put(5, temp);
			else if (temp.equals((Card) new GoFasterStripesCard(player)))
				cardStore.put(6, temp);
			else if (temp.equals((Card) new TeleportCard(player)))
				cardStore.put(7, temp);
		}
		
		assertTrue();
		
		
	}

	@Test
	public void testCreateResourceCard() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateMagicCard() {
		fail("Not yet implemented");
	}

}
