package com.TeamHEC.LocomotionCommotion.Game_Actors;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Goal.Goal;

public class Game_goal_NewGoalCreator {
	public static ArrayList<Game_goal_NewGoal> createdGoals;
	public static Game_goal_NewGoal newgoal1, newgoal2, newgoal3,
	newgoal4, newgoal5, newgoal6,
	newgoal7, newgoal8, newgoal9;
	public static int numberofNewGoals;
	public int row1 = 500, row2 = row1-220, row3 = row2-220;
	public int col1 = 660, col2 = col1+320, col3 = col2+320;
	public Game_goal_NewGoalCreator(ArrayList<Goal> newgoals){
		numberofNewGoals = newgoals.size();
		createdGoals = new ArrayList<Game_goal_NewGoal>();
		if (numberofNewGoals==0){
			createdGoals = createEmpties();

		}
		else if(numberofNewGoals>9){
			System.out.println("Error list has over 9 goals");
		}
		else
		{

			if (numberofNewGoals==1){
				newgoal1 = new Game_goal_NewGoal(row1,col1,false);
				createdGoals.add(newgoal1);
				createdGoals.addAll(createEmpties());

			}
		}

	}

	public ArrayList<Game_goal_NewGoal> createEmpties(){
		ArrayList<Game_goal_NewGoal> empties = new ArrayList<Game_goal_NewGoal>();
		if(numberofNewGoals==0){
			newgoal1 = new Game_goal_NewGoal(row1,col1,true);
			empties.add(newgoal1);
			newgoal2 = new Game_goal_NewGoal(row1,col2,true);
			empties.add(newgoal2);
			newgoal3 = new Game_goal_NewGoal(row1,col3,true);
			empties.add(newgoal3);
			
			newgoal4 = new Game_goal_NewGoal(row2,col1,true);
			empties.add(newgoal4);
			newgoal5 = new Game_goal_NewGoal(row2,col2,true);
			empties.add(newgoal5);
			newgoal6 = new Game_goal_NewGoal(row2,col3,true);
			empties.add(newgoal6);
			
			newgoal7 = new Game_goal_NewGoal(row3,col1,true);
			empties.add(newgoal7);
			newgoal8 = new Game_goal_NewGoal(row3,col2,true);
			empties.add(newgoal8);
			newgoal9 = new Game_goal_NewGoal(row3,col3,true);
			empties.add(newgoal9);
		}
		return empties;
	}
	
	public ArrayList<Game_goal_NewGoal> getGoals(){
		return createdGoals;
	}
}
