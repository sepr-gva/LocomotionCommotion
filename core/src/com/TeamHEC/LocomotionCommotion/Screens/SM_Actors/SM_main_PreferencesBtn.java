package com.TeamHEC.LocomotionCommotion.Screens.SM_Actors;
/*
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * Button that moves page from main to preferences.
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
 * 				Action- moves camera down to preferences menu
 */
import com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
import com.TeamHEC.LocomotionCommotion.Screens.SM_TextureManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class SM_main_PreferencesBtn extends Actor {

	Texture texture = SM_TextureManager.sm_main_preferencesbtn;
	float actorX = SM_main_NewGameBtn.actorX-10 ,actorY = SM_main_NewGameBtn.actorY-150;
	public boolean started = false;

	public SM_main_PreferencesBtn(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((SM_main_PreferencesBtn)event.getTarget()).started = true;
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
			StartMenu.changeCam(0, -950);
			started = false;
		}
	}
	
	public void update(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
	}
}