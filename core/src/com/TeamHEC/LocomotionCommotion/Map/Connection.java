package com.TeamHEC.LocomotionCommotion.Map;

import java.util.Arrays;
import java.util.Collections;

public class Connection{
	
	public Station stationStart, endStation;
	public Track[] tracks;
	
	public Connection(Station startStation, Station endStation, Track[] tracks)
	{
		this.stationStart = startStation;
		this.endStation = endStation;
		this.tracks = tracks;
	}
	
	// Dunno if we need this:
	public void reverseConnection()
	{
		Track[] reverseTrack = tracks.clone();
		Collections.reverse(Arrays.asList(reverseTrack));
		// Station temp = 
	}
}