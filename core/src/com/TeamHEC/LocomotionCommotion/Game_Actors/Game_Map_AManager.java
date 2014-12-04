package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_Map_AManager {

	private final static Array<Actor> actors = new Array<Actor>();
	
	public static Game_Map tempMap;
	public static Game_Map_Info mapInfo;
	
	public static boolean infoVisible= false;
	public static int  stagestart, mapActors;
	


	public Game_Map_AManager(){	}
	
	public void create(Stage stage){
		
		actors.clear();
		stagestart =0;
		mapActors=0;
		tempMap = new Game_Map();		
		actors.add(tempMap);
		
		

		
		
		for (Actor a : actors){
			a.setTouchable(Touchable.enabled);
			stage.addActor(a);
			mapActors ++;
		}
		
		stagestart= stage.getActors().size;
		mapInfo = new Game_Map_Info();
		mapInfo.setVisible(infoVisible);
		stage.addActor(mapInfo);

	}
	
	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */
	


}

