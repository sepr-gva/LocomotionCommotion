package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Game_Map_Station extends Game_Map_MapObj{

	public Texture texture;
	public float actorX, actorY;
	public boolean started, highlighted;

	public  Game_Map_Station (MapObj station, float actorX, float actorY ){
		this.texture = Game_Map_TextureManager.station;
		this.mapObj = station;
		this.actorX = actorX;
		this.actorY = actorY;
		this.highlighted = false;
		this.started = false;
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());

		// Shows station info box on click:
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				//((Game_Map_Station)event.getTarget()).showInfoBox();
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
	
	public void setOwnerTexture(Player player)
	{
		if(player == null)
			texture = Game_Map_TextureManager.station;
		else if(player.equals(GameScreen.game.getPlayer1()))
		{
			texture = Game_Map_TextureManager.station;
		}
		else
		{
			texture = Game_Map_TextureManager.station;
		}
	}
	
	public void toggleHighlight(boolean highlighted)
	{
		if(highlighted)
		{
			showInfoBox();
			texture = Game_Map_TextureManager.stationx2;
			actorX -= 2.5;
			actorY -= 2.5;
		}
		else
		{
			hideInfoBox();
			texture = Game_Map_TextureManager.station;
			actorX += 2.5;
			actorY += 2.5;
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
				Game_Map_Manager.stationLabelName.setText(mapObj.getName());
				Game_Map_Manager.stationLabelCost.setText(String.format("%d", mapObj.getTotalRent()));
				Game_Map_Manager.stationLabelFuel.setText(String.format("%d * %s", mapObj.getFuelType().getValue(), mapObj.getFuelString()));
				
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
	
	@Override
	public void act(float delta){
		if(started)
		{
			started = false;
		}
	}
	
	/*
	@Override
	public void act(float delta){
		if(started){
			if(this.highlighted==false){
				Game_Map_Manager.resetStations();
				toggleHighlight();
				showInfoBox();
				Game_Map_Manager.selectedStation=this;
			}
			else{
				toggleHighlight();
				hideInfoBox();
			}
			started = false;
		}
	}
	public void resetHighlight(){
		if (highlighted){
			this.texture=Game_Map_TextureManager.station;
			this.actorX+=2.5;
			this.actorY+=2.5;
			this.highlighted = false;
		}

	}
	public void toggleHighlight(){
		if (this.highlighted){
			this.texture=Game_Map_TextureManager.station;
			this.actorX+=2.5;
			this.actorY+=2.5;
			this.highlighted = false;
		}
		else{
			this.texture=Game_Map_TextureManager.stationx2;
			this.actorX-=2.5;
			this.actorY-=2.5;
			this.highlighted = true;

		}
	}

	public void setStarted(Boolean b){
		this.started =b;
	}
	*/
}
