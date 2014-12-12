package com.TeamHEC.LocomotionCommotion.Game_Actors;

import java.util.ArrayList;
import java.util.HashMap;

import com.TeamHEC.LocomotionCommotion.Goal.Goal;

public class Game_goal_NewGoalCreator {
	public static ArrayList<Game_goal_NewGoal> createdGoals;
	public ArrayList<Goal> newgoals;
	public static Game_goal_NewGoal newgoal1, newgoal2, newgoal3,
	newgoal4, newgoal5, newgoal6,
	newgoal7, newgoal8, newgoal9
	;
	public static int numberofNewGoals;
	public int row1 = 500, row2 = row1-220, row3 = row2-220;
	public int col1 = 660, col2 = col1+320, col3 = col2+320;

	public Game_goal_NewGoalCreator(ArrayList<Goal> newgoals){
		this.newgoals = newgoals;

		numberofNewGoals = newgoals.size();
		createdGoals = new ArrayList<Game_goal_NewGoal>();

		if (numberofNewGoals==0){
			createdGoals = createEmpties(newgoals);
		}
		else if(numberofNewGoals>9){
			System.out.println("Error list has over 9 goals");
		}
		else
		{
			//Create slots
			HashMap<String, Game_goal_NewGoal> goalslots = new HashMap<String, Game_goal_NewGoal>();
			goalslots = createSlots();

			//fill slots
			for (int i=0;i<numberofNewGoals;i++){
				String a = new Integer(i+1).toString();
				goalslots.get(a).setGoal(newgoals.get(i));
				goalslots.get(a).setEmpty(false);
				goalslots.get(a).setIndex(i+1);
				createdGoals.add(goalslots.get(a));
			}
			//create empty slots
			for (int i=numberofNewGoals;i<9;i++){
				String a = new Integer(i+1).toString();
				goalslots.get(a).setEmpty(true);
				createdGoals.add(goalslots.get(a));
			}	
		}

	}
	private ArrayList<Game_goal_NewGoal> createEmpties(ArrayList<Goal> newgoals) {
		ArrayList<Game_goal_NewGoal> empties = new ArrayList< Game_goal_NewGoal>();
		HashMap<String, Game_goal_NewGoal> goalslots = new HashMap<String, Game_goal_NewGoal>();
		
		goalslots = createSlots();

		for (int i=numberofNewGoals;i<9;i++){
			String a = new Integer(i+1).toString();
			empties.add(goalslots.get(a));
		}
		return empties;
	}

	private HashMap<String, Game_goal_NewGoal> createSlots() {
		HashMap<String, Game_goal_NewGoal> goalslots = new HashMap<String, Game_goal_NewGoal>();
		goalslots.put("1", newgoal1= new Game_goal_NewGoal(row1,col1,true,null));
		goalslots.put("2", newgoal2= new Game_goal_NewGoal(row1,col2,true,null));
		goalslots.put("3", newgoal3= new Game_goal_NewGoal(row1,col3,true,null));
		goalslots.put("4", newgoal4= new Game_goal_NewGoal(row2,col1,true,null));
		goalslots.put("5", newgoal5= new Game_goal_NewGoal(row2,col2,true,null));
		goalslots.put("6", newgoal6= new Game_goal_NewGoal(row2,col3,true,null));
		goalslots.put("7", newgoal7= new Game_goal_NewGoal(row3,col1,true,null));
		goalslots.put("8", newgoal8= new Game_goal_NewGoal(row3,col2,true,null));
		goalslots.put("9", newgoal9= new Game_goal_NewGoal(row3,col3,true,null));
		return goalslots;
	}


	public ArrayList<Game_goal_NewGoal> getGoals(){
		return createdGoals;
	}
}
