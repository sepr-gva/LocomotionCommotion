package com.TeamHEC.LocomotionCommotion.UI_Elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.Array;

public class TimerText {
	//Creates labels using Gills Sans that can be added to the GameScreen stage and rendered at some x, y.
	//Intended to be used for the game timer and turn timer. The former of these is fully implemented.
	
	private final static Array<Actor> actors = new Array<Actor>();
	
	//Attributes for rendering timer
	private static FreeTypeFontGenerator generator;
	private static FreeTypeFontParameter parameter;
	private static BitmapFont timerFont;
	private static LabelStyle timerStyle;
	private static Label timerLabel1, timerLabel2;
	
	public void create(Stage stage){
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
		
		timerLabel1 = new Label(null, timerStyle);
		timerLabel1.setColor(0, 0, 0, 1);
		timerLabel1.setAlignment(Align.left);
		timerLabel1.setX(1360);
		timerLabel1.setY(330);
		timerLabel1.setText("");
		
		actors.add(timerLabel1);
		
		timerLabel2 = new Label(null, timerStyle);
		timerLabel2.setColor(0, 0, 0, 1);
		timerLabel2.setAlignment(Align.left);
		timerLabel2.setX(1360);
		timerLabel2.setY(367);
		timerLabel2.setText("");
		
		actors.add(timerLabel2);
		
		for (Actor a : actors){
			stage.addActor(a);
		}
	}
	
	public void setText1(String text){
		timerLabel1.setText(text);
	}
	
	public void setText2(String text){
		timerLabel2.setText(text);
	}
}
