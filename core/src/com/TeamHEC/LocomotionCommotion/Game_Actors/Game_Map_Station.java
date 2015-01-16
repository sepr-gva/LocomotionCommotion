package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.StationListener;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;

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
		if(!highlighted)
		{	
			highlighted = true;
			showInfoBox();
			Game_Map_StationBtn.selectedStation = this;
		}
		else
		{
			highlighted = false;
			hideInfoBox();
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
				// Sets the labels to info from each station:
				Game_Map_Manager.stationLabelName.setText(station.getName());
				Game_Map_Manager.stationLabelCost.setText(String.format("%d", station.getTotalRent()));
				Game_Map_Manager.stationLabelFuel.setText(String.format("%d * %s", station.getResourceType().getValue(), station.getResourceString()));
				
				GameScreen.getStage().getActors().get(i).setVisible(true);
				Game_Map_Manager.moveInfoBox(this.actorX-180, this.actorY-80);
			}
		}		
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
