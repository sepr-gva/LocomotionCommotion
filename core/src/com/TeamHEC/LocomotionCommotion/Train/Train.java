package com.TeamHEC.LocomotionCommotion.Train;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class Train {
	
	/*
	 Train is an object that the player moves around the map to complete goals.
	 A train has different types; coal, oil,electricity and nuclear all of which
	 use their respective fuels. A train can be upgraded to go faster, be protected
	 against obstacles and other novel upgrades that affect the performance of the
	 object in game.
	 
	 Upgrading Trains:
	 
	Players will be able to upgrade individual trains with a variety of upgrades such as increasing the carriage limit
	along with other upgrades that will improve the trains performance, speed and efficiency.
	 
	 There are four different types of fuel that have different levels of effectiveness for example a nuclear train will move
	 further per turn than a coal one.
	 
	 Carriage Class
This is a train upgrade that allows you increase the capacity of your train allowing you to carry more passengers or
cargo. More carriages are needed to be able to access higher level goals which give better rewards. However there
is a cost increase in the fuel needed to travel.

	Coal 
	Oil
	Electric
	Nuclear
	 
	 */
	
	private int baseSpeed, speedMod = 0;
	private int baseCarriageLimit, carriageLimitMod = 0;
	private int value;
	private boolean inStation;
	
	public Train(int baseSpeed, int baseCarriageLimit, int value, boolean inStation)
	{
		this.baseSpeed = baseSpeed;
		this.baseCarriageLimit = baseCarriageLimit;
		this.value = value;
		this.inStation = inStation;
	}
	
	public int getSpeed()
	{
		return baseSpeed + speedMod;
	}
	
	public int getCarriageNumber()
	{
		return baseCarriageLimit + carriageLimitMod;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public boolean isInStation()
	{
		return inStation;
	}
	
	public void setSpeedMod(int speedMod)
	{
		this.speedMod = speedMod;
	}
	
	public void setCarriageMod(int carriageLimitMod)
	{
		this.carriageLimitMod = carriageLimitMod;
	}
	
	public void addCarriage(int numCarriages)
	{
		carriageLimitMod += numCarriages;
	}
	
	public void setInStation(boolean inStation)
	{
		this.inStation = inStation;
	}
}
