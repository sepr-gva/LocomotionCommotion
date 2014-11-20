package com.TeamHEC.LocomotionCommotion.Map;

import javax.sound.sampled.Line;

import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Fuel;

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
	
	public Station()
	{
		// Implement soon
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
	
	/*
	 Was going to create a listener for when a station is purchased, so that I
	 can implement the creation of another WildCard in the CardFactory...
	 */
}
