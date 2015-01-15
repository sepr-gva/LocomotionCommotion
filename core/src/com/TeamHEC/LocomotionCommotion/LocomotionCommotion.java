package com.TeamHEC.LocomotionCommotion;

import com.TeamHEC.LocomotionCommotion.Game.CoreGame;
import com.TeamHEC.LocomotionCommotion.Scene.SceneManager;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class LocomotionCommotion extends Game {
	
	public GameScreen gameScreen;
	public CoreGame newGame;

	public static int screenX = 1680;
	public static int screenY = 1050;
	
	private static LocomotionCommotion INSTANCE = new LocomotionCommotion();

	public static LocomotionCommotion getInstance()
	{
		return INSTANCE;
	}
	
	private LocomotionCommotion(){}
	public static final String TITLE = "LOCOMOTION COMOTION", VERSION = "0.0.0.1";
	
	@Override
	public void create() {
		gameScreen = new GameScreen();
		
		//setScreen(gameScreen); // Use the StartMenu Screen First
		setScreen(SceneManager.getInstance().startScene);
	}

	public void setGameScreen()
	{
		SceneManager.getInstance().startScene.dispose();
		gameScreen = null;
		gameScreen = new GameScreen();
		GameScreen.create();
		gameScreen.resetScreen();
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		setScreen(gameScreen);
	}
	
	public void setMenuScreen()
	{
		gameScreen.dispose();
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		
		SceneManager.getInstance().startScene.addToStage();
		setScreen(SceneManager.getInstance().startScene);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void render() {
		Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
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