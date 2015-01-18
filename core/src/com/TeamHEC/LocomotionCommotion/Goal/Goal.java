package com.TeamHEC.LocomotionCommotion.Goal;

import com.TeamHEC.LocomotionCommotion.Map.Station;

public class Goal { 
	//Variables
	protected Station SStation;
	protected Station FStation;
	protected Station stationVia;

	private String cargo;

	public boolean Special;
	protected double Reward;
	private int Startdate;

	//Constructor

	public Goal(Station Startstation, Station FinalStation, Station stationVia, String cargo, int reward2)
	{
		this.SStation = Startstation;
		this.FStation = FinalStation;
		this.stationVia = stationVia;
		this.Special = false; 
		this.Reward = reward2;  
		this.cargo = cargo;
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

	public String getSStation(){
		return this.SStation.getName();
	}

	public String getFStation(){
		return this.FStation.getName(); //eh
	}

	public int getReward() {
		// TODO Auto-generated method stub
		return -1;
	}
	public int getStartDate() {
		// TODO Auto-generated method stub
		return -1;
	}
	public String getVia() {
		// TODO Auto-generated method stub
		return "Any";
	}
	public String getCargo() {
		// TODO Auto-generated method stub
		return cargo;
	}
}

