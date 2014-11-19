package com.TeamHEC.LocomotionCommotion.Train;

public class Train {
	
	/*
	 Train is an object that the player moves around the map to complete goals.
	 A train has different types; coal, oil,electricity and nuclear all of which
	 use their respective fuels. A train can be upgraded to go faster, be protected
	 against obstacles and other novel upgrades that affect the performance of the
	 object in game.
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
	
	public void setInStation(boolean inStation)
	{
		this.inStation = inStation;
	}
}
