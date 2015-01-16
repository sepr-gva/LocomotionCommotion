package com.TeamHEC.LocomotionCommotion.Goal;

import java.util.ArrayList;

public class GoalMenu {
  public ArrayList<Goal> GoalList = new ArrayList<Goal>(11);
  public GoalFactory goalfactory =new GoalFactory();
  public static GoalMenu INSTANCE = new GoalMenu();
 public static GoalMenu getInstance()
 {
  return INSTANCE;
 } 
  private GoalMenu()
 {
	  int i = 0;
    for (i = 0; i < 13; i++){
  GoalList.add(goalfactory.CreateRandomGoal());   
    }     
 }   
  
  private Goal genGoal(){
    Goal goal = goalfactory.CreateRandomGoal();
    return goal;
  }
  private void addGtolist(Goal goal){
    GoalList.add(goal);
    
  }
  private void fillList(){ 
    while (GoalList.size() <12) {
     GoalList.add(this.genGoal());          
    }
  }  
  public int SpecialCount(){
    int count = 0;
    int i = 0;
    for (i = 0; i < 13; i++){
     Goal goal = GoalList.get(i);
     if (goal.isSpecial()){
       
       count = count + 1;
     }
      
    }
    return count;
  }
  
//  private Goal PlayerSelect(){
//    Random r = new Random();
//    int i = r.nextInt(GoalList.size());
//    // dont know how player will select
//    //made this instead 
//    Goal PSGoal = GoalList.get(i);
//    GoalList.remove(PSGoal);
//    GoalList.add(this.genGoal());
//    }

}
