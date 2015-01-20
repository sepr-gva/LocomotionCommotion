package com.TeamHEC.LocomotionCommotion.Player;

import com.TeamHEC.LocomotionCommotion.Card.CardFactory;
import com.TeamHEC.LocomotionCommotion.UI_Elements.WarningMessage;

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

	private Player customer;
	private CardFactory cardFactory;
	
	//Sell price is 70% of the buy price
	public final static int coalPrice = 1;
	public final static float coalSellPrice = 0.7f;
	public final static int oilPrice = 2;
	public final static float oilSellPrice = 1.4f;
	public final static int electricPrice = 3;
	public final static float electricSellPrice = 2.1f;
	public final static int nuclearPrice = 4;
	public final static float nuclearSellPrice = 2.8f;
	public final static int cardPrice = 1000;
	public final static float cardSellPrice = 700f;
	
	public Shop(Player customer)
	{
		this.customer = customer;	
		cardFactory = new CardFactory(customer);
	}
	
	public void buyFuel(String fuelType, int quantity)
	{		
		if(fuelType == "Coal" && customer.getGold() >= (quantity*coalPrice)) {
			customer.addFuel(fuelType, quantity);
			customer.subGold(quantity * coalPrice);
		}
		else if(fuelType == "Oil" && customer.getGold() >= (quantity*oilPrice)) {
			customer.addFuel(fuelType, quantity);
			customer.subGold(quantity * oilPrice);
		}
		else if(fuelType == "Electric" && customer.getGold() >= (quantity*electricPrice)) {
			customer.addFuel(fuelType, quantity);
			customer.subGold(quantity * electricPrice);
		}
		else if(fuelType == "Nuclear" && customer.getGold() >= (quantity*nuclearPrice)) {
			customer.addFuel(fuelType, quantity);
			customer.subGold(quantity * nuclearPrice);
		}	
		else
		{
			WarningMessage.fireWarningWindow("SORRY", "You don't have enough gold!");
		}
	}
		
	public void sellFuel(String fuelType, int quantity)
	{
		
		if(fuelType == "Coal" && customer.getFuel(fuelType) >= quantity) {
			customer.subFuel(fuelType, quantity);
			customer.addGold((int)(Math.ceil(quantity * coalSellPrice)));
		}
		
		
		else if(fuelType == "Oil" && customer.getFuel(fuelType) >= quantity) {
			customer.subFuel(fuelType, quantity);
			customer.addGold((int)(Math.ceil(quantity * oilSellPrice)));
		}
		
		
		else if(fuelType == "Electric" && customer.getFuel(fuelType) >= quantity) {
			customer.subFuel(fuelType, quantity);
			customer.addGold((int)(Math.ceil(quantity * electricSellPrice))); //DO NOT REMOVE MATH.CEIL IT ROUNDS WIERDLY
		}
		
		
		else if(fuelType == "Nuclear" && customer.getFuel(fuelType) >= quantity) {
			customer.subFuel(fuelType, quantity);
			customer.addGold((int)(Math.ceil(quantity * nuclearSellPrice)));
		}
		else
		{
			WarningMessage.fireWarningWindow("SORRY", "You don't have enough "+fuelType+"!");
		}
	}

	public void buyCard()
	{
		if (customer.getCards().size() < 7 && customer.getGold() >= 1000)
		{			
			// Sets the owner to the card and subtract gold from player
			customer.addCard(cardFactory.createAnyCard());
			customer.subGold(1000);		
		}
		else
		{
			WarningMessage.fireWarningWindow("SORRY", "You don't have enough gold!");
		}
	}
}