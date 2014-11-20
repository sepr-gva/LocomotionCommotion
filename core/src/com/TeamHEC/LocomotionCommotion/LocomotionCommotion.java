package com.TeamHEC.LocomotionCommotion;

import com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class LocomotionCommotion extends Game {

	public static final String TITLE = "LOCOMOTION COMOTION", VERSION = "0.0.0.1";
	@Override
	public void create() {
        StartMenu.create();
		setScreen(new StartMenu()); // Use the StartMenu Screen First
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void dispose() {
		super.dispose();
	}
		

	}