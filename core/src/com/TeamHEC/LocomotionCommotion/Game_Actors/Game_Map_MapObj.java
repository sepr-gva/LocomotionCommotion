package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Game_Map_MapObj extends Actor{
	
	public Texture texture, toggleTexture1, toggleTexture2;
	public float actorX, actorY;
	public boolean started = false, highlighted = false;
	
	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(this.texture, actorX, actorY);
	}
}
