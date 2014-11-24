package com.TeamHEC.LocomotionCommotion.Screens.SM_Actors;

import com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
import com.TeamHEC.LocomotionCommotion.Screens.SM_TextureManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class SM_loadgame_Examples extends Actor {

	Texture texture = SM_TextureManager.sm_loadgame_Examples;
	float actorX = 1250+ 350 ,actorY = 500;
	public boolean started = false;

	public SM_loadgame_Examples(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((SM_loadgame_Examples)event.getTarget()).started = true;
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