package com.TeamHEC.LocomotionCommotion.Map;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.TeamHEC.LocomotionCommotion.MapActors.Game_Map_Manager;

public class RepairConnectionTest {

	@Before
	public void setUp(){
		breakAllConnections();
		repairAllConnections();
	}
	
	@Test
	public void testFixed(){
		for (Station station : WorldMap.getInstance().stationsList){
			for (Connection connection : station.connections){
				assertTrue("Connection between " + connection.getStartMapObj() + 
						" " + connection.getDestination() + " did not fix properly.",
						connection.getTraversable());
			}
		}
	}
	
	
	public void breakAllConnections(){
		for (Station station : WorldMap.getInstance().stationsList){
			for (Connection connection : station.connections){
				Game_Map_Manager.breakConnection(connection.getStartMapObj(), connection.getDestination(), false);
			}
		}
	}
	
	public void repairAllConnections(){
		for (Station station : WorldMap.getInstance().stationsList){
			for (Connection connection : station.connections){
				Game_Map_Manager.repairConnection(connection.getStartMapObj(), connection.getDestination());
			}
		}
	}
}
