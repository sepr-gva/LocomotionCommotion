package com.TeamHEC.LocomotionCommotion.Goal;

import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Train.RouteListener;
import com.TeamHEC.LocomotionCommotion.Train.Train;

public class Goal implements RouteListener{ 
	//Variables
	protected Station SStation;
	protected Station FStation;
	protected Station stationVia;

	private String cargo;

	public boolean Special;
	protected double Reward;
	private int Startdate;

	// Variables used to track Goal completion:
	private Train train;
	
	private boolean startStationPassed;
	private boolean stationViaPassed;
	private boolean finalStationPassed;
	
	
	public Goal(Station Startstation, Station FinalStation, Station stationVia, String cargo, int reward2)
	{
		this.SStation = Startstation;
		this.FStation = FinalStation;
		this.stationVia = stationVia;
		this.Special = false; 
		this.Reward = reward2;  
		this.cargo = cargo;
		
		// Initiliase goal completion variables to false
		startStationPassed = false;
		if(stationVia == null)
			stationViaPassed = true;
		else
			stationViaPassed = false;
		finalStationPassed = false;
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

	/**
	 * Assigns a goal to a train and registers listeners
	 * @param train The train to assign to
	 */
	public void assignTrain(Train train)
	{
		this.train = train;
		train.route.register(this);
		
		if(train.route.getStation() == SStation)
			startStationPassed = true;
	}
	
	public void goalComplete()
	{
		System.out.println("Goal complete");
	}
	
	@Override
	public void stationPassed(Station station, Train train)
	{
		if(train == this.train)
		{
			if(station == SStation)
				startStationPassed = true;
			else if(station == FStation)
				finalStationPassed = true;
			else if(station == stationVia && stationVia != null)
				stationViaPassed = true;
			
			if(startStationPassed && finalStationPassed && stationViaPassed)
				goalComplete();
		}
	}
}

