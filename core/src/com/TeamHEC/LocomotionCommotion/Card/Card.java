package com.TeamHEC.LocomotionCommotion.Card;

public class Card {
	
	/*
		Thought process:
	
	 1) Associated with player class
	 	- A player is limited to the amount of cards associated with them
	 	
	 	A) Implemented within player class
	 	
	 2) Each card has an effect on the game and can only be used once so can interact
	 with a wide range of other classes.
	 
	 	A) So this can be a super class and we'll create subclasses for each card type
	 	
	 3) Once used, the instance of the card class will be collected as there is no need to record cards
	 that have been played.
	 
	 	A) 	This can be controlled in this class as a super class
	 */
	
	private final String cardName;
	private final String cardDescription;
	
	public Card(String name, String description)
	{
		cardName = name;
		cardDescription = description;
	}
	
	// For the shop:
	public String getName()
	{
		return cardName;
	}
	
	public String getDescription()
	{
		return cardDescription;
	}
}
