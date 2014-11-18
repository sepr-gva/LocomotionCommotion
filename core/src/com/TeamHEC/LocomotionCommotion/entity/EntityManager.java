package com.TeamHEC.LocomotionCommotion.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class EntityManager {
	
	private final Array<Entity> entities = new Array<Entity>();
	private final Title title;
	private SM_NewGame newgame;
	
	
	public EntityManager(){
		title = new Title(new Vector2(10,900), new Vector2(0,0));
		newgame = new SM_NewGame(new Vector2(230, 15), new Vector2(0,0));
	}
	
	public void update(){
		for (Entity e: entities)
			e.update();
		title.update();
		newgame.update();
		
		
	}
	
	public void render(SpriteBatch sb){
		for (Entity e: entities){
			e.render(sb);
		} 
		title.render(sb); 
		newgame.render(sb);
	}
	
	public void addEntity(Entity entity){
		entities.add(entity);
	}
	

}
