package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
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
	public static Game_start_getStartedWindow getStartedWindow;

	public Game_startGameManager(){}

	public void create(Stage stage)
	{
		actors.clear();
		stagestart =0;
		startGameActors=0;
		player1= true;
		inProgress = true;

		getStartedWindow= new Game_start_getStartedWindow();
		actors.add(getStartedWindow);
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 40;

		BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose();
		LabelStyle style = new LabelStyle();
		style.font = font;

		selectLabel = new Label(null, style);
		selectLabel.setText(GameScreen.player1name + " please select your start station!");
		selectLabel.setColor(0,0,0,1);
		selectLabel.setAlignment(Align.center);
		selectLabel.setX(790);
		selectLabel.setY(575);

		actors.add(selectLabel);

		stagestart= stage.getActors().size;
		for (Actor a : actors){
			a.setTouchable(Touchable.enabled);
			stage.addActor(a);
			startGameActors ++;
		}

	}

	@SuppressWarnings("static-access")
	public static void startGame(){
	
		for(int i=Game_ScreenMenu.actorManager.getStageStart(); i<=Game_ScreenMenu.actorManager.getStageEnd();i++)	
		{ 	
			if (i > GameScreen.getStage().getActors().size-1)
			{//This is just to avoid range errors
			}
			else
				GameScreen.getStage().getActors().get(i).setVisible(true);
		}
		
		//Handle Text within Game
		//Score and Who's Turn it is
		Game_ScreenMenu.actorManager.playerScore.setText(GameScreen.player1name+"    " + GameScreen.player1score +
				"     SCORE     "+ GameScreen.player2score+"     "+GameScreen.player2name
				+"                      "+GameScreen.game.getPlayerTurn().getName()+" it's your turn ");
		//Resources
		Game_ScreenMenu.resourceActorManager.goldQuant.setText(""+GameScreen.game.getPlayerTurn().getGold());
		Game_ScreenMenu.resourceActorManager.coalQuant.setText(""+GameScreen.game.getPlayerTurn().getFuel("Coal"));
		Game_ScreenMenu.resourceActorManager.oilQuant.setText(""+GameScreen.game.getPlayerTurn().getFuel("Oil"));
		Game_ScreenMenu.resourceActorManager.electricityQuant.setText(""+GameScreen.game.getPlayerTurn().getFuel("Electricity"));
		Game_ScreenMenu.resourceActorManager.nuclearQuant.setText(""+GameScreen.game.getPlayerTurn().getFuel("Nuclear"));
		Game_ScreenMenu.resourceActorManager.cardQuant.setText(""+GameScreen.cards);
		
		Game_ScreenMenu.resourceActorManager.game_card_togglebtn.setVisible(true);
		Game_ScreenMenu.resourceActorManager.cardQuant.setVisible(true);
	}
	
	public static void reset(){
		actors.clear();
		stagestart =0;
		startGameActors=0;
		player1= true;
		inProgress = true;
	}
	
	public static class Game_start_getStartedWindow extends Game_Actor {
		public Game_start_getStartedWindow(){
			texture = Game_TextureManager.getInstance().game_start_getstartedwindow; 
			actorX = 300 ;
			actorY = 400;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_start_getStartedWindow)event.getTarget()).started = true;
					return true;
				}
			});

		}


		@Override
		public void draw(Batch batch, float alpha){
			batch.draw(texture,actorX,actorY);
		}

		@Override
		public void act(float delta){
			if(started){
				this.setVisible(false);
				Game_startGameManager.selectLabel.setVisible(false);
				started = false;
			}
		}
	}
}
