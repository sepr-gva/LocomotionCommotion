package com.TeamHEC.LocomotionCommotion.Map;

import java.io.Serializable;
import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Resource.*;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class WorldMap implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private final static WorldMap INSTANCE = new WorldMap();
	public static WorldMap getInstance()
	{
		return INSTANCE;
	}
	
	// List of Stations:
	// String name, int baseValue, Fuel fuelType, int baseFuelOut, Line lineType, int rentValue
	
	// NEEDS UPDATING WITH FUEL AND VALUE ETC!
	//Line colour takes an array of 3 colours, if a station needs less than 3 set the first one(s) to the colour you want and repeat the last unique colour
	//e.g. for a station on a black and blue line the second and third slots of the array must be the same (order of colours is otherwise irrelevant)
	
	private final Station LONDON = new Station("London", 10, new Coal(500), 10, new Line[]{Line.Black, Line.Black, Line.Black}, 10);
	private final Station PARIS = new Station("Paris", 10, new Electric(500), 10, new Line[]{Line.Yellow, Line.Black, Line.Black}, 10);
	private final Station REYKJAVIK = new Station("Reykjavik", 10, new Electric(500), 10, new Line[]{Line.Blue, Line.Black, Line.Black}, 10);
	private final Station DUBLIN = new Station("Dublin", 10, new Coal(500), 10, new Line[]{Line.Orange, Line.Black, Line.Black}, 10);
	private final Station AMSTERDAM = new Station("Amsterdam", 10, new Coal(500), 10, new Line[]{Line.Orange, Line.Orange, Line.Orange}, 10);
	private final Station OSLO = new Station("Oslo", 10, new Oil(500), 10, new Line[]{Line.Purple, Line.Blue, Line.Blue}, 10);
	private final Station STOCKHOLM = new Station("Stockholm", 10, new Oil(500), 10, new Line[]{Line.Blue, Line.Orange, Line.Orange}, 10);
	private final Station HELSINKI = new Station("Helsinki", 10, new Oil(500), 10, new Line[]{Line.Brown, Line.Blue, Line.Blue}, 10);
	private final Station VILNIUS = new Station("Vilnuis", 10, new Oil(500), 10, new Line[]{Line.Brown, Line.Brown, Line.Brown}, 10);
	private final Station MOSCOW = new Station("Moscow", 10, new Oil(500), 10, new Line[]{Line.Blue, Line.Orange, Line.Orange}, 10);
	private final Station WARSAW = new Station("Warsaw", 10, new Oil(500), 10, new Line[]{Line.Red, Line.Orange, Line.Orange}, 10);
	private final Station PRAGUE = new Station("Prague", 10, new Oil(500), 10, new Line[]{Line.Orange, Line.Yellow, Line.Brown}, 10);
	private final Station VIENNA = new Station("Vienna", 10, new Oil(500), 10, new Line[]{Line.Brown, Line.Brown, Line.Brown}, 10);
	private final Station ROME = new Station("Rome", 10, new Oil(500), 10, new Line[]{Line.Purple, Line.Green, Line.Green}, 10);
	private final Station MADRID = new Station("Madrid", 10, new Oil(500), 10, new Line[]{Line.Yellow, Line.Orange, Line.Orange}, 10);
	private final Station LISBON = new Station("Lisbon", 10, new Oil(500), 10, new Line[]{Line.Yellow, Line.Green, Line.Green}, 10);
	private final Station MONACO = new Station("Monaco", 10, new Oil(500), 10, new Line[]{Line.Black, Line.Orange, Line.Orange}, 10);
	private final Station ATHENS = new Station("Athens", 10, new Oil(500), 10, new Line[]{Line.Brown, Line.Green, Line.Green}, 10);
	private final Station BERLIN = new Station("Berlin", 10, new Oil(500), 10, new Line[]{Line.Purple, Line.Red, Line.Red}, 10);
	private final Station BERN = new Station("Bern", 10, new Oil(500), 10, new Line[]{Line.Purple, Line.Orange, Line.Orange}, 10);
	
	// Specify coordinates of each junction here:
	private final Junction[] junction = new Junction[]{new Junction(1.5f, 1.5f), new Junction(1.5f, 1.5f)};
	
	//CALLUM NEEDS A COPY OF ALL THE STATIONS SO HE MADE THIS SO HE CAN ACCESS THEM
	public ArrayList<Station> stationsList = new ArrayList<Station>() {	 		 
		private static final long serialVersionUID = 1L;

	{ 
	add(LONDON);
	add(PARIS);
	add(REYKJAVIK);
	add(DUBLIN);
	add(AMSTERDAM);
	add(OSLO);
	add(STOCKHOLM);
	add(HELSINKI);
	add(VILNIUS);
	add(MOSCOW);
	add(WARSAW);
	add(PRAGUE);
	add(VIENNA);
	add(ROME);
	add(MADRID);
	add(LISBON);
	add(MONACO);
	add(ATHENS);
	add(BERLIN);
	add(BERN);
	 }};
	
	private WorldMap()
	{
		// Set Station positions (could go in constructor of station tbh)
		stationPos(AMSTERDAM, 620f, 1300f);
		stationPos(ATHENS, 1140f, 400f);
		stationPos(BERLIN, 750f, 1300f);
		stationPos(BERN, 750f, 1300f);
		stationPos(DUBLIN, 490f, 1300f);
		stationPos(HELSINKI, 1140f, 1900f);
		stationPos(LISBON, 360f, 400f);
		stationPos(LONDON, 490f, 1000f);
		stationPos(MADRID, 490f, 700f);
		stationPos(MONACO, 620, 700f);
		stationPos(MOSCOW, 1400f, 1300f);
		stationPos(OSLO, 750f, 1900f);
		stationPos(PARIS, 620f, 1000f);
		stationPos(PRAGUE, 880f, 1000f);
		stationPos(REYKJAVIK, 230f, 1900f);
		stationPos(ROME, 880f, 400f);
		stationPos(STOCKHOLM, 880f, 1900f);
		stationPos(VIENNA, 1010f, 700f);
		stationPos(VILNIUS, 1140f, 1600f);
		stationPos(WARSAW, 800f, 1300f);
		
		junctionPos(junction[0], 750f, 1000f);
		junctionPos(junction[1], 1010f, 1300f);
		
		// Creates a connection instance for each:
		
		createConnections(REYKJAVIK, new MapObj[]{OSLO, DUBLIN});
		createConnections(DUBLIN, new MapObj[]{REYKJAVIK, AMSTERDAM, LONDON});
		createConnections(LONDON, new MapObj[]{DUBLIN, PARIS});
		createConnections(PARIS, new MapObj[]{LONDON, MONACO, MADRID, junction[0]});
		createConnections(MADRID, new MapObj[]{PARIS, MONACO, LISBON});
		createConnections(LISBON, new MapObj[]{MADRID, ROME});
		createConnections(AMSTERDAM, new MapObj[]{DUBLIN, BERLIN});
		createConnections(BERLIN, new MapObj[]{AMSTERDAM, OSLO, WARSAW, junction[0]});
		createConnections(OSLO, new MapObj[]{STOCKHOLM, REYKJAVIK, BERLIN});
		createConnections(WARSAW, new MapObj[]{BERLIN, STOCKHOLM, junction[1], PRAGUE});
		createConnections(STOCKHOLM, new MapObj[]{OSLO, WARSAW, HELSINKI});
		createConnections(HELSINKI, new MapObj[]{STOCKHOLM, VILNIUS, MOSCOW});
		createConnections(MOSCOW, new MapObj[]{HELSINKI, junction[1]});
		createConnections(PRAGUE, new MapObj[]{WARSAW, junction[0], junction[1], BERN, VIENNA});
		createConnections(VIENNA, new MapObj[]{PRAGUE, ATHENS});
		createConnections(ROME, new MapObj[]{LISBON, BERN, ATHENS});
		createConnections(MONACO, new MapObj[]{MADRID, PARIS, BERN});
		createConnections(BERN, new MapObj[]{MONACO, junction[0], PRAGUE});
	}
	
	// could go in constructor instead..
	public void stationPos(Station station, float x, float y)
	{
		station.x = x;
		station.y = y;
	}
	
	public void junctionPos(Junction junction, float x, float y)
	{
		junction.x = x;
		junction.y = y;
	}
	
	/*
		-Every MapObj (Station/Junction) has an ArrayList of connections
		-Every connection has a length which is calculated using coordinates set above
		-You can add a connection to a specific Train route using Train.addRouteConnection...
	*/
	public void createConnections(MapObj mapObj, MapObj[] connection)
	{
		for(int i = 0; i < connection.length; i++)
		{
			mapObj.connections.add(new Connection(mapObj, connection[i]));
		}
	}
	
	public void addAdjacencyMarkers(MapObj mapObj)
	{
		for(Connection i: mapObj.connections)
		{
			i.getDestination().showBlip();
		}
	}
}
