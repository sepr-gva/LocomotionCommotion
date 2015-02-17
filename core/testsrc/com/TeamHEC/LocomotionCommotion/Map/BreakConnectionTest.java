package com.TeamHEC.LocomotionCommotion.Map;

import static org.junit.Assert.*;

import com.TeamHEC.LocomotionCommotion.MapActors.Game_Map_Manager;
import com.TeamHEC.LocomotionCommotion.Mocking.GdxTestRunner;
import com.TeamHEC.LocomotionCommotion.Game.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class BreakConnectionTest {
	
	/**
	 * Break all the connections
	 */
	@Before
	public void setUp(){
		breakAllConnections();
	};
	
	@Test
	public void testBroken(){
		for (Station station : WorldMap.getInstance().stationsList){
			for (Connection connection : station.connections){
				assertTrue("Connection between " + connection.getStartMapObj() + 
						" " + connection.getDestination() + " did not break properly.",
						connection.getTraversable() == false);
			}
		}
	}
	
	/**
	 * Repair all the connections so that it doesnt interfere with other tests
	 */
	@After
	public void repairAllConnections(){
		for (Station station : WorldMap.getInstance().stationsList){
			for (Connection connection : station.connections){
				Game_Map_Manager.repairConnection(connection.getStartMapObj(), connection.getDestination());
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

}
