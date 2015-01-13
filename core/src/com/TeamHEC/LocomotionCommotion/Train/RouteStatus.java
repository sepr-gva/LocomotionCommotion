package com.TeamHEC.LocomotionCommotion.Train;

public interface RouteStatus {
	
	public void register(RouteListener r);
	public void unregister(RouteListener r);
	public void notifyStationPassed();
}
