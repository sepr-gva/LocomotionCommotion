package com.TeamHEC.LocomotionCommotion.Map;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Resource;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_Station;
import com.TeamHEC.LocomotionCommotion.Map.Line;

/**
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 */

public class Station extends MapObj{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Player owner;
	private int baseValue;
	private int valueMod;
	private Resource resourceType;
	private int baseResourceOut;
	private int resourceOutMod;
	private Line[] line = null;//max number of lines on one station is 3, alter if this changes
	private int rentValue;
	private int rentValueMod;
	
	protected ArrayList<StationListener> listeners = new ArrayList<StationListener>();
	
	public Station(String name, int baseValue, Resource resourceType, int baseFuelOut, Line[] line, int rentValue, float x, float y)
	{
		super(x, y);
		
		actor = new Game_Map_Station(this, x, y);
		
		this.trains = new Train[5];
		this.name = name;
		this.owner = null;
		this.baseValue = baseValue;
		this.valueMod = 0;
		this.resourceType = resourceType;
		this.baseResourceOut = baseFuelOut;
		this.resourceOutMod = 0;
		this.line = line;
		this.rentValue = rentValue;
		this.rentValueMod = 0;
	}
	
	public Station getStation()
	{
		return this;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getResourceString()
	{
		return resourceType.getType();
	}
	
	public int getBaseValue()
	{
		return baseValue;
	}
	public int getValueMod()
	{
		return valueMod;
	}
	public void setValueMod(int value)
	{
		valueMod = value;
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
		return baseValue * (1 + valueMod);
	}
	
	public Resource getResourceType()
	{
		return resourceType;
	}
	public int getBaseResourceOut()
	{
		return baseResourceOut;
	}
	public int getResourceOutMod()
	{
		return resourceOutMod;
	}
	public void setResourceOutMod(int mod)
	{
		resourceOutMod = mod;
	}
	public void addResourceOutMod(int add)
	{
		resourceOutMod += add;
	}
	public void subResourceOutMod(int sub)
	{
		resourceOutMod -= sub;
	}	
	public int getTotalResourceOut()
	{
		return baseResourceOut * (1 + resourceOutMod);
	}
	
	public int getRentValue()
	{
		return rentValue;
	}
	public int getRentValueMod()
	{
		return rentValueMod;
	}	
	public void setRentValueMod(int value)
	{
		rentValueMod = value;
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
		return rentValue * (1 + rentValueMod);
	}
	
	public Player getOwner()
	{
		return owner;
	}
	public void setOwner(Player newOwner)
	{
		owner = newOwner;
	}
	
	public Line[] getLineType()
	{
			return line;
	}
	
	public void purchaseStation(Player player)
	{		
		//needs conditions to check station is purchasable
		//either added here or where purchase station will be called
		
		//player.subGold(this.getTotalValue());
		
		setOwner(player);
		notifyStationPurchased(this, player);
	}
	
	public void register(StationListener newListener)
	{
		if(newListener != null)
			listeners.add(newListener);
	}
	
	public void unregister(StationListener s)
	{
		listeners.remove(listeners.indexOf(s));
	}
	
	public void notifyStationPurchased(Station station, Player player) 
	{
		for(StationListener listener: listeners)
		{
			listener.ownerChanged(station, player);
		}
	}
}
