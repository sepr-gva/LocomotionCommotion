package com.TeamHEC.LocomotionCommotion.Screens.Actors;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class ActorManager {
	
	private final static Array<Actor> actors = new Array<Actor>();
	private static NewGameActor newgame;
	private static LinesActor lines;
	private static LoadGameActor loadgame;
	private static PreferencesActor preferences;
	private static HowToPlayActor howtoplay;
	
	private static TitleActor title;
	
	//NewGame Page
	private static NewGameMenuText newgamescreentext;
	private static BackBtn back;
	private static TempTextBox1 textbox1;
	private static TempTextBox2 textbox2;
	private static TurnTimeOutBtn turntimeout;
	private static StationDomBtn stationdom;
	private static Turn50 turn50;
	private static Turn100 turn100;
	private static Turn150 turn150;
	private static GoBtn gobtn;
	
	
	public ActorManager(){		
	}
	
	public static void create(Stage stage){
		//Lines
				lines = new LinesActor();
				actors.add(lines);
			
				newgame = new NewGameActor();
				actors.add(newgame);
				
				loadgame = new LoadGameActor();
				actors.add(loadgame);
				
				preferences = new PreferencesActor();
				actors.add(preferences);
				
				howtoplay = new HowToPlayActor();
				actors.add(howtoplay);
				
				
				title = new TitleActor();
				actors.add(title);
				
			
				// NewGame Page
				newgamescreentext = new NewGameMenuText();
				actors.add(newgamescreentext);
				
				back = new BackBtn();
				actors.add(back);
				
				textbox1 = new TempTextBox1();
				actors.add(textbox1); 
				
				textbox2 = new TempTextBox2();
				actors.add(textbox2); 
				
				turntimeout = new	TurnTimeOutBtn();
				actors.add(turntimeout);
				
				stationdom = new StationDomBtn();
				actors.add(stationdom);
				
				turn50 = new Turn50();
				actors.add(turn50);
				
				turn100 = new Turn100();
				actors.add(turn100);
				
				turn150= new Turn150();
				actors.add(turn150);
				
				gobtn = new GoBtn();
				actors.add(gobtn);
				
		for (Actor a : actors){
			a.setTouchable(Touchable.enabled);
			stage.addActor(a);
		}
       
	}
	
	public void addActor(Actor actor){
		actors.add(actor);
	}
	

}

