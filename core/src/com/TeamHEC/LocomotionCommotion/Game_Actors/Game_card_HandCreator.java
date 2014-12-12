package com.TeamHEC.LocomotionCommotion.Game_Actors;

/*
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * This class is the hand creator. It takes an ArrayList of cards from the card factory or player and turns the card objects into card_Card objects. (name may change)
 * @param card1, card2, card3, card4, card5, card6,card7	holds empty classes to be filled
 * @param newCards 			an ArrayList that is ultimately what is returned from this class. It holds the new hand of cards.
 * @param numberOfCards		an integer used to hold the number of cards in the hand. I assign it the size of the given ArrayList of cards.
 * @param cardslots			a hashmap which is used to hold card_Cards in slots.
 * 
 * Other Points:
 * I have used "String a = new Integer(i).toString();	" on several occasions this turns an int into a string which we need to get things from an hashmap.
 */
import java.util.ArrayList;
import java.util.HashMap;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;

public class Game_card_HandCreator {

	public static ArrayList<Game_card_Card> newCards;
	public static Game_card_Card card1, card2, card3, card4, card5, card6,card7;
	public static int numberOfCards;

	public Game_card_HandCreator(ArrayList<Card> cards)
	{
		
		numberOfCards = cards.size();	 	//assign the size of the give ArrayList of Cards
		GameScreen.cards= numberOfCards;	//update the gamescreen value (for display)
		
		newCards = new ArrayList<Game_card_Card>(); //initialise new Arraylist
		
		if (cards.size()==0){
			newCards=createEmpties(cards);	//if there are not given card then we need an empty hand
		}
		else if(cards.size()>7){
			throw new Error("Error list has over 7 cards"); //Hand can only have a max of 7 cards, so I throw an Error.
		}
		else
		{	//Otherwise we need to put the cards given to us into card slots
			//Create slots
			HashMap<String, Game_card_Card> cardslots = new HashMap<String, Game_card_Card>();	//we are using a Hashmap to hold the slots
			cardslots = createSlots(cards); //Call Method to initialise slots.

			//fill slots
			for (int i=0;i<numberOfCards;i++)
			{							//1. run through the cards given
				String a = new Integer(i+1).toString();					//turn the counter in to a string for Hashmap recall
				cardslots.get(a).setTexture(cards.get(i).getImage());	//Take the image in the card object and assign it to the actor
				cardslots.get(a).setCard(cards.get(i));					//Give the actor the card (this is needed when trying to use the card
				newCards.add(cardslots.get(a));							// Add it to the newcard list
			}
			//create empty slots
			for (int i=numberOfCards;i<7;i++)
			{
				String a = new Integer(i+1).toString();
				cardslots.get(a).setEmpty(true);						//set slot as empty which means it does not get drawn
				newCards.add(cardslots.get(a));							//add it to the new card list
			}	
		}
	}
	private ArrayList<Game_card_Card> createEmpties(ArrayList<Card> cards) 
	{
		HashMap<String, Game_card_Card> cardslots = new HashMap<String, Game_card_Card>(); //create an Hashmap of slots
		cardslots = createSlots(cards);		//create slots
		
		for (int i=numberOfCards;i<7;i++)				//run through all slots
		{
			String a = new Integer(i+1).toString();		//change the counter+1 to a string for recall in the hashmap 
			cardslots.get(a).setEmpty(true);			//set slot as empty which means it does not get drawn
			newCards.add(cardslots.get(a));				//add it to the new card list
		}
		return newCards;
	}
	
	private HashMap<String, Game_card_Card> createSlots(ArrayList<Card> cards) {
		int heightY = -100;
		int x = 1130;
		HashMap<String, Game_card_Card> cardslots = new HashMap<String, Game_card_Card>();
		cardslots.put("1", card1= new Game_card_Card(cards.get(0).getImage(),x,heightY,false,1));
		x-=130;																				 //Move card across to make them overlay on each other
		cardslots.put("2", card2= new Game_card_Card(cards.get(0).getImage(),x,heightY,false,2));
		x-=130;
		cardslots.put("3", card3= new Game_card_Card(cards.get(0).getImage(),x,heightY,false,3));
		x-=130;
		cardslots.put("4", card4= new Game_card_Card(cards.get(0).getImage(),x,heightY,false,4));
		x-=130;
		cardslots.put("5", card5= new Game_card_Card(cards.get(0).getImage(),x,heightY,false,5));
		x-=130;
		cardslots.put("6", card6= new Game_card_Card(cards.get(0).getImage(),x,heightY,false,6));
		x-=130;
		cardslots.put("7", card7= new Game_card_Card(cards.get(0).getImage(),x,heightY,false,7));
		return cardslots;
	}
	
	
		public  ArrayList<Game_card_Card>  getNewCards(){
			return newCards; //return the result
		}
	


	}
