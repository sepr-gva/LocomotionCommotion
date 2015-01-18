package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Game_Actor extends Actor{
	public Texture texture;
	private float actorX;
	private float actorY;
	public boolean started = false;

	public void draw(Batch batch, float alpha){
		batch.draw(texture, getActorX(), getActorY());
	}

	public void setTexture(Texture t){
		this.texture=t;
	}
	public Texture getTexture(){
		return this.texture;
	}

	public float getActorX() {
		return actorX;
	}

	public void setActorX(float actorX) {
		this.actorX = actorX;
	}

	public float getActorY() {
		return actorY;
	}

	public void setActorY(float actorY) {
		this.actorY = actorY;
	}
}
