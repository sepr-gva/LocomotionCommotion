package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Map.Junction;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Game_Map_Junction extends Game_Map_MapObj{
	
	private Junction junction;
	
	public  Game_Map_Junction (Junction junction, float actorX, float actorY )
	{
		this.texture = Game_Map_TextureManager.getInstance().junction;
		this.junction = junction;
		this.actorX = actorX;
		this.actorY = actorY;

		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		
		//Mouse click listener - not used yet
		
		/*
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((Game_Map_Junction)event.getTarget()).started = true;
				return true;
			}
		});
		 */
 
		addListener(new InputListener(){
			public void enter(InputEvent event, float x, float y, int pointer, Actor Game_Map_Station) {
			
				((Game_Map_Junction)event.getTarget()).texture = Game_Map_TextureManager.getInstance().junctionx2;
				((Game_Map_Junction)event.getTarget()).actorX-=2.5;
				((Game_Map_Junction)event.getTarget()).actorY-=2.5;
			
			}
		});
		addListener(new InputListener(){
			public void exit(InputEvent event, float x, float y, int pointer, Actor Game_Map_Station) {
				
				((Game_Map_Junction)event.getTarget()).texture = Game_Map_TextureManager.getInstance().junction;
				((Game_Map_Junction)event.getTarget()).actorX+=2.5;
				((Game_Map_Junction)event.getTarget()).actorY+=2.5;
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
