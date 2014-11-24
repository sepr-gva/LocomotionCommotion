package com.TeamHEC.LocomotionCommotion.Screens.SM_Actors;

import com.TeamHEC.LocomotionCommotion.Screens.SM_TextureManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class SM_main_LinesImg extends Actor {

	Texture texture = SM_TextureManager.sm_main_linesimg;
	float actorX = -85 ,actorY = -320;
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