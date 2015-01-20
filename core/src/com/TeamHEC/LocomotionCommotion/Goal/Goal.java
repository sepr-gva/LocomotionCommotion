package com.TeamHEC.LocomotionCommotion.Goal;

import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Train.RouteListener;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.UI_Elements.WarningMessage;

/**
 * 
 * @author Sam Anderson <sa902@york.ac.uk>
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */
public class Goal implements RouteListener{ 
	//Variables
	protected Station sStation;
	protected Station fStation;
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
	
	/**
	 * Initialises the goal.
	 * @param startStation The Station the goal starts from
	 * @param finalStation The Station the goal ends at
	 * @param stationVia The Station the goal wants you to travel via
	 * @param cargo The type of cargo the train is carrying.
	 * @param reward The reward (currently Gold) you get for completing the Goal
	 */
	public Goal(Station startStation, Station finalStation, Station stationVia, String cargo, int reward)
	{
		this.sStation = startStation;
		this.fStation = finalStation;
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
		return this.sStation.getName();
	}

	public String getFStation()
	{
		return this.fStation.getName();
	}

	public int getReward()
	{
		return reward;
	}
	
	public String getStartDate()
	{
		return startDate;
	}
	
	/**
	 * Returns the name of the viaStation. Returns "Any" if StationVia is null.
	 * @return The name of the viaStation. Returns "Any" if StationVia is null.
	 */
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
	 * 
	 */
	public void assignTrain(Train train)
	{
		this.train = train;
		train.route.register(this);
		
		if(train.route.getStation() == sStation)
			startStationPassed = true;
	}
	
	public Train getTrain()
	{
		return train;
	}
	
	/**
	 * Called when the goal is successfully complete:
	 */	
	public void goalComplete()
	{
		WarningMessage.fireWarningWindow("GOAL COMPLETE!", "You've successfully complete the route: " + getSStation()
				+ " to " + getFStation() + "\n you've won " + getReward());
		
		train.getOwner().addGold(getReward());
		train.route.unregister(this);
	}
	
	/**
	 * Listener trigger when a train passes a station
	 * 
	 */
	@Override
	public void stationPassed(Station station, Train train)
	{
		if(train == this.train)
		{
			System.out.println(train.getName() +" passed " + station.getName());
			//WarningMessage.fireWarningWindow(train.getName(), station.getName());;
			
			if(station == sStation)
				startStationPassed = true;
			else if(startStationPassed && station == fStation)
				finalStationPassed = true;
			else if(startStationPassed && station == stationVia && stationVia != null)
				stationViaPassed = true;
			
			if(startStationPassed && finalStationPassed && stationViaPassed)
				goalComplete();
		}
	}
}

