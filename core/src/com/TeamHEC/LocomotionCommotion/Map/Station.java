package com.TeamHEC.LocomotionCommotion.Map;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Resource;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_Station;
import com.TeamHEC.LocomotionCommotion.Map.Line;

/**
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 * @author Elliot Bray<eb1033@york.ac.uk>
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
	
	/**
	 * @param name
	 * @param baseValue The value of the station
	 * @param resourceType The type of resource the station produces
	 * @param baseFuelOut The amount of resource the station produces each turn, without up line bonuses
	 * @param line Array of lines the station belongs to
	 * @param rentValue How much it costs to rent
	 * @param x Coordinate of position x on map
	 * @param y Coordinate of position y on map 
	 */
	
	public Station(String name, int baseValue, Resource resourceType, int baseFuelOut, Line[] line, int rentValue, float x, float y)
	{
		super(x, y);
		
		// Creates a map blip for this station
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
	
	/**
	 *@return station instance, used in MapObj and overwritten here
	 */
	public Station getStation()
	{
		return this;
	}
	
	/**
	 * @return  the name of the station
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @return The string of the fuelType used, can be used in player to deduct resources
	 */
	public String getResourceString()
	{
		return resourceType.getType();
	}
	/** 
	 * @return the value of the station without mods
	 */
	public int getBaseValue()
	{
		return baseValue;
	}
	/**
	 * @return the value added onto baseValue from bonuses
	 */
	public int getValueMod() //Currently has no affect on the game, but 
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
	/**
	 * @return the total value of the station with mods (Base + Mod)
	 */
	public int getTotalValue()
	{
		return baseValue + valueMod;
	}
	/**
	 * @return returns the resource Type as a type
	 */
	public Resource getResourceType()
	{
		return resourceType;
	}
	/**
	 * @return returns the base amount of resources produced by the station
	 */
	public int getBaseResourceOut()
	{
		return baseResourceOut;
	}
	/**
	 * @return the amount of resources added to base from bonuses
	 */
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
	/**
	 * @return the total output of fuel resources the station produces
	 */
	public int getTotalResourceOut()
	{
		return baseResourceOut + resourceOutMod;
	}
	
	public int getBaseRentValue()
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
	/**
	 * @return the total value of the station with mods
	 */
	public int getTotalRent()
	{
		return rentValue + rentValueMod ;
	}
	
	/**
	 * @return The current owner of the station
	 */
	public Player getOwner()
	{
		return owner;
	}
	/**
	 * Changes the owner of this station
	 * @param newOwner
	 */
	public void setOwner(Player newOwner)
	{
		owner = newOwner;
	}
	/**
	 * @return the array of lines the station is on
	 */
	public Line[] getLineType()
	{
		return line;
	}
	
	public void purchaseStation(Player player)
	{		
		//needs conditions to check station is purchasable
		//either added here or where purchase station will be called
		setOwner(player);
		notifyStationPurchased(this, player);
	}
	
	/**
	 * Registers an object implementing the StationListener by adding it to the listeners array
	 * @param newListener the object to be added
	 */
	public void register(StationListener newListener)
	{
		if(newListener != null)
			listeners.add(newListener);
	}
	
	/**
	 * Removes object implementing StationListener so it no longer recieves updates
	 * @param s the object to be removed
	 */
	public void unregister(StationListener s)
	{
		listeners.remove(listeners.indexOf(s));
	}
	/**
	 * Called when you want to notify listeners that a station has changed ownership, such as 
	 * changing the texture on the map or setting the text of the players gold 
	 * @param station
	 * @param player
	 */
	public void notifyStationPurchased(Station station, Player player) 
	{
		for(StationListener listener: listeners)
		{
			listener.ownerChanged(station, player);
		}
	}
}
