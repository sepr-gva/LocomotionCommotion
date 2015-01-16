package com.TeamHEC.LocomotionCommotion.Goal;

import java.util.Random;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Resource.Resource;
import com.TeamHEC.LocomotionCommotion.Train.Train;
public class Goal { 
 //Variables
 protected Station SStation;
 protected Station FStation;
 private boolean Special;
 protected double Reward;
 private int Startdate;
 private Card card;
 protected Resource resc;
 
 
 //Constructor
 
 public Goal(Station Startstation, Station FinalStation, Card card2, Resource resc2,double reward2, boolean b) {
	 this.SStation = Startstation;
     this.FStation = FinalStation;
     this.Special = b; 
     this.Reward = reward2;  
     this.resc = resc2;     
     this.card = card2;     
}
	//Accessors/Mutators
    public int startdate(){
  return this.Startdate;
 }
  public boolean isSpecial(){
  return this.Special;
 }
  public double rewards(){
  return this.Reward;
 }
 
 public String GetSStation(){
  return this.SStation.getName();
 }
 
 public String GetFStation(){
  return this.FStation.getName(); //eh
 }
 
 public String getMission(){
  String st = "You are required to deliver " + resc + " from " + SStation + " to " +FStation + ". The reward for this will be " + Reward + "points and a special card.";
  return st;   //potentally iterate over enum to find goal
 }
}

