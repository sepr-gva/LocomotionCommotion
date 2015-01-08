package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_Map_Manager {

	private final static Array<Actor> actors = new Array<Actor>();
	
	public static Map map;
	public static Game_Map_Info mapInfo;
	
	public static boolean infoVisible= false;
	public static int  stagestart, mapActors;
	
	public Game_Map_Manager(){	}
	
	public void create(Stage stage){
		
		actors.clear();
		stagestart =0;
		mapActors=0;
		map = new Map();		
		actors.add(map);
		
		stagestart= stage.getActors().size;
		for (Actor a : actors){
			a.setTouchable(Touchable.enabled);
			stage.addActor(a);
			mapActors ++;
		}
		
		mapInfo = new Game_Map_Info();
		mapInfo.setVisible(infoVisible);
		stage.addActor(mapInfo);
	}
	
	public class Map extends Actor {

		public Texture texture = Game_Map_TextureManager.map; // reuse the new game back btn texture
		public float actorX =100;
		public float actorY = 60;
		public boolean started = false;
		

		public Map(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_Map)event.getTarget()).started = true;
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
				started = false;
			}
		}
	}
}
		
	
	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */



