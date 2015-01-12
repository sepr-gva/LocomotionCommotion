package com.TeamHEC.LocomotionCommotion.Train;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Map.Connection;
import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.badlogic.gdx.math.Vector2;

public class Route {
	
	/*
	  	## READ ME ##
		https://drive.google.com/file/d/0B-ZG2Demzd4tc0JTbWxOS0FVd0E/view?usp=sharing
	*/
	
	private ArrayList<Connection> route = new ArrayList<Connection>();
	
	// Progress through route ArrayList
	private int routeIndex = 0;
	private float connectionTravelled = 0;
	
	private MapObj currentMapObj;
	
	public Route(MapObj startingPos)
	{
		currentMapObj = startingPos;
		routeIndex = 0;
		connectionTravelled = 0;
	}
	
	public Route(MapObj startingPos, int routeIndex, float connectionTravelled)
	{
		currentMapObj = startingPos;
		this.routeIndex = routeIndex;
		this.connectionTravelled = connectionTravelled;
	}
	
	public ArrayList<Connection> getRoute()
	{
		return route;
	}
	
	public int getRouteIndex()
	{
		return routeIndex;
	}
	
	public float getConnectionTravelled()
	{
		return connectionTravelled;
	}
	
	public void setRouteIndex(int index)
	{
		routeIndex = index;
	}
	
	public void setConnectionedTravelled(float travelled)
	{
		connectionTravelled = travelled;
	}
	
	public void setCurrentMapObj(MapObj current)
	{
		currentMapObj = current;
	}
	
	/*
	 	If a route hasn't been created, this method returns adjacent connections to the startingPos
	 	of the train or the connections at the end of the current planned route
	*/
	public ArrayList<Connection> getAdjacentConnections()
	{
		if(route.isEmpty())
		{
			return currentMapObj.connections;
		}
		else
			return route.get(route.size()).getDestination().connections;
	}

	// Adds a connection to the route
	public void addConnection(Connection connection)
	{
		route.add(connection);
	}

	// Removes the last connection in the route
	public void removeConnection()
	{
		route.remove(route.size());
	}
	
	// Returns a Vector of the trains position
	public Vector2 getTrainPos()
	{
		if(route.isEmpty())
		{
			return new Vector2(currentMapObj.x, currentMapObj.y);
		}
		else
		{
			Vector2 vect = route.get(routeIndex).getVector();
			
			// Scales the vector by the distance travelled:
			vect.scl(connectionTravelled);			
			return vect;
		}
	}
	
	// Returns the total length of the route from start to end
	public float getTotalLength()
	{
		float length = 0;
		for(int i = 0; i < route.size(); i++)
		{
			length += route.get(i).getLength();
		}
		return length;
	}
	
	//  Returns the length remaining in the route
	public float getLengthRemaining()
	{
		float currentLength = route.get(routeIndex).getLength(); 
		float length = currentLength - connectionTravelled;

		for(int i = routeIndex + 1; i < route.size(); i++)
		{
			length += route.get(i).getLength();
		}
		return length;
	}
	
	public boolean inStation()
	{
		Connection currentConnection = route.get(routeIndex);
		float connectionLength = currentConnection.getLength();
		
		if(connectionTravelled == 0 || connectionTravelled == connectionLength)
			return true;
		else
			return false;
	}
	
	/*
	public Station getStation()
	{
		if(inStation())
		{
			if(connectionTravelled == 0)
				return route.get(routeIndex).getStartMapObj();
		}
	}
	*/
	
	/*
	  	Haven't tested it yet but it should progress the train along the
	  	connections in route and how far it's along that connection
	*/
	public void update(float moveBy)
	{
		float connectionLength = route.get(routeIndex).getLength();
		if(connectionTravelled + moveBy < connectionLength)
		{
			connectionTravelled += moveBy;
		}
		else
		{
			float diff = Math.abs(connectionTravelled + moveBy - connectionLength);
			currentMapObj = route.get(routeIndex).getDestination();
			
			routeIndex++;
			connectionTravelled = 0;
			if(routeIndex < route.size())
			{
				update(diff);
			}
			else
			{
				// ROUTE FINISHED
				// Check if task complete?
			}
		}
	}
}
