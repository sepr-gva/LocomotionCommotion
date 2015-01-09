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
	public boolean started = false, highlighted;
	
	public  Game_Map_Station (MapObj station, float actorX, float actorY ){
		this.texture = Game_Map_TextureManager.station;
		this.actorX = actorX;
		this.actorY = actorY;
		this.highlighted = false;
		
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		//Mouse click listener - not used yet
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((Game_Map_Station)event.getTarget()).started = true;
				return true;
			}
		});
		addListener(new InputListener(){
			public void enter(InputEvent event, float x, float y, int pointer, Actor Game_Map_Station) {
				((Game_Map_Station)event.getTarget()).started = true;
			}

		});
		addListener(new InputListener(){
			public void exit(InputEvent event, float x, float y, int pointer, Actor Game_Map_Station) {
				((Game_Map_Station)event.getTarget()).started = true;
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
				if(this.highlighted==false){
					Game_Map_Manager.resetStations();
					toggleHighlight();
				}
				else{
					toggleHighlight();
				}
				started = false;
			}
	}
		public void resetHighlight(){
			if (highlighted){
				this.texture=Game_Map_TextureManager.station;
				this.actorX+=2.5;
				this.actorY+=2.5;
				this.highlighted = false;
			}
			
		}
		public void toggleHighlight(){
			if (this.highlighted){
				this.texture=Game_Map_TextureManager.station;
				this.actorX+=2.5;
				this.actorY+=2.5;
				this.highlighted = false;
			}
			else{
				this.texture=Game_Map_TextureManager.stationx2;
				this.actorX-=2.5;
				this.actorY-=2.5;
				this.highlighted = true;
				
			}
		}
}
