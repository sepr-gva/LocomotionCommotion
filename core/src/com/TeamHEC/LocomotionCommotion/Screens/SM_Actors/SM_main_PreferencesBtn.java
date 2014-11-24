package com.TeamHEC.LocomotionCommotion.Screens.SM_Actors;

import com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
import com.TeamHEC.LocomotionCommotion.Screens.TextureManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class SM_main_PreferencesBtn extends Actor {

	Texture texture = TextureManager.sm_main_preferencesbtn;
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