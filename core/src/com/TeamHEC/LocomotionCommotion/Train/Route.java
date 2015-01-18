package com.TeamHEC.LocomotionCommotion.Train;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_Manager;
import com.TeamHEC.LocomotionCommotion.Map.Connection;
import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Route{
	
	/*
	## READ ME ##
	https://drive.google.com/file/d/0B-ZG2Demzd4tc0JTbWxOS0FVd0E/view?usp=sharing
	*/
	
	private ArrayList<Connection> route = new ArrayList<Connection>();
	
	// Progress through route ArrayList
	private int routeIndex = 0;
	private float connectionTravelled = 0;	
	private MapObj currentMapObj;	
	private boolean isComplete = false;
	
	public Train train;
	
	protected ArrayList<RouteListener> listeners = new ArrayList<RouteListener>();
	
	/**
	 * Creates an arrayList of connections (a route) for tge train to eventually follow
	 * @param startingPos the starting position of the route
	 */
	public Route(MapObj startingPos)
	{
		currentMapObj = startingPos;
		routeIndex = 0;
		connectionTravelled = 0;
	}
	/**
	 * Used to reload an existing route
	 * @param route current route of the train
	 * @param routeIndex The index used to track progress through an array of connections
	 * @param connectionTravelled The distance travelled through that connection 
	 */
	public Route(ArrayList<Connection> route, int routeIndex, float connectionTravelled)
	{
		this.route = route;
		if(!route.isEmpty())
			currentMapObj = route.get(routeIndex).getStartMapObj();
		this.routeIndex = routeIndex;
		this.connectionTravelled = connectionTravelled;
	}
	
	/**
	 * @return An Arraylist of connections within the route
	 */
	public ArrayList<Connection> getRoute()
	{
		return route;
	}
	
	/**
	 * @return The current position of the train within the connections ArrayList
	 */
	public int getRouteIndex()
	{
		return routeIndex;
	}
	
	public boolean isComplete()
	{
		return isComplete;
	}
	
	/**
	 * @return The amount a train has progress through the current connection in a route
	 */
	public float getConnectionTravelled()
	{
		return connectionTravelled;
	}
	
	/**
	 * Can be used to change the position of the train within the route
	 * @param index the index of the connection to move the train to
	 */
	public void setRouteIndex(int index)
	{
		routeIndex = index;
	}
	/**
	 * Can be used to change the position of the train within the route
	 * @param The position of the train in the current connection
	 */
	public void setConnectionTravelled(float travelled)
	{
		connectionTravelled = travelled;
	}
	
	/**
	 * The currentMapObj the train is positioned at
	 */
	public void setCurrentMapObj(MapObj current)
	{
		currentMapObj = current;
	}
	
	/**
	 * Can be used to see which  adjacent connections are available to add to an existing route
	 * @return an ArrayList of adjacent connections to the latest connection in the route.
	 */
	public ArrayList<Connection> getAdjacentConnections()
	{
		if(route.isEmpty())
		{
			return currentMapObj.connections;
		}
		else
			return route.get(route.size()-1).getDestination().connections;
	}

	/**
	 * Adds a new connection to the end of the route.
	 * Usually one of the connections return from getAdjacentConnections()
	 * @param connection The connection to be added
	 */
	public void showRouteBlips()
	{
		Stage stage = train.getActor().getStage();
		for(Connection c : getRoute())
		{
			for(Actor a : c.getRouteBlips())
			{
				a.setVisible(true);
				stage.addActor(a);
			}
		}
	}
	
	public void hideRouteBlips()
	{
		Stage stage = train.getActor().getStage();
		for(Connection c : getRoute())
		{
			for(Actor a : c.getRouteBlips())
			{
				a.setVisible(false);
				stage.getActors().removeValue(a, true);
			}
		}
	}
	
	public void showConnectionBlips(Connection connection)
	{
		Stage stage = train.getActor().getStage();
		for(Actor a : connection.getRouteBlips())
		{
			a.setVisible(true);
			stage.addActor(a);
		}
	}
	
	public void hideConnectionBlips(Connection connection)
	{
		Stage stage = train.getActor().getStage();
		for(Actor a : connection.getRouteBlips())
		{
			a.setVisible(false);
			stage.getActors().removeValue(a, true);
		}
	}
	
	public void addConnection(Connection connection)
	{
		//Discards old selections:
		ArrayList<Connection> oldConnections = connection.getStartMapObj().connections;
		for(Connection c : oldConnections)
		{
			c.getDestination().getActor().setRouteAvailable(false);
			c.getDestination().getActor().toggleHighlight(false);
			
			// hideConnectionBlips(c);
		}
		
		route.add(connection);
		
		ArrayList<Connection> adj = getAdjacentConnections();	
		
		//Adds new ones:
		for(Connection c: adj)
		{
			c.getDestination().getActor().setRouteAvailable(train, c);
			c.getDestination().getActor().toggleHighlight(true);
			
			// showConnectionBlips(c);
		}
		
		showConnectionBlips(connection);
		
		isComplete = false;
		train.getActor().canMove = false;
		
		Game_Map_Manager.routeLength.setText(String.format("Route length: %.1f", getTotalLength()));
		Game_Map_Manager.routeRemaining.setText(String.format("Route remaining: %.1f", getLengthRemaining()));
	}

	/**
	 * Removes the latest connection from the route.
	 * Used to undo latest addition.
	 */
	public void removeConnection()
	{
		if(!route.isEmpty())
		{	
			// If the route trying to be removed has already been traversed...
			if((route.get(route.size() - 1) == route.get(routeIndex) && connectionTravelled == 0) || route.get(route.size() - 1) != route.get(routeIndex))
			{
				hideConnectionBlips(route.get(route.size() - 1));
				
				ArrayList<Connection> currentConnection = getAdjacentConnections();	
				
				// Removes the possible adjacent connections: 
				for(Connection c : currentConnection)
				{
					c.getDestination().getActor().setRouteAvailable(false);
					c.getDestination().getActor().toggleHighlight(false);
					
					//train.route.hideConnectionBlips(c);
				}
				
				// Remove the connection from the route:
				route.remove(route.size() - 1);
				
				// Updates the route information window text:
				Game_Map_Manager.routeLength.setText(String.format("Route length: %.1f", getTotalLength()));
				Game_Map_Manager.routeRemaining.setText(String.format("Route remaining: %.1f", getLengthRemaining()));
						
				//Toggles the current selection for the new route:
				currentConnection = getAdjacentConnections();	
				for(Connection c: currentConnection)
				{
					c.getDestination().getActor().setRouteAvailable(train, c);
					c.getDestination().getActor().toggleHighlight(true);
					
					//train.route.showConnectionBlips(c);
				}
			}
		}
	}
	
	/**
	 * Returns Vector2 containing x and y position of the Train in the Route. Calculated using
	 * the route index and connectionTravelled by scaling the direction vector within a connection
	 * @return a Vector containing the coordinates of the Train on the map
	 */
	public Vector2 getTrainPos()
	{
		if(route.isEmpty())
		{
			return new Vector2(currentMapObj.x, currentMapObj.y);
		}
		else
		{
			MapObj startMapObj = route.get(routeIndex).getStartMapObj();
			
			Vector2 pos = new Vector2(startMapObj.x, startMapObj.y);
			Vector2 vect = route.get(routeIndex).getVector().cpy();
				
			vect.scl(connectionTravelled);
			pos.add(vect);

			return pos;
		}
	}
	
	/**
	 * @return The length of the route from start to end
	 */
	public float getTotalLength()
	{
		float length = 0;
		for(int i = 0; i < route.size(); i++)
		{
			length += route.get(i).getLength();
		}
		return length;
	}
	
	/**
	 * @return The length of the route remaining
	 */
	public float getLengthRemaining()
	{
		if(route.isEmpty())
		{
			return 0;
		}
		else
		{
			float currentLength = route.get(routeIndex).getLength(); 
			float length = currentLength - connectionTravelled;

			for(int i = routeIndex + 1; i < route.size(); i++)
			{
				length += route.get(i).getLength();
			}
			return length;
		}
	}
	
	/**
	 * @return if the train is currently in a station
	 */
	public boolean inStation()
	{
		if(route.isEmpty())
		{
			return true;
		}
		else
		{
			Connection currentConnection = route.get(routeIndex);
			float connectionLength = currentConnection.getLength();
			
			if(connectionTravelled == 0 || connectionTravelled == connectionLength)
				return true;
			else
				return false;
		}
	}
	
	/**
	 * @return The station instance of the station the Train is in. Null if between stations
	 */
	public Station getStation()
	{
		if(inStation())
		{
			if(route.isEmpty())
			{
				return currentMapObj.getStation();
			}
			else
			{
				float connectionLength = route.get(routeIndex).getLength();
				
				if(connectionTravelled == 0)
					return route.get(routeIndex).getStartMapObj().getStation();
				else if(connectionTravelled == connectionLength)
					return route.get(routeIndex).getDestination().getStation();
			}
		}
		return null;
	}
	
	/**
	 * Progressed a train in the route by certain amount - normally it's speed
	 * @param moveBy how much to progress the Train through the route by
	 */
	public void update(float moveBy)
	{
		float connectionLength = route.get(routeIndex).getLength();
		
		if(connectionTravelled + moveBy < connectionLength)
			connectionTravelled += moveBy;
		else
		{
			float diff = Math.abs(connectionTravelled + moveBy - connectionLength);
			currentMapObj = route.get(routeIndex).getDestination();
			
			routeIndex++;
			connectionTravelled = 0;
			notifyStationPassed();
			
			if(routeIndex < route.size())
				update(diff);
			else
			{
				// ROUTE FINISHED
				route.clear();
				routeIndex = 0;
				isComplete = true;
			}
		}
	}

	/**
	 * Adds an object to the listener array
	 */
	public void register(RouteListener newListener)
	{
		if(newListener != null)
			listeners.add(newListener);
	}
	/**
	 * Removes an object from the Listener array
	 */
	public void unregister(RouteListener r)
	{
		listeners.remove(listeners.indexOf(r));
	}

	/**
	 * Notifies all listeners that a station has been passed by a train while completely it's route.
	 * Can be used to tax trains for passing rival stations
	 */
	public void notifyStationPassed()
	{
		for(RouteListener listener: listeners)
		{
			if(currentMapObj.getStation() != null)
				listener.stationPassed(currentMapObj.getStation());
		}
	}
}
