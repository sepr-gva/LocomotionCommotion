package com.TeamHEC.LocomotionCommotion.Screens.Actors;

import com.TeamHEC.LocomotionCommotion.Screens.TextureManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class SM_newgame_Turn150Btn extends Actor {
	
	public static Texture texture = TextureManager.sm_newgame_Turn150_unselected_Btn;
	public static float actorX = 680 ,actorY = 1150+250;
	public boolean started = false;

	public SM_newgame_Turn150Btn(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((SM_newgame_Turn150Btn)event.getTarget()).started = true;
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
			SM_newgame_Turn50Btn.texture = TextureManager.sm_newgame_Turn50_unselected_Btn;
			SM_newgame_Turn100Btn.texture = TextureManager.sm_newgame_Turn100_unselected_Btn;
			SM_newgame_Turn150Btn.texture = TextureManager.sm_newgame_Turn150Btn;
			started = false;
			
			
		}
	}
}