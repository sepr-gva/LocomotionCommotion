package com.TeamHEC.LocomotionCommotion.Train;

import java.io.Serializable;

import com.TeamHEC.LocomotionCommotion.Resource.Fuel;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class Train implements Serializable{
	
	/*
	 Train is an object that the player moves around the map to complete goals.
	 A train has different types; coal, oil,electricity and nuclear all of which
	 use their respective fuels. A train can be upgraded to go faster, be protected
	 against obstacles and other novel upgrades that affect the performance of the
	 object in game.
	 
	 Upgrading Trains:
	 
		- increase carriage limit, trains performance, speed and efficiency.
	 	- Nuclear will move further than coal...
	 	- More carriages = more fuel...
	
	Train:

	Speed					= --------
	Number of Carriages		= ---
	Carriage Capacity		= ------------
	Fuel Efficiency			= -----
	
	You need one power to pull every carriage
	
	Fuel Efficiency = amount of fuel charged per carriage

	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int baseSpeed, speedMod;
	private int baseCarriageLimit, carriageLimitMod;
	private int numOfCarriages;
	
	private Fuel fuel;
	public int fuelPerTurn;
	
	// needs to change after upgrades
	private int value;
	private boolean inStation;
	
	// Need somewhere to store the location of the Train
	
	public Train(String name, Fuel fuelType, int baseSpeed, int speedMod, int baseCarriageLimit,
			int carriageLimitMod, int value, boolean inStation)
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
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getValue()
	{
		// Should calculate after updates are made
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
	
	public void setInStation(boolean inStation)
	{
		this.inStation = inStation;
	}
	
	public boolean isInStation()
	{
		return inStation;
	}
}
