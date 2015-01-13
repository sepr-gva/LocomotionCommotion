package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Game_Map_Train extends Actor{
	
	private Train train;
	private Texture texture, toggleTexture1, toggleTexture2;
	
	public Game_Map_Train(Train train)
	{
		this.train = train;
		texture = Game_Map_TextureManager.getInstance().p1Train;
		
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
		train.route.addConnection(train.route.getAdjacentConnections().get(0));
			
		train.route.update(70);
	}
	
	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(this.texture, train.route.getTrainPos().x, train.route.getTrainPos().y);
	}
	
}
