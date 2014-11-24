package com.TeamHEC.LocomotionCommotion.Map;

import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Fuel;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.Map.Line;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class Station extends MapObj{
	
	private String name;
	private Player owner;
	private int baseValue;
	private int valueMod;
	private Fuel fuelType;
	private int baseFuelOut;
	private int fuelOutMod;
	private Line lineType;
	private int rentValue;
	private int rentValueMod;
	
	public Station(String name, int baseValue, Fuel fuelType, int baseFuelOut, Line lineType, int rentValue)
	{
		this.trains = new Train[5];
		this.name = name;
		this.owner = null;
		this.baseValue = baseValue;
		this.valueMod = 0;
		this.fuelType = fuelType;
		this.baseFuelOut = baseFuelOut;
		this.fuelOutMod = 0;
		this.lineType = lineType;
		this.rentValue = rentValue;
		this.rentValueMod = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getBaseValue()
	{
		return baseValue;
	}
	
	public int getValueMod()
	{
		return valueMod;
	}
	
	public void addValueMod(int add)
	{
		valueMod += add;
	}
	public void subValueMod(int sub)
	{
		valueMod -= sub;
	}
	
	public int getTotalValue()
	{
		return baseValue + valueMod;
	}
	
	public Fuel getFuelType()
	{
		return fuelType;
	}
	
	public int getBaseFuelOut()
	{
		return baseFuelOut;
	}
	
	public int getFuelOutMod()
	{
		return fuelOutMod;
	}
	
	public void addFuelOutMod(int add)
	{
		fuelOutMod += add;
	}
	public void subFuelOutMod(int sub)
	{
		fuelOutMod -= sub;
	}
	
	public int getTotalFuelOut()
	{
		return baseFuelOut + fuelOutMod;
	}
	
	public int getRentValue()
	{
		return rentValue;
	}
	
	public int getRentValueMod()
	{
		return rentValueMod;
	}
	
	public void addRentValueMod(int add)
	{
		rentValueMod += add;
	}
	
	public void subRentValueMod(int sub)
	{
		rentValueMod-= sub;
	}
	
	public int getTotalRent()
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
	
	public Line getLineType()
	{
		return lineType;
	}
	
	public void purchaseStation(Player player)
	{		
		player.subGold(this.getTotalValue());
		owner = player;
	}
}
