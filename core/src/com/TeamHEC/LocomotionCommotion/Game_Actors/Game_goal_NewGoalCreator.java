package com.TeamHEC.LocomotionCommotion.Game_Actors;
/*
 *  @author Robert Precious <rp825@york.ac.uk>
 *  This Class creates the grid of new goals from a arraylist of newgoals.
 *  
 *  @param createdGoals	-The result of the class, the list of new goals
 *  @param newgoals	- The goal objects where we get the information for the new goals
 *  @param newgoal1-9	-Slots for the goals
 *  @param numberofNewGoals	-count of the goals passed to the class
 *  @param row1-3	-y positions of each row
 *  @param col1-3	-x positions of each column
 */
import java.util.ArrayList;
import java.util.HashMap;

import com.TeamHEC.LocomotionCommotion.Goal.Goal;

public class Game_goal_NewGoalCreator {
	public static ArrayList<Game_goal_PlayerGoalActors> createdGoals;
	public ArrayList<Goal> newgoals;
	public static Game_goal_PlayerGoalActors newgoal1, newgoal2, newgoal3,
									newgoal4, newgoal5, newgoal6,
									newgoal7, newgoal8, newgoal9;
	
	public static int numberofNewGoals;
	public int row1 = 500, row2 = row1-220, row3 = row2-220;
	public int col1 = 660, col2 = col1+320, col3 = col2+320;

	public Game_goal_NewGoalCreator(ArrayList<Goal> newgoals){
		this.newgoals = newgoals;
		//get the number of goals passed
		if (newgoals!=null)
			numberofNewGoals = newgoals.size();
		else
			numberofNewGoals = 0;
		//Initialize createGoals 
		createdGoals = new ArrayList<Game_goal_PlayerGoalActors>();

		if (numberofNewGoals==0){	//If no goals passed just create 9 empty tickets
			createdGoals = createEmpties(newgoals);
		}
		else if(numberofNewGoals>9){
			throw new Error("Error list has over 9 goals"); //if more than 9 tickets passed throw error
		}
		else
		{
			//Create slots
			HashMap<String, Game_goal_PlayerGoalActors> goalslots = new HashMap<String, Game_goal_PlayerGoalActors>();
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
	
	private ArrayList<Game_goal_PlayerGoalActors> createEmpties(ArrayList<Goal> newgoals) {
		ArrayList<Game_goal_PlayerGoalActors> 		empties = new ArrayList< Game_goal_PlayerGoalActors>();
		HashMap<String, Game_goal_PlayerGoalActors> 	goalslots = new HashMap<String, Game_goal_PlayerGoalActors>();
		
		goalslots = createSlots();

		for (int i=numberofNewGoals;i<9;i++){
			String a = new Integer(i+1).toString();
			empties.add(goalslots.get(a));
		}
		return empties;
	}

	private HashMap<String, Game_goal_PlayerGoalActors> createSlots() {
		HashMap<String, Game_goal_PlayerGoalActors> goalslots = new HashMap<String, Game_goal_PlayerGoalActors>();
		goalslots.put("1", newgoal1= new Game_goal_PlayerGoalActors(row1,col1,true,null));
		goalslots.put("2", newgoal2= new Game_goal_PlayerGoalActors(row1,col2,true,null));
		goalslots.put("3", newgoal3= new Game_goal_PlayerGoalActors(row1,col3,true,null));
		goalslots.put("4", newgoal4= new Game_goal_PlayerGoalActors(row2,col1,true,null));
		goalslots.put("5", newgoal5= new Game_goal_PlayerGoalActors(row2,col2,true,null));
		goalslots.put("6", newgoal6= new Game_goal_PlayerGoalActors(row2,col3,true,null));
		goalslots.put("7", newgoal7= new Game_goal_PlayerGoalActors(row3,col1,true,null));
		goalslots.put("8", newgoal8= new Game_goal_PlayerGoalActors(row3,col2,true,null));
		goalslots.put("9", newgoal9= new Game_goal_PlayerGoalActors(row3,col3,true,null));
		return goalslots;
	}


	public ArrayList<Game_goal_PlayerGoalActors> getGoals(){
		return createdGoals;
	}
}