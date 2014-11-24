package com.TeamHEC.LocomotionCommotion.Screens.SM_Actors;

import com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
import com.TeamHEC.LocomotionCommotion.Screens.SM_TextureManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class SM_newgame_StationDomBtn extends Actor {
	
	public static Texture texture = SM_TextureManager.sm_newgame_StationDom_unselected_Btn;
	public static float actorX = 660 ,actorY = 1150+530;
	public boolean started = false;

	public SM_newgame_StationDomBtn(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((SM_newgame_StationDomBtn)event.getTarget()).started = true;
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
			StartMenu.gameMode = "stationdomination";
			texture = SM_TextureManager.sm_newgame_StationDomBtn;
			SM_newgame_TurnTimeOutBtn.texture = SM_TextureManager.sm_newgameTurnTimeOut_unselected_Btn;
			started = false;
			
			
		}
	}
}