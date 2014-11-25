package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_ActorManager {

	private final static Array<Actor> actors = new Array<Actor>();
	
	public static Game_menuobject_TopBar game_menuobject_topbar;
	public static Game_menuobject_MenuBtn game_menuobject_menubtn;
	


	public Game_ActorManager(){		}

	public static void create(Stage stage){
		game_menuobject_topbar = new Game_menuobject_TopBar();
		actors.add(game_menuobject_topbar);		
		
		game_menuobject_menubtn = new Game_menuobject_MenuBtn();
		actors.add(game_menuobject_menubtn);
		
		for (Actor a : actors){
			a.setTouchable(Touchable.enabled);
			stage.addActor(a);
		}
			

	}
	
	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */
	public static void saveActors()
	{
		
		
	}


}

