package com.TeamHEC.LocomotionCommotion.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class ActorManager {
	private Stage stage;
	private final Array<Actor> actors = new Array<Actor>();

	NewGameActor newgame ;
	LoadGameActor loadgame;
	
	public void ActorManger(){	
		NewGameActor newgame = new NewGameActor();
		actors.add(newgame);
		LoadGameActor loadgame = new LoadGameActor();
		actors.add(loadgame);
	}
	
	public void create(){
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		for(Actor a: actors){
		stage.addActor(((NewGameActor) a).create());
		}
	
		
	}
	
	public void update(){
		
	}
	
	public void render(SpriteBatch sb){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();
	}
	
	public void addActor(Actor a){
		actors.add(a);
		
	}
}
