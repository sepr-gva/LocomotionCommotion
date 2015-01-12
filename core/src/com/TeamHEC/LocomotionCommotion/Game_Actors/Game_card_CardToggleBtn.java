package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
/*
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * This is a class for a button that toggles whether or not you can see the hand of cards
 * 
 * This is an Actor- meaning it's given texture is displayed on the stage and actions (acts) can be performed.
 * @param texture	The image used for the Actor pulled in from SM_TextureManager (see documentation)
 * @param actorX	The x coordinate of the bottom left corner of the image
 * @param actorY	The y coordinate of the bottom left corner of the image
 * @param started	Boolean used to show if an Actor has been interacted with. Used to stop and start interactions.
 * @param open		This holds the boolean for whether or not the hand of cards is visible or hidden.
 * 
 * setBounds	This is the bounds for the interaction, we make it the whole image.
 * addListener	This adds a listener for a particular interaction in this case touchDown (click)
 * draw			Actor is drawn
 * act			The action taken if the listener detects interaction
 * 				Action- finds the range of actors within cards and either shows them if they are hidden or hides them if they're visible.
 */

public class Game_card_CardToggleBtn extends Actor {

	Texture texture = Game_TextureManager.getInstance().game_card_cardtoggle; // reuse the new game back btn texture
	float actorX = 670 ,actorY = 25;
	public boolean started = false;

	public Game_card_CardToggleBtn(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((Game_card_CardToggleBtn)event.getTarget()).started = true;
				return true;
			}
		});
	}


	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(texture,actorX,actorY);
	}

	@Override
	public void act(float delta){
		if(started){
			if (Game_CardHandManager.open== false)
			{
				Game_CardHandManager.open= true; //set hand as open (visible)
				for(int i=Game_CardHandManager.stagestart; i<=Game_CardHandManager.stagestart +Game_CardHandManager.cardActors-1;i++)	//Range of Card Actors
				{ 	
					if (i > GameScreen.getStage().getActors().size-1)
					{//This is just to avoid range errors
					}
					else
						GameScreen.getStage().getActors().get(i).setVisible(true); //Make Card Actors Visible
				}			
			}
			else
			{	
				Game_CardHandManager.open= false; //set hand as closed (hidden)
				for(int i=Game_CardHandManager.stagestart; i<=Game_CardHandManager.stagestart +Game_CardHandManager.cardActors-1;i++) //Range of Card Actors
				{		
					if (i > GameScreen.getStage().getActors().size-1)
					{//This is just to avoid range errors
					}
					else
						GameScreen.getStage().getActors().get(i).setVisible(false); //Make Card Actors Hidden
				}

				Game_CardHandManager.selectedCard=0;	// 0 means that no card is selected 
				Game_CardHandManager.organiseDeck(); 	//call OrganiseDeck - see Game_CardHandManager.organiseDeck() documentation
				Game_CardHandManager.usecardbtn.setVisible(false);	//hide the usecard button
			}
			started = false; //Ends the action
		}
	}

	public void refreshBounds(){
		//Used when button moves to make sure that the action area is where the image is
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());

	}
}