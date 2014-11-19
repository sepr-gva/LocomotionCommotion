package com.TeamHEC.LocomotionCommotion.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

class LoadGameActor extends Actor {
	//Texture
	Texture loadgame = new Texture(Gdx.files.internal("sm_loadgame.png"));
	float actorX = 310, actorY = 500; //Texture pos
	
	public boolean started = false;
	

	public LoadGameActor(){
		setBounds(actorX,actorY,loadgame.getWidth(),loadgame.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				if (((NewGameActor)event.getTarget()).started == false)
					((NewGameActor)event.getTarget()).started = true;
				else
					((NewGameActor)event.getTarget()).started = false;
				return true;
			}
		});
	}


	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(loadgame,actorX,actorY);
	}

	@Override
	public void act(float delta){
		if(started){
			if (actorX < Gdx.graphics.getWidth())
				actorX+=5;
			else
				actorX=0;

		}
	}
	public  NewGameActor create(){
		NewGameActor newGameActor = new NewGameActor();
		newGameActor.setTouchable(Touchable.enabled);
		return newGameActor;
	}
	
	public void render(SpriteBatch sb){
		
	}
	public void update() {
		 }
}


