package com.TeamHEC.LocomotionCommotion.Screens.SM_Actors;


import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.TeamHEC.LocomotionCommotion.Screens.StartScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
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


	//ACTOR MANAGER 
	public static class SM_ActorManager {

		public static Array<Actor> actors = new Array<Actor>();
		//Start Menu Main Page
		public SM_main_TitleText sm_main_title;
		public SM_main_LinesImg sm_main_lines;
		public SM_main_NewGameBtn sm_main_newgamebtn;
		public SM_main_LoadGameBtn sm_main_loadgamebtn;
		public SM_main_PreferencesBtn sm_main_preferences;
		public SM_main_HowToPlayBtn sm_main_howtoplay;


		//Start Menu NewGame Page
		public SM_newgame_MenuText sm_newgame_menutext;
		public SM_newgame_BackBtn sm_newgame_back;
		public SM_newgame_TurnTimeOutBtn sm_newgame_turntimeoutbtn;
		public SM_newgame_StationDomBtn sm_newgmae_stationdombtn;
		public SM_newgame_Turn50Btn sm_newgame_turn50btn;
		public SM_newgame_Turn100Btn sm_newgame_turn100btn;
		public SM_newgame_Turn150Btn sm_newgame_turn150btn;
		public SM_newgame_GoBtn sm_newgame_gobtn;

		//Start Menu LoadGame Page
		public SM_loadgame_TitleText sm_loadgame_title;
		public SM_loadgame_Examples sm_loadgame_examples;
		public SM_loadgame_BackBtn sm_loadgame_backbtn;

		//Start Menu Preferences Page
		public SM_preferences_VertLine sm_preferences_vertline;
		public SM_preferences_TitleText  sm_preferences_titletext;
		public SM_preferences_GameSettingsBtn sm_preferences_gamesettingsbtn;
		public SM_preferences_DisplaySettingsBtn sm_preferences_displaysettingsbtn;
		public SM_preferences_SoundSettingsBtn sm_preferences_soundsettingsbtn;
		public SM_preferences_ControlSettingsBtn sm_preferences_controlsettingsbtn;
		public SM_preferences_BackBtn sm_preferences_backbtn;

		//Start Menu HowtoPlay Page
		public SM_howtoplay_LineImg sm_howtoplay_line;
		public SM_howtoplay_TitleText sm_howtoplay_title;
		public SM_howtoplay_NextBtn sm_howtoplay_nextbtn;
		public SM_howtoplay_PreviousBtn sm_howtoplay_previousbtn;
		public SM_howtoplay_HomeBtn sm_howtoplay_homebtn;
		public SM_howtoplay_FrameImg sm_howtoplay_frame;
		public SM_howtoplay_BackBtn sm_howtoplay_backbtn;

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


	//MAIN MENU ACTORS---------------------------------------------------------------------------------
	
	// Main Title- No Action
	public static class SM_main_TitleText extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_main_title;
		float actorX = 5 ,actorY = 650;
		public SM_main_TitleText(){
		}
		public void draw(Batch batch, float alpha){
			batch.draw(texture,actorX,actorY);

		}
	}

	// New Game Button
	public static class SM_main_NewGameBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_main_newgamebtn; //Image Used for the New Game button
		public float actorX = 600; //Position of bottom left corner
		public float actorY = 480;
		public boolean started = false; //
		int animationTracker1,animationTracker2;

		public SM_main_NewGameBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_main_NewGameBtn)event.getTarget()).started = true;
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

				if (animationTracker1<950){
					StartScreen.changeCam(0,15);
					animationTracker1+=15;
				}
				else{
					if(animationTracker2<90){
						StartScreen.changeCam(-15,0);
						animationTracker2+=15;
					}
					else{
						started = false;
						animationTracker1=0;
						animationTracker2=0;
					}
				}
			}
		}
	}

	//Load Game Button
	public static class SM_main_LoadGameBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_main_loadgamebtn;
		float actorX = StartMenu.actorManager.sm_main_newgamebtn.actorX ,actorY = StartMenu.actorManager.sm_main_newgamebtn.actorY-74;
		public boolean started = false;
		int animationTracker1,animationTracker2;

		public SM_main_LoadGameBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_main_LoadGameBtn)event.getTarget()).started = true;
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
				if (animationTracker1<1680){
					StartScreen.changeCam(15,0);
					animationTracker1+=15;
				}
				else{
					if(animationTracker2<40){
						StartScreen.changeCam(0,10);
						animationTracker2+=10;
					}

					else{
						started = false;
						animationTracker1=0;
						animationTracker2=0;
					}
				}

			}

		}
	}

	//Preferences button
	public static class SM_main_PreferencesBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_main_preferencesbtn;
		float actorX = StartMenu.actorManager.sm_main_newgamebtn.actorX-10 ,actorY = StartMenu.actorManager.sm_main_newgamebtn.actorY-150;
		public boolean started = false;
		int animationTracker1,animationTracker2,animationTracker3;

		public SM_main_PreferencesBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_main_PreferencesBtn)event.getTarget()).started = true;
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
				if (animationTracker1<900){
					StartScreen.changeCam(30,0);
					animationTracker1+=30;
				}
				else{
					if(animationTracker2<1000){
						StartScreen.changeCam(0,-30);
						animationTracker2+=30;
					}
					else
					{
						if(animationTracker3<500)
						{
							StartScreen.changeCam(-30,0);
							animationTracker3 +=30;
						}else{
							started = false;
							animationTracker1=0;
							animationTracker2=0;
							animationTracker3=0;
						}
					}
				}

			}
		}
	}

	//How to Play Button
	public static class SM_main_HowToPlayBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_main_howtoplaybtn;
		float actorX = StartMenu.actorManager.sm_main_newgamebtn.actorX-10 ,actorY = StartMenu.actorManager.sm_main_newgamebtn.actorY-225;
		public boolean started = false;

		public SM_main_HowToPlayBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_main_HowToPlayBtn)event.getTarget()).started = true;
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
				StartScreen.changeCam(-1500, 0);
				started = false;
			}
		}
	}
	
	//lines Image-No Action
	public static class SM_main_LinesImg extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_main_linesimg;
		float actorX = -229 ,actorY = -145;
		public boolean started = false;

		public SM_main_LinesImg(){
		}
		@Override
		public void draw(Batch batch, float alpha){
			batch.draw(texture,actorX,actorY);
		}
	}

	//NEW GAME ACTORS---------------------------------------------------------------------------------
	
	//New game: Title Text and page Text - No Action
	public static class SM_newgame_MenuText extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_newgame_MenuText;
		float actorX = 80 ,actorY = 1150+ 250;
		public boolean started = false;

		public SM_newgame_MenuText(){

		}
		public void draw(Batch batch, float alpha){
			batch.draw(texture,actorX,actorY);
		}
	}
	
	//NewGame: Back Button
	public static class SM_newgame_BackBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_newgame_BackBtn;
		float actorX = 1150 ,actorY = 1050+750;
		public boolean started = false;
		int animationTracker1,animationTracker2;

		public SM_newgame_BackBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_BackBtn)event.getTarget()).started = true;
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
				
				if (animationTracker1<90){
					StartScreen.changeCam(15,0);
					animationTracker1+=15;
				}
				else{
					if(animationTracker2<950){
						StartScreen.changeCam(0,-15);
						animationTracker2+=15;
					}
					else{
						resetNewGameScreen();
						started = false;
						animationTracker1=0;
						animationTracker2=0;
					}
				}
			}
			
				
		}
		
		public void resetNewGameScreen(){
			SM_newgame_TurnTimeOutBtn.texture = SM_TextureManager.getInstance().sm_newgameTurnTimeOut_unselected_Btn;
			SM_newgame_StationDomBtn.texture =SM_TextureManager.getInstance().sm_newgame_StationDom_unselected_Btn ;
			StartMenu.textbox1.setText("");
			StartMenu.textbox2.setText("");
			SM_newgame_Turn50Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn;
			SM_newgame_Turn100Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn;
			SM_newgame_Turn150Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn;
			StartMenu.gameMode=null;
			StartMenu.player1name= null;
			StartMenu.player2name= null;
			StartMenu.turnChoice=0;
		}
	}
	
	//NewGame: Game Mode Choices
	//Turn Timeout
	public static class SM_newgame_TurnTimeOutBtn extends Actor {
		
		public static Texture texture = SM_TextureManager.getInstance().sm_newgameTurnTimeOut_unselected_Btn;
		public static float actorX = 400 ,actorY = 1150+530;
		public boolean started = false;

		public SM_newgame_TurnTimeOutBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_TurnTimeOutBtn)event.getTarget()).started = true;
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
				StartMenu.gameMode = "turntimeout";
				texture = SM_TextureManager.getInstance().sm_newgame_TurnTimeOutBtn;
				SM_newgame_StationDomBtn.texture = SM_TextureManager.getInstance().sm_newgame_StationDom_unselected_Btn;
				started = false;
				
				
			}
		}
	}
	//Station Domination
	public static class SM_newgame_StationDomBtn extends Actor {
		
		public static Texture texture = SM_TextureManager.getInstance().sm_newgame_StationDom_unselected_Btn;
		public static float actorX = 660 ,actorY = 1150+530;
		public boolean started = false;

		public SM_newgame_StationDomBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_StationDomBtn)event.getTarget()).started = true;
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
				StartMenu.gameMode = "stationdomination";
				texture = SM_TextureManager.getInstance().sm_newgame_StationDomBtn;
				SM_newgame_TurnTimeOutBtn.texture = SM_TextureManager.getInstance().sm_newgameTurnTimeOut_unselected_Btn;
				started = false;
				
				
			}
		}
	}
	
	//NewGame : Go Button
	public static class SM_newgame_GoBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_newgame_GoBtn;
		public static float actorX = -100 ,actorY = 1150+50;
		public boolean started = false;

		public SM_newgame_GoBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_GoBtn)event.getTarget()).started = true;
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
				//System.out.println("New Game: "+StartMenu.gameMode+" "+StartMenu.player1name+ " "+ StartMenu.player2name +
				//" "+ StartMenu.turnChoice);
				GameScreen.player1name=StartMenu.player1name;
				GameScreen.player2name=StartMenu.player2name;
				GameScreen.gameMode=StartMenu.gameMode;
				GameScreen.turns=StartMenu.turnChoice;
				resetNewGameScreen();
				LocomotionCommotion.getInstance().setGameScreen();
				
				started = false;


			}
		}
		
		public void resetNewGameScreen(){
			SM_newgame_TurnTimeOutBtn.texture = SM_TextureManager.getInstance().sm_newgameTurnTimeOut_unselected_Btn;
			SM_newgame_StationDomBtn.texture =SM_TextureManager.getInstance().sm_newgame_StationDom_unselected_Btn ;
			StartMenu.textbox1.setText("");
			StartMenu.textbox2.setText("");
			SM_newgame_Turn50Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn;
			SM_newgame_Turn100Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn;
			SM_newgame_Turn150Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn;
			StartMenu.gameMode=null;
			StartMenu.player1name= null;
			StartMenu.player2name= null;
			StartMenu.turnChoice=0;
		}
	}

	//NewGame Turn choices
	//50 Turns
	public static class SM_newgame_Turn50Btn extends Actor {
		
		public static Texture texture = SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn;
		public static float actorX = 490 ,actorY = 1150+250;
		public boolean started = false;

		public SM_newgame_Turn50Btn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_Turn50Btn)event.getTarget()).started = true;
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
				StartMenu.turnChoice = 50;
				SM_newgame_Turn50Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn50Btn;
				SM_newgame_Turn100Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn;
				SM_newgame_Turn150Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn;
				started = false;
				
				
			}
		}
	}
	//100 Turns
	public static class SM_newgame_Turn100Btn extends Actor {
		
		public static Texture texture = SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn;
		public static float actorX = 590 ,actorY = 1150+250;
		public boolean started = false;

		public SM_newgame_Turn100Btn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_Turn100Btn)event.getTarget()).started = true;
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
				StartMenu.turnChoice = 100;
				SM_newgame_Turn50Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn;
				SM_newgame_Turn100Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn100Btn;
				SM_newgame_Turn150Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn;
				started = false;
				
				
			}
		}
	}
	//150 Turns
	public static class SM_newgame_Turn150Btn extends Actor {
		
		public static Texture texture = SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn;
		public static float actorX = 680 ,actorY = 1150+250;
		public boolean started = false;

		public SM_newgame_Turn150Btn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_Turn150Btn)event.getTarget()).started = true;
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
				StartMenu.turnChoice = 150;
				SM_newgame_Turn50Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn;
				SM_newgame_Turn100Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn;
				SM_newgame_Turn150Btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn150Btn;
				started = false;
				
				
			}
		}
	}
	
	
	//LOAD GAME ACTORS ---------------------------------------------------------------------------------
	//LoadGame Title-- No Action
	public static class SM_loadgame_TitleText extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_loadgame_Title;
		float actorX = 1680+ 350 ,actorY = 665;
		public boolean started = false;

		public SM_loadgame_TitleText(){
		
		}
		public void draw(Batch batch, float alpha){
			batch.draw(texture,actorX,actorY);
		}

	}

	//LoadGame Examples--No Action -- To be deleted when load game is properly implemented
	public static class SM_loadgame_Examples extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_loadgame_Examples;
		float actorX = 1680+ 350 ,actorY = 500;
		public boolean started = false;

		public SM_loadgame_Examples(){
			
		}
		public void draw(Batch batch, float alpha){
			batch.draw(texture,actorX,actorY);
		}

	}
	
	//LoadGame BackBtn
	public static class SM_loadgame_BackBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_newgame_BackBtn; // Reuse Texture the BackButton from new game
		float actorX = 1680+150 ,actorY = 850;
		public boolean started = false;
		int animationTracker1,animationTracker2;

		public SM_loadgame_BackBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_loadgame_BackBtn)event.getTarget()).started = true;
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
				if (animationTracker1<50){
					StartScreen.changeCam(0,-10);
					animationTracker1+=15;
				}
				else{
					if(animationTracker2<1680){
						StartScreen.changeCam(-15,0);
						animationTracker2+=15;
					}

					else{
						started = false;
						animationTracker1=0;
						animationTracker2=0;
					}
				}

			}

		}
	}
	
	//PREFRENCES ACTORS---------------------------------------------------------------------------------
	//Preferences: Title - No Action
	public static class SM_preferences_TitleText extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_preferences_Title;
		float actorX = 500 ,actorY= -900+720;
		public boolean started = false;

		public SM_preferences_TitleText(){
			
		}
		public void draw(Batch batch, float alpha){
			batch.draw(texture,actorX,actorY);
		}

	}
	// Preferences Vertical line Image -- No Action
	public static class SM_preferences_VertLine extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_preferences_VertLine;
		float actorX = 1420 ,actorY= -900+72;
		public boolean started = false;
		public SM_preferences_VertLine(){
		
		}

		public void draw(Batch batch, float alpha){
			batch.draw(texture,actorX,actorY);
		}

	}
	
	//Preferences: Back Button
	public static class SM_preferences_BackBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_newgame_BackBtn; // reuse the new game back btn texture
		float actorX = 1390 ,actorY = -900+ 745;
		public boolean started = false;
		int animationTracker1,animationTracker2,animationTracker3;

		public SM_preferences_BackBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_preferences_BackBtn)event.getTarget()).started = true;
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
				if (animationTracker1<510){
					StartScreen.changeCam(30,0);
					animationTracker1+=30;
				}
				else{
					if(animationTracker2<1000){
						StartScreen.changeCam(0,30);
						animationTracker2+=30;
					}
					else
					{
						if(animationTracker3<900)
						{
							StartScreen.changeCam(-30,0);
							animationTracker3 +=30;
						}else{
							started = false;
							animationTracker1=0;
							animationTracker2=0;
							animationTracker3=0;
						}
					}
				}

			}
		}
	}
	
	//Preferences: Game Settings
	public static class SM_preferences_GameSettingsBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_preferences_GameSettingsBtn;
		float actorX = 890;
		float actorY= -900+550;
		public boolean started = false;

		public SM_preferences_GameSettingsBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_preferences_GameSettingsBtn)event.getTarget()).started = true;
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
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}
	
	//Preferences: Display Settings
	public static class SM_preferences_DisplaySettingsBtn extends Actor {


		Texture texture = SM_TextureManager.getInstance().sm_preferences_DisplaySettingsBtn;
		float actorX = StartMenu.actorManager.sm_preferences_gamesettingsbtn.actorX-37 ,actorY= StartMenu.actorManager.sm_preferences_gamesettingsbtn.actorY-100;
		public boolean started = false;

		public SM_preferences_DisplaySettingsBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_preferences_DisplaySettingsBtn)event.getTarget()).started = true;
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
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}
	
	//Preferences: Sound Settings
	public static class SM_preferences_SoundSettingsBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_preferences_SoundSettingsBtn;
	    float actorX = StartMenu.actorManager.sm_preferences_gamesettingsbtn.actorX-37 ,actorY= StartMenu.actorManager.sm_preferences_gamesettingsbtn.actorY-175;
		public boolean started = false;

		public SM_preferences_SoundSettingsBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_preferences_SoundSettingsBtn)event.getTarget()).started = true;
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
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}
	
	//Preferences: Control Settings
	public static class SM_preferences_ControlSettingsBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_preferences_ControlSettingsBtn;
		float actorX = StartMenu.actorManager.sm_preferences_gamesettingsbtn.actorX-80 ,actorY= StartMenu.actorManager.sm_preferences_gamesettingsbtn.actorY-300;
		public boolean started = false;

		public SM_preferences_ControlSettingsBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_preferences_ControlSettingsBtn)event.getTarget()).started = true;
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
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}
	
	//HOW TO PLAY ACTORS -------------------------------------------------------------------------------
	//How to play: Title
	public static class SM_howtoplay_TitleText extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_howtoplay_title;
		float actorX = -1290+ 350 ,actorY = 650;
		public boolean started = false;

		public SM_howtoplay_TitleText(){
		
		}
		public void draw(Batch batch, float alpha){
			batch.draw(texture,actorX,actorY);
		}

	}
	//How to play: Frame
	public static class SM_howtoplay_FrameImg extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_howtoplay_frame; 
		float actorX = -1290+ 240 ,actorY = 220;
		public boolean started = false;

		public SM_howtoplay_FrameImg(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_howtoplay_FrameImg)event.getTarget()).started = true;
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
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}
	//How to play: Home
	public static class SM_howtoplay_HomeBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_howtoplay_homebtn; 
		float actorX = -1290+ 570 ,actorY = 160;
		public boolean started = false;

		public SM_howtoplay_HomeBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_howtoplay_HomeBtn)event.getTarget()).started = true;
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
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}
	//How to play: Next
	public static class SM_howtoplay_NextBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_howtoplay_nextbtn;
		float actorX = -1290+ 590 ,actorY = 150;
		public boolean started = false;

		public SM_howtoplay_NextBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_howtoplay_NextBtn)event.getTarget()).started = true;
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
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}
	//How to play: Previous
	public static class SM_howtoplay_PreviousBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_howtoplay_previousbtn; 
		float actorX = -1290+ 460 ,actorY = 150;
		public boolean started = false;

		public SM_howtoplay_PreviousBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_howtoplay_PreviousBtn)event.getTarget()).started = true;
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
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}
	//How to play: LineImage
	public static class SM_howtoplay_LineImg extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_howtoplay_line; 
		float actorX = -1290+ 1030 ,actorY = 150;
		public boolean started = false;
		public SM_howtoplay_LineImg(){
			
		}
		public void draw(Batch batch, float alpha){
			batch.draw(texture,actorX,actorY);
		}

	}
	//How to play: Back
	public static class SM_howtoplay_BackBtn extends Actor {

		Texture texture = SM_TextureManager.getInstance().sm_newgame_BackBtn; // reuse the new game back btn texture
		float actorX = -1290+ 1000 ,actorY = 625;
		public boolean started = false;

		public SM_howtoplay_BackBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_howtoplay_BackBtn)event.getTarget()).started = true;
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
				StartScreen.changeCam(1250, 0);
				started = false;
			}
		}
	}
}








