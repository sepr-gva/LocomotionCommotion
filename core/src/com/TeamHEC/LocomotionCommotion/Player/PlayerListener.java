package com.TeamHEC.LocomotionCommotion.Player;

import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.StationListener;

public interface PlayerListener {
	
	public void register(StationListener s);
	public void unregister(StationListener s);
	public void notifyStationPurchased(Station station, Player player);
}
