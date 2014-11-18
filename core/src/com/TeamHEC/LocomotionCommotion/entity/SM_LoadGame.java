package com.TeamHEC.LocomotionCommotion.entity;

import com.TeamHEC.LocomotionCommotion.TextureManager;
import com.badlogic.gdx.math.Vector2;

public class SM_LoadGame extends Entity{

	public SM_LoadGame(Vector2 pos, Vector2 direction) {
		super(TextureManager.sm_loadgame, pos, direction);
	}

	@Override
	public void update() {
		pos.add(direction); 


}
}
