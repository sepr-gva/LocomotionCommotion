package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

/*
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * This is an Actor- meaning it's given texture is displayed on the stage and actions (acts) can be performed.
 * @param texture	The image used for the Actor pulled in from SM_TextureManager (see documentation)
 * @param actorX	The x coordinate of the bottom left corner of the image
 * @param actorY	The y coordinate of the bottom left corner of the image
 * @param started	Boolean used to show if an Actor has been interacted with. Used to stop and start interactions.
 * 
 * setBounds	This is the bounds for the interaction, we make it the whole image.
 * addListener	This adds a listener for a particular interaction in this case touchDown (click)
 * draw			Actor is drawn
 * act			The action taken if the listener detects interaction
 * 				Action- None
 */

public class Game_Map_StationSelectBtn extends Game_Map_MapObj {

	public boolean exit = false;

	// Used to hold player1s selection:
	public static Game_Map_Station selectedStation, selectedP1;
	private static Station tempP1Station;

	public Game_Map_StationSelectBtn()
	{
		this.actorX=0;
		this.actorY=0;
		this.texture = Game_Map_TextureManager.getInstance().stationSelect;
			
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((Game_Map_StationSelectBtn)event.getTarget()).started = true;
				return true;
			}
		});
	}
		
	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(texture,actorX,actorY);
	}

	@Override
	public void act(float delta){
		if(started){
			if(Game_startGameManager.inProgress)
			{
				if(Game_startGameManager.player1)
				{
					// Sets texture (could be done via listener?)
					
					selectedStation.texture = Game_Map_TextureManager.getInstance().p1Station;
					selectedStation.setOwned(true);
					Game_Map_Manager.hideInfoBox();
					
					tempP1Station = selectedStation.getStation();
					
					selectedStation.setTouchable(Touchable.disabled);
					selectedP1 = selectedStation;
					selectedStation = null;
					
					Game_startGameManager.selectLabel.setText(GameScreen.player2name + " please select your start station!");
					Game_startGameManager.player1 = false;
				}
				else
				{
					selectedStation.texture=Game_Map_TextureManager.getInstance().p2Station;
					selectedStation.setOwned(true);
					Game_Map_Manager.hideInfoBox();
					
					selectedP1.setTouchable(Touchable.enabled);
					
					Game_startGameManager.selectLabel.setVisible(false);
					
					Game_startGameManager.startGame();
					Game_startGameManager.inProgress = false;
					
					GameScreen.createCoreGame(tempP1Station, selectedStation.getStation());
				}
			}
		}
		started = false;
	}


public float getX (){
	return this.actorX;
}
public void setX(float x){
	this.actorX = x;

}
public float getY(){
	return this.actorY;
}
public void setY(float y){
	this.actorY = y;

}


public void refreshBounds(){
	setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());

}
}