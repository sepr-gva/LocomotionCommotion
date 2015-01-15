package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.TeamHEC.LocomotionCommotion.UI_Elements.SpriteButton;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Touchable;

/*
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * This is an Actor- meaning it's given texture is displayed on the stage and actions (acts) can be performed.
 * @param texture	The image used for the Actor pulled in from SM_TextureManager (see documentation)
 * @param x	The x coordinate of the bottom left corner of the image
 * @param y	The y coordinate of the bottom left corner of the image
 *
 */

public class Game_Map_StationBtn extends SpriteButton {

	public boolean exit = false;

	// Used to hold player1s selection:
	public static Game_Map_Station selectedStation, selectedP1;
	private static Station tempP1Station;

	public Game_Map_StationBtn(float x, float y, Texture texture)
	{
		super(x, y, texture);	
	}
	
	@Override
	protected void onClicked()
	{
		started = true;
	}
		
	@Override
	public void act(float delta){
		if(started){
			if(Game_startGameManager.inProgress)
			{
				selectedStation.actorX -= 2.5;
				selectedStation.actorY -= 2.5;
				
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
					
					Game_startGameManager.selectLabel.setVisible(true);
					Game_startGameManager.getStartedWindow.setVisible(true);
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
					Game_startGameManager.selectLabel.setVisible(true);
					Game_startGameManager.getStartedWindow.setVisible(true);
					Game_startGameManager.getStartedWindow.actorX=100;
					Game_startGameManager.getStartedWindow.setTexture(Game_TextureManager.getInstance().game_start_getstartedwindow2);
					
					Game_startGameManager.selectLabel.setText(GameScreen.game.getPlayerTurn().getName()+"select a new Goal from the goalScreen");
				}
			}
		}
		started = false;
	}
}