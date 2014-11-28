package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_PauseMenuManager {

	private final static Array<Actor> actors = new Array<Actor>();
	
	public static Game_pause_BlackoutScreen game_pause_blackoutscreen;
	public static Game_pause_Background game_pause_background;
	public static Game_pause_Logo game_pause_logo;
	public static Game_pause_ResumeGame game_pause_resume;
	public static Game_pause_LoadGame game_pause_load;
	public static Game_pause_Settings game_pause_settings;
	public static Game_pause_MainMenu game_pause_mainmenu;
	
	
	public static boolean open=false;
	
	public static int  stagestart, pauseActors;


	public Game_PauseMenuManager(){	}
		
	public static void create(Stage stage){
		
		game_pause_blackoutscreen = new Game_pause_BlackoutScreen();
		actors.add(game_pause_blackoutscreen);
		game_pause_background = new Game_pause_Background();
		actors.add(game_pause_background);
		game_pause_logo = new Game_pause_Logo();
		actors.add(game_pause_logo);
		game_pause_resume = new Game_pause_ResumeGame();
		actors.add(game_pause_resume);
		game_pause_load = new Game_pause_LoadGame();
		actors.add(game_pause_load);
		game_pause_settings = new Game_pause_Settings();
		actors.add(game_pause_settings);
		game_pause_mainmenu = new Game_pause_MainMenu();
		actors.add(game_pause_mainmenu);

	
	
		
		stagestart= stage.getActors().size;
		for (Actor a : actors){
			if(open == true){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);}
			else
				a.setVisible(false);

			stage.addActor(a);
			pauseActors ++;
		}
		
			

	}
	
	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */


	
	


}

