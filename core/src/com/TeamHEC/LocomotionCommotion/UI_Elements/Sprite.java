package com.TeamHEC.LocomotionCommotion.UI_Elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Sprite extends Actor{
	
	public float actorX, actorY;
	public Texture actorTexture;
	
	public Sprite(float x, float y, Texture texture)
	{
		actorX = x;
		actorY = y;
		actorTexture = texture;
	}
	
	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(actorTexture, actorX, actorY);
	}
	
}
