package com.TeamHEC.LocomotionCommotion.Train;

import java.io.Serializable;
import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_Train;
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
	 	- More carriages = more fuel...
	
	Train:

	Speed					= ---
	Number of Carriages		= ---
	Carriage Capacity		= ------------
	Fuel Efficiency			= -----
	
	You need one power to pull every carriage
	Fuel Efficiency = amount of fuel charged per carriage
	 */
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int baseSpeed, speedMod;
	private int numOfCarriages, baseCarriageLimit, carriageLimitMod;
	
	private Fuel fuel;
	public int fuelPerTurn;
	
	private int value; // needs to change after upgrades?
	private boolean inStation;
	
	public final Route route;
	
	public Game_Map_Train trainActor;
	
	private ArrayList<TrainUpgrade> upgrades = new ArrayList<TrainUpgrade>();
	
	public Train(String name, Fuel fuelType, int baseSpeed, int speedMod, int baseCarriageLimit,
			int carriageLimitMod, int value, boolean inStation, Route route)
	{
		this.name = name;
		this.fuel = fuelType;
		
		this.baseSpeed = baseSpeed;
		this.speedMod = speedMod;
		this.baseCarriageLimit = baseCarriageLimit;
		this.carriageLimitMod = carriageLimitMod;
		this.numOfCarriages = baseCarriageLimit;
		this.value = value;
		this.inStation = inStation;
		this.route = route;
		
		trainActor = new Game_Map_Train(this);
	}
	
	// =========== Getters ===========
	
	public String getName()
	{
		return name;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public int getSpeed()
	{
		return baseSpeed + speedMod - numOfCarriages;
	}
		
	public int getPricePerTurn()
	{
		return fuel.cost * fuelPerTurn;
	}
		
	public int getCarriageCapacity()
	{
		return baseCarriageLimit + carriageLimitMod;
	}
	
	public String getFuelType()
	{
		return fuel.getClass().getName();				
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
	
	public void setCarriageLimitMod(int carriageLimitMod)
	{
		this.carriageLimitMod = carriageLimitMod;
	}
	
	public void increaseCarriageLimit(int by)
	{
		carriageLimitMod += by;
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
	
	public void moveTrain()
	{
		route.update(getSpeed());
	}
	
	public void addUpgrade(TrainUpgrade upgrade)
	{
		upgrade.addUpgrade();
		upgrades.add(upgrade);
	}
	
	public void removeUpgrade(TrainUpgrade upgrade)
	{
		upgrade.undoUpgrade();
		upgrades.remove(upgrade);
	}
}
