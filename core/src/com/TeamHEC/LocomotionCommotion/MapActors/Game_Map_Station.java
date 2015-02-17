package com.TeamHEC.LocomotionCommotion.MapActors;

import com.TeamHEC.LocomotionCommotion.Game.GameScreen;
import com.TeamHEC.LocomotionCommotion.Map.Connection;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.StationListener;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.UI_Elements.WarningMessage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class Game_Map_Station extends Game_Map_MapObj implements StationListener {

	public boolean owned;
	private Station station;

	public float offset = 0;

	public Game_Map_Station(Station station, float actorX, float actorY)
	{
		super(actorX, actorY, Game_Map_TextureManager.getInstance().station, Game_Map_TextureManager.getInstance().stationx2);

		this.station = station;
		this.owned = false;
		station.register(this);
	}

	public Station getStation()
	{
		return station;
	}

	@Override
	public void ownerChanged(Station station, Player player)
	{
		if(player == null)
		{
			texture = Game_Map_TextureManager.getInstance().station;
			toggleTexture1 = Game_Map_TextureManager.getInstance().station;
			toggleTexture2 = Game_Map_TextureManager.getInstance().stationx2;
		}

		else if(player.isPlayer1)
		{
			texture = Game_Map_TextureManager.getInstance().p1Station;
			toggleTexture1 = Game_Map_TextureManager.getInstance().p1Station;
			toggleTexture2 = Game_Map_TextureManager.getInstance().p1Stationx2;
		}
		else
		{
			texture = Game_Map_TextureManager.getInstance().p2Station;
			toggleTexture1 = Game_Map_TextureManager.getInstance().p2Station;
			toggleTexture2 = Game_Map_TextureManager.getInstance().p2Stationx2;
		}
	}

	@Override
	protected void onClicked()
	{
		super.onClicked();
		//If the boolean teleportCity is true, the station info box will not come up, but the
		//selected train will be moved to this city
		if (Game_Map_Manager.teleportCity){
			//Set teleport city to false so that when stations are clicked afterwards 
			//they will act as normal
			Game_Map_Manager.teleportCity = false;
			
			//Clear the trains route so that it will not try and continue its current
			//route after it has been teleported
			Game_Map_Manager.currentTeleportCard.train.route.getRoute().clear();
			Game_Map_Manager.currentTeleportCard.train.route.setRouteIndex(0);
			Game_Map_Manager.currentTeleportCard.train.route.setConnectionTravelled(0);
			
			//Move the trains current station to this station
			Game_Map_Manager.currentTeleportCard.train.route.setCurrentMapObj(station);
			
			//Make the currentTeleportCard null so that it is no longer accessible
			Game_Map_Manager.currentTeleportCard = null;
		}
		//Boolean that says that a break rail card is being implemented, and the first city is
		//being chosen and so when a city is clicked it becomes the first city in the break
		else if (Game_Map_Manager.firstBreakCity){
			//First city chosen
			Game_Map_Manager.firstBreakCity = false;
			//Cards first city is this city
			Game_Map_Manager.currentBreakCard.firstObj = this.station;
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
				if (connection.getDestination() == this.station){
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
					Game_Map_Manager.breakConnection(Game_Map_Manager.currentBreakCard.firstObj, this.station);
					WarningMessage.fireWarningWindow("CONNECTION BROKEN", "Connection between " + 
							Game_Map_Manager.currentBreakCard.firstObj.getName() + " and " + this.station.getName() + 
							"\nhas been broken.");
					Game_Map_Manager.trainsTouchable();
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
		//Boolean that says that a fix rail card is being implemented, and the first city is
		//being chosen and so when a city is clicked it becomes the first city in the fix
		else if (Game_Map_Manager.firstFixCity){
			//First city chosen
			Game_Map_Manager.firstFixCity = false;
			//Cards first city is this city
			Game_Map_Manager.currentFixCard.firstObj = this.station;
			//Second city is now being chosen, so when a city is clicked it becomes the second city
			WarningMessage.fireWarningWindow("CHOOSE SECOND STATION", "Choose an ajoining station, inbetween which \nthe connection will be fixed.");
			Game_Map_Manager.secondFixCity = true;
		}
		//Checking for if the second city is being chosen
		else if (Game_Map_Manager.secondFixCity){
			//Second city has been chosen, go back to normal city interaction
			Game_Map_Manager.secondFixCity = false;
			//The actual connection and whether it has been found (if it is valid or not)
			Connection con = null;
			boolean found = false;
			//Checking whether a connection between the two chosen cities exists
			for (Connection connection : Game_Map_Manager.currentFixCard.firstObj.connections){
				if (connection.getDestination() == this.station){
					found = true;
					con = connection;
				}
			}
				
			//If a connection is found, go on to check if it is already broken or not,
			//If it is, start the implementation of the card over again
			if (found){
				//If the connection is not broken, break it and give a message to say what
				//has happened
				if (!con.getTraversable()){
					Game_Map_Manager.repairConnection(Game_Map_Manager.currentBreakCard.firstObj, this.station);
					WarningMessage.fireWarningWindow("CONNECTION FIXED", "Connection between " + 
							Game_Map_Manager.currentBreakCard.firstObj.getName() + " and " + this.station.getName() + 
							"\nhas been fixed.");
					Game_Map_Manager.trainsTouchable();
				}
				else{
					WarningMessage.fireWarningWindow("NOT BROKEN", "The connection you want to fix is not broken, \nchoose a new starting city.");
					Game_Map_Manager.firstFixCity = true;						}
			}
			else{
				WarningMessage.fireWarningWindow("NOT VALID CONNECTION", "That is not a valid connection, choose a new starting city.");
				Game_Map_Manager.firstFixCity = true;
			}
		}
		else{
			Game_Map_StationBtn.selectedStation = this;
			if(!highlighted)
			{	
				highlighted = true;
				if(!Game_Map_Manager.routingModeWindow.isVisible())
					showInfoBox();
			}
			else
			{
				highlighted = false;
				hideInfoBox();
			}
		}
	}

	public void showInfoBox()
	{
		for(int i = Game_Map_Manager.stagestart;i <= Game_Map_Manager.stagestart + Game_Map_Manager.mapActors-1; i++)	
		{ 	
			if (i > GameScreen.getStage().getActors().size-1){
			}
			else
			{
				GameScreen.getStage().getActors().get(i).setVisible(true);
			}
		}
		// Sets the labels to info from each station:
		Game_Map_Manager.stationLabelName.setText(station.getName());
		Game_Map_Manager.stationLabelCost.setText(String.format("%d", station.getBaseValue() ));
		Game_Map_Manager.stationLabelFuel.setText(String.format("%d * %s", station.getTotalResourceOut(), station.getResourceString()));

		Game_Map_Manager.moveInfoBox(this.actorX-180, this.actorY-80);
	}
	
	public void hideInfoBox(){
		for(int i=Game_Map_Manager.stagestart; i<=Game_Map_Manager.stagestart +Game_Map_Manager.mapActors-1;i++)	
		{ 	
			if (i > GameScreen.getStage().getActors().size-1){
			}
			else
			{
				GameScreen.getStage().getActors().get(i).setVisible(false);
			}
		}		
	}

	public void setOwned(Boolean b)
	{
		this.owned =b;
	}
}
