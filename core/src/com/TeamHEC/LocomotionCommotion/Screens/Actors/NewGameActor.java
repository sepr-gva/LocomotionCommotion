package com.TeamHEC.LocomotionCommotion.Screens.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class NewGameActor extends Actor {

	Texture texture = new Texture(Gdx.files.internal("sm_newgame.png"));
	float actorX = 100 ,actorY = 100;
	public boolean started = false;

	public NewGameActor(){
		texture.getMinFilter();
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean keyDown (InputEvent event, int keycode) {
				((NewGameActor)event.getTarget()).started = true;
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