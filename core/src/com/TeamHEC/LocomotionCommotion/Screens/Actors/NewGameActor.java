package com.TeamHEC.LocomotionCommotion.Screens.Actors;

import com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class NewGameActor extends Actor {

	Texture texture = new Texture(Gdx.files.internal("sm_newgame.png"));
	float actorX = 450 ,actorY = 455;
	public boolean started = false;

	public NewGameActor(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
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
			StartMenu.changeCam(0, 10);
			started = false;
		}
	}
}