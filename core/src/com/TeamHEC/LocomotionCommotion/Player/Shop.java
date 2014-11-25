package com.TeamHEC.LocomotionCommotion.Player;

import java.util.ArrayList;
import java.util.HashMap;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Card.CardFactory;
import com.TeamHEC.LocomotionCommotion.Resource.*;
import com.TeamHEC.LocomotionCommotion.Train.Train;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class Shop {
	
	/*
	  The shop can be used to buy more fuel, more trains, upgrade your existing trains and purchase Wildcards in
		exchange for Gold. You can also sell existing resources in exchange for Gold.
	*/
	
	private ArrayList<Card> cardsForSale = new ArrayList<Card>();
	
	private Coal coalForSale;
	private Electric electricForSale;
	private Nuclear nuclearForSale;
	private Oil oilForSale;
	private Carriage carriageForSale;
	
	private HashMap<String, Fuel> fuelSale;
	
	private Player customer;
	
	public Shop(Player customer)
	{
		this.customer = customer;
		
		coalForSale = new Coal(500);
		electricForSale = new Electric(500);
		nuclearForSale = new Nuclear(500);
		oilForSale = new Oil(500);
		carriageForSale = new Carriage(100);
		
		fuelSale = new HashMap<String, Fuel>();
		
		fuelSale.put("Coal", coalForSale);
		fuelSale.put("Electric", electricForSale);
		fuelSale.put("Nuclear", nuclearForSale);
		fuelSale.put("Oil", oilForSale);
				
		// Generated wild cards for sale:
		for(int i = 0; i < 3; i++)
			cardsForSale.add(CardFactory.getInstance().createRandomCard());
	}
	
	public void openShop()
	{
		// Stuff for setting up UI
	}
	
	// Need validation for price etc..
	public void buyFuel(String fuelType, int quantity)
	{
		Fuel fuel = fuelSale.get(fuelType);
		customer.addFuel(fuelType, quantity);
		customer.subGold(fuel.cost * quantity);
	}
		
	public void sellFuel(String fuelType, int quantity)
	{
		Fuel fuel = fuelSale.get(fuelType);
		customer.subFuel(fuelType, quantity);
		customer.addGold(fuel.cost * quantity);
	}
	
	// Needs Gold validation
	public void upgradeTrainCarriageCapacity(Train train, int quantity)
	{
		customer.subGold(carriageForSale.cost * quantity);
		train.increaseCarriageLimit(quantity);
	}
	
	public void upgradeTrainType(Train train)
	{
		// Not sure quite to do this as they're different classes for each
		// need to fetch all of the current trains stats and make a new object
		// replace accordingly in the Player trains list
	}
	
	// ========== See comments ==============
	
	public void purchaseCard(Card card)
	{
		// ** need a try catch or something for insufficient funds exception **
		
		// Sets the owner to the card and subtract gold from player
		customer.purchaseCard(card);
		customer.subGold(card.getValue());
		
		// Replenish Shop with another card (needs testing):
		int cardIndex = cardsForSale.indexOf(card);
		cardsForSale.remove(card);
		cardsForSale.add(cardIndex, CardFactory.getInstance().createRandomCard());
	}
}