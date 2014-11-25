package com.TeamHEC.LocomotionCommotion.Map;

public class Connection{
	
	public Station stationStart, endStation;
	public Track[] tracks;
	
	public Connection(Station startStation, Station endStation, Track[] tracks)
	{
		this.stationStart = startStation;
		this.endStation = endStation;
		this.tracks = tracks;
	}
}
