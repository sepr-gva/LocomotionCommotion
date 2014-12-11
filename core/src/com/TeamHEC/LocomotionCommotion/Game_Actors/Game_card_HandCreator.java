package com.TeamHEC.LocomotionCommotion.Game_Actors;

import java.util.ArrayList;
import java.util.HashMap;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;

public class Game_card_HandCreator {

	public static ArrayList<ScreenCard> newCards;
	public static ScreenCard card1, card2, card3, card4, card5, card6,card7;
	public static int numberOfCards;

	public Game_card_HandCreator(ArrayList<Card> cards){
		numberOfCards = cards.size();
		newCards = new ArrayList<ScreenCard>();
		GameScreen.cards= numberOfCards;
		
		if (cards.size()==0){
			newCards=createEmpties(cards);
		}
		else if(cards.size()>7){
			System.out.println("Error list has over 7 cards");
		}
		else
		{
			//Create slots
			HashMap<String, ScreenCard> cardslots = new HashMap<String, ScreenCard>();
			cardslots = createSlots(cards);

			//fill slots
			for (int i=0;i<numberOfCards;i++){
				String a = new Integer(i+1).toString();
				cardslots.get(a).setTexture(cards.get(i).getImage());
				cardslots.get(a).setCard(cards.get(i));
				newCards.add(cardslots.get(a));
			}
			//create empty slots
			for (int i=numberOfCards;i<7;i++){
				String a = new Integer(i+1).toString();
				cardslots.get(a).setEmpty(true);
				newCards.add(cardslots.get(a));
			}	
		}



	}
	private ArrayList<ScreenCard> createEmpties(ArrayList<Card> cards) {
		HashMap<String, ScreenCard> cardslots = new HashMap<String, ScreenCard>();
		cardslots = createSlots(cards);
		
		for (int i=numberOfCards;i<7;i++){
			String a = new Integer(i+1).toString();
			cardslots.get(a).setEmpty(true);
			newCards.add(cardslots.get(a));
		}
		return newCards;
	}
	
	private HashMap<String, ScreenCard> createSlots(ArrayList<Card> cards) {
		int heightY = -100;
		int x = 1130;
		HashMap<String, ScreenCard> cardslots = new HashMap<String, ScreenCard>();
		cardslots.put("1", card1= new ScreenCard(cards.get(0).getImage(),x,heightY,false,1));
		x-=130;
		cardslots.put("2", card2= new ScreenCard(cards.get(0).getImage(),x,heightY,false,2));
		x-=130;
		cardslots.put("3", card3= new ScreenCard(cards.get(0).getImage(),x,heightY,false,3));
		x-=130;
		cardslots.put("4", card4= new ScreenCard(cards.get(0).getImage(),x,heightY,false,4));
		x-=130;
		cardslots.put("5", card5= new ScreenCard(cards.get(0).getImage(),x,heightY,false,5));
		x-=130;
		cardslots.put("6", card6= new ScreenCard(cards.get(0).getImage(),x,heightY,false,6));
		x-=130;
		cardslots.put("7", card7= new ScreenCard(cards.get(0).getImage(),x,heightY,false,7));
		return cardslots;
	}
	
	
		public  ArrayList<ScreenCard>  getNewCards(){
			return newCards;
		}
	


	}
