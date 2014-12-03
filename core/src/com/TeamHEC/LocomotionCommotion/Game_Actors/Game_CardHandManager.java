package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_CardHandManager {

	private final static Array<Actor> actors = new Array<Actor>();
	private final static Array<Card> cards = new Array<Card>();



	public static boolean open=false;

	public static int  stagestart, cardActors, height=-100;

	public static Card card1, card2, card3, card4, card5, card6,card7;

	public static Card selectedCard= null;


	public Game_CardHandManager(){	}

	public void create(Stage stage){

		actors.clear();
		stagestart =0;
		cardActors=0;

		//Card 1

		int x= 1130;
		int heightY = height;
		card1= new Card(Game_TextureManager.game_card_oilcard, x, heightY);
		actors.add(card1);
		cards.add(card1);


		card2= new Card(Game_TextureManager.game_card_oilcard, (x=x-130), heightY);
		actors.add(card2);
		cards.add(card2);

		card3= new Card(Game_TextureManager.game_card_oilcard, (x=x-130), heightY);
		actors.add(card3);
		cards.add(card3);

		card4= new Card(Game_TextureManager.game_card_oilcard, (x=x-130), heightY);
		actors.add(card4);
		cards.add(card4);

		card5= new Card(Game_TextureManager.game_card_oilcard, (x=x-130), heightY);
		actors.add(card5);
		cards.add(card5);

		card6= new Card(Game_TextureManager.game_card_oilcard, (x=x-130), heightY);
		actors.add(card6);
		cards.add(card6);

		card7= new Card(Game_TextureManager.game_card_oilcard, (x=x-130), heightY);
		actors.add(card7);
		cards.add(card7);




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
		if (selectedCard == null){
			System.out.println("null called");
			for(Card b : cards)
				b.setexpanded(false);

			collapseCards();
		}
		else{
			collapseCards();

		}
	}

	public static void collapseCards(){
		if (card1 != selectedCard)
			card1.cardCollapse();
		if (card2 != selectedCard)
			card2.cardCollapse();
		if (card3 != selectedCard)
			card3.cardCollapse();
		if (card4 != selectedCard)
			card4.cardCollapse();
		if (card5 != selectedCard)
			card5.cardCollapse();
		if (card6 != selectedCard)
			card6.cardCollapse();
		if (card7 != selectedCard)
			card7.cardCollapse();



	}




}

