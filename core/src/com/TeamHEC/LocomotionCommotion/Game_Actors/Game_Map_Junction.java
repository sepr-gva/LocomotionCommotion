package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Game_Map_Junction extends Game_Map_MapObj{
	
	public  Game_Map_Junction (MapObj station, float actorX, float actorY )
	{
		this.texture = Game_Map_TextureManager.junction;
		this.mapObj = station;
		this.actorX = actorX;
		this.actorY = actorY;
		this.started = false;

		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		//Mouse click listener - not used yet
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((Game_Map_Junction)event.getTarget()).started = true;
				return true;
			}
		});
		addListener(new InputListener(){
			public void enter(InputEvent event, float x, float y, int pointer, Actor Game_Map_Station) {
				((Game_Map_Junction)event.getTarget()).started = true;
			}

		});
	}

	@Override
	public void act(float delta){
		if(started){
			started = false;
		}
	}
}
