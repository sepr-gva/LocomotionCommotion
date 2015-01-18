package com.TeamHEC.LocomotionCommotion.UI_Elements;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
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

public class WarningMessage {
	
	static LabelStyle titleStyle, bodyStyle;
	static Label titleLabel, bodyLabel;
	static SpriteButton window;
	
	static Stage stage;
	static Array<Actor> actors = new Array<Actor>();
	
	public void create(Stage stage)
	{	
		WarningMessage.stage = stage;
		
		window = new SpriteButton(300,400,Game_TextureManager.getInstance().game_warningwindow){
			@Override
			protected void onClicked(){
				killWarningWindow();
			}
		};
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 40;

		BitmapFont titlefont = generator.generateFont(parameter); 
		parameter.size = 32;
		BitmapFont bodyfont = generator.generateFont(parameter); 
		generator.dispose();
		
		titleStyle = new LabelStyle();
		bodyStyle = new LabelStyle();
		
		titleStyle.font = titlefont;
		bodyStyle.font = bodyfont;
		
		titleLabel = new Label(null, titleStyle);
		titleLabel.setColor(0,0,0,1);
		titleLabel.setAlignment(Align.center);
		titleLabel.setX(790);
		titleLabel.setY(630);
		titleLabel.setText("");
		
		bodyLabel = new Label(null, bodyStyle);
		bodyLabel.setColor(0,0,0,1);
		bodyLabel.setAlignment(Align.center);
		bodyLabel.setX(790);
		bodyLabel.setY(575);
		bodyLabel.setText("");
		
		window.setVisible(false);
		titleLabel.setVisible(false);
		bodyLabel.setVisible(false);
		
		actors.add(window);
		actors.add(bodyLabel);
		actors.add(titleLabel);
	}
	
	public static void fireWarningWindow(String title, String body)
	{
		stage.getActors().addAll(actors);
		
		window.setVisible(true);
		titleLabel.setVisible(true);
		titleLabel.setText(title);
		bodyLabel.setVisible(true);
		bodyLabel.setText(body);
	}
	public static void killWarningWindow()
	{	
		window.setVisible(false);
		titleLabel.setVisible(false);
		titleLabel.setText("");
		bodyLabel.setVisible(false);
		titleLabel.setText("");
		
		for(Actor a: actors)
		{
			stage.getActors().removeValue(a, true);
		}
	}
}
