package com.TeamHEC.LocomotionCommotion.Map;

import javax.sound.sampled.Line;

import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Fuel;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class Station extends MapObj{
	
	public Player owner;
	public int baseValue;
	private int valueMod;
	public Fuel fuelType;
	private int baseFuelOut;
	private int fuelOutMod;
	public Line lineType;
	private int rentValue;
	private int rentValueMod;
	
	public Station(Player owner, int baseValue, int valueMod, Fuel fuelType, int baseFuelOut, int fuelOutMod,
			Line lineType, int rentValue, int rentValueMod)
	{
		this.owner = owner;
		this.baseValue = baseValue;
		this.valueMod = valueMod;
		this.fuelType = fuelType;
		this.baseFuelOut = baseFuelOut;
		this.fuelOutMod = fuelOutMod;
		this.lineType = lineType;
		this.rentValue = rentValue;
		this.rentValueMod = rentValueMod;
	}
	
	public int getValue()
	{
		return baseValue + valueMod;
	}
	
	public Fuel getFuel()
	{
		return fuelType;
	}
	
	public int getRent()
	{
		return rentValue + rentValueMod;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	
	public void setOwner(Player newOwner)
	{
		owner = newOwner;
	}
	
	public void setFuelOutMod(int mod)
	{
		fuelOutMod = mod;
	}
}
