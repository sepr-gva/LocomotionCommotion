package com.TeamHEC.LocomotionCommotion.Screens.SM_Actors;

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
 * 				Action- None
 */
public class SM_main_LinesImg extends Actor {

	Texture texture = SM_TextureManager.sm_main_linesimg;
	float actorX = -229 ,actorY = -145;
	public boolean started = false;

	public SM_main_LinesImg(){
		texture.getMinFilter();
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean keyDown (InputEvent event, int keycode) {
				((SM_main_LinesImg)event.getTarget()).started = true;
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
			actorX-=30;
		}
	}
}