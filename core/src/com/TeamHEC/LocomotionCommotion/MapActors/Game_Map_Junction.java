package com.TeamHEC.LocomotionCommotion.MapActors;

import com.TeamHEC.LocomotionCommotion.Map.Connection;
import com.TeamHEC.LocomotionCommotion.Map.Junction;
import com.TeamHEC.LocomotionCommotion.UI_Elements.WarningMessage;

public class Game_Map_Junction extends Game_Map_MapObj{
	
	public float offset = 0;
	public Junction junction;
	
	public Game_Map_Junction(Junction junction, float actorX, float actorY)
	{
		super(actorX, actorY, Game_Map_TextureManager.getInstance().junction, Game_Map_TextureManager.getInstance().junctionx2);
		this.junction = junction;
	}
	
	@Override
	protected void onClicked()
	{
		super.onClicked();
		//Boolean that says that a break rail card is being implemented, and the first city is
		//being chosen and so when a city is clicked it becomes the first city in the break
		if (Game_Map_Manager.firstBreakCity){
			//First city chosen
			Game_Map_Manager.firstBreakCity = false;
			//Cards first city is this city
			Game_Map_Manager.currentBreakCard.firstObj = this.junction;
			//Second city is now being chosen, so when a city is clicked it becomes the second city
			WarningMessage.fireWarningWindow("CHOOSE SECOND STATION", "Choose an ajoining station, inbetween which \nthe connection will be broken");
			Game_Map_Manager.secondBreakCity = true;
		}
		//Checking for if the second city is being chosen
		else if (Game_Map_Manager.secondBreakCity){
			//Second city has been chosen, go back to normal city interaction
			Game_Map_Manager.secondBreakCity = false;
			//The actual connection and whether it has been found (if it is valid or not)
			Connection con = null;
			boolean found = false;
			//Checking whether a connection between the two chosen cities exists
			for (Connection connection : Game_Map_Manager.currentBreakCard.firstObj.connections){
				if (connection.getDestination() == this.junction){
					found = true;
					con = connection;
				}
			}
			
			//If a connection is found, go on to check if it is already broken or not,
			//If it is, start the implementation of the card over again
			if (found){
				//If the connection is not broken, break it and give a message to say what
				//has happened
				if (con.getTraversable()){
					Game_Map_Manager.breakConnection(Game_Map_Manager.currentBreakCard.firstObj, this.junction);
					WarningMessage.fireWarningWindow("CONNECTION BROKEN", "Connection between " + 
							Game_Map_Manager.currentBreakCard.firstObj.getName() + " and " + this.junction.getName() + 
							"\nhas been broken.");
				}
				else{
					WarningMessage.fireWarningWindow("ALREADY BROKEN", "The connection you want to break is already broken, \nchoose a new starting city.");
					Game_Map_Manager.firstBreakCity = true;
				}
			}
			else{
				WarningMessage.fireWarningWindow("NOT VALID CONNECTION", "That is not a valid connection, choose a new starting city.");
				Game_Map_Manager.firstBreakCity = true;
			}
		}
	}
}
