package com.TeamHEC.LocomotionCommotion.Game_Actors;
/*
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * This class is a Manager, I use Managers in the UI to handed groups of actors. It means I can hide or show a major group of action from one action.
 * This Manager calls the HandCreator and then takes the result and adds them to the actor which are then added to the stage (recording where in the stage they are)
 * The Manager also handles add and removing from cards from the players hand.
 * 
 * @param actors		Array of actors used to add to stage in one loop
 * @param cards			Array of cards  used for global use
 * @param currentHand	ArrayList of card_Card that represents the currentHand
 * @param newcards		ArrayList of card_Card from the HandCreator
 * @param open			Boolean for if the cards are visible or not
 * @param card1-7		card_Card actors for the cards
 * @param stagestart	int that records the position of the first card_Card actor
 * @param cardActors	int of the number of card_Card actors
 * @param height		int records the height for the cards on screen
 * @param selectedCard	Holds the selected card slot number
 * @param numberofcards	Holds the number of cards from the HandCreator
 * @param usecardbtn	Actor for the use card button
 *
 */

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
	//Arrays
	private static 	Array<Actor> actors = new Array<Actor>();
	public static 	Array<Game_card_Card> cards = new Array<Game_card_Card>();
	//ArrayLists
	public static 	ArrayList<Game_card_Card> currentHand;
	public static 	ArrayList<Card> newcards = new ArrayList<Card>();
	//Booleans
	public static boolean open=false;
	//Game_card_Cards
	public static Game_card_Card card1, card2, card3, card4, card5, card6,card7;
	//Ints
	public static int stagestart, cardActors, height=-100;
	public static int selectedCard= 0;
	public static int numberofcards;
	//Actors
	public static Game_card_UseCardBtn usecardbtn;

	public Game_CardHandManager(){	}

	public void create(Stage stage){
		//Refreshes Lists - Important for creating a new gamescreen
		actors.clear();
		newcards.clear();
		//Refresh actor counters
		stagestart =0;
		cardActors=0;
		
		//TEMP CARDS- Cards need to come from the player.
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
		//TEMP CARDS

		numberofcards= newcards.size();
		Game_card_HandCreator hand = new Game_card_HandCreator(newcards);

		populateHand(hand); //create the actors
		currentHand= hand.getNewCards();	//assign the hand for global use


		stagestart= stage.getActors().size;  	//Record the start or the Card actors
		for (Actor a : actors){					//add the actors to the stage
			if(open == true){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);}
			else
				a.setVisible(false);

			stage.addActor(a);
			cardActors ++;					//Increment the number of cardActors
		}
		usecardbtn = new Game_card_UseCardBtn();//add the the usecardbtn to the stage
		usecardbtn.setVisible(false);
		stage.addActor(usecardbtn);



	}

	public static void useCard(int cardNum){						//Method useCard lets the player use their card.
		if (cardNum !=0){												//if the the number of card is not 0
			cards.get(cardNum-1).getCard().implementCard();				//Implement the card object
			Game_ScreenMenu.resourceActorManager.refreshResources();					//refresh the labels showing the resources
			if (cardNum<numberofcards){									//Shuffle the cards up
				for(int i=cardNum-1;i<numberofcards-1;i++){
					cards.get(i).setTexture(cards.get(i+1).getTexture());
					cards.get(i).setSlot(i+1);
					cards.get(i).setCard(cards.get(i+1).getCard());
					
				}
			}

			selectedCard = 0;											//No card is selected
			cards.get(numberofcards-1).setEmpty(true);					//Set the end slot as empty and hidden
			cards.get(numberofcards-1).setVisible(false);
			numberofcards-=1;											//decrement card number
			GameScreen.cards-=1;										
			Game_ScreenMenu.resourceActorManager.refreshResources();
			organiseDeck();
			Game_CardHandManager.usecardbtn.setVisible(false);			//hide the use card button
		}


	}
	
	public static void addCard(Card newCard){						//Method adds card to the hand if not already full
		if(numberofcards<7){
			cards.get(numberofcards).setTexture(newCard.getImage());	//sets the image
			cards.get(numberofcards).setSlot(numberofcards+1);			//sets the slot
			cards.get(numberofcards).setEmpty(false);					//sets the empty boolean to false
			cards.get(numberofcards).setVisible(true);					//makes the card visible
			cards.get(numberofcards).setCard(newCard);					//give the actor the card object
			
			numberofcards+=1;											//increment the number of cards
			GameScreen.cards+=1;										//update the cards value for display
			Game_ScreenMenu.resourceActorManager.refreshResources();					//refresh the labels to show the change in resources (the change in card number)
		}
	}



	private static void populateHand(Game_card_HandCreator hand) {
		if (hand.getNewCards().size()==0)
			throw new Error("NO CARDS- Including empties");//Check if we have a card (empty or not) for the slots
		
		//assign the cards to the actors and add them to the lists.
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
	public static void changeHeight(float height){  //Method to move all cards up or down at once
		float newheight = card1.getY() +height;
		card1.setActorY(newheight);
		card2.setActorY(newheight);
		card3.setActorY(newheight);
		card4.setActorY(newheight);
		card5.setActorY(newheight);
		card6.setActorY(newheight);
		card7.setActorY(newheight);
	}

	public static void organiseDeck()
	{
		if (selectedCard == 0){		//resets the expanded boolean for all cards not selected.
			for(Game_card_Card b : cards)
				b.setexpanded(false);
			collapseCards();
		}
		else{
			collapseCards();
		}
	}

	//CollapseCards- resets any card that is not selected to unexpanded position
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
	
	//Getter for selectedcard
	public static Game_card_Card getSelectedCard(){
		for (Game_card_Card c: cards)
		{
			if(c.getSlot()==selectedCard)
			{return c;
			}
		}
		if (selectedCard == 0)
		{
			throw new Error("No card selected: This should only be called when use card button is using it! ");
		}
		return null;
	}

}

