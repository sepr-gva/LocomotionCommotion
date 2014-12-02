package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_TrainDepotManager {

	private final static Array<Actor> actors = new Array<Actor>();
	
	public static Game_traindepot_Backdrop game_traindepot_backdrop;
	public static Game_traindepot_BackBtn game_traindepot_backbtn;
	public static Game_traindepot_Title game_traindepot_title;
	
	
	public static boolean open=false;
	
	public static int  stagestart, traindepotActors;


	public Game_TrainDepotManager(){	}
		
	public void create(Stage stage){
		actors.clear();
		game_traindepot_backdrop = new Game_traindepot_Backdrop();
		actors.add(game_traindepot_backdrop);
		game_traindepot_backbtn = new Game_traindepot_BackBtn();
		actors.add(game_traindepot_backbtn);
		game_traindepot_title = new Game_traindepot_Title();
		actors.add(game_traindepot_title);
		

	
	
		
		stagestart= stage.getActors().size;
		for (Actor a : actors){
			if(open == true){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);}
			else
				a.setVisible(false);

			stage.addActor(a);
			traindepotActors ++;
		}
		
			

	}
	
	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */


	
	


}

