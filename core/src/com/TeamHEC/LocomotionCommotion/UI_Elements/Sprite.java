package com.TeamHEC.LocomotionCommotion.UI_Elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Sprite extends Actor{
	
	private float actorX, actorY;
	private Texture actorTexture;
	
	public boolean started = false;
	
	/**
	 * Creates a Sprite which can be drawn to a stage
	 * @param x xPosition on screen
	 * @param y yPosition on screen
	 * @param texture The image texture used
	 */
	public Sprite(float x, float y, Texture texture)
	{
		actorX = x;
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
		batch.draw(actorTexture, actorX, actorY);
	}
	
	/**
	 * Sets the touchable region for clicking on a Sprite to it's position
	 */
	public void refreshBounds()
	{
		setBounds(actorX, actorY, actorTexture.getWidth(), actorTexture.getHeight());
	}

	public float getX()
	{
		return actorX;
	}

	public void setX(float actorX)
	{
		this.actorX = actorX;
	}
	
	public float getY()
	{
		return actorY;
	}

	public void setY(float actorY)
	{
		this.actorY = actorY;
	}
	
	public void increaseY(float amount)
	{
		actorY += amount;
	}
	
	public void increaseX(float amount)
	{
		actorX += amount;
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
	
}
