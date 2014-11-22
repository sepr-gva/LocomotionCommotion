package com.TeamHEC.LocomotionCommotion.Player;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Card.CardFactory;
import com.TeamHEC.LocomotionCommotion.Resource.Coal;
import com.TeamHEC.LocomotionCommotion.Resource.Fuel;

public class Shop {
	
	/*
	  The shop can be used to buy more fuel, more trains, upgrade your existing trains and purchase Wildcards in
	exchange for Gold. You can also sell existing resources in exchange for Gold.
	
	*/
	
	private ArrayList<Card> cardsForSale = new ArrayList<Card>();
	private Coal coalForSale;
	private Player customer;
	
	public Shop(Player customer)
	{
		this.customer = customer;
		
		// Generated wild cards for sale:
		for(int i = 0; i < 3; i++)
			cardsForSale.add(CardFactory.getInstance().createCard());
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
		cardsForSale.add(cardIndex, CardFactory.getInstance().createCard());
	}
	
	
	// Need validation for price etc..
	// Surely we can use a superclass somehow?
	
	public void sellCoal(int quantity)
	{
		customer.coal.subValue(quantity);
		customer.addGold(customer.coal.cost * quantity);
	}
	
	public void buyCoal(int quantity)
	{
		customer.subGold(coalForSale.cost * quantity);
		customer.coal.addValue(quantity);
	}
	
	public void sellElectric(int quantity)
	{
		customer.electric.subValue(quantity);
		customer.addGold(customer.electric.cost * quantity);
	}
	
	public void buyElectric(int quantity)
	{
		customer.subGold(coalForSale.cost * quantity);
		customer.coal.addValue(quantity);
	}
}
