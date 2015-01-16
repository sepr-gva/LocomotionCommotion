package com.TeamHEC.LocomotionCommotion.UI_Elements;


import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_Manager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_TextureManager;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.Array;

public class TrainInfo extends Sprite{
	
	public static Label name, speed, routeRemaining;
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
		routeRemaining = new Label(null, style);
		
		planRoute = new SpriteButton(0, 0, Game_Map_TextureManager.getInstance().trainInfoPlanRoute){
			@Override
			protected void onClicked()
			{
				started = true;
			}
			

			@Override
			public void act(float delta){
				if(started){
					Game_Map_Manager.planBackground.setVisible(true);
					makeVisible(false);
					started=false;
				}
			}
		};
		
		actors.add(name);
		actors.add(speed);
		actors.add(routeRemaining);
		actors.add(planRoute);
	}
	
	public Array<Actor> getActors()
	{
		return actors;
	}
	
	public void showLabel(Train train)
	{
		float x = train.route.getTrainPos().x + 30;
		float y = train.route.getTrainPos().y - 50;
		
		this.setPosition(x, y);
		planRoute.setPosition(x + 22, y + 15);
		planRoute.refreshBounds();
		
		name.setPosition(x + 32, y + 142, Align.center);
		speed.setPosition(x + 93, y + 97, Align.center);
		routeRemaining.setPosition(x + 85, y + 57, Align.center);
		
		speed.setColor(Color.BLACK);
		routeRemaining.setColor(Color.BLACK);
		
		name.setText(train.getName());
		speed.setText(Integer.toString(train.getSpeed()));
		routeRemaining.setText(Float.toString(train.route.getLengthRemaining()));
		
		makeVisible(true);
	}
	
	public void makeVisible(boolean v)
	{
		this.setVisible(v);
		for(Actor a : actors)
		{
			a.setVisible(v);
		}
	}
}
