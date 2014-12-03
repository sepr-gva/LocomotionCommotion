package com.TeamHEC.LocomotionCommotion.Game_Actors;


import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_Goal_AManager {

	private final static Array<Actor> actors = new Array<Actor>();
	
	public static Game_goal_Backdrop Game_goal_Backdrop;
	public static Game_goal_BackBtn game_goal_backbtn;
	public static Game_goal_NewGoal newgoal1, newgoal2,newgoal3,newgoal4,newgoal5,newgoal6,newgoal7,newgoal8,newgoal9;
	
	
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
		
		ArrayList<Goal> goals = new ArrayList<Goal>();
		Game_goal_NewGoalCreator goalcreator= new Game_goal_NewGoalCreator(goals);
		ArrayList<Game_goal_NewGoal> createdGoals = goalcreator.getGoals();
		
		newgoal1 = createdGoals.get(0);
		actors.add(newgoal1);
		newgoal2 = createdGoals.get(1);
		actors.add(newgoal2);
		newgoal3 = createdGoals.get(2);
		actors.add(newgoal3);
		
		newgoal4 = createdGoals.get(3);
		actors.add(newgoal4);
		newgoal5 = createdGoals.get(4);
		actors.add(newgoal5);
		newgoal6 = createdGoals.get(5);
		actors.add(newgoal6);
		
		newgoal7 = createdGoals.get(6);
		actors.add(newgoal7);
		newgoal8 = createdGoals.get(7);
		actors.add(newgoal8);
		newgoal9 = createdGoals.get(8);
		actors.add(newgoal9);
		
		

	
	
		
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

