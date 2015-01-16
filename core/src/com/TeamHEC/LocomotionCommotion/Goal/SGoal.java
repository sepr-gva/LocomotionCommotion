package com.TeamHEC.LocomotionCommotion.Goal;

import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Resource.Resource;

public class SGoal extends Goal{

 private static final long serialVersionUID = 1L;

 
 
 public SGoal(Station Startstation, Station FinalStation, Station stationVia, String cargo, int reward2) 
 {	 
	 super(Startstation, FinalStation, stationVia , cargo, reward2);  
	 this.Special = true;
}

}