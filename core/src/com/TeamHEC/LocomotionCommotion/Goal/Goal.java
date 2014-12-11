package com.TeamHEC.LocomotionCommotion.Goal;


public  class Goal  {

	//Variables
	private String SStation;
	private String FStation;
	private boolean Special;
	private int Reward;
	private int Startdate;
	private String Carriagetype, route;

	//Constructor
	public Goal(String Startstation,String FinalStation, Boolean special, int rewards, int startdate, String ctype, String route) {
		this.SStation = Startstation;
		this.FStation = FinalStation;
		this.Special = special; 
		this.Reward = rewards;
		this.Startdate = startdate;
		this.Carriagetype = ctype;
		this.route = route;
	}
	public String getCarriagetype(){
		return this.Carriagetype;
	}
	public int getstartdate(){
		return this.Startdate;
	}
	public boolean isSpecial(){
		return this.Special;
	}
	public int getrewards(){
		return this.Reward;
	}

	//Accessors/Mutators
	public String getSStation(){
		return this.SStation;
	}

	public String getFStation(){
		return this.FStation;
	}
	public String getRoute(){
		return this.route;
	}

}