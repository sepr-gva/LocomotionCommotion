package com.TeamHEC.LocomotionCommotion.Game_Actors;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Map.Connection;
import com.TeamHEC.LocomotionCommotion.Map.Junction;

public class Game_Map_Junction extends Game_Map_MapObj{
	
	private Junction junction;
	public float offset = 0;
	
	public Game_Map_Junction(Junction junction, float actorX, float actorY)
	{
		super(actorX, actorY, Game_Map_TextureManager.getInstance().junction, Game_Map_TextureManager.getInstance().junctionx2);
		
		this.junction = junction;
	}
	
	@Override
	protected void onClicked()
	{
		if(routeAvailable())
		{
			System.out.println("Added to route");
			
			/* Need to discard old connections somehow...
			ArrayList<Connection> oldConnections = getRouteConnection().getStartMapObj().connections;
			for(Connection c : oldConnections)
			{
				c.getDestination().getActor().setRouteAvailable(null, null, false);
				c.getDestination().getActor().toggleHighlight(false);
			}
			*/
			
			getRouteTrain().route.addConnection(getRouteConnection());
			ArrayList<Connection> adj = getRouteTrain().route.getAdjacentConnections();	
			
			for(Connection c: adj)
			{
				c.getDestination().getActor().setRouteAvailable(getRouteTrain(), c, true);
				c.getDestination().getActor().toggleHighlight(true);
			}
			
		}
	}
}
