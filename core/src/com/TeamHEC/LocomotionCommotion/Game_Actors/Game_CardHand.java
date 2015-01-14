package com.TeamHEC.LocomotionCommotion.Game_Actors;

import java.util.ArrayList;
import java.util.HashMap;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_CardHand {
	public static Game_CardHandManager actorManager;
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
	public void create(Stage stage){
		actorManager = new Game_CardHandManager();
		actorManager.create(stage);
	}
	public static class Game_CardHandManager {
		//Arrays
		private static 	Array<Actor> actors = new Array<Actor>();
		public 	Array<Game_card_Card> cards = new Array<Game_card_Card>();
		//ArrayLists
		public static 	ArrayList<Game_card_Card> currentHand;
		public static 	ArrayList<Card> newcards = new ArrayList<Card>();
		//Booleans
		public boolean open=false;
		//Game_card_Cards
		public  static Game_card_Card card1, card2, card3, card4, card5, card6,card7;
		//Ints
		public  int stagestart, cardActors, height=-100;
		public int selectedCard= 0;
		public  int numberofcards;
		//Actors
		public Game_card_UseCardBtn usecardbtn;

		public Game_CardHandManager(){	}

		public void create(Stage stage){
			//Refreshes Lists - Important for creating a new gamescreen
			actors.clear();
			newcards.clear();
			//Refresh actor counters
			stagestart =0;
			cardActors=0;

//			//TEMP CARDS- Cards need to come from the player.
//			CoalCard coal = new CoalCard();
//			OilCard oil = new OilCard();
//			GoldCard gold = new GoldCard();
//			newcards.add(coal);
//			newcards.add(coal);
//			newcards.add(gold);
//			newcards.add(oil);
//			newcards.add(gold);
//			newcards.add(oil);
//			newcards.add(coal);
//			//TEMP CARDS

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

		public void useCard(int cardNum){						//Method useCard lets the player use their card.
			if (cardNum !=0){												//if the the number of card is not 0
				cards.get(cardNum-1).getCard().implementCard();				//Implement the card object
				Game_ScreenMenu.resourceActorManager.refreshResources();					//refresh the labels showing the resources
				if (cardNum<Game_CardHand.actorManager.numberofcards){									//Shuffle the cards up
					for(int i=cardNum-1;i<Game_CardHand.actorManager.numberofcards-1;i++){
						cards.get(i).setTexture(cards.get(i+1).getTexture());
						cards.get(i).setSlot(i+1);
						cards.get(i).setCard(cards.get(i+1).getCard());

					}
				}

				Game_CardHand.actorManager.selectedCard = 0;											//No card is selected
				cards.get(Game_CardHand.actorManager.numberofcards-1).setEmpty(true);					//Set the end slot as empty and hidden
				cards.get(Game_CardHand.actorManager.numberofcards-1).setVisible(false);
				Game_CardHand.actorManager.numberofcards-=1;											//decrement card number
				GameScreen.cards-=1;										
				Game_ScreenMenu.resourceActorManager.refreshResources();
				Game_CardHand.actorManager.organiseDeck();
				Game_CardHand.actorManager.usecardbtn.setVisible(false);			//hide the use card button
			}


		}

		public void addCard(Card newCard){
			//Method adds card to the hand if not already full
			int numberofcards=Game_CardHand.actorManager.numberofcards;
			if(numberofcards<7){
				Game_CardHand.actorManager.cards.get(numberofcards).setTexture(newCard.getImage());	//sets the image
				Game_CardHand.actorManager.cards.get(numberofcards).setSlot(numberofcards+1);			//sets the slot
				Game_CardHand.actorManager.cards.get(numberofcards).setEmpty(false);					//sets the empty boolean to false
				Game_CardHand.actorManager.cards.get(numberofcards).setCard(newCard);					//give the actor the card object
				Game_CardHand.actorManager.cards.get(numberofcards).refreshBounds();		
				Game_CardHand.actorManager.numberofcards+=1;											//increment the number of cards
				GameScreen.cards+=1;										//update the cards value for display
				Game_ScreenMenu.resourceActorManager.refreshResources();					//refresh the labels to show the change in resources (the change in card number)
			}
		}



		private static void populateHand(Game_card_HandCreator hand) {
			if (hand.getNewCards().size()==0)
				throw new Error("NO CARDS- Including empties");//Check if we have a card (empty or not) for the slots

			//assign the cards to the actors and add them to the lists.
			Game_CardHandManager.card1= hand.getNewCards().get(0);
			actors.add(Game_CardHandManager.card1);
			Game_CardHand.actorManager.cards.add(Game_CardHandManager.card1);


			Game_CardHandManager.card2= hand.getNewCards().get(1);
			actors.add(Game_CardHandManager.card2);
			Game_CardHand.actorManager.cards.add(Game_CardHandManager.card2);

			Game_CardHandManager.card3= hand.getNewCards().get(2);
			actors.add(Game_CardHandManager.card3);
			Game_CardHand.actorManager.cards.add(Game_CardHandManager.card3);

			Game_CardHandManager.card4= hand.getNewCards().get(3);
			actors.add(Game_CardHandManager.card4);
			Game_CardHand.actorManager.cards.add(Game_CardHandManager.card4);

			Game_CardHandManager.card5= hand.getNewCards().get(4);
			actors.add(Game_CardHandManager.card5);
			Game_CardHand.actorManager.cards.add(Game_CardHandManager.card5);

			Game_CardHandManager.card6= hand.getNewCards().get(5);
			actors.add(Game_CardHandManager.card6);
			Game_CardHand.actorManager.cards.add(Game_CardHandManager.card6);

			Game_CardHandManager.card7=hand.getNewCards().get(6);
			actors.add(Game_CardHandManager.card7);
			Game_CardHand.actorManager.cards.add(Game_CardHandManager.card7);		
		}

		/*
		 * Serializes all actors and stores them in an array. This and the Game object
		 * are then saved and stored to be loaded.
		 */
		public void changeHeight(float height){  //Method to move all cards up or down at once
			float newheight = card1.getY() +height;
			card1.setActorY(newheight);
			card2.setActorY(newheight);
			card3.setActorY(newheight);
			card4.setActorY(newheight);
			card5.setActorY(newheight);
			card6.setActorY(newheight);
			card7.setActorY(newheight);
		}

		public void organiseDeck()
		{
			if (Game_CardHand.actorManager.selectedCard == 0){		//resets the expanded boolean for all cards not selected.
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
			if (card1.getSlot() != Game_CardHand.actorManager.selectedCard)
				card1.cardCollapse();
			if (card2.getSlot() != Game_CardHand.actorManager.selectedCard)
				card2.cardCollapse();
			if (card3.getSlot() != Game_CardHand.actorManager.selectedCard)
				card3.cardCollapse();
			if (card4.getSlot() != Game_CardHand.actorManager.selectedCard)
				card4.cardCollapse();
			if (card5.getSlot() != Game_CardHand.actorManager.selectedCard)
				card5.cardCollapse();
			if (card6.getSlot() != Game_CardHand.actorManager.selectedCard)
				card6.cardCollapse();
			if (card7.getSlot() != Game_CardHand.actorManager.selectedCard)
				card7.cardCollapse();
		}

		//Getter for selectedcard
		public static Game_card_Card getSelectedCard(){
			for (Game_card_Card c: Game_CardHand.actorManager.cards)
			{
				if(c.getSlot()==Game_CardHand.actorManager.selectedCard)
				{return c;
				}
			}
			if (Game_CardHand.actorManager.selectedCard == 0)
			{
				throw new Error("No card selected: This should only be called when use card button is using it! ");
			}
			return null;
		}

	}
	
	
	//Card Actor
	public static class Game_card_Card extends Actor {
		boolean started = false;
		private boolean expanded =false;
		private Texture texture;
		private float actorX;
		private float actorY;
		private boolean empty;
		private int slot;
		private Card card;
		
		public  Game_card_Card(Texture texture, int actorX, int actorY, boolean empty, int slot){
			this.slot = slot;
			this.empty= empty;
			if (texture==null){
				this.texture = Game_TextureManager.getInstance().game_card_cardtoggle;//just a filler to avoid errors
			}else
				this.texture = texture; 
			this.actorX = actorX;
			this.actorY = actorY;
			

			setBounds(this.actorX,this.actorY,this.texture.getWidth(),this.texture.getHeight());
			
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_card_Card)event.getTarget()).started = true;
					return true;
				}
			});	
			
		/*	UNCOMMENT THIS TO ALLOW MOUSE OVER (VERY BUGGY)
			addListener(new InputListener(){
				public void enter(InputEvent event, float x, float y, int pointer, Actor ScreenCard) {
					((ScreenCard)event.getTarget()).started = true;
				}
			
			});
			addListener(new InputListener(){
				public void exit(InputEvent event, float x, float y, int pointer, Actor ScreenCard) {
					((ScreenCard)event.getTarget()).started = true;
				}
			
			});
			*/
		}


		public void refreshBounds() {
			setBounds(this.actorX,this.actorY,this.texture.getWidth(),this.texture.getHeight());
			
		}


		@Override
		public void draw(Batch batch, float alpha){
				if (empty)
					this.setVisible(false); //if empty we do not want to draw the actor.
				else
					batch.draw(this.texture,actorX,actorY);
					
		}

		@Override
		public void act(float delta){
			if(started){
				if (isExpanded()) //if expanded, we run cardCollapse which puts the card back in position.
				{
					this.cardCollapse();
					Game_CardHand.actorManager.usecardbtn.setVisible(false);	// hides the use card button
					Game_CardHand.actorManager.selectedCard=0; 				//sets to no card selected
					
				}
				else
				{
					Game_CardHand.actorManager.selectedCard=this.getSlot();		//sets the this card to be selected
					Game_CardHand.actorManager.usecardbtn.setVisible(true);		//makes the use card button to visible
					this.cardExpand();										//raises the card
					Game_CardHand.actorManager.usecardbtn.actorX=this.actorX+40;				//moves the usecardbutton to above it
					Game_CardHand.actorManager.usecardbtn.actorY=this.actorY+350;			//moves the usecardbutton to above it
					
				}
				Game_CardHand.actorManager.usecardbtn.refreshBounds();		//refreshes the use card button action area
				started = false; 	//ends action
			}
		}


		//Getter and Setter for Expanded
		public boolean isExpanded() {
			return expanded;
		}
		public boolean setexpanded(boolean open) {
			this.expanded = open;
			return open;
		}

		//Getter and Setter for Card
		public Card getCard(){
			return this.card;
		}
		public void setCard(Card card){
			this.card = card;
		}

		//Getter and Setter for Texture
		public void setTexture(Texture texture){
			this.texture = texture;
		}
		public Texture getTexture(){
			return texture;
		}
		
		//Getter and Setter for Slot
		public int getSlot(){
			return this.slot;
		}
		public void setSlot(int slot) {
			this.slot= slot;
		}
		
		//Setter for ActorY
		public void setActorY(float y){
			this.actorY=y;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());				
		}
		
		//Setter for Empty
		public void setEmpty(boolean b) {
			this.empty=b;
		}
		
		//cardExpand- Calls Organise deck, moves the card up, updates the expanded boolean, and refreshes bounds.
		public void cardExpand(){
			Game_CardHand.actorManager.organiseDeck();
			this.actorY+=200;
			setexpanded(true);
			setBounds(this.actorX,this.actorY,this.texture.getWidth(),this.texture.getHeight());
		}
		
		/*cardCollapse- if the card is expanded: resets the height of the card depending on whether or not the resource bar is expanded
			sets the expanded boolean, refreshes the action area and calls organiseDeck OR just resets the height when the resource bar changes.*/
		public void cardCollapse(){
			if (expanded){
				if (Game_ScreenMenu.resourceActorManager.resourcebarexpanded)
					this.actorY=80;
				else
					this.actorY=-100;
				setexpanded(false);
				setBounds(this.actorX,this.actorY,this.texture.getWidth(),this.texture.getHeight());
				Game_CardHand.actorManager.organiseDeck();
				}
			else
			{if (Game_ScreenMenu.resourceActorManager.resourcebarexpanded)
				this.actorY=80;
			else
				this.actorY=-100;}
				
		}		
	}
	
	//Hand Creator----------------------------------------------------------------------------------------------
	public static class Game_card_HandCreator {
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
			cardslots.put("1", card1= new Game_card_Card(null,x,heightY,false,1));
			x-=130;																				 //Move card across to make them overlay on each other
			cardslots.put("2", card2= new Game_card_Card(null,x,heightY,false,2));
			x-=130;
			cardslots.put("3", card3= new Game_card_Card(null,x,heightY,false,3));
			x-=130;
			cardslots.put("4", card4= new Game_card_Card(null,x,heightY,false,4));
			x-=130;
			cardslots.put("5", card5= new Game_card_Card(null,x,heightY,false,5));
			x-=130;
			cardslots.put("6", card6= new Game_card_Card(null,x,heightY,false,6));
			x-=130;
			cardslots.put("7", card7= new Game_card_Card(null,x,heightY,false,7));
			return cardslots;
		}
		
		
			public  ArrayList<Game_card_Card>  getNewCards(){
				return newCards; //return the result
			}
		


		}
	
	//Card Hand Actors----------------------------------------------------------------------------------------------
	//Use Card Button
	public static class Game_card_UseCardBtn extends Game_Actor {
		/*
		 * @author Robert Precious <rp825@york.ac.uk>
		 * 
		 * This is an Actor- meaning it's given texture is displayed on the stage and actions (acts) can be performed.
		 * @param texture	The image used for the Actor pulled in from SM_TextureManager (see documentation)
		 * @param actorX	The x coordinate of the bottom left corner of the image
		 * @param actorY	The y coordinate of the bottom left corner of the image
		 * @param started	Boolean used to show if an Actor has been interacted with. Used to stop and start interactions.
		 * 
		 * setBounds	This is the bounds for the interaction, we make it the whole image.
		 * addListener	This adds a listener for a particular interaction in this case touchDown (click)
		 * draw			Actor is drawn
		 * act			The action taken if the listener detects interaction
		 * refreshbounds 	resets the action area
		 * 				Action- calls usecard method in CardHandManager
		 */
		public Game_card_UseCardBtn(){
			texture = Game_TextureManager.getInstance().game_card_usecardbtn; 
			actorX = 1170;
			actorY = 450;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_card_UseCardBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				Game_CardHand.actorManager.useCard((Game_CardHand.actorManager.selectedCard)); //gets the selected card and sends it to the useCard method.
				started= false;
				}
		}
		
		public void refreshBounds(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		
		}

	}
	
	


}
