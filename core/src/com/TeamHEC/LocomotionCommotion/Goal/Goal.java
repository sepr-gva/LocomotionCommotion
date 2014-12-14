package com.TeamHEC.LocomotionCommotion.Goal;


public  class Goal  {

	//Variables
	private String sStation;
	private String fStation;
	private boolean special;
	private int reward;
	private int startDate;
	private String carriageType, route;

	//Constructor
	public Goal(String startStation,String finalStation, Boolean special, int reward, int startDate, String cType, String route) {
		this.sStation = startStation;
		this.fStation = finalStation;
		this.special = special; 
		this.reward = reward;
		this.startDate = startDate;
		this.carriageType = cType;
		this.route = route;
	}
	public String getCarriageType(){
		return this.carriageType;
	}
	public int getStartDate(){
		return this.startDate;
	}
	public boolean isSpecial(){
		return this.special;
	}
	public int getReward(){
		return this.reward;
	}

	//Accessors/Mutators
	public String getSStation(){
		return this.sStation;
	}

	public String getFStation(){
		return this.fStation;
	}
	public String getRoute(){
		return this.route;
	}

}