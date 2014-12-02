package com.TeamHEC.LocomotionCommotion.Game_Actors;


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

public class Game_TicketsManager {

	private final static Array<Actor> actors = new Array<Actor>();
	
	public static Game_menuobject_Ticket1 game_menuobject_ticket1;
	public static Game_menuobject_Ticket2 game_menuobject_ticket2;
	public static Game_menuobject_Ticket3 game_menuobject_ticket3;
	
	public static Game_menuobject_ticketenclosure game_menuobject_ticketenclosure;
	
	public static boolean open=false;
	
	public static int  stagestart, ticketActors;


	public Game_TicketsManager(){	}
		
	public void create(Stage stage){
		
		actors.clear();
		stagestart =0;
		ticketActors=0;
		
		game_menuobject_ticketenclosure=new Game_menuobject_ticketenclosure();
		actors.add(game_menuobject_ticketenclosure);
		
		game_menuobject_ticket1 = new Game_menuobject_Ticket1();		
		actors.add(game_menuobject_ticket1);
		
		game_menuobject_ticket2 = new Game_menuobject_Ticket2();		
		actors.add(game_menuobject_ticket2);
		
		game_menuobject_ticket3 = new Game_menuobject_Ticket3();		
		actors.add(game_menuobject_ticket3);

		
		
		
		//Temp Ticket solution
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 16;
		float textx= Game_menuobject_Ticket1.actorX +10;
		float texty= Game_menuobject_Ticket1.actorY +83;
		
		BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose();
		LabelStyle style = new LabelStyle();
		Label ticket1, ticket2, ticket3;
		style.font = font;
		ticket1 = new Label(null, style);
		ticket1.setText(ticketMaker("Passenger","50 Points","London","Turn 3", "Athens", " ANY"));
		ticket1.setColor(0,0,0,1);
		ticket1.setX(textx);
		ticket1.setY(texty);
		actors.add(ticket1);
		
		ticket2 = new Label(null, style);
		ticket2.setText(ticketMaker("Cargo","50 Points","Moscow","Turn 3", "Rome", " ANY"));
		ticket2.setColor(0,0,0,1);
		ticket2.setX(textx);
		ticket2.setY(texty-200);
		actors.add(ticket2);
		
		ticket3 = new Label(null, style);
		ticket3.setText(ticketMaker("Passenger","50 Points","Berlin","Turn 6", "Oslo", " ANY"));
		ticket3.setColor(0,0,0,1);
		ticket3.setX(textx);
		ticket3.setY(texty-400);
		actors.add(ticket3);
	
		
		stagestart= stage.getActors().size;
		for (Actor a : actors){
			if(open == true){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);}
			else
				a.setVisible(false);

			stage.addActor(a);
			ticketActors ++;
		}
		
	

	}
	
	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */
	public static String ticketMaker(String type, String  reward, String from, String start, String dest, String route){
		String output;
		output ="";
		
		output += type + getSpacing(type.length()) + reward; 
		output += "\n\n";
		output += from + getSpacing(from.length()) + start; 
		output += "\n\n";
		output += dest + getSpacing(dest.length()) + route;
		return output;
		
	}
	public static String getSpacing(int len){
		String space="";
		for (int i=0; i<(17-len)+23; i++){
			space += " ";
			
		}
		return space;
	}
	

	
	


}

