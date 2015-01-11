package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
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

public class Game_Map_StationSelectBtn extends Actor {

	public static Texture texture = Game_Map_TextureManager.stationSelect;
	public  float actorX = 0 ,actorY = 0;
	public boolean started = false, highlighted=false, exit =false;
	Game_Map_Station tempPlayer1Station;


	public Game_Map_StationSelectBtn(){
		this.actorX=0;
		this.actorY=0;
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
			if (Game_startGameManager.inProgress){
				if (Game_startGameManager.player1){
					Game_Map_Manager.selectedStation.texture=Game_Map_TextureManager.stationp1;
					Game_Map_Manager.selectedStation.setOwned(true);
					Game_Map_Manager.hideInfoBox();
					tempPlayer1Station=Game_Map_Manager.selectedStation;
					Game_Map_Manager.selectedStation.setTouchable(Touchable.disabled);
					Game_Map_Manager.selectedStation=null;
					Game_startGameManager.selectLabel.setText(GameScreen.player2name+"  please select your start station!");
					Game_startGameManager.player1=false;
				}
				else
				{
					Game_Map_Manager.selectedStation.texture=Game_Map_TextureManager.stationp2;
					Game_Map_Manager.selectedStation.setOwned(true);
					Game_Map_Manager.hideInfoBox();
					tempPlayer1Station.setTouchable(Touchable.enabled);
					Game_startGameManager.selectLabel.setVisible(false);
					Game_startGameManager.startGame();
					Game_startGameManager.inProgress=false;

					
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