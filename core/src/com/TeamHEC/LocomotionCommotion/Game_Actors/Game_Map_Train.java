package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Game_Map_Train extends Actor{
	
	private Train train;
	private Texture texture, toggleTexture1, toggleTexture2;
	private float offset;
	
	public Game_Map_Train(Train train)
	{
		this.train = train;
		if(train.getOwner().isPlayer1)
		{
			toggleTexture1 = Game_Map_TextureManager.getInstance().p1Train;
			toggleTexture2 = Game_Map_TextureManager.getInstance().p1Trainx2;
		}
		else
		{
			toggleTexture1 = Game_Map_TextureManager.getInstance().p2Train;
			toggleTexture2 = Game_Map_TextureManager.getInstance().p2Trainx2;
		}
		texture = toggleTexture1;
		
		addListener(new InputListener(){
			public void enter(InputEvent event, float x, float y, int pointer, Actor Game_Map_Station) {
				((Game_Map_Train)event.getTarget()).toggleHighlight(true);
			}

		});
		addListener(new InputListener(){
			public void exit(InputEvent event, float x, float y, int pointer, Actor Game_Map_Station) {
				((Game_Map_Train)event.getTarget()).toggleHighlight(false);
			}

		});
		
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(1));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(1));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(1));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(1));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(1));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(1));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
	}
	
	public void toggleHighlight(boolean highlighted)
	{
		if(highlighted)
		{
			texture = toggleTexture2;
			offset = -2.5f;
		}
		else
		{
			texture = toggleTexture1;
			offset = 0;
		}
	}
	
	@Override
	public void act(float delta){
		if(!train.route.isComplete())
		{
			train.moveTrain();
		}
	}
	
	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(this.texture, train.route.getTrainPos().x + offset, train.route.getTrainPos().y + offset);
	}
	
}
