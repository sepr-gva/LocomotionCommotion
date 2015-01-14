package com.TeamHEC.LocomotionCommotion.Game_Actors;

/*
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * card_Card is the actor representing a Card object.
 * 
 *  This is an Actor- meaning it's given texture is displayed on the stage and actions (acts) can be performed.
 * @param texture	The image used for the Actor pulled in from SM_TextureManager (see documentation)
 * @param actorX	The x coordinate of the bottom left corner of the image
 * @param actorY	The y coordinate of the bottom left corner of the image
 * @param started	Boolean used to show if an Actor has been interacted with. Used to stop and start interactions.
 * @param expanded		This holds the boolean for whether or not the hard it raise above the overs.
 * @param empty
 * @param slot
 * @param card
 * 
 * setBounds	This is the bounds for the interaction, we make it the whole image.
 * addListener	This adds a listener for a particular interaction in this case touchDown (click)
 * draw			Actor is drawn if not empty
 * act			The action taken if the listener detects interaction
 * 				Action- Moves the card up and down and makes the use card button available when expanding.
 */

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

class Game_card_Card extends Actor {
	boolean started = false;
	private boolean expanded =false;
	private Texture texture;
	private float actorX;
	private float actorY;
	private boolean empty;
	private int slot;
	private Card card;
	
	public Game_card_Card(Texture texture, int actorX, int actorY, boolean empty, int slot){
		this.slot = slot;
		this.empty= empty;
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
				Game_CardHandManager.usecardbtn.setVisible(false);	// hides the use card button
				Game_CardHandManager.selectedCard=0; 				//sets to no card selected
				
			}
			else
			{
				Game_CardHandManager.selectedCard=this.getSlot();		//sets the this card to be selected
				Game_CardHandManager.usecardbtn.setVisible(true);		//makes the use card button to visible
				this.cardExpand();										//raises the card
				Game_card_UseCardBtn.actorX=this.actorX+40;				//moves the usecardbutton to above it
				Game_card_UseCardBtn.actorY=this.actorY+350;			//moves the usecardbutton to above it
				
			}
			Game_CardHandManager.usecardbtn.refreshBounds();		//refreshes the use card button action area
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
		Game_CardHandManager.organiseDeck();
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
			Game_CardHandManager.organiseDeck();
			}
		else
		{if (Game_ScreenMenu.resourceActorManager.resourcebarexpanded)
			this.actorY=80;
		else
			this.actorY=-100;}
			
	}




	
}