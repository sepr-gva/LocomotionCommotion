package com.TeamHEC.LocomotionCommotion.Game_Actors;
/*
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * 
 */

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
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
import com.badlogic.gdx.utils.Array;

public class Game_menuObject_AManager {

	private final static Array<Actor> actors = new Array<Actor>();
	
	public static Game_menuobject_TopBar game_menuobject_topbar;
	public static Game_menuobject_MenuBtn game_menuobject_menubtn;
	public static Game_menuobject_Ticket1 game_menuobject_ticket;
	public static Game_menuobject_ResourcesBar game_menuobject_resourcesbar;
	
	public static Game_menuobject_TicketToggleBtn game_menuobject_tickettoggle;
	public static Game_menuobject_EndTurnBtn game_menuobject_endturnbutton;
	public static Game_menuobject_CornerFrame game_menuobject_cornerframe;
	public static Game_menuobject_InfoToggleBtn game_menuobject_infobutton;
	
	public static Game_menuobject_ShopBtn game_menuobject_shopbtn;
	public static Game_menuobject_TrainDepotBtn game_menuobject_traindepotbtn;
	
	public static Game_menuobjects_GoalScreenBtn game_menuobject_goalscreenbtn;
	public static Label playerScore;
	


	public Game_menuObject_AManager(){		}

	public void create(Stage stage){
		actors.clear();
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 32;
		
		BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose();
		LabelStyle style = new LabelStyle();
		style.font = font;
		
		
		playerScore = new Label(null, style);
		playerScore.setColor(0,0,0,1);
		playerScore.setText(GameScreen.player1name+"    " + GameScreen.player1score +
							"     SCORE     "+ GameScreen.player2score+"     "+GameScreen.player2name );
		playerScore.setX(600);
		playerScore.setY(LocomotionCommotion.screenY-90);
		
		
		game_menuobject_topbar = new Game_menuobject_TopBar();
		actors.add(game_menuobject_topbar);		
		
		game_menuobject_menubtn = new Game_menuobject_MenuBtn();
		actors.add(game_menuobject_menubtn);
		
		game_menuobject_tickettoggle=new Game_menuobject_TicketToggleBtn();
		actors.add(game_menuobject_tickettoggle);
		
		
		game_menuobject_cornerframe=new Game_menuobject_CornerFrame();
		actors.add(game_menuobject_cornerframe);
		
		game_menuobject_endturnbutton=new Game_menuobject_EndTurnBtn();
		actors.add(game_menuobject_endturnbutton);
		
		
		game_menuobject_infobutton=new Game_menuobject_InfoToggleBtn();
		actors.add(game_menuobject_infobutton);
		
		
		game_menuobject_shopbtn = new Game_menuobject_ShopBtn();
		actors.add(game_menuobject_shopbtn);
		
		game_menuobject_traindepotbtn = new Game_menuobject_TrainDepotBtn();
		actors.add(game_menuobject_traindepotbtn);
		
		game_menuobject_goalscreenbtn = new Game_menuobjects_GoalScreenBtn();
		actors.add(game_menuobject_goalscreenbtn);
		
		actors.add(playerScore);
		
		
		for (Actor a : actors){
			a.setTouchable(Touchable.enabled);
			stage.addActor(a);
		}
		
			

	}
	
	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */
	public static void saveActors()
	{
		
		
	}


}

