package com.TeamHEC.LocomotionCommotion.UI_Elements;

import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class TrainInfo extends Sprite{
	
	public static Label name, speed, fuelPerTurn, routeRemaining;
	public LabelStyle style;
	
	public SpriteButton planRoute;
	
	public TrainInfo(float x, float y, Texture texture)
	{
		super(x, y, texture);
		
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
		
		planRoute = new SpriteButton(0, 0, null);
	}
	
	public void showLabel(Train train)
	{
		name.setText(train.getName());
		name.setAlignment(Align.center);
		speed.setText(String.format("%d", train.getSpeed()));
		speed.setAlignment(Align.center);
		//fuelPerTurn.setText(train.getFuelType().);
		fuelPerTurn.setAlignment(Align.center);
	}
}
