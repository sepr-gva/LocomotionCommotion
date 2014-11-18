package com.TeamHEC.LocomotionCommotion;

import com.TeamHEC.LocomotionCommotion.StartMenu.SMAsset;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LocomotionCommotion extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	public static float width = 1680;
	public static float height = 1050;
	SMAsset title;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture(title.getAsset());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
}
