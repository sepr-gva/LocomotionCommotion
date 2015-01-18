package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.TeamHEC.LocomotionCommotion.UI_Elements.SpriteButton;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Touchable;

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
					Game_startGameManager.selectLabel.setText(LocomotionCommotion.player2name + " please select your start station!");
					Game_startGameManager.player1 = false;
				}
				else	
				{
					selectedStation.texture=Game_Map_TextureManager.getInstance().p2Station;
					selectedStation.setOwned(true);
					Game_Map_Manager.hideInfoBox();
					
					selectedP1.setTouchable(Touchable.enabled);
					
					Game_startGameManager.selectLabel.setVisible(false);
					
					GameScreen.createCoreGame(tempP1Station, selectedStation.getStation());
					Game_startGameManager.startGame();
					Game_ScreenMenu.resourceActorManager.refreshResources();
					Game_startGameManager.inProgress = false;
					
					Game_startGameManager.selectLabel.setVisible(true);
					Game_startGameManager.getStartedWindow.setVisible(true);
					Game_startGameManager.getStartedWindow.actorX=130;
					Game_startGameManager.getStartedWindow.setTexture(Game_TextureManager.getInstance().game_start_getstartedwindow2);
					
					Game_startGameManager.selectLabel.setText(GameScreen.game.getPlayerTurn().getName()+" select a new Goal from the Goal Screen!");
					Game_startGameManager.selectLabel.setX(950);
				}
			}
			else
			{
				//Buy Stations in game
				if (GameScreen.game.getPlayerTurn().getGold()>= selectedStation.getStation().getBaseValue()){
					GameScreen.game.getPlayerTurn().purchaseStation(selectedStation.getStation());
					System.out.println(selectedStation.getStation().getOwner());				}
					Game_Map_Manager.hideInfoBox();
			}
			
		}
		started = false;
	}
}