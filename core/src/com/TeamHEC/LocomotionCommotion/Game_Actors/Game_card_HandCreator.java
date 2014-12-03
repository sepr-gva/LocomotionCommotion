package com.TeamHEC.LocomotionCommotion.Game_Actors;

import java.util.ArrayList;

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
			newCards=createEmpties();
		}
		else if(cards.size()>7){
			System.out.println("Error list has over 7 cards");
		}
		else
		{
			
			int heightY = -100;
			int x = 1130;
			if(numberOfCards==1){
				card1 = new ScreenCard(cards.get(0).getImage(),x,heightY,false);
				newCards.add(card1);
				newCards.addAll(createEmpties());
				System.out.println(newCards.size());
				}
			if(numberOfCards==2){
				card1 = new ScreenCard(cards.get(0).getImage(),x,heightY,false);
				newCards.add(card1);
				x-=130;
				card2 = new ScreenCard(cards.get(1).getImage(),x,heightY,false);
				newCards.add(card2);
				newCards.addAll(createEmpties());
				
				}
			if(numberOfCards==3){
				card1 = new ScreenCard(cards.get(0).getImage(),x,heightY,false);
				newCards.add(card1);
				x-=130;
				card2 = new ScreenCard(cards.get(1).getImage(),x,heightY,false);
				newCards.add(card2);
				x-=130;
				card3 = new ScreenCard(cards.get(2).getImage(),x,heightY,false);
				newCards.add(card3);
				newCards.addAll(createEmpties());
				
				}
			if(numberOfCards==4){
				card1 = new ScreenCard(cards.get(0).getImage(),x,heightY,false);
				newCards.add(card1);
				x-=130;
				card2 = new ScreenCard(cards.get(1).getImage(),x,heightY,false);
				newCards.add(card2);
				x-=130;
				card3 = new ScreenCard(cards.get(2).getImage(),x,heightY,false);
				newCards.add(card3);
				x-=130;
				card4 = new ScreenCard(cards.get(3).getImage(),x,heightY,false);
				newCards.add(card4);
				newCards.addAll(createEmpties());
				
				}
			if(numberOfCards==5){
				card1 = new ScreenCard(cards.get(0).getImage(),x,heightY,false);
				newCards.add(card1);
				x-=130;
				card2 = new ScreenCard(cards.get(1).getImage(),x,heightY,false);
				newCards.add(card2);
				x-=130;
				card3 = new ScreenCard(cards.get(2).getImage(),x,heightY,false);
				newCards.add(card3);
				x-=130;
				card4 = new ScreenCard(cards.get(3).getImage(),x,heightY,false);
				newCards.add(card4);
				x-=130;
				card5 = new ScreenCard(cards.get(4).getImage(),x,heightY,false);
				newCards.add(card5);
				newCards.addAll(createEmpties());
				
				}
			if(numberOfCards==6){
				card1 = new ScreenCard(cards.get(0).getImage(),x,heightY,false);
				newCards.add(card1);
				x-=130;
				card2 = new ScreenCard(cards.get(1).getImage(),x,heightY,false);
				newCards.add(card2);
				x-=130;
				card3 = new ScreenCard(cards.get(2).getImage(),x,heightY,false);
				newCards.add(card3);
				x-=130;
				card4 = new ScreenCard(cards.get(3).getImage(),x,heightY,false);
				newCards.add(card4);
				x-=130;
				card5 = new ScreenCard(cards.get(4).getImage(),x,heightY,false);
				newCards.add(card5);
				x-=130;
				card6 = new ScreenCard(cards.get(5).getImage(),x,heightY,false);
				newCards.add(card6);
				newCards.addAll(createEmpties());
				
				}
			if(numberOfCards==7){
				card1 = new ScreenCard(cards.get(0).getImage(),x,heightY,false);
				newCards.add(card1);
				x-=130;
				card2 = new ScreenCard(cards.get(1).getImage(),x,heightY,false);
				newCards.add(card2);
				x-=130;
				card3 = new ScreenCard(cards.get(2).getImage(),x,heightY,false);
				newCards.add(card3);
				x-=130;
				card4 = new ScreenCard(cards.get(3).getImage(),x,heightY,false);
				newCards.add(card4);
				x-=130;
				card5 = new ScreenCard(cards.get(4).getImage(),x,heightY,false);
				newCards.add(card5);
				x-=130;
				card6 = new ScreenCard(cards.get(5).getImage(),x,heightY,false);
				newCards.add(card6);
				x-=130;
				card7 = new ScreenCard(cards.get(6).getImage(),x,heightY,false);
				newCards.add(card7);
				
				}


		}



	}
	public  ArrayList<ScreenCard>  getNewCards(){
		return newCards;
	}

	public ArrayList<ScreenCard> createEmpties(){
		ArrayList<ScreenCard> empties = new ArrayList<ScreenCard>();
		if(numberOfCards==0){
			card1 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card1);
			card2 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card2);
			card3 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card3);
			card4 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card4);
			card5 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card5);
			card6 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card6);
			card7 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card7);
		}
		if(numberOfCards==1){
			card2 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card2);
			card3 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card3);
			card4 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card4);
			card5 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card5);
			card6 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card6);
			card7 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card7);
		}
		if(numberOfCards==2){
			card3 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card3);
			card4 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card4);
			card5 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card5);
			card6 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card6);
			card7 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card7);
		}
		if(numberOfCards==3){
			card4 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card4);
			card5 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card5);
			card6 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card6);
			card7 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card7);
		}
		if(numberOfCards==4){
			card5 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card5);
			card6 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card6);
			card7 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card7);
		}
		if(numberOfCards==5){
			card6 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card6);
			card7 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card7);
		}
		if(numberOfCards==6){
			card7 = new ScreenCard(Game_TextureManager.game_card_cardtoggle,0,0,true);
			empties.add(card7);
		}
		
		return empties;

	}

}
