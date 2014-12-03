package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_Goal_AManager {

	private final static Array<Actor> actors = new Array<Actor>();
	
	public static Game_goal_Backdrop Game_goal_Backdrop;
	public static Game_goal_BackBtn game_goal_backbtn;
	public static Game_goal_Title Game_goal_Title;
	
	
	public static boolean open=false;
	
	public static int  stagestart, goalActors;


	public Game_Goal_AManager(){	}
		
	public void create(Stage stage){
		actors.clear();
		stagestart =0;
		goalActors=0;
		Game_goal_Backdrop = new Game_goal_Backdrop();
		actors.add(Game_goal_Backdrop);
		game_goal_backbtn = new Game_goal_BackBtn();
		actors.add(game_goal_backbtn);
		Game_goal_Title = new Game_goal_Title();
		actors.add(Game_goal_Title);
		

	
	
		
		stagestart= stage.getActors().size;
		for (Actor a : actors){
			if(open == true){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);}
			else
				a.setVisible(false);

			stage.addActor(a);
			goalActors ++;
		}
			

	}
	
	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */


	
	


}

