package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_ShopManager {

	private final static Array<Actor> actors = new Array<Actor>();
	
	public static Game_shop_Backdrop game_shop_backdrop;
	public static Game_shop_BackBtn game_shop_backbtn;
	public static Game_shop_Title game_shop_title;
	
	
	public static boolean open=false;
	
	public static int  stagestart, shopActors;


	public Game_ShopManager(){	}
		
	public void create(Stage stage){
		actors.clear();
		stagestart =0;
		shopActors=0;
		game_shop_backdrop = new Game_shop_Backdrop();
		actors.add(game_shop_backdrop);
		game_shop_backbtn = new Game_shop_BackBtn();
		actors.add(game_shop_backbtn);
		game_shop_title = new Game_shop_Title();
		actors.add(game_shop_title);
		

	
	
		
		stagestart= stage.getActors().size;
		for (Actor a : actors){
			if(open == true){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);}
			else
				a.setVisible(false);

			stage.addActor(a);
			shopActors ++;
		}
			

	}
	
	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */


	
	


}

