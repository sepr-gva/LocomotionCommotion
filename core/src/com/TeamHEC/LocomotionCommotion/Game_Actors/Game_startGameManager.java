package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
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

public class Game_startGameManager {

	private final static Array<Actor> actors = new Array<Actor>();
	public static int stagestart ;
	public static int startGameActors;
	public static Label selectLabel;
	public static boolean player1 = true, inProgress = true;

	public Game_startGameManager(){	}

	public void create(Stage stage){
		actors.clear();
		stagestart =0;
		startGameActors=0;
		player1= true;
		inProgress = true;

		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 40;

		BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose();
		LabelStyle style = new LabelStyle();
		style.font = font;

		selectLabel = new Label(null, style);
		selectLabel.setText(GameScreen.player1name+"  please select your start station!");
		selectLabel.setColor(0,0,0,1);
		selectLabel.setAlignment(Align.center);
		selectLabel.setX(800);
		selectLabel.setY(950);

		actors.add(selectLabel);

		stagestart= stage.getActors().size;
		for (Actor a : actors){
			a.setTouchable(Touchable.enabled);
			stage.addActor(a);
			startGameActors ++;
		}

	}

	public static void startGame(){
	
		for(int i=Game_menuObject_AManager.menuobjectsStageStart; i<=Game_menuObject_AManager.menuobjectsStageEnd-1;i++)	
		{ 	
			if (i > GameScreen.getStage().getActors().size-1)
			{//This is just to avoid range errors
			}
			else
				GameScreen.getStage().getActors().get(i).setVisible(true);
		}			

				
	}
	
	public static void reset(){
		actors.clear();
		stagestart =0;
		startGameActors=0;
		player1= true;
		inProgress = true;
	}







}
