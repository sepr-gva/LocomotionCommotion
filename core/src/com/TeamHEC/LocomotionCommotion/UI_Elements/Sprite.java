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
		setActorX(x);
		actorY = y;
		actorTexture = texture;
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
		batch.draw(actorTexture, getActorX(), actorY);
	}
	
	public void refreshBounds()
	{
		setBounds(getActorX(), actorY, actorTexture.getWidth(), actorTexture.getHeight());
	}

	public float getActorX() {
		return actorX;
	}

	public void setActorX(float actorX)
	{
		this.actorX = actorX;
	}
	
	public float getActorY()
	{
		return actorY;
	}

	public void setActorY(float actorY)
	{
		this.actorY = actorY;
	}
	
	public Vector2 getPosition()
	{
		return new Vector2(getActorX(), actorY);
	}
	
	public void setPosition(float x, float y)
	{
		setActorX(x);
		actorY = y;
	}
}
