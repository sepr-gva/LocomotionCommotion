package com.TeamHEC.LocomotionCommotion.Screens.SM_Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
/*
 * * Button for selecting game mode
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
 * 				Action- changes its own image, the Stationdomination image and the gamemode param in StartMenu
 */
public class SM_newgame_TurnTimeOutBtn extends Actor {
	
	public static Texture texture = SM_TextureManager.getInstance().sm_newgameTurnTimeOut_unselected_Btn;
	public static float actorX = 400 ,actorY = 1150+530;
	public boolean started = false;

	public SM_newgame_TurnTimeOutBtn(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((SM_newgame_TurnTimeOutBtn)event.getTarget()).started = true;
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
			StartMenu.gameMode = "turntimeout";
			texture = SM_TextureManager.getInstance().sm_newgame_TurnTimeOutBtn;
			SM_newgame_StationDomBtn.texture = SM_TextureManager.getInstance().sm_newgame_StationDom_unselected_Btn;
			started = false;
			
			
		}
	}
}