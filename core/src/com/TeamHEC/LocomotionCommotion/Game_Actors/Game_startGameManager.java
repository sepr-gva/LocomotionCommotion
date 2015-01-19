package com.TeamHEC.LocomotionCommotion.Game_Actors;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.TeamHEC.LocomotionCommotion.Goal.GoalFactory;
import com.TeamHEC.LocomotionCommotion.Goal.GoalMenu;
import com.TeamHEC.LocomotionCommotion.Goal.PlayerGoals;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.TeamHEC.LocomotionCommotion.UI_Elements.SpriteButton;
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
	public static SpriteButton getStartedWindow;

	public Game_startGameManager(){}

	public void create(Stage stage)
	{
		actors.clear();
		stagestart =0;
		startGameActors=0;
		player1= true;
		inProgress = true;

		getStartedWindow= new SpriteButton(300,400,Game_TextureManager.getInstance().game_start_getstartedwindow){
			@Override
			protected void onClicked(){
				Game_startGameManager.selectLabel.setVisible(false);
				this.setVisible(false);
				
			}
		};
		actors.add(getStartedWindow);

		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 40;

		BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose();
		LabelStyle style = new LabelStyle();
		style.font = font;

		selectLabel = new Label(null, style);
		selectLabel.setText(LocomotionCommotion.player1name + " please select your start station!");
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

	public static void startGame(){

		for(int i=GameScreen_ActorManager.getStageStart(); i<=GameScreen_ActorManager.getStageEnd();i++)	
		{ 	
			if (i > GameScreen.getStage().getActors().size-1)
			{//This is just to avoid range errors
			}
			else
				GameScreen.getStage().getActors().get(i).setVisible(true);
		}

		//Handle Text within Game
		//Score and Who's Turn it is
		GameScreen_ActorManager.playerScore.setText(GameScreen.game.getPlayer1().getName()+"    " + 0 +
				"     SCORE     "+ 0+"     "+GameScreen.game.getPlayer2().getName());
		GameScreen_ActorManager.currentPlayerName.setText(GameScreen.game.getPlayerTurn().getName()+"'s TURN");
		//Resources
		GameScreen_ActorManager.goldQuant.setText(""+GameScreen.game.getPlayerTurn().getGold());
		GameScreen_ActorManager.coalQuant.setText(""+GameScreen.game.getPlayerTurn().getFuel("Coal"));
		GameScreen_ActorManager.oilQuant.setText(""+GameScreen.game.getPlayerTurn().getFuel("Oil"));
		GameScreen_ActorManager.electricityQuant.setText(""+GameScreen.game.getPlayerTurn().getFuel("Electric"));
		GameScreen_ActorManager.nuclearQuant.setText(""+GameScreen.game.getPlayerTurn().getFuel("Nuclear"));
		GameScreen_ActorManager.cardQuant.setText(""+GameScreen.game.getPlayerTurn().getCards().size());

		GameScreen_ActorManager.game_card_togglebtn.setVisible(true);
		GameScreen_ActorManager.cardQuant.setVisible(true);
		PlayerGoals.changePlayer(GameScreen.game.getPlayerTurn());
		fillGoalScreen();
	}

	public static void fillGoalScreen(){
		ArrayList<Goal> goals = new ArrayList<Goal>();
		GoalFactory factory = new GoalFactory();
		
		for (int i=0; i<9; i++){
				goals.add(factory.CreateRandomGoal());
		}
		GoalMenu.AddGoalToScreen(goals);
	}
	public static void reset(){
		actors.clear();
		stagestart =0;
		startGameActors=0;
		player1= true;
		inProgress = true;
	}

}
