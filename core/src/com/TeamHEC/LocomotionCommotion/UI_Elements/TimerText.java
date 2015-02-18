package com.TeamHEC.LocomotionCommotion.UI_Elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.Array;

public class TimerText {
	
	private final static Array<Actor> actors = new Array<Actor>();
	
	//Attributes for rendering timer
	private static FreeTypeFontGenerator generator;
	private static FreeTypeFontParameter parameter;
	private static BitmapFont timerFont;
	private static LabelStyle timerStyle;
	private static Label timerLabel;
	
	public void create(Stage stage, int xCoord, int yCoord){
		actors.clear();
		
		//Font for timer label
		generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 32;
		timerFont = generator.generateFont(parameter);
		generator.dispose();
		
		//Setting up timer label
		timerStyle = new LabelStyle();
		timerStyle.font = timerFont;
		timerLabel = new Label(null, timerStyle);
		timerLabel.setColor(0, 0, 0, 1);
		timerLabel.setAlignment(Align.center);
		timerLabel.setX(xCoord);
		timerLabel.setY(yCoord);
		timerLabel.setText("");
		
		actors.add(timerLabel);
		
		for (Actor a : actors){
			stage.addActor(a);
		}
	}
	
	public void setText(String text){
		timerLabel.setText(text);
	}
}
