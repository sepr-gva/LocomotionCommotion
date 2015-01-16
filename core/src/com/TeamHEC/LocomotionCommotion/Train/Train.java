package com.TeamHEC.LocomotionCommotion.Train;

import java.io.Serializable;
import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_Train;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Fuel;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class Train implements Serializable{
	
	/*
	 A train can be upgraded to go faster, be protected
	 against obstacles and other novel upgrades that affect the performance of the
	 object in game.
	 
	 Upgrading Trains:
	 
		- increase carriage limit, trains performance, speed and efficiency.
	 	- Nuclear will move further than coal...
	
	Train:

	Speed					= ---
	Fuel Efficiency			= -----
	 */
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int baseSpeed, speedMod;
	
	private Fuel fuel;
	public int fuelPerTurn;
	
	private int value; // needs to change after upgrades?
	private boolean inStation;
	private Player owner;
	
	public final Route route;
	
	private Game_Map_Train trainActor;
	
	private ArrayList<TrainUpgrade> upgrades = new ArrayList<TrainUpgrade>();
	
	/**
	 * The superclass of Train types, Creates a Train for player.
	 * @param fuelType Type of fuel the train consumes
	 * @param speedMod Any speed modifications made to the train
	 * @param value The price of the train
	 * @param inStation whether the train is currently in a station
	 * @param route The route the train is currently using
	 * @param owner The owner of the train
	 */
	public Train(String name, Fuel fuelType, int baseSpeed, int speedMod, int value, boolean inStation, Route route, Player owner)
	{
		this.name = name;
		this.fuel = fuelType;
		
		this.baseSpeed = baseSpeed;
		this.speedMod = speedMod;
		this.value = value;
		this.inStation = inStation;
		this.route = route;
		this.owner = owner;
		
		// The UI blip for each train
		trainActor = new Game_Map_Train(this);
	}
	
	// =========== Getters ===========
	/**
	 * @return The Actor (UI Elelemt) for the train
	 */
	public Game_Map_Train getActor()
	{
		return trainActor;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	
	public int getSpeed()
	{
		return baseSpeed + speedMod;
	}
		
	public int getPricePerTurn()
	{
		return fuel.cost * fuelPerTurn;
	}
		
	public String getFuelType()
	{
		return fuel.getClass().getName();				
	}
	
	public Route getRoute()
	{
		return route;
	}
	
	// =========== Setters ===========
	
	public void setSpeedMod(int speedMod)
	{
		this.speedMod = speedMod;
	}
	
	public void setFuelPerTurn(int fuelPerTurn)
	{
		this.fuelPerTurn = fuelPerTurn;
	}
		
	public void increaseSpeedMod(int by)
	{
		speedMod += by;
	}
	
	public void decreaseFuelPerTurn(int by)
	{
		fuelPerTurn -= by;
	}
	
	public void setInStation(boolean inStation)
	{
		this.inStation = inStation;
	}
	
	// =========== Train Operations ===========
	
	public boolean isInStation()
	{
		return inStation;
	}	
	
	/**
	 * Moves the train through it's route using it's speed
	 */
	public void moveTrain()
	{
		route.update(getSpeed());
	}
	
	/**
	 * Adds an upgrade to the current train:
	 * @param upgrade The upgrade to be added
	 */
	public void addUpgrade(TrainUpgrade upgrade)
	{
		upgrade.addUpgrade();
		upgrades.add(upgrade);
	}
	/**
	 * Removes an upgrade from a train
	 * @param upgrade the upgrade to be removed
	 */
	public void removeUpgrade(TrainUpgrade upgrade)
	{
		upgrade.undoUpgrade();
		upgrades.remove(upgrade);
	}
}
