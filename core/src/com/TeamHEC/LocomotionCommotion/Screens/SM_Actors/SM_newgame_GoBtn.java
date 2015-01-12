package com.TeamHEC.LocomotionCommotion.Screens.SM_Actors;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
/*
 * Button that passes the varibles needed to start a new game, shows the gamescreen and disposes the startmenu
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
 * 				Action- sets the screen to game screen by calling method 
 */

public class SM_newgame_GoBtn extends Actor {

	Texture texture = SM_TextureManager.getInstance().sm_newgame_GoBtn;
	public static float actorX = -100 ,actorY = 1150+50;
	public boolean started = false;

	public SM_newgame_GoBtn(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((SM_newgame_GoBtn)event.getTarget()).started = true;
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
			//System.out.println("New Game: "+StartMenu.gameMode+" "+StartMenu.player1name+ " "+ StartMenu.player2name +
			//" "+ StartMenu.turnChoice);
			GameScreen.player1name=StartMenu.player1name;
			GameScreen.player2name=StartMenu.player2name;
			GameScreen.gameMode=StartMenu.gameMode;
			GameScreen.turns=StartMenu.turnChoice;

			LocomotionCommotion.getInstance().setGameScreen();

			started = false;


		}
	}
}