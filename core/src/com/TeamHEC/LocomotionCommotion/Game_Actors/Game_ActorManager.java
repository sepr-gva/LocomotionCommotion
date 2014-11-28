package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Array;

public class Game_ActorManager {

	private final static Array<Actor> actors = new Array<Actor>();
	
	public static Game_menuobject_TopBar game_menuobject_topbar;
	public static Game_menuobject_MenuBtn game_menuobject_menubtn;
	public static Game_menuobject_Ticket1 game_menuobject_ticket;
	public static Game_menuobject_ResourcesBar game_menuobject_resourcesbar;
	
	public static Game_menuobject_TicketToggleBtn game_menuobject_tickettoggle;
	public static Game_menuobject_EndTurnBtn game_menuobject_endturnbutton;
	public static Game_menuobject_CornerFrame game_menuobject_cornerframe;
	public static Game_menuobject_InfoToggleBtn game_menuobject_infobutton;
	
	public static int coal, oil, electricy, nuclear;


	public Game_ActorManager(){		}

	public static void create(Stage stage){
		game_menuobject_topbar = new Game_menuobject_TopBar();
		actors.add(game_menuobject_topbar);		
		
		game_menuobject_menubtn = new Game_menuobject_MenuBtn();
		actors.add(game_menuobject_menubtn);
		
		game_menuobject_tickettoggle=new Game_menuobject_TicketToggleBtn();
		actors.add(game_menuobject_tickettoggle);
		
		
		
		BitmapFont font = new BitmapFont();
		LabelStyle style = new LabelStyle();
		Label  resourcesQuant;
		style.font = font;
	
		//End
		
		//Resources bar is now connected to variables for easy update of quantities.
		game_menuobject_resourcesbar = new Game_menuobject_ResourcesBar();
		actors.add(game_menuobject_resourcesbar);
		String spacing = "                              ";
		resourcesQuant = new Label(null,style);
		resourcesQuant.setText(coal+spacing+ oil +spacing+electricy+spacing+nuclear);
		resourcesQuant.setColor(0,0,0,1);
		resourcesQuant.setScale(0.9f);
		resourcesQuant.setX(90);
		resourcesQuant.setY(40);
		actors.add(resourcesQuant);
		
		game_menuobject_cornerframe=new Game_menuobject_CornerFrame();
		actors.add(game_menuobject_cornerframe);
		
		game_menuobject_endturnbutton=new Game_menuobject_EndTurnBtn();
		actors.add(game_menuobject_endturnbutton);
		
		game_menuobject_infobutton=new Game_menuobject_InfoToggleBtn();
		actors.add(game_menuobject_infobutton);
		
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

