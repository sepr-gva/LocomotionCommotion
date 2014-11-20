package com.TeamHEC.LocomotionCommotion.Screens.Actors;

import com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class PreferencesActor extends Actor {

	Texture texture = new Texture(Gdx.files.internal("sm_preferences.png"));
	float actorX = NewGameActor.actorX-10 ,actorY = NewGameActor.actorY-150;
	public boolean started = false;

	public PreferencesActor(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((PreferencesActor)event.getTarget()).started = true;
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
			StartMenu.changeCam(0, -1050);
			started = false;
		}
	}
	
	public void update(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
	}
}