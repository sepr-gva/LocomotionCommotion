package com.TeamHEC.LocomotionCommotion.Train;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Map.Connection;
import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.badlogic.gdx.math.Vector2;

public class Route {
	
	private ArrayList<Connection> route = new ArrayList<Connection>();
	
	// Progress through route ArrayList
	private int routeIndex = 0;
	private float connectionTravelled = 0;
	
	private MapObj currentMapObj;
	
	public Route(MapObj startingPos)
	{
		currentMapObj = startingPos;
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

	public void addConnection(Connection connection)
	{
		route.add(connection);
	}

	public void removeConnection()
	{
		route.remove(route.size());
	}
	
	public Vector2 getTrainVector()
	{
		if(route.isEmpty())
		{
			return new Vector2(currentMapObj.x, currentMapObj.y);
		}
		else
		{
			Vector2 vect = route.get(routeIndex).getVector();
			
			// Normalises the Vector to get direction and scales it by distance travelled:
			
			vect.nor();
			vect.scl(connectionTravelled);
			
			return vect;
		}
	}
	
	public float getTotalLength()
	{
		float length = 0;
		for(int i = 0; i < route.size(); i++)
		{
			length += route.get(i).getLength();
		}
		return length;
	}
	
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
			}
		}
	}
}
