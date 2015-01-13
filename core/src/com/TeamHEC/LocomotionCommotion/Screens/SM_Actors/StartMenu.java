package com.TeamHEC.LocomotionCommotion.Screens.SM_Actors;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.utils.Array;

public class StartMenu {
	public static SM_ActorManager actorManager;
	public static String gameMode, player1name, player2name;
	public static int turnChoice;
	public static TextField textbox1, textbox2;
	
	public static void create(Stage stage) {
		//Create ActorManager- A Class that groups all actors Instantiates them and adds them to the Stage
		actorManager = new SM_ActorManager();
		actorManager.create(stage);
		createNewGameTextBoxes(stage);


	}
	public static void createNewGameTextBoxes(Stage stage){
		
		//Text boxes for Player 1 and 2 names
    	Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
    	
		textbox1 = new TextField("", skin);
		skin.getFont("default-font").setScale(1.5f, 1.5f);
		textbox1.setX(480);
		textbox1.setY(1150+430);
		textbox1.setSize(430, 60);
		textbox1.setMessageText("Player 1");
		TextFieldListener player1 = new TextFieldListener() {
			 @Override
			 public void keyTyped (TextField textbox1, char key) {
			         if (key == '\n') textbox1.getOnscreenKeyboard().show(false);
			         player1name = textbox1.getText();
			     }};
		textbox1.setTextFieldListener(player1);
	 
		textbox2 = new TextField("", skin);
		textbox2.setX(480);
		textbox2.setY(1150+350);
		textbox2.setSize(430, 60);
		textbox2.setMessageText("Player 2");
		TextFieldListener player2 = new TextFieldListener() {
			 @Override
			 public void keyTyped (TextField textbox2, char key) {
			         if (key == '\n') textbox2.getOnscreenKeyboard().show(false);
			         player2name = textbox2.getText();
			     }};
		textbox2.setTextFieldListener(player2);
		stage.addActor(textbox1);
		stage.addActor(textbox2);
	}



	public static class SM_ActorManager {

		public static Array<Actor> actors = new Array<Actor>();
		//Start Menu Main Page
		public static SM_main_TitleText sm_main_title;
		public static SM_main_LinesImg sm_main_lines;
		public static SM_main_NewGameBtn sm_main_newgamebtn;
		public static SM_main_LoadGameBtn sm_main_loadgamebtn;
		public static SM_main_PreferencesBtn sm_main_preferences;
		public static SM_main_HowToPlayBtn sm_main_howtoplay;


		//Start Menu NewGame Page
		public static SM_newgame_MenuText sm_newgame_menutext;
		public static SM_newgame_BackBtn sm_newgame_back;
		public static SM_newgame_TurnTimeOutBtn sm_newgame_turntimeoutbtn;
		public static SM_newgame_StationDomBtn sm_newgmae_stationdombtn;
		public static SM_newgame_Turn50Btn sm_newgame_turn50btn;
		public static SM_newgame_Turn100Btn sm_newgame_turn100btn;
		public static SM_newgame_Turn150Btn sm_newgame_turn150btn;
		public static SM_newgame_GoBtn sm_newgame_gobtn;

		//Start Menu LoadGame Page
		public static SM_loadgame_TitleText sm_loadgame_title;
		public static SM_loadgame_Examples sm_loadgame_examples;
		public static SM_loadgame_BackBtn sm_loadgame_backbtn;

		//Start Menu Preferences Page
		public static SM_preferences_VertLine sm_preferences_vertline;
		public static SM_preferences_TitleText  sm_preferences_titletext;
		public static SM_preferences_GameSettingsBtn sm_preferences_gamesettingsbtn;
		public static SM_preferences_DisplaySettingsBtn sm_preferences_displaysettingsbtn;
		public static SM_preferences_SoundSettingsBtn sm_preferences_soundsettingsbtn;
		public static SM_preferences_ControlSettingsBtn sm_preferences_controlsettingsbtn;
		public static SM_preferences_BackBtn sm_preferences_backbtn;

		//Start Menu HowtoPlay Page
		public static SM_howtoplay_LineImg sm_howtoplay_line;
		public static SM_howtoplay_TitleText sm_howtoplay_title;
		public static SM_howtoplay_NextBtn sm_howtoplay_nextbtn;
		public static SM_howtoplay_PreviousBtn sm_howtoplay_previousbtn;
		public static SM_howtoplay_HomeBtn sm_howtoplay_homebtn;
		public static SM_howtoplay_FrameImg sm_howtoplay_frame;
		public static SM_howtoplay_BackBtn sm_howtoplay_backbtn;

		public void create(Stage stage){



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

			//Start Menu LoadGame page

			sm_loadgame_title = new SM_loadgame_TitleText();
			actors.add(sm_loadgame_title);

			sm_loadgame_backbtn = new SM_loadgame_BackBtn();
			actors.add(sm_loadgame_backbtn);

			sm_loadgame_examples = new SM_loadgame_Examples();
			actors.add(sm_loadgame_examples);

			//Start Menu Preferences Page

			sm_preferences_vertline = new SM_preferences_VertLine();
			actors.add(sm_preferences_vertline);

			sm_preferences_backbtn = new SM_preferences_BackBtn();
			actors.add(sm_preferences_backbtn);

			sm_preferences_titletext = new SM_preferences_TitleText();
			actors.add(sm_preferences_titletext);

			sm_preferences_gamesettingsbtn = new SM_preferences_GameSettingsBtn();
			actors.add(sm_preferences_gamesettingsbtn);

			sm_preferences_displaysettingsbtn = new SM_preferences_DisplaySettingsBtn();
			actors.add(sm_preferences_displaysettingsbtn);

			sm_preferences_soundsettingsbtn = new SM_preferences_SoundSettingsBtn();
			actors.add(sm_preferences_soundsettingsbtn);

			sm_preferences_controlsettingsbtn = new SM_preferences_ControlSettingsBtn();
			actors.add(sm_preferences_controlsettingsbtn);

			//StartMenu HowtoPlay screen

			sm_howtoplay_line = new SM_howtoplay_LineImg();
			actors.add(sm_howtoplay_line);

			sm_howtoplay_title = new SM_howtoplay_TitleText();
			actors.add(sm_howtoplay_title);

			sm_howtoplay_nextbtn = new SM_howtoplay_NextBtn();
			actors.add(sm_howtoplay_nextbtn);

			sm_howtoplay_previousbtn = new SM_howtoplay_PreviousBtn();
			actors.add(sm_howtoplay_previousbtn);

			sm_howtoplay_homebtn = new SM_howtoplay_HomeBtn();
			actors.add(sm_howtoplay_homebtn);

			sm_howtoplay_frame = new SM_howtoplay_FrameImg();
			actors.add(sm_howtoplay_frame);

			sm_howtoplay_backbtn = new SM_howtoplay_BackBtn();
			actors.add(sm_howtoplay_backbtn);

			//Add Actors to Stage
			for (Actor a : actors){
				a.setTouchable(Touchable.enabled);
				stage.addActor(a);
			}


		}


	}
}








