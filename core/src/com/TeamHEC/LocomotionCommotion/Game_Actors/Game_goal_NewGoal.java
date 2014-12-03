package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Game_goal_NewGoal extends Actor {
	boolean started = false;
	private Texture texture;
	private float actorX;
	private float actorY;
	private boolean empty;
	public Game_goal_NewGoal( int actorY, int actorX, boolean empty){
		this.empty= empty;
		if (empty)
			this.texture = Game_TextureManager.game_menuobject_ticket;
		else
			this.texture = Game_TextureManager.game_menuobject_ticket;
			
		this.actorX = actorX;
		this.actorY = actorY;

		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((Game_goal_NewGoal)event.getTarget()).started = true;
				return true;
			}
		});

	}


	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(this.texture,actorX,actorY);
		

	}

	@Override
	public void act(float delta){
		if(started){
			started = false;
		}
	}


}
