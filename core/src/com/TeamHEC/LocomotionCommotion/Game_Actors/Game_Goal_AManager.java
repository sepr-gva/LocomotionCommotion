package com.TeamHEC.LocomotionCommotion.Game_Actors;


import java.util.ArrayList;
import java.util.HashMap;

import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Array;

public class Game_Goal_AManager {

	private final static Array<Actor> actors = new Array<Actor>();
	private final static Array<Actor> subactors = new Array<Actor>();
	private static ArrayList<Game_goal_NewGoal> createdGoals;
	private static ArrayList<Goal> goals;
	public static HashMap<String,Goal> newgoals ;
	public static HashMap<String, Label> goalLabels ;

	public static Game_goal_Backdrop Game_goal_Backdrop;
	public static Game_goal_AddGoalBtn Game_goal_addgoalbtn;
	public static Game_goal_BackBtn game_goal_backbtn;
	public static Game_goal_NewGoal newgoal1, newgoal2,newgoal3,newgoal4,newgoal5,newgoal6,newgoal7,newgoal8,newgoal9, selectedGoal;

	public static int row1 = 580, row2 = row1-220, row3 = row2-220;
	public static int col1 = 670, col2 = col1+320, col3 = col2+320;
	public static LabelStyle style;

	public static boolean open=false;

	public static int  stagestart, goalActors;

	public static Label gLabel1,gLabel2,gLabel3,gLabel4,gLabel5,gLabel6,gLabel7,gLabel8,gLabel9;


	public Game_Goal_AManager(){	}

	public void create(Stage stage){
		actors.clear();
		stagestart =0;
		goalActors=0;
		selectedGoal = new Game_goal_NewGoal(0, 0, true, null);
		Game_goal_Backdrop = new Game_goal_Backdrop();
		actors.add(Game_goal_Backdrop);
		game_goal_backbtn = new Game_goal_BackBtn();
		actors.add(game_goal_backbtn);
		
		goals = new ArrayList<Goal>();
		Goal goal1 = new Goal("London", "Paris", false, 100, 0, "Passenger","Any");
		goals.add(goal1);
		Goal goal2 = new Goal("Lisbon", "Helsinki", false, 200, 0, "Cargo","Any");
		goals.add(goal2);
		Goal goal3 = new Goal("Berln", "Moscow", false, 200, 0, "Cargo","Any");
		goals.add(goal3);
		Game_goal_NewGoalCreator goalcreator= new Game_goal_NewGoalCreator(goals);
		createdGoals = goalcreator.getGoals();
		


		//Stuff for Labels
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 17;

		BitmapFont font = generator.generateFont(parameter); 
		generator.dispose();
		style = new LabelStyle();
		style.font = font;

		//end

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
		
		Game_goal_addgoalbtn = new Game_goal_AddGoalBtn();
		subactors.add(Game_goal_addgoalbtn);
		

		goalLabels = createLabels();
		goalLabels=createGoalLabels(goalLabels);
		addLabelstoStage();
		
		





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
		for (Actor a : subactors){
				a.setTouchable(Touchable.enabled);
				a.setVisible(false);
			stage.addActor(a);
		}


	}


	public static  HashMap<String, Label> createLabels(){
		HashMap<String, Label> goals = new HashMap<String, Label>();
		
		goals.put("1", gLabel1= new Label(null,style));
		goals.put("2", gLabel2= new Label(null,style));
		goals.put("3", gLabel3= new Label(null,style));
		goals.put("4", gLabel4= new Label(null,style));
		goals.put("5", gLabel5= new Label(null,style));
		goals.put("6", gLabel6= new Label(null,style));
		goals.put("7", gLabel7= new Label(null,style));
		goals.put("8", gLabel8= new Label(null,style));
		goals.put("9", gLabel9= new Label(null,style));
		int row =1;
		int col =1;

		for(int g=0;g<9;g++){
			String a = new Integer(g+1).toString();
			goals.get(a).setColor(0,0,0,1);
			
			if(col==1)
				goals.get(a).setX(col1);
			if(col==2)
				goals.get(a).setX(col2);
			if(col==3)
				goals.get(a).setX(col3);
			
			if(row==1)
				goals.get(a).setY(row1);
			if(row==2)
				goals.get(a).setY(row2);
			if(row==3)
				goals.get(a).setY(row3);
			
			//Next Row
			if (col==3){
				col=1;
				row+=1;
			}
			else
				col+=1;


		}
		return goals;

	}

	public static  HashMap<String, Label> createGoalLabels(HashMap<String, Label> newgoalLabels){
		int  numberofNewGoals = goals.size();
		for (int i=0;i<numberofNewGoals;i++){
			String a = new Integer(i+1).toString();
			newgoalLabels.get(a).setText(ticketMaker(createdGoals.get(i).getGoal().getCarriagetype(),createdGoals.get(i).getGoal().getrewards(),createdGoals.get(i).getGoal().getSStation(),
									createdGoals.get(i).getGoal().getstartdate(), createdGoals.get(i).getGoal().getFStation(), createdGoals.get(i).getGoal().getRoute()));
		}
		for (int i=numberofNewGoals;i<9;i++){
			String a = new Integer(i+1).toString();
			newgoalLabels.get(a).setText("");
		}
		return newgoalLabels;

	}
	
	public static void addLabelstoStage(){
		actors.add(gLabel1);
		actors.add(gLabel2);
		actors.add(gLabel3);
		actors.add(gLabel4);
		actors.add(gLabel5);
		actors.add(gLabel6);
		actors.add(gLabel7);
		actors.add(gLabel8);
		actors.add(gLabel9);
		
		
	}
	public static String ticketMaker(String type, int  reward, String from, int startdate, String dest, String route){
		String output;
		output ="";

		output += type + getSpacing(type.length()) + reward; 
		output += "\n\n";
		output += from + getSpacing(from.length()) + startdate; 
		output += "\n\n";
		output += dest + getSpacing(dest.length()) + route;
		return output;

	}
	public static String getSpacing(int len){
		String space="";
		for (int i=0; i<(17-len)+22; i++){
			space += " ";

		}
		return space;
	}

	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */






}

