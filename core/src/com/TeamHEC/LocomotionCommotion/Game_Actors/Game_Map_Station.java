package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.StationListener;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Game_Map_Station extends Game_Map_MapObj implements StationListener {

	public boolean owned;
	private Station station;
	
	public float offset = 0;

	public Game_Map_Station(Station station, float actorX, float actorY)
	{
		this.texture = Game_Map_TextureManager.getInstance().station;
		this.toggleTexture1 = Game_Map_TextureManager.getInstance().station;
		this.toggleTexture2 = Game_Map_TextureManager.getInstance().stationx2;
		this.station = station;
		this.actorX = actorX;
		this.actorY = actorY;
		
		station.register(this);
		this.owned = false;
	
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());

		// Shows station info box on click:
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((Game_Map_Station)event.getTarget()).started = true;
				return true;
			}
		});
		addListener(new InputListener(){
			public void enter(InputEvent event, float x, float y, int pointer, Actor Game_Map_Station) {
				((Game_Map_Station)event.getTarget()).toggleHighlight(true);
			}

		});
		addListener(new InputListener(){
			public void exit(InputEvent event, float x, float y, int pointer, Actor Game_Map_Station) {
				((Game_Map_Station)event.getTarget()).toggleHighlight(false);
			}

		});
	}
	
	public void toggleHighlight(boolean highlighted)
	{
		if(highlighted)
		{
			texture = toggleTexture2;
			offset = -2.5f;
		}
		else
		{
			texture = toggleTexture1;
			offset = 0;
		}
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
	public void act(float delta){
		if(started){
			if(this.highlighted==false)
			{	
				toggleHighlight(false);
				showInfoBox();
				Game_Map_StationBtn.selectedStation = this;
			}
			else
			{
				toggleHighlight(true);
				hideInfoBox();
			}
			started = false;
		}
	}

	public void resetHighlight(){
		if(owned){
			
		}
		else if (highlighted)
		{
			this.texture= Game_Map_TextureManager.getInstance().station;
			this.actorX+=2.5;
			this.actorY+=2.5;
			this.highlighted = false;
		}

	}

	public void showInfoBox(){
		for(int i=Game_Map_Manager.stagestart; i<=Game_Map_Manager.stagestart +Game_Map_Manager.mapActors-1;i++)	
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
	
	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(this.texture, actorX + offset, actorY + offset);
	}
}
