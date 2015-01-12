package com.TeamHEC.LocomotionCommotion.Screens.SM_Actors;

import com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
/*
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * Button that returns user to main page
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
 * 				Action- moves camera down to the main page and resets page.
 */
public class SM_newgame_BackBtn extends Actor {

	Texture texture = SM_TextureManager.sm_newgame_BackBtn;
	float actorX = 1150 ,actorY = 1050+750;
	public boolean started = false;
	int animationTracker1,animationTracker2;

	public SM_newgame_BackBtn(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((SM_newgame_BackBtn)event.getTarget()).started = true;
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
			
			if (animationTracker1<90){
				StartMenu.changeCam(15,0);
				animationTracker1+=15;
			}
			else{
				if(animationTracker2<950){
					StartMenu.changeCam(0,-15);
					animationTracker2+=15;
				}
				else{
					resetNewGameScreen();
					started = false;
					animationTracker1=0;
					animationTracker2=0;
				}
			}
		}
		
			
	}
	
	public void resetNewGameScreen(){
		SM_newgame_TurnTimeOutBtn.texture = SM_TextureManager.sm_newgameTurnTimeOut_unselected_Btn;
		SM_newgame_StationDomBtn.texture =SM_TextureManager.sm_newgame_StationDom_unselected_Btn ;
		StartMenu.textbox1.setText("");
		StartMenu.textbox2.setText("");
		SM_newgame_Turn50Btn.texture = SM_TextureManager.sm_newgame_Turn50_unselected_Btn;
		SM_newgame_Turn100Btn.texture = SM_TextureManager.sm_newgame_Turn100_unselected_Btn;
		SM_newgame_Turn150Btn.texture = SM_TextureManager.sm_newgame_Turn150_unselected_Btn;
		StartMenu.gameMode=null;
		StartMenu.player1name= null;
		StartMenu.player2name= null;
		StartMenu.turnChoice=0;
	}
}