package com.TeamHEC.LocomotionCommotion;

import com.TeamHEC.LocomotionCommotion.Game.CoreGame;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
import com.badlogic.gdx.Game;

public class LocomotionCommotion extends Game {
	public StartMenu startMenu;
	public GameScreen gameScreen;
	public CoreGame newGame;

	private static LocomotionCommotion INSTANCE = new LocomotionCommotion();

	public static LocomotionCommotion getInstance()
	{
		return INSTANCE;
	}

	private LocomotionCommotion(){}

	public static final String TITLE = "LOCOMOTION COMOTION", VERSION = "0.0.0.1";
	@Override
	public void create() {
		startMenu = new StartMenu();
		gameScreen = new GameScreen();
		
		//TEMP CHANGE WHILE DESIGNING THE GAMESCREEN UI (SHOULD BE startMenu)
		setScreen(startMenu); // Use the StartMenu Screen First
	}

	public void setGameScreen()
	{
		setScreen(gameScreen);
		startMenu.dispose();
		//newGame = new CoreGame(StartMenu.player1name, StartMenu.player2name, null, null, StartMenu.turnChoice);

	}
	
	public void setMenuScreen()
	{
		setScreen(startMenu);
		gameScreen.dispose();
		//newGame = new CoreGame(StartMenu.player1name, StartMenu.player2name, null, null, StartMenu.turnChoice);

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