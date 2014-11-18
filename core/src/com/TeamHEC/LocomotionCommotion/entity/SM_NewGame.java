package com.TeamHEC.LocomotionCommotion.entity;

import com.TeamHEC.LocomotionCommotion.TextureManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;


public class SM_NewGame extends Entity{

	public SM_NewGame(Vector2 pos, Vector2 direction) {
		super(TextureManager.sm_newgame, pos, direction);
	}

	@Override
	public void update() {
		pos.add(direction); 

		/*if (Gdx.input.isKeyPressed(Keys.A))
			setDirection(-300,0);  //Left need to use this when button pressed.
		else if (Gdx.input.isKeyPressed(Keys.D))
			setDirection(300,0); //right need to use this when button pressed.
		else
			setDirection(0,0);*/
	}




}
