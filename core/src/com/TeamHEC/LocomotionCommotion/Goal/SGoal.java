package com.TeamHEC.LocomotionCommotion.Goal;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Resource.Resource;

public class SGoal extends Goal{

 private static final long serialVersionUID = 1L;

 
 
 public SGoal(Station Startstation, Station FinalStation, Card card, Resource resc,double reward, boolean b) {
	 
	 super(Startstation,FinalStation,card,resc,reward,b);  
	
}

@Override
 public String getMission()
 {
   String st = "You are required to deliver " + resc + "using a from " + SStation + " to " +FStation + ". The reward for this will be " + Reward + "points and a special card.";
  return st;
 }
}