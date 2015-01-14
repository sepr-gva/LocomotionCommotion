package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Game_Actor extends Actor{
	public Texture texture;
	float actorX, actorY;
	boolean started = false;

	public void draw(Batch batch, float alpha){
		batch.draw(texture, actorX, actorY);
	}

	public void setTexture(Texture t){
		this.texture=t;
	}
	public Texture getTexture(){
		return this.texture;
	}
}
