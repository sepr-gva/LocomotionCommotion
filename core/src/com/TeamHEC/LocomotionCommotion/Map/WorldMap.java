package com.TeamHEC.LocomotionCommotion.Map;

import java.util.HashMap;

import com.TeamHEC.LocomotionCommotion.Resource.Coal;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

/*
	- All the junctions are initialise first so we can reuse the variable for different connections 
	- We then create each station and create an array of Track objects between them,
		remembering to include any junction objects we've already created...
	- the connection can then be made...
*/

public class WorldMap {
	
	private final static WorldMap INSTANCE = new WorldMap();
	public static WorldMap getInstance()
	{
		return INSTANCE;
	}
	
	public HashMap<String, Connection> connections = new HashMap<String, Connection>();
	
	// Hard-coded Junctions:
	private final static Track[] junctions = {new Track(true), new Track(true)};
	
	// List of Stations:
	// String name, int baseValue, Fuel fuelType, int baseFuelOut, Line lineType, int rentValue
	private static Station EDINBURGH = new Station("Edinburgh", 10, new Coal(500), 10, Line.Black, 10);
	private static Station YORK = new Station("York", 10, new Coal(500), 10, Line.Black, 10);
	
	private final static Track[] YORK_EDINBURGH = {new Track(), new Track(), junctions[0]};
	
	private static final Connection YORK_EDINBURGH_CONNECTION = new Connection(YORK, EDINBURGH, YORK_EDINBURGH);
	
	private WorldMap()
	{
		connections.put("YORK_EDINBURGH", YORK_EDINBURGH_CONNECTION);
	}
	
	public void moveTrain()
	{
		
	}
	
	public void initiliaseMap()
	{
		
	}
}
