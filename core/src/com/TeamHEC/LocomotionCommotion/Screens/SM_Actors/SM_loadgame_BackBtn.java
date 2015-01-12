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
 * 				Action- Moves camera left back to the main menu page
 */
public class SM_loadgame_BackBtn extends Actor {

	Texture texture = SM_TextureManager.getInstance().sm_newgame_BackBtn; // Reuse Texture the BackButton from new game
	float actorX = 1680+150 ,actorY = 850;
	public boolean started = false;
	int animationTracker1,animationTracker2;

	public SM_loadgame_BackBtn(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((SM_loadgame_BackBtn)event.getTarget()).started = true;
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
			if (animationTracker1<50){
				StartMenu.changeCam(0,-10);
				animationTracker1+=15;
			}
			else{
				if(animationTracker2<1680){
					StartMenu.changeCam(-15,0);
					animationTracker2+=15;
				}

				else{
					started = false;
					animationTracker1=0;
					animationTracker2=0;
				}
			}

		}

	}
}