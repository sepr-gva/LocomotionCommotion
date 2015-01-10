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
	// String name, int baseValue, Fuel fuelType, int baseFuelOut, Line lineType, int rentValue, xcoordinate and ycoordinate
	
	// NEEDS UPDATING WITH FUEL AND VALUE ETC!
	//Line colour takes an array of 3 colours, if a station needs less than 3 set the first one(s) to the colour you want and repeat the last unique colour
	//e.g. for a station on a black and blue line the second and third slots of the array must be the same (order of colours is otherwise irrelevant)
	
	private final Station AMSTERDAM = new Station("Amsterdam", 10, new Electric(500), 10, new Line[]{Line.Orange, Line.Orange, Line.Orange}, 10, 615f, 560f);
	private final Station ATHENS = new Station("Athens", 10, new Coal(500), 10, new Line[]{Line.Brown, Line.Green, Line.Green}, 10,  1121f, 170f);
	private final Station BERLIN = new Station("Berlin", 10, new Nuclear(500), 10, new Line[]{Line.Purple, Line.Red, Line.Red}, 10, 731f, 560f);
	private final Station BERN = new Station("Bern", 10, new Nuclear(500), 10, new Line[]{Line.Purple, Line.Orange, Line.Orange}, 10, 731f, 300f);
	private final Station DUBLIN = new Station("Dublin", 10, new Coal(500), 10, new Line[]{Line.Orange, Line.Black, Line.Black}, 10, 471f, 560f);
	private final Station HELSINKI = new Station("Helsinki", 10, new Oil(500), 10, new Line[]{Line.Brown, Line.Blue, Line.Blue}, 10, 1121f, 820f);
	private final Station LISBON = new Station("Lisbon", 10, new Electric(500), 10, new Line[]{Line.Yellow, Line.Green, Line.Green}, 10, 341f, 170f);
	private final Station LONDON = new Station("London", 10, new Coal(500), 10, new Line[]{Line.Black, Line.Black, Line.Black}, 10, 471f, 430f);
	private final Station MADRID = new Station("Madrid", 10, new Electric(500), 10, new Line[]{Line.Yellow, Line.Orange, Line.Orange}, 10, 471f, 300f);
	//Gold is not currently accpeted as a fuel type for station output so for now Monaco gives nuclear
	private final Station MONACO = new Station("Monaco", 10, new Nuclear(500), 10, new Line[]{Line.Black, Line.Orange, Line.Orange}, 10, 601f, 300f);
	private final Station MOSCOW = new Station("Moscow", 10, new Nuclear(500), 10, new Line[]{Line.Blue, Line.Orange, Line.Orange}, 10, 1381f, 560f);
	private final Station OSLO = new Station("Oslo", 10, new Oil(500), 10, new Line[]{Line.Purple, Line.Blue, Line.Blue}, 10, 731f, 820f);
	private final Station PARIS = new Station("Paris", 10, new Electric(500), 10, new Line[]{Line.Yellow, Line.Black, Line.Black}, 10, 601f, 430f);
	private final Station PRAGUE = new Station("Prague", 10, new Oil(500), 10, new Line[]{Line.Orange, Line.Yellow, Line.Brown}, 10, 861f, 430f);
	private final Station REYKJAVIK = new Station("Reykjavik", 10, new Electric(500), 10, new Line[]{Line.Blue, Line.Black, Line.Black}, 10, 211f, 820f);
	private final Station ROME = new Station("Rome", 10, new Coal(500), 10, new Line[]{Line.Purple, Line.Green, Line.Green}, 10, 861f, 170f);
	private final Station STOCKHOLM = new Station("Stockholm", 10, new Oil(500), 10, new Line[]{Line.Blue, Line.Orange, Line.Orange}, 10, 861f, 820f);
	private final Station VIENNA = new Station("Vienna", 10, new Oil(500), 10, new Line[]{Line.Brown, Line.Brown, Line.Brown}, 10, 991f, 300f);
	private final Station VILNIUS = new Station("Vilnuis", 10, new Oil(500), 10, new Line[]{Line.Brown, Line.Brown, Line.Brown}, 10, 1121f, 690f);
	private final Station WARSAW = new Station("Warsaw", 10, new Coal(500), 10, new Line[]{Line.Red, Line.Orange, Line.Orange}, 10, 861f, 560f);
	
	// Specify coordinates of each junction here:
	private final Junction[] junction = new Junction[]{new Junction(731f, 430f), new Junction(991f, 560f)};
	
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
}
