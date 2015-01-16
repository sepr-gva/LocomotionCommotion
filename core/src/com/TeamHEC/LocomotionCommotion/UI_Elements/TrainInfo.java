package com.TeamHEC.LocomotionCommotion.UI_Elements;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_TextureManager;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.Array;

public class TrainInfo extends Sprite{
	
	public static Label name, speed, fuelPerTurn, routeRemaining;
	public LabelStyle style;
	public SpriteButton planRoute;
	
	public Array<Actor> actors = new Array<Actor>();
	
	public TrainInfo()
	{
		super(0, 0, Game_Map_TextureManager.getInstance().trainInfo);
		
		//Stuff for Labels
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 23;

		BitmapFont font = generator.generateFont(parameter); 
		generator.dispose();
		style = new LabelStyle();
		style.font = font;
		
		name = new Label(null, style);
		speed = new Label(null, style);
		fuelPerTurn = new Label(null, style);
		routeRemaining = new Label(null, style);
		
		planRoute = new SpriteButton(0, 0, Game_Map_TextureManager.getInstance().trainInfoPlanRoute);
		
		actors.add(name);
		actors.add(speed);
		actors.add(fuelPerTurn);
		actors.add(planRoute);
	}
	
	public Array<Actor> getActors()
	{
		return actors;
	}
	
	public void showLabel(Train train)
	{
		for(Actor a : actors)
		{
			a.setVisible(true);
		}
		
		planRoute.setPosition(train.route.getTrainPos().x, train.route.getTrainPos().y);
				
		name.setText(train.getName());
		name.setAlignment(Align.center);
		speed.setText(String.format("%d", train.getSpeed()));
		speed.setAlignment(Align.center);
		fuelPerTurn.setText(String.format("%d", train.getFuelPerTurn()));
		fuelPerTurn.setAlignment(Align.center);
	}
}
