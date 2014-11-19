package com.TeamHEC.LocomotionCommotion.entity;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class EntityManager {
	
	private final Array<Entity> entities = new Array<Entity>();
	//Start Menu Entities
	private final Title title;
	private SM_NewGame newgame;
	private SM_LoadGame loadgame;
	private SM_Preferences preferences;
	private SM_HowToPlay sm_howtoplay;
	private SM_mainpageLines mainpagelines;
	private int h = LocomotionCommotion.HEIGHT;
	
	
	public EntityManager(){
		//Start Menu title and buttons
		title = new Title(new Vector2(10,h-300), new Vector2(0,0));
		newgame = new SM_NewGame(new Vector2(310, h-450), new Vector2(0,0));
		loadgame = new SM_LoadGame(new Vector2(309, h-550), new Vector2(0,0));
		preferences = new SM_Preferences(new Vector2(309, h-650), new Vector2(0,0));
		sm_howtoplay = new SM_HowToPlay(new Vector2(300, h-750), new Vector2(0,0));
		//Lines
		mainpagelines = new SM_mainpageLines(new Vector2(-385, -1116), new Vector2(0,0));
	}
	
	public void update(){
		for (Entity e: entities)
			e.update();
		title.update();
		newgame.update();
		loadgame.update();
		preferences.update();
		sm_howtoplay.update();
		mainpagelines.update();
		
		
		
	}
	
	public void render(SpriteBatch sb){
		for (Entity e: entities){
			e.render(sb);
		} 
		title.render(sb); 
		newgame.render(sb);
		loadgame.render(sb);
		preferences.render(sb);
		sm_howtoplay.render(sb);
		mainpagelines.render(sb);
	}
	
	public void addEntity(Entity entity){
		entities.add(entity);
	}
	

}
