package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.badlogic.gdx.graphics.Texture;

public class Game_Asset extends Game_Actor{		
	public Game_Asset(float x, float y, Texture t)
	{
		this.setActorX(x);
		this.setActorY(y);
		texture = t;
	}

}
