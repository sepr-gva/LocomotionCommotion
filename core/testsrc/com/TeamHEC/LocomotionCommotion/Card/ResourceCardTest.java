package com.TeamHEC.LocomotionCommotion.Card;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Electric;
import com.TeamHEC.LocomotionCommotion.Resource.Gold;
import com.TeamHEC.LocomotionCommotion.Resource.Nuclear;
import com.TeamHEC.LocomotionCommotion.Resource.Oil;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.badlogic.gdx.graphics.Texture;

public class ResourceCardTest {
	
	Card card;
	Player player;
	String cardName;
	Texture cardTexture;
	
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
		
		cardName = "Name";
		cardTexture = Game_TextureManager.getInstance().game_card_coalcard;	
		card = new CoalCard(player); //Using CoalCard to test as ResourceCard is abstract
	}

	@Test
	public void testImplementCard() {
		
	}

	@Test
	public void testResourceCard() {
		assertTrue("Card's owner was not set correctly", card.getOwner() == player);
		assertTrue("Card's texutre was not set correctly", card.getImage() == cardTexture);
		assertTrue("Card's name was not set correctly", card.getName() == cardName);
	}

}
