package com.TeamHEC.LocomotionCommotion.UI_Elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Sprite extends Actor{
	
	private float actorX, actorY;
	private Texture actorTexture;
	
	public boolean started = false;
	
	public Sprite(float x, float y, Texture texture)
	{
		actorX = x;
		actorY = y;
		actorTexture = texture;
	}
	
	public Vector2 getPosition()
	{
		return new Vector2(actorX, actorY);
	}
	
	public void setPosition(float x, float y)
	{
		actorX = x;
		actorY = y;
	}
	
	public Texture getTexture()
	{
		return actorTexture;
	}
	
	public void setTexture(Texture t)
	{
		actorTexture = t;
	}
		
	@Override
	public void act(float delta)
	{
		
	}
	
	@Override
	public void draw(Batch batch, float alpha)
	{
		batch.draw(actorTexture, actorX, actorY);
	}
}
