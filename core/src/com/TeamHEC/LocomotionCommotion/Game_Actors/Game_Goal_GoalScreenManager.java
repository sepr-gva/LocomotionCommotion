package com.TeamHEC.LocomotionCommotion.Game_Actors;
/*
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * This class is a Manager for all the Goal Actors (excluding the the side menu of goals which is Managed by PlayerGaals)
 * Calls the goalcreator to turn an array of Goal to the UI goals
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_goal_Assets.Game_goal_AddGoalBtn;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_goal_Assets.Game_goal_BackBtn;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_goal_Assets.Game_goal_Backdrop;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_goal_Assets.Game_goal_RefreshGoals;
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

public class Game_Goal_GoalScreenManager {
	//Arrays
	private final static Array<Actor> actors = new Array<Actor>();
	private final static Array<Actor> subactors = new Array<Actor>();
	//ArrayLists
	public static ArrayList<GoalActor> createdGoals;
	private static ArrayList<Goal> goals;
	//HashMaps
	public static HashMap<String,Goal> newgoals ;
	public static HashMap<String, Label> goalLabels ;
	//Actors
	public static Game_goal_Backdrop Game_goal_Backdrop;
	public static Game_goal_AddGoalBtn Game_goal_addgoalbtn;
	public static Game_goal_BackBtn game_goal_backbtn;
	public static GoalActor newgoal1, newgoal2,newgoal3,newgoal4,newgoal5,newgoal6,newgoal7,newgoal8,newgoal9, selectedGoal;
	public static Game_goal_RefreshGoals refreshGoals; 
	//Ints
	public static int  stagestart, goalActors;
	public static int row1 = 580, row2 = row1-220, row3 = row2-220;
	public static int col1 = 670, col2 = col1+320, col3 = col2+320;
	//Label and LabelStyle
	public static Label gLabel1,gLabel2,gLabel3,gLabel4,gLabel5,gLabel6,gLabel7,gLabel8,gLabel9;
	public static LabelStyle style;
	//Booleans
	public static boolean open=false;
	
	public static int numberofGoalsOnScreen;




	public Game_Goal_GoalScreenManager(){	}

	public void create(Stage stage){
		//reset Array for newGame
		actors.clear();
		//Reset Actor ranging values
		stagestart =0;
		goalActors=0;
		numberofGoalsOnScreen=0;

		//Actors
		Game_goal_Backdrop = new Game_goal_Backdrop();
		actors.add(Game_goal_Backdrop);
		game_goal_backbtn = new Game_goal_BackBtn();
		actors.add(game_goal_backbtn);
		refreshGoals = new Game_goal_RefreshGoals();
		actors.add(refreshGoals);

//		//TEMP GOALS
//		goals = new ArrayList<Goal>();
//		Goal goal1 = new Goal("London", "Paris", false, 100, 0, "Passenger","Any");
//		goals.add(goal1);
//		Goal goal2 = new Goal("Lisbon", "Helsinki", false, 200, 0, "Cargo","Any");
//		goals.add(goal2);
//		Goal goal3 = new Goal("Berln", "Moscow", false, 200, 0, "Cargo","Any");
//		goals.add(goal3);
//		//TEMP GOALS

		Game_goal_NewGoalCreator goalcreator= new Game_goal_NewGoalCreator(goals); //Call goal creator
		createdGoals = goalcreator.getGoals();	//set createdGoals to the result of the goal creator



		//Stuff for Labels
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 17;

		BitmapFont font = generator.generateFont(parameter); 
		generator.dispose();
		style = new LabelStyle();
		style.font = font;

		//end

		//Assign new goals to the actors
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

		//Add the addgoalbtn actor to sub actors
		Game_goal_addgoalbtn = new Game_goal_AddGoalBtn();
		subactors.add(Game_goal_addgoalbtn);

		goalLabels = createLabels();				//createLabels
		goalLabels=createGoalLabels(goalLabels);	//Set the properties of the Labels using the goal information
		addLabelstoStage();							//Call function to add labels to stage

		//Adds the actors to the stage
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
		//Used for other actors we don't want to show straight away
		for (Actor a : subactors){
			a.setTouchable(Touchable.enabled);
			a.setVisible(false);
			stage.addActor(a);
		}


	}
	//Creates the blank label objects
	public static  HashMap<String, Label> createLabels(){
		//Create the Labels in a Hashmap and run through them
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

	//Creates the goal labels - sets the text of the blank labels to the goal information
	public static  HashMap<String, Label> createGoalLabels(HashMap<String, Label> newgoalLabels){
		int  numberofNewGoals;
		if (goals==null){
			numberofNewGoals=0;
		}
		else
			numberofNewGoals= goals.size();
		for (int i=0;i<numberofNewGoals;i++){
			String a = new Integer(i+1).toString();
			newgoalLabels.get(a).setText(ticketMaker(	createdGoals.get(i).getGoal().getCarriageType(),
					createdGoals.get(i).getGoal().getReward(),
					createdGoals.get(i).getGoal().getSStation(),
					createdGoals.get(i).getGoal().getStartDate(), 
					createdGoals.get(i).getGoal().getFStation(), 
					createdGoals.get(i).getGoal().getRoute()));
			numberofGoalsOnScreen++;
		}
		for (int i=numberofNewGoals;i<9;i++){
			String a = new Integer(i+1).toString();
			newgoalLabels.get(a).setText("");
		}
		return newgoalLabels;

	}

	//Adds all labels to stage
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
	//Creates the string that make up the ticket information
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
	//Adds spacing for Labels
	public static String getSpacing(int len){
		String space="";
		for (int i=0; i<(17-len)+22; i++){
			space += " ";

		}
		return space;
	}
	
	public static void AddGoalToScreen(ArrayList<Goal> goals){
		createNewGoalLabels1(goalLabels,goals);
	}
	public static  void createNewGoalLabels(HashMap<String, Label> newgoalLabels,ArrayList<Goal> goals){
		int goalsbeforeadd= numberofGoalsOnScreen;
		for (int i=0;i<goals.size();i++){
			if (numberofGoalsOnScreen==9){
				break;
			}
			String a = new Integer(numberofGoalsOnScreen+1).toString();
		
				
			newgoalLabels.get(a).setText(ticketMaker(	goals.get(i).getCarriageType(),
					goals.get(i).getReward(),
					goals.get(i).getSStation(),
					goals.get(i).getStartDate(), 
					goals.get(i).getFStation(), 
					goals.get(i).getRoute()));
			createdGoals.get(goalsbeforeadd+i).setGoal(goals.get(i));
			createdGoals.get(goalsbeforeadd+i).setEmpty(false);
			createdGoals.get(goalsbeforeadd+i).setIndex(goalsbeforeadd+i+1);
			numberofGoalsOnScreen++;
		}
	

	}
	public static  void createNewGoalLabels1(HashMap<String, Label> newgoalLabels,ArrayList<Goal> goals){
		for (int i=0;i<goals.size();i++){
			if (numberofGoalsOnScreen==9){
				break;
			}
			int emptyspace= findEmptySpace(newgoalLabels);
			String a = new Integer(emptyspace+1).toString();
			System.out.println(emptyspace);	
			
			newgoalLabels.get(a).setText(ticketMaker(	goals.get(i).getCarriageType(),
					goals.get(i).getReward(),
					goals.get(i).getSStation(),
					goals.get(i).getStartDate(), 
					goals.get(i).getFStation(), 
					goals.get(i).getRoute()));
			createdGoals.get(emptyspace).setGoal(goals.get(i));
			createdGoals.get(emptyspace).setEmpty(false);
			createdGoals.get(emptyspace).setIndex(emptyspace+1);
			numberofGoalsOnScreen++;
		}
	

	}
	public static int findEmptySpace(HashMap<String, Label> newgoalLabels){
		for (int i=0;i<9;i++){
			String a = new Integer(i+1).toString();
			if( newgoalLabels.get(a).getText().length==0){
				return i;
				
			}
		}
		return 0;
		
	}

	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */






}

