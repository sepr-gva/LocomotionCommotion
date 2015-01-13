package com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
/*
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * Start Menu is in charge of everything that happens in the Start Menu.
 * Start Menu is all on one plane and we move the camera up, down, left and right using the changeCamera() method.
 * There are two types of objects in Start Menu Actors and Images; I have made the distinction using two super classes
 * StartMenuImage and StartMenuActor. These super classes run the draw method needed for any object to render and take 
 * the x and y coordinates and a texture(Image); 
 * 
 * StartMenu Class consists of three main parts also.
 * 1.Create Text boxes
 * 		This creates the text fields needed in NewGame menu 
 * 2. StartMenuActorManager
 * 		Start Menu Manager first initialises all the Objects, then adds them to the stage.
 * 3. The Object Classes.
 * 		The classes of the objects. Within these classes are the x and y coordinates if you need to move objects
 * 		and act methods for the objects. This is the code executed if an action is placed on the object.
 * 
 * @param actorManager	the class which handles creation of all objects in the start menu
 * @param gameMode
 * @param player1name
 * @param player2name
 * @param turnChoice
 * @param textbox1
 * @param textbox2
 * @param skin
 * 
 */

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
	public static StartMenuActorManager actorManager;
	public static String gameMode, player1name, player2name;
	public static int turnChoice;
	public static TextField textbox1, textbox2;

	public static void create(Stage stage) {
		//Create ActorManager- A Class that groups all actors Instantiates them and adds them to the Stage
		actorManager = new StartMenuActorManager();
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
				public void keyTyped (TextField textbox2, char key) {
					if (key == '\n') textbox2.getOnscreenKeyboard().show(false);
					player2name = textbox2.getText();
				}};
				textbox2.setTextFieldListener(player2);
				stage.addActor(textbox1);
				stage.addActor(textbox2);
	}


	//ACTOR MANAGER 
	public static class StartMenuActorManager {

		public static Array<Actor> actors = new Array<Actor>();
		//Start Menu Main Page
		public StartMenuImage sm_main_title;
		public StartMenuImage sm_main_lines;
		public SM_main_NewGameBtn sm_main_newgamebtn;
		public SM_main_LoadGameBtn sm_main_loadgamebtn;
		public SM_main_PreferencesBtn sm_main_preferences;
		public SM_main_HowToPlayBtn sm_main_howtoplay;


		//Start Menu NewGame Page
		public StartMenuImage sm_newgame_menutext;
		public SM_newgame_BackBtn sm_newgame_back;
		public SM_newgame_TurnTimeOutBtn sm_newgame_turntimeoutbtn;
		public SM_newgame_StationDomBtn sm_newgmae_stationdombtn;
		public SM_newgame_Turn50Btn sm_newgame_turn50btn;
		public SM_newgame_Turn100Btn sm_newgame_turn100btn;
		public SM_newgame_Turn150Btn sm_newgame_turn150btn;
		public SM_newgame_GoBtn sm_newgame_gobtn;

		//Start Menu LoadGame Page
		public StartMenuImage sm_loadgame_title;
		public StartMenuImage sm_loadgame_examples;
		public SM_loadgame_BackBtn sm_loadgame_backbtn;

		//Start Menu Preferences Page
		public StartMenuImage sm_preferences_vertline;
		public StartMenuImage  sm_preferences_titletext;
		public SM_preferences_GameSettingsBtn sm_preferences_gamesettingsbtn;
		public SM_preferences_DisplaySettingsBtn sm_preferences_displaysettingsbtn;
		public SM_preferences_SoundSettingsBtn sm_preferences_soundsettingsbtn;
		public SM_preferences_ControlSettingsBtn sm_preferences_controlsettingsbtn;
		public SM_preferences_BackBtn sm_preferences_backbtn;

		//Start Menu HowtoPlay Page
		public StartMenuImage sm_howtoplay_line;
		public StartMenuImage sm_howtoplay_title;
		public SM_howtoplay_NextBtn sm_howtoplay_nextbtn;
		public SM_howtoplay_PreviousBtn sm_howtoplay_previousbtn;
		public SM_howtoplay_HomeBtn sm_howtoplay_homebtn;
		public StartMenuImage sm_howtoplay_frame;
		public SM_howtoplay_BackBtn sm_howtoplay_backbtn;

		public void create(Stage stage){



			//Start Menu Main Page

			sm_main_title = new StartMenuImage(6, 650, SM_TextureManager.getInstance().sm_main_title);
			actors.add(sm_main_title);

			sm_main_lines = new StartMenuImage(-229,-145, SM_TextureManager.getInstance().sm_main_linesimg);
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
			sm_newgame_menutext =  new StartMenuImage(80,1150+250, SM_TextureManager.getInstance().sm_newgame_MenuText);
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

			sm_loadgame_title = new StartMenuImage(1680+350,665, SM_TextureManager.getInstance().sm_loadgame_Title);
			actors.add(sm_loadgame_title);

			sm_loadgame_backbtn = new SM_loadgame_BackBtn();
			actors.add(sm_loadgame_backbtn);

			sm_loadgame_examples = new StartMenuImage(1680+350,500, SM_TextureManager.getInstance().sm_loadgame_Examples);
			actors.add(sm_loadgame_examples);

			//Start Menu Preferences Page

			sm_preferences_vertline = new StartMenuImage(1420,-900+72, SM_TextureManager.getInstance().sm_preferences_VertLine);
			actors.add(sm_preferences_vertline);

			sm_preferences_backbtn = new SM_preferences_BackBtn();
			actors.add(sm_preferences_backbtn);

			sm_preferences_titletext = new StartMenuImage(500,-900+720, SM_TextureManager.getInstance().sm_preferences_Title);
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

			sm_howtoplay_line = new StartMenuImage(-1290+1030,150, SM_TextureManager.getInstance().sm_howtoplay_line);
			actors.add(sm_howtoplay_line);

			sm_howtoplay_title = new StartMenuImage(-1290+350,650, SM_TextureManager.getInstance().sm_howtoplay_title);
			actors.add(sm_howtoplay_title);

			sm_howtoplay_nextbtn = new SM_howtoplay_NextBtn();
			actors.add(sm_howtoplay_nextbtn);

			sm_howtoplay_previousbtn = new SM_howtoplay_PreviousBtn();
			actors.add(sm_howtoplay_previousbtn);

			sm_howtoplay_homebtn = new SM_howtoplay_HomeBtn();
			actors.add(sm_howtoplay_homebtn);

			sm_howtoplay_frame = new StartMenuImage(-1290+240,220, SM_TextureManager.getInstance().sm_howtoplay_frame);
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

	//Super Classes
	public static class StartMenuActor extends Actor{
		public Texture texture;
		float actorX, actorY;
		boolean started = false;
		public void draw(Batch batch, float alpha){
			batch.draw(texture, actorX, actorY);
		}
		public void setTexture(Texture t){
			this.texture=t;
		}
		public Texture getTexture(){
			return this.texture;
		}
	}


	public static class StartMenuImage extends StartMenuActor{		
		public StartMenuImage(float x, float y, Texture t)
		{
			actorX = x;
			actorY = y;
			texture = t;
		}

	}

	//MAIN MENU ACTORS---------------------------------------------------------------------------------



	// New Game Button
	public static class SM_main_NewGameBtn extends StartMenuActor {
		int animationTracker1,animationTracker2;
		public SM_main_NewGameBtn(){
			actorX=600;
			actorY=480;
			texture = SM_TextureManager.getInstance().sm_main_newgamebtn;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_main_NewGameBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}

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
	public static class SM_main_LoadGameBtn extends StartMenuActor {
		int animationTracker1,animationTracker2;
		public SM_main_LoadGameBtn(){
			texture = SM_TextureManager.getInstance().sm_main_loadgamebtn;
			actorX = StartMenu.actorManager.sm_main_newgamebtn.actorX ;
			actorY = StartMenu.actorManager.sm_main_newgamebtn.actorY-74;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_main_LoadGameBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
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
	public static class SM_main_PreferencesBtn extends StartMenuActor {
		int animationTracker1,animationTracker2,animationTracker3;
		public SM_main_PreferencesBtn(){
			texture = SM_TextureManager.getInstance().sm_main_preferencesbtn;
			actorX = StartMenu.actorManager.sm_main_newgamebtn.actorX-10 ;
			actorY = StartMenu.actorManager.sm_main_newgamebtn.actorY-150;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_main_PreferencesBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
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
	public static class SM_main_HowToPlayBtn extends StartMenuActor {
		int animationTracker1,animationTracker2,animationTracker3;
		public SM_main_HowToPlayBtn(){
			texture = SM_TextureManager.getInstance().sm_main_howtoplaybtn;
			actorX = StartMenu.actorManager.sm_main_newgamebtn.actorX-10 ;
			actorY = StartMenu.actorManager.sm_main_newgamebtn.actorY-225;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_main_HowToPlayBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				StartScreen.changeCam(-1500, 0);
				started = false;
			}
		}
	}



	//NEW GAME ACTORS---------------------------------------------------------------------------------


	//NewGame: Back Button
	public static class SM_newgame_BackBtn extends StartMenuActor {
		int animationTracker1,animationTracker2;
		public SM_newgame_BackBtn(){
			texture = SM_TextureManager.getInstance().sm_newgame_BackBtn;
			actorX = 1150;
			actorY = 1050+750;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_BackBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}

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
			StartMenu.actorManager.sm_newgame_turntimeoutbtn.texture = SM_TextureManager.getInstance().sm_newgameTurnTimeOut_unselected_Btn;
			StartMenu.actorManager.sm_newgmae_stationdombtn.texture =SM_TextureManager.getInstance().sm_newgame_StationDom_unselected_Btn ;
			StartMenu.textbox1.setText("");
			StartMenu.textbox2.setText("");
			StartMenu.actorManager.sm_newgame_turn50btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn;
			StartMenu.actorManager.sm_newgame_turn100btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn;
			StartMenu.actorManager.sm_newgame_turn150btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn;
			StartMenu.gameMode=null;
			StartMenu.player1name= null;
			StartMenu.player2name= null;
			StartMenu.turnChoice=0;
		}
	}

	//NewGame: Game Mode Choices
	//Turn Timeout
	public static class SM_newgame_TurnTimeOutBtn extends StartMenuActor {
		public SM_newgame_TurnTimeOutBtn(){
			this.texture = SM_TextureManager.getInstance().sm_newgameTurnTimeOut_unselected_Btn;
			this.actorX = 400 ;
			this.actorY = 1150+530;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_TurnTimeOutBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				StartMenu.gameMode = "turntimeout";
				texture = SM_TextureManager.getInstance().sm_newgame_TurnTimeOutBtn;
				StartMenu.actorManager.sm_newgmae_stationdombtn.setTexture(SM_TextureManager.getInstance().sm_newgame_StationDom_unselected_Btn);
				started = false;


			}
		}
	}
	//Station Domination
	public static class SM_newgame_StationDomBtn extends StartMenuActor {
		public SM_newgame_StationDomBtn(){
			texture = SM_TextureManager.getInstance().sm_newgame_StationDom_unselected_Btn;
			actorX = 660 ;
			actorY = 1150+530;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_StationDomBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				StartMenu.gameMode = "stationdomination";
				texture = SM_TextureManager.getInstance().sm_newgame_StationDomBtn;
				StartMenu.actorManager.sm_newgame_turntimeoutbtn.texture = SM_TextureManager.getInstance().sm_newgameTurnTimeOut_unselected_Btn;
				started = false;


			}
		}
	}

	//NewGame : Go Button
	public static class SM_newgame_GoBtn extends StartMenuActor {
		public SM_newgame_GoBtn(){
			texture = SM_TextureManager.getInstance().sm_newgame_GoBtn;
			actorX = -100 ;
			actorY = 1150+50;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_GoBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
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
			StartMenu.actorManager.sm_newgame_turntimeoutbtn.texture = SM_TextureManager.getInstance().sm_newgameTurnTimeOut_unselected_Btn;
			StartMenu.actorManager.sm_newgmae_stationdombtn.texture =SM_TextureManager.getInstance().sm_newgame_StationDom_unselected_Btn ;
			StartMenu.textbox1.setText("");
			StartMenu.textbox2.setText("");
			StartMenu.actorManager.sm_newgame_turn50btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn;
			StartMenu.actorManager.sm_newgame_turn100btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn;
			StartMenu.actorManager.sm_newgame_turn150btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn;
			StartMenu.gameMode=null;
			StartMenu.player1name= null;
			StartMenu.player2name= null;
			StartMenu.turnChoice=0;
		}
	}

	//NewGame Turn choices
	//50 Turns
	public static class SM_newgame_Turn50Btn extends StartMenuActor {
		public SM_newgame_Turn50Btn(){
			texture = SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn;
			actorX = 490 ;
			actorY = 1150+250;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_Turn50Btn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				StartMenu.turnChoice = 50;
				StartMenu.actorManager.sm_newgame_turn50btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn50Btn;
				StartMenu.actorManager.sm_newgame_turn100btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn;
				StartMenu.actorManager.sm_newgame_turn150btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn;
				started = false;


			}
		}
	}
	//100 Turns
	public static class SM_newgame_Turn100Btn extends StartMenuActor {
		public SM_newgame_Turn100Btn(){
			texture = SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn;
			actorX = 590 ;
			actorY = 1150+250;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_Turn100Btn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				StartMenu.turnChoice = 100;
				StartMenu.actorManager.sm_newgame_turn50btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn;
				StartMenu.actorManager.sm_newgame_turn100btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn100Btn;
				StartMenu.actorManager.sm_newgame_turn150btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn;
				started = false;


			}
		}
	}
	//150 Turns
	public static class SM_newgame_Turn150Btn extends StartMenuActor {
		public SM_newgame_Turn150Btn(){
			texture = SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn;
			actorX = 680 ;
			actorY = 1150+250;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_newgame_Turn150Btn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				StartMenu.turnChoice = 150;
				StartMenu.actorManager.sm_newgame_turn50btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn;
				StartMenu.actorManager.sm_newgame_turn100btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn;
				StartMenu.actorManager.sm_newgame_turn150btn.texture = SM_TextureManager.getInstance().sm_newgame_Turn150Btn;
				started = false;


			}
		}
	}


	//LOAD GAME ACTORS ---------------------------------------------------------------------------------


	//LoadGame BackBtn
	public static class SM_loadgame_BackBtn extends StartMenuActor {
		int animationTracker1,animationTracker2;
		public SM_loadgame_BackBtn(){
			texture = SM_TextureManager.getInstance().sm_newgame_BackBtn; // Reuse Texture the BackButton from new game
			actorX = 1680+150 ;
			actorY = 850;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_loadgame_BackBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
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

	//Preferences: Back Button
	public static class SM_preferences_BackBtn extends StartMenuActor {
		int animationTracker1,animationTracker2,animationTracker3;
		public SM_preferences_BackBtn(){
			texture = SM_TextureManager.getInstance().sm_newgame_BackBtn; // reuse the new game back btn texture
			actorX = 1390 ;
			actorY = -900+ 745;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_preferences_BackBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
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
	public static class SM_preferences_GameSettingsBtn extends StartMenuActor {
		public SM_preferences_GameSettingsBtn(){
			texture = SM_TextureManager.getInstance().sm_preferences_GameSettingsBtn;
			actorX = 890;
			actorY= -900+550;
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
	public static class SM_preferences_DisplaySettingsBtn extends StartMenuActor {
		public SM_preferences_DisplaySettingsBtn(){
			texture = SM_TextureManager.getInstance().sm_preferences_DisplaySettingsBtn;
			actorX = StartMenu.actorManager.sm_preferences_gamesettingsbtn.actorX-37 ;
			actorY= StartMenu.actorManager.sm_preferences_gamesettingsbtn.actorY-100;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_preferences_DisplaySettingsBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}

	//Preferences: Sound Settings
	public static class SM_preferences_SoundSettingsBtn extends StartMenuActor {
		public SM_preferences_SoundSettingsBtn(){
			texture = SM_TextureManager.getInstance().sm_preferences_SoundSettingsBtn;
			actorX = StartMenu.actorManager.sm_preferences_gamesettingsbtn.actorX-37 ;
			actorY= StartMenu.actorManager.sm_preferences_gamesettingsbtn.actorY-175;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_preferences_SoundSettingsBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}

	//Preferences: Control Settings
	public static class SM_preferences_ControlSettingsBtn extends StartMenuActor {
		public SM_preferences_ControlSettingsBtn(){
			texture = SM_TextureManager.getInstance().sm_preferences_ControlSettingsBtn;
			actorX = StartMenu.actorManager.sm_preferences_gamesettingsbtn.actorX-80 ;
			actorY= StartMenu.actorManager.sm_preferences_gamesettingsbtn.actorY-300;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_preferences_ControlSettingsBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}

	//HOW TO PLAY ACTORS -------------------------------------------------------------------------------

	//How to play: Home
	public static class SM_howtoplay_HomeBtn extends StartMenuActor {
		public SM_howtoplay_HomeBtn(){
			texture = SM_TextureManager.getInstance().sm_howtoplay_homebtn; 
			actorX = -1290+ 570 ;
			actorY = 160;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_howtoplay_HomeBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}
	//How to play: Next
	public static class SM_howtoplay_NextBtn extends StartMenuActor {
		public SM_howtoplay_NextBtn(){
			texture = SM_TextureManager.getInstance().sm_howtoplay_nextbtn;
			actorX = -1290+ 590 ;
			actorY = 150;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_howtoplay_NextBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}
	//How to play: Previous
	public static class SM_howtoplay_PreviousBtn extends StartMenuActor {
		public SM_howtoplay_PreviousBtn(){
			texture = SM_TextureManager.getInstance().sm_howtoplay_previousbtn; 
			actorX = -1290+ 460 ;
			actorY = 150;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_howtoplay_PreviousBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				StartScreen.changeCam(0, 0);
				started = false;
			}
		}
	}

	//How to play: Back
	public static class SM_howtoplay_BackBtn extends StartMenuActor {
		public SM_howtoplay_BackBtn(){
			texture = SM_TextureManager.getInstance().sm_newgame_BackBtn; // reuse the new game back btn texture
			actorX = -1290+ 1000 ;
			actorY = 625;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((SM_howtoplay_BackBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				StartScreen.changeCam(1250, 0);
				started = false;
			}
		}
	}
}