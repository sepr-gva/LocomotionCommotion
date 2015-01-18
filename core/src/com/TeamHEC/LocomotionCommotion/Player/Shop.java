package com.TeamHEC.LocomotionCommotion.Player;

import java.io.Serializable;

import com.TeamHEC.LocomotionCommotion.Card.CardFactory;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class Shop implements Serializable {
	
	/*
	  The shop can be used to buy more fuel, more trains, upgrade your existing trains and purchase Wildcards in
		exchange for Gold. You can also sell existing resources in exchange for Gold.
	*/
	
	private static final long serialVersionUID = 1L;
	
	private Player customer;
	private CardFactory cardFactory;
	
	public final static int coalPrice = 1;
	public final static int oilPrice = 2;
	public final static int electricPrice = 3;
	public final static int nuclearPrice = 4;
	public final static int cardPrice = 1000;
	
	public Shop(Player customer)
	{
		this.customer = customer;	
		cardFactory = new CardFactory(customer);
	}
	
	public void buyFuel(String fuelType, int quantity)
	{		
		if(fuelType == "Coal" && customer.getGold() > (quantity*coalPrice)) {
			customer.addFuel(fuelType, quantity);
			customer.subGold(quantity * coalPrice);
		}
		if(fuelType == "Oil" && customer.getGold() > (quantity*oilPrice)) {
			customer.addFuel(fuelType, quantity);
			customer.subGold(quantity * oilPrice);
		}
		if(fuelType == "Electric" && customer.getGold() > (quantity*electricPrice)) {
			customer.addFuel(fuelType, quantity);
			customer.subGold(quantity * electricPrice);
		}
		if(fuelType == "Nuclear" && customer.getGold() > (quantity*nuclearPrice)) {
			customer.addFuel(fuelType, quantity);
			customer.subGold(quantity * nuclearPrice);
		}						
	}
		
	public void sellFuel(String fuelType, int quantity)
	{
		if(fuelType == "Coal" && customer.getFuel(fuelType) > quantity) {
			customer.subFuel(fuelType, quantity);
			customer.addGold(quantity * coalPrice);
		}
		if(fuelType == "Oil" && customer.getFuel(fuelType) > quantity) {
			customer.subFuel(fuelType, quantity);
			customer.addGold(quantity * oilPrice);
		}
		if(fuelType == "Electric" && customer.getFuel(fuelType) > quantity) {
			customer.subFuel(fuelType, quantity);
			customer.addGold(quantity * electricPrice);
		}
		if(fuelType == "Nuclear" && customer.getFuel(fuelType) > quantity) {
			customer.subFuel(fuelType, quantity);
			customer.addGold(quantity * nuclearPrice);
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
	}
}