package com.TeamHEC.LocomotionCommotion.Screens.Actors;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class ActorManager {

	private final static Array<Actor> actors = new Array<Actor>();
	//Start Menu Main Page
	private static SM_main_TitleText sm_main_title;
	private static SM_main_LinesImg sm_main_lines;
	private static SM_main_NewGameBtn sm_main_newgamebtn;
	private static SM_main_LoadGameBtn sm_main_loadgamebtn;
	private static SM_main_PreferencesBtn sm_main_preferences;
	private static SM_main_HowToPlayBtn sm_main_howtoplay;


	//Start Menu NewGame Page
	private static SM_newgame_MenuText sm_newgame_menutext;
	private static SM_newgame_BackBtn sm_newgame_back;
	private static SM_newgame_TempTextBox1 sm_newgame_textbox1;
	private static SM_newgame_TempTextBox2 sm_newgame_textbox2;
	private static SM_newgame_TurnTimeOutBtn sm_newgame_turntimeoutbtn;
	private static SM_newgame_StationDomBtn sm_newgmae_stationdombtn;
	private static SM_newgame_Turn50Btn sm_newgame_turn50btn;
	private static SM_newgame_Turn100Btn sm_newgame_turn100btn;
	private static SM_newgame_Turn150Btn sm_newgame_turn150btn;
	private static SM_newgame_GoBtn sm_newgame_gobtn;


	public ActorManager(){		
	}

	public static void create(Stage stage){
		//Start Menu Main Page
		
		sm_main_title = new SM_main_TitleText();
		actors.add(sm_main_title);
		
		sm_main_lines = new SM_main_LinesImg();
		actors.add(sm_main_lines);

		sm_main_newgamebtn = new SM_main_NewGameBtn();
		actors.add(sm_main_newgamebtn);

		sm_main_loadgamebtn = new SM_main_LoadGameBtn();
		actors.add(sm_main_loadgamebtn);

		sm_main_preferences = new SM_main_PreferencesBtn();
		actors.add(sm_main_preferences);

		sm_main_howtoplay = new SM_main_HowToPlayBtn();
		actors.add(sm_main_howtoplay);


		// Start MenuNewGame Page
		sm_newgame_menutext = new SM_newgame_MenuText();
		actors.add(sm_newgame_menutext);

		sm_newgame_back = new SM_newgame_BackBtn();
		actors.add(sm_newgame_back);

		sm_newgame_textbox1 = new SM_newgame_TempTextBox1();
		actors.add(sm_newgame_textbox1); 

		sm_newgame_textbox2 = new SM_newgame_TempTextBox2();
		actors.add(sm_newgame_textbox2); 

		sm_newgame_turntimeoutbtn = new	SM_newgame_TurnTimeOutBtn();
		actors.add(sm_newgame_turntimeoutbtn);

		sm_newgmae_stationdombtn = new SM_newgame_StationDomBtn();
		actors.add(sm_newgmae_stationdombtn);

		sm_newgame_turn50btn = new SM_newgame_Turn50Btn();
		actors.add(sm_newgame_turn50btn);

		sm_newgame_turn100btn = new SM_newgame_Turn100Btn();
		actors.add(sm_newgame_turn100btn);

		sm_newgame_turn150btn= new SM_newgame_Turn150Btn();
		actors.add(sm_newgame_turn150btn);

		sm_newgame_gobtn = new SM_newgame_GoBtn();
		actors.add(sm_newgame_gobtn);

		for (Actor a : actors){
			a.setTouchable(Touchable.enabled);
			stage.addActor(a);
		}

	}

	public void addActor(Actor actor){
		actors.add(actor);
	}


}

