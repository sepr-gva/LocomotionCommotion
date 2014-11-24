package com.TeamHEC.LocomotionCommotion;

import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
import com.badlogic.gdx.Game;

public class LocomotionCommotion extends Game {
	StartMenu startMenu;
	GameScreen gameScreen;
	

	public static final String TITLE = "LOCOMOTION COMOTION", VERSION = "0.0.0.1";
	@Override
	public void create() {
		StartMenu.create();
//        GameScreen.create();
//		
//		startMenu = new StartMenu();
//		gameScreen = new GameScreen();
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