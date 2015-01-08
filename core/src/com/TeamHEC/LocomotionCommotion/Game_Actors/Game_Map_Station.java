package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Game_Map_Station extends Actor{
	
	public Texture texture;
	public float actorX, actorY;
	public boolean started = false;
	
	public  Game_Map_Station (MapObj station, float actorX, float actorY ){
		this.texture = Game_Map_TextureManager.station;
		this.actorX = actorX;
		this.actorY = actorY;
		
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		//Mouse click listener - not used yet
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((Game_Map_Station)event.getTarget()).started = true;
				return true;
			}
		});
	}
		
		@Override
		public void draw(Batch batch, float alpha){
			batch.draw(this.texture,actorX,actorY);
		}

		@Override
		public void act(float delta){
			if(started){
				started = false;
			}
	}
}
