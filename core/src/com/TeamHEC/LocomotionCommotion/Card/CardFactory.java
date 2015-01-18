package com.TeamHEC.LocomotionCommotion.Card;

import java.util.ArrayList;
import java.util.Random;

import com.TeamHEC.LocomotionCommotion.Player.Player;

/**
 * 
 * @author Callum Hewitt <ch1194@york.ac.uk>
 *
 */

public class CardFactory{
	
	private Random random;
	private ArrayList<Card> magicCardList;
	private ArrayList<Card> resourceCardList;
	private Player player;
	
	TeleportCard teleport;
	GoFasterStripesCard goFaster;
	
	CoalCard coal;
	OilCard oil;
	ElectricCard electric;
	NuclearCard nuclear;
	GoldCard gold;

	public CardFactory(Player player) //player is null for shop.
	{		
		this.player = player;
		random = new Random();		
		
		teleport = new TeleportCard(this.player);
		goFaster = new GoFasterStripesCard(this.player);
		
		coal = new CoalCard(this.player);
		oil = new OilCard(this.player);
		electric = new ElectricCard(this.player);
		nuclear = new NuclearCard(this.player);
		gold = new GoldCard(this.player);
		
		magicCardList = new ArrayList<Card>();
		magicCardList.add(teleport);
		magicCardList.add(goFaster);
				
		resourceCardList = new ArrayList<Card>();
		resourceCardList.add(coal);
		resourceCardList.add(oil);
		resourceCardList.add(electric);
		resourceCardList.add(nuclear);
		resourceCardList.add(gold);	
	}

	// returns a card from the existing list:
	public Card createAnyCard()
	{
		ArrayList<Card> cardList = new ArrayList<Card>(magicCardList);
		cardList.addAll(resourceCardList);
		
		return cardList.get(random.nextInt(cardList.size()));		
	}
	
	public Card createResourceCard()
	{
		return magicCardList.get(random.nextInt(magicCardList.size()));
	}
	
	public Card createMagicCard()
	{
		return resourceCardList.get(random.nextInt(resourceCardList.size()));
	}
}
