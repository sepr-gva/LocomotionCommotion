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
	//temp
	private SM_PrefScreen prefscreen;
	private SM_NewGameScreen newgamescreen;
	
	
	private int h = LocomotionCommotion.HEIGHT;
	
	
	public EntityManager(){
		//Lines
		mainpagelines = new SM_mainpageLines(new Vector2(-385, -930), new Vector2(0,0));
		entities.add(mainpagelines);
		//Start Menu title and buttons
		title = new Title(new Vector2(10,h-300), new Vector2(0,0));
		entities.add(title);
		newgame = new SM_NewGame(new Vector2(310, h-450), new Vector2(0,0));
		entities.add(newgame);
		loadgame = new SM_LoadGame(new Vector2(309, h-550), new Vector2(0,0));
		entities.add(loadgame);
		preferences = new SM_Preferences(new Vector2(309, h-650), new Vector2(0,0));
		entities.add(preferences);
		sm_howtoplay = new SM_HowToPlay(new Vector2(300, h-750), new Vector2(0,0));
		entities.add(sm_howtoplay);
		
		
		//temp
		prefscreen = new SM_PrefScreen(new Vector2(205, 44-h), new Vector2(0,0));
		entities.add(prefscreen);
		newgamescreen = new SM_NewGameScreen(new Vector2(-154, 65+h), new Vector2(0,0));
		entities.add(newgamescreen);
	}
	
	public void update(){
		for (Entity e: entities)
			e.update();
		
	}
	
	public void render(SpriteBatch sb){
		for (Entity e: entities){
			e.render(sb);
		} 
	}
	
	public void addEntity(Entity entity){
		entities.add(entity);
	}
	

}
