package com.TeamHEC.LocomotionCommotion.Actors;

import com.TeamHEC.LocomotionCommotion.entity.NewGameActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class NewGameActor {
	class NewGameActor extends Actor {
        Texture newgame = new Texture(Gdx.files.internal("sm_newgame.png"));
        float actorX = 310, actorY = 600;
        public boolean started = false;

        public NewGameActor(){
            setBounds(actorX,actorY,newgame.getWidth(),newgame.getHeight());
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
            batch.draw(newgame,actorX,actorY);
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
    }
}
    private Stage stage;
  public void create() {        
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        
        NewGameActor newGameActor = new NewGameActor();
        newGameActor.setTouchable(Touchable.enabled);
        stage.addActor(newGameActor);
        
    }

}
