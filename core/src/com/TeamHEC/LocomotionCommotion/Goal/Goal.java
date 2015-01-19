package com.TeamHEC.LocomotionCommotion.Goal;

import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Train.RouteListener;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.UI_Elements.WarningMessage;

public class Goal implements RouteListener{ 
	//Variables
	protected Station SStation;
	protected Station FStation;
	protected Station stationVia;

	private String cargo;

	public boolean special;
	private int reward;
	private String startDate;

	// Variables used to track Goal completion:
	private Train train;
	
	private boolean startStationPassed;
	private boolean stationViaPassed;
	private boolean finalStationPassed;
	
	public Goal(Station Startstation, Station FinalStation, Station stationVia, String cargo, int reward)
	{
		this.SStation = Startstation;
		this.FStation = FinalStation;
		this.stationVia = stationVia;
		this.special = false; 
		this.reward = reward;  
		this.cargo = cargo;
		
        startDate = "1";
		
		// Initiliase goal completion variables to false
		startStationPassed = false;
		if(stationVia == null)
			stationViaPassed = true;
		else
			stationViaPassed = false;
		finalStationPassed = false;
	}

	public boolean isSpecial()
	{
		return special;
	}

	public String getSStation()
	{
		return this.SStation.getName();
	}

	public String getFStation()
	{
		return this.FStation.getName();
	}

	public int getReward()
	{
		return reward;
	}
	
	public String getStartDate()
	{
		return startDate;
	}
	
	public String getVia()
	{
		if(stationVia == null)
			return "Any";
		else
			return stationVia.getName();
	}
	public String getCargo()
	{
		return cargo;
	}

	/**
	 * Assigns a goal to a train and registers listeners
	 * @param train The train to assign to
	 * @author Matthew Taylor <mjkt500@york.ac.uk>
	 */
	public void assignTrain(Train train)
	{
		this.train = train;
		train.route.register(this);
		
		if(train.route.getStation() == SStation)
			startStationPassed = true;
	}
	
	/**
	 * Called when the goal is successfully complete:
	 */
	public void goalComplete()
	{
		WarningMessage.fireWarningWindow("GOAL COMPLETE!", "You've successfully complete the route: " + getSStation()
				+ " to " + getFStation() + "\n you've won " + getReward());
		
		train.getOwner().addGold(getReward());
		//train.route.unregister(this);
	}
	
	/**
	 * Listener trigger when a train passes a station
	 * @author Matthew Taylor <mjkt500@york.ac.uk>
	 */
	@Override
	public void stationPassed(Station station, Train train)
	{
		if(train == this.train)
		{
			System.out.println(train.getName() +" passed " + station.getName());
			//WarningMessage.fireWarningWindow(train.getName(), station.getName());;
			
			if(station == SStation)
				startStationPassed = true;
			else if(startStationPassed && station == FStation)
				finalStationPassed = true;
			else if(startStationPassed && station == stationVia && stationVia != null)
				stationViaPassed = true;
			
			if(startStationPassed && finalStationPassed && stationViaPassed)
				goalComplete();
		}
	}
}

