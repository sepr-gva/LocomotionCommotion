package com.TeamHEC.LocomotionCommotion.Screens.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class LinesActor extends Actor {

	Texture texture = new Texture(Gdx.files.internal("lines.png"));
	float actorX = -400, actorY = -1100;
	public boolean started = false;

	public LinesActor(){
		texture.getMinFilter();
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean keyDown (InputEvent event, int keycode) {
				((LinesActor)event.getTarget()).started = true;
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