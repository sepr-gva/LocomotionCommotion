package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Game_Map_Train extends Actor{
	
	private Train train;
	private Texture texture;
	
	public Game_Map_Train(Train train)
	{
		this.train = train;
		texture = Game_Map_TextureManager.p1Train;
		
		System.out.println(String.format("%f and %f", train.route.getTrainPos().x, train.route.getTrainPos().y));
	}
	
	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(this.texture, train.route.getTrainPos().x, train.route.getTrainPos().y);
	}
	
}
