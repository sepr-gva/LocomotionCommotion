package com.TeamHEC.LocomotionCommotion.Screens.Actors;

import com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
import com.TeamHEC.LocomotionCommotion.Screens.TextureManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class SM_newgame_GoBtn extends Actor {
	
	Texture texture = TextureManager.sm_newgame_GoBtn;
	public static float actorX = -100 ,actorY = 1150+50;
	public boolean started = false;

	public SM_newgame_GoBtn(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((SM_newgame_GoBtn)event.getTarget()).started = true;
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
			StartMenu.changeCam(0, 0);
			started = false;
			
			
		}
	}
}