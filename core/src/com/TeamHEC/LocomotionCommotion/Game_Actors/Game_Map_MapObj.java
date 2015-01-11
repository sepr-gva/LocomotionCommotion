package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Game_Map_MapObj extends Actor{
	
	public Texture texture;
	public float actorX, actorY;
	public boolean started = false, highlighted = false;
	public MapObj mapObj;
	
	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(this.texture,actorX,actorY);
	}

}
