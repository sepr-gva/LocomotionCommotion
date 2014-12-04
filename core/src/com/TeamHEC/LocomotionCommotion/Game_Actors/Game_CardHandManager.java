package com.TeamHEC.LocomotionCommotion.Game_Actors;


import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Card.CoalCard;
import com.TeamHEC.LocomotionCommotion.Card.GoldCard;
import com.TeamHEC.LocomotionCommotion.Card.OilCard;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_CardHandManager {

	private final static Array<Actor> actors = new Array<Actor>();
	private final static Array<ScreenCard> cards = new Array<ScreenCard>();



	public static boolean open=false;

	public static int  stagestart, cardActors, height=-100;

	public static ScreenCard card1, card2, card3, card4, card5, card6,card7;

	public static int selectedCard= 0;

	public static Game_card_UseCardBtn usecardbtn;

	public static ArrayList<ScreenCard> currentHand;

	public static ArrayList<Card> newcards = new ArrayList<Card>();

	public Game_CardHandManager(){	}

	public void create(Stage stage){

		actors.clear();
		newcards.clear();
		stagestart =0;
		cardActors=0;
		CoalCard coal = new CoalCard();
		OilCard oil = new OilCard();
		GoldCard gold = new GoldCard();
		newcards.add(coal);
		newcards.add(coal);
		newcards.add(gold);
		newcards.add(oil);
		newcards.add(gold);
		newcards.add(oil);
		newcards.add(coal);


		Game_card_HandCreator hand = new Game_card_HandCreator(newcards);

		populateHand(hand);
		currentHand= hand.getNewCards();


		stagestart= stage.getActors().size;
		for (Actor a : actors){
			if(open == true){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);}
			else
				a.setVisible(false);

			stage.addActor(a);
			cardActors ++;
		}
		usecardbtn = new Game_card_UseCardBtn();
		usecardbtn.setVisible(false);
		stage.addActor(usecardbtn);



	}
	//Do not use
	public static void changeHand(Stage stage){
		if (selectedCard!=0)
				newcards.remove(selectedCard-1);
		Game_card_HandCreator hand = new Game_card_HandCreator(newcards);
		actors.clear();
		cards.clear();
		populateNewHand(hand);
		currentHand= hand.getNewCards();
		for (int i=stagestart;i<cardActors+2 ;i=i+1){
//			GameScreen.getStage().getActors().removeIndex(i);
			System.out.println(GameScreen.getStage().getActors().get(i).getX());
			System.out.println(i);
		}
		stagestart= stage.getActors().size;
		for (Actor a : actors){
			if(open == true){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);}
			else
				a.setVisible(false);

			stage.addActor(a);
			cardActors ++;
		}
		usecardbtn = new Game_card_UseCardBtn();
		usecardbtn.setVisible(false);
		stage.addActor(usecardbtn);
		

	}
	private static void populateNewHand(Game_card_HandCreator hand){
		card1= hand.getNewCards().get(0);
		actors.add(card1);
		cards.add(card1);


		card2= hand.getNewCards().get(1);
		actors.add(card2);
		cards.add(card2);

		card3= hand.getNewCards().get(2);
		actors.add(card3);
		cards.add(card3);

		card4= hand.getNewCards().get(3);
		actors.add(card4);
		cards.add(card4);

		card5= hand.getNewCards().get(4);
		actors.add(card5);
		cards.add(card5);

		card6= hand.getNewCards().get(5);
		actors.add(card6);
		cards.add(card6);

		card7=hand.getNewCards().get(6);
		actors.add(card7);
		cards.add(card7);	
		
	}

	
	private static void populateHand(Game_card_HandCreator hand) {
		if (hand.getNewCards().size()==0)
			throw new Error("my error");
		card1= hand.getNewCards().get(0);
		actors.add(card1);
		cards.add(card1);


		card2= hand.getNewCards().get(1);
		actors.add(card2);
		cards.add(card2);

		card3= hand.getNewCards().get(2);
		actors.add(card3);
		cards.add(card3);

		card4= hand.getNewCards().get(3);
		actors.add(card4);
		cards.add(card4);

		card5= hand.getNewCards().get(4);
		actors.add(card5);
		cards.add(card5);

		card6= hand.getNewCards().get(5);
		actors.add(card6);
		cards.add(card6);

		card7=hand.getNewCards().get(6);
		actors.add(card7);
		cards.add(card7);		
	}

	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */
	public static void changeHeight(float height){
		float newheight = card1.getY() +height;
		card1.setActorY(newheight);
		card2.setActorY(newheight);
		card3.setActorY(newheight);
		card4.setActorY(newheight);
		card5.setActorY(newheight);
		card6.setActorY(newheight);
		card7.setActorY(newheight);
	}

	public static void organiseDeck(){
		if (selectedCard == 0){
			for(ScreenCard b : cards)
				b.setexpanded(false);

			collapseCards();
		}
		else{
			collapseCards();

		}
	}

	public static void collapseCards(){
		if (card1.getSlot() != selectedCard)
			card1.cardCollapse();
		if (card2.getSlot() != selectedCard)
			card2.cardCollapse();
		if (card3.getSlot() != selectedCard)
			card3.cardCollapse();
		if (card4.getSlot() != selectedCard)
			card4.cardCollapse();
		if (card5.getSlot() != selectedCard)
			card5.cardCollapse();
		if (card6.getSlot() != selectedCard)
			card6.cardCollapse();
		if (card7.getSlot() != selectedCard)
			card7.cardCollapse();



	}
	public static ScreenCard getSelectedCard(){
		for (ScreenCard c: cards){
			if(c.getSlot()==selectedCard){
				return c;
			}}
		if (selectedCard == 0){
			throw new Error("No card selected: This should only be called when use card button is using it! ");
		}	

		return null;
	}



}

