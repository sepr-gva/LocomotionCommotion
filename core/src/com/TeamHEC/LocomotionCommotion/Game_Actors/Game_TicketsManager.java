package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Array;

public class Game_TicketsManager {

	private final static Array<Actor> actors = new Array<Actor>();
	
	public static Game_menuobject_Ticket game_menuobject_ticket;
	
	public static boolean open=false;
	


	public Game_TicketsManager(){		}

	public static void create(Stage stage){
		
		game_menuobject_ticket = new Game_menuobject_Ticket();
		if (open == false){
			Game_menuobject_Ticket.actorX=- 1000;
		}
		actors.add(game_menuobject_ticket);
		
		//Temp Ticket solution
		BitmapFont font = new BitmapFont();
		LabelStyle style = new LabelStyle();
		Label text;
		style.font = font;
		text = new Label(null, style);
		text.setText( "Passenger                   50 Points"
					+ "\n\n"
				    + "London                      TURN 3   "
				    + "\n\n"
				    + "Athens                        ANY"
					);
		text.setColor(0,0,0,1);
		text.setScale(0.9f);
		text.setX(Game_menuobject_Ticket.actorX +7);
		text.setY(Game_menuobject_Ticket.actorY +64);
		actors.add(text);
	
		
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

