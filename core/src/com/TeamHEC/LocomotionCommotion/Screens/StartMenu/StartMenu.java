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

import com.TeamHEC.LocomotionCommotion.Screens.StartScreen;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Sprite;
import com.TeamHEC.LocomotionCommotion.UI_Elements.SpriteButton;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
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
		public Sprite sm_main_title, sm_main_lines;
		
		//Start Menu NewGame Page
		public Sprite sm_newgame_menutext;
	
		//Start Menu LoadGame Page
		public Sprite sm_loadgame_title, sm_loadgame_examples;

		//Start Menu Preferences Page
		public Sprite sm_preferences_vertline, sm_preferences_titletext;

		//Start Menu HowtoPlay Page
		public Sprite sm_howtoplay_line, sm_howtoplay_title;
		public Sprite sm_howtoplay_frame;
		
		public SpriteButton newGameButton, loadGameButton, preferencesButton, howToPlayButton;
		public SpriteButton newGameBackButton, turnTimeOutButton, stationDomButton, newGameGoButton;
		public SpriteButton turn50Button, turn100Button, turn150Button;
		public SpriteButton loadGameBckButton, prefBackButton, settingsButton;
		public SpriteButton displayButton, soundButton, controlButton;
		public SpriteButton homeButton, nextButton, prevButton, backButton;
		
		public void create(Stage stage)
		{
			
			sm_main_title = new Sprite(6, 650, SM_TextureManager.getInstance().sm_main_title);
			actors.add(sm_main_title);

			sm_main_lines = new Sprite(-229,-145, SM_TextureManager.getInstance().sm_main_linesimg);
			actors.add(sm_main_lines);

			// Start MenuNewGame Page
			sm_newgame_menutext =  new Sprite(80,1150+250, SM_TextureManager.getInstance().sm_newgame_MenuText);
			actors.add(sm_newgame_menutext);

			newGameButton = new SpriteButton(600, 480, SM_TextureManager.getInstance().sm_main_newgamebtn){
				
													@Override
													protected void onClicked()
													{
														started = true;
													}
													
													int animationTracker1, animationTracker2;
													
													@Override
													public void act(float delta)
													{
														if(started)
														{
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
											};
			actors.add(newGameButton);
			
			loadGameButton = new SpriteButton(600, 406, SM_TextureManager.getInstance().sm_main_loadgamebtn){
				
													@Override
													public void onClicked()
													{
														started = true;
													}
												
													int animationTracker1, animationTracker2;
												
													@Override
													public void act(float delta)
													{
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
				
											};
											
			actors.add(loadGameButton);
			
			preferencesButton = new SpriteButton(590, 330, SM_TextureManager.getInstance().sm_main_preferencesbtn){
				
														@Override
														public void onClicked()
														{
															started = true;
														}
													
														int animationTracker1, animationTracker2, animationTracker3;
													
														@Override
														public void act(float delta)
														{
															if(started)
															{
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

											};
		actors.add(preferencesButton);
				
		howToPlayButton = new SpriteButton(590, 255, SM_TextureManager.getInstance().sm_main_howtoplaybtn){
			
												@Override
												public void onClicked()
												{
													StartScreen.changeCam(-1500, 0);
												}
									};
		actors.add(howToPlayButton);
			
		
			newGameBackButton = new SpriteButton(1150, 1800, SM_TextureManager.getInstance().sm_newgame_BackBtn){
				
													@Override
													public void onClicked()
													{
														started = true;
													}
												
													int animationTracker1, animationTracker2;	
													
													@Override
													public void act(float delta)
													{
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
														StartMenu.actorManager.turnTimeOutButton.setTexture(SM_TextureManager.getInstance().sm_newgameTurnTimeOut_unselected_Btn);
														StartMenu.actorManager.stationDomButton.setTexture(SM_TextureManager.getInstance().sm_newgame_StationDom_unselected_Btn);
														StartMenu.textbox1.setText("");
														StartMenu.textbox2.setText("");
														StartMenu.actorManager.turn50Button.setTexture(SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn);
														StartMenu.actorManager.turn100Button.setTexture(SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn);
														StartMenu.actorManager.turn150Button.setTexture(SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn);
														StartMenu.gameMode=null;
														StartMenu.player1name= null;
														StartMenu.player2name= null;
														StartMenu.turnChoice=0;
													}
										};
			actors.add(newGameBackButton);
			
			turnTimeOutButton = new SpriteButton(400, 1680, SM_TextureManager.getInstance().sm_newgameTurnTimeOut_unselected_Btn){
				
									@Override
									public void onClicked()
									{
										StartMenu.gameMode = "turntimeout";
										setTexture(SM_TextureManager.getInstance().sm_newgame_TurnTimeOutBtn);
										StartMenu.actorManager.stationDomButton.setTexture(SM_TextureManager.getInstance().sm_newgame_StationDom_unselected_Btn);
									}
				
								};
			actors.add(turnTimeOutButton);
			
			stationDomButton = new SpriteButton(660, 1680, SM_TextureManager.getInstance().sm_newgame_StationDom_unselected_Btn){
				
				@Override
				public void onClicked()
				{
					StartMenu.gameMode = "stationdomination";
					setTexture(SM_TextureManager.getInstance().sm_newgame_StationDomBtn);
					StartMenu.actorManager.turnTimeOutButton.setTexture(SM_TextureManager.getInstance().sm_newgameTurnTimeOut_unselected_Btn);
				}

			};
			actors.add(stationDomButton);
						
			turn50Button = new SpriteButton(490, 1400, SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn){
				
				@Override
				public void onClicked()
				{
					StartMenu.turnChoice = 50;
					setTexture(SM_TextureManager.getInstance().sm_newgame_Turn50Btn);
					StartMenu.actorManager.turn100Button.setTexture(SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn);
					StartMenu.actorManager.turn150Button.setTexture(SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn);
				}

			};
			actors.add(turn50Button);
						
			turn100Button = new SpriteButton(590, 1400, SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn){
				
				@Override
				public void onClicked()
				{
					StartMenu.turnChoice = 100;
					StartMenu.actorManager.turn50Button.setTexture(SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn);
					setTexture(SM_TextureManager.getInstance().sm_newgame_Turn100Btn);
					StartMenu.actorManager.turn150Button.setTexture(SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn);
				}

			};
			actors.add(turn100Button);
						
			turn150Button = new SpriteButton(680, 1400, SM_TextureManager.getInstance().sm_newgame_Turn150_unselected_Btn){
				
				@Override
				public void onClicked()
				{
					StartMenu.turnChoice = 150;
					StartMenu.actorManager.turn50Button.setTexture(SM_TextureManager.getInstance().sm_newgame_Turn50_unselected_Btn);
					StartMenu.actorManager.turn100Button.setTexture(SM_TextureManager.getInstance().sm_newgame_Turn100_unselected_Btn);
					setTexture(SM_TextureManager.getInstance().sm_newgame_Turn150Btn);
				}

			};
			actors.add(turn150Button);
			
			sm_loadgame_title = new Sprite(1680+350,665, SM_TextureManager.getInstance().sm_loadgame_Title);
			actors.add(sm_loadgame_title);
			
			loadGameBckButton = new SpriteButton(1680+150, 850, SM_TextureManager.getInstance().sm_newgame_BackBtn){
				
													@Override
													public void onClicked()
													{
														started = true;
													}
												
													int animationTracker1, animationTracker2;	
													
													@Override
													public void act(float delta)
													{
														if(started)
														{
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
											};
			actors.add(loadGameBckButton);

			sm_loadgame_examples = new Sprite(1680+350,500, SM_TextureManager.getInstance().sm_loadgame_Examples);
			actors.add(sm_loadgame_examples);

			//Start Menu Preferences Page

			sm_preferences_vertline = new Sprite(1420,-900+72, SM_TextureManager.getInstance().sm_preferences_VertLine);
			actors.add(sm_preferences_vertline);
	
			prefBackButton = new SpriteButton(1390, -900+ 745, SM_TextureManager.getInstance().sm_newgame_BackBtn){
				
												@Override
												public void onClicked()
												{
													started = true;
												}
											
												int animationTracker1, animationTracker2, animationTracker3;	
												
												@Override
												public void act(float delta)
												{
													if(started)
													{
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
										};
			actors.add(prefBackButton);
			
			sm_preferences_titletext = new Sprite(500,-900+720, SM_TextureManager.getInstance().sm_preferences_Title);
			actors.add(sm_preferences_titletext);
			
			settingsButton = new SpriteButton(890, -900+550, SM_TextureManager.getInstance().sm_preferences_GameSettingsBtn){
				
				@Override
				public void onClicked()
				{
					StartScreen.changeCam(0, 0);
				}
			};
			actors.add(settingsButton);
					
			displayButton = new SpriteButton(890-37, -900+450, SM_TextureManager.getInstance().sm_preferences_DisplaySettingsBtn){
				
				@Override
				public void onClicked()
				{
					StartScreen.changeCam(0, 0);
				}
			};
			actors.add(displayButton);
				
			soundButton = new SpriteButton(890-37, -900+550-175, SM_TextureManager.getInstance().sm_preferences_SoundSettingsBtn){
				
				@Override
				public void onClicked()
				{
					StartScreen.changeCam(0, 0);
				}
			};
			actors.add(soundButton);
					
			controlButton = new SpriteButton(890-80, -900+550-300, SM_TextureManager.getInstance().sm_preferences_ControlSettingsBtn){
				
				@Override
				public void onClicked()
				{
					StartScreen.changeCam(0, 0);
				}
			};
			actors.add(controlButton);
			
			//StartMenu HowtoPlay screen

			sm_howtoplay_line = new Sprite(-1290+1030,150, SM_TextureManager.getInstance().sm_howtoplay_line);
			actors.add(sm_howtoplay_line);

			sm_howtoplay_title = new Sprite(-1290+350,650, SM_TextureManager.getInstance().sm_howtoplay_title);
			actors.add(sm_howtoplay_title);
			
			nextButton = new SpriteButton(-1290+ 590, 150, SM_TextureManager.getInstance().sm_howtoplay_nextbtn){
				
				@Override
				public void onClicked()
				{
					StartScreen.changeCam(0, 0);
				}
			};
			actors.add(nextButton);
						
			prevButton = new SpriteButton(-1290+ 460, 150, SM_TextureManager.getInstance().sm_howtoplay_previousbtn){
				
				@Override
				public void onClicked()
				{
					StartScreen.changeCam(0, 0);
				}
			};
			actors.add(prevButton);

			
			homeButton = new SpriteButton(-1290+ 570, 160, SM_TextureManager.getInstance().sm_howtoplay_homebtn){
				
				@Override
				public void onClicked()
				{
					StartScreen.changeCam(0, 0);
				}
			};
			actors.add(homeButton);

			sm_howtoplay_frame = new Sprite(-1290+240,220, SM_TextureManager.getInstance().sm_howtoplay_frame);
			actors.add(sm_howtoplay_frame);
			
			backButton = new SpriteButton(-1290+ 1000, 625, SM_TextureManager.getInstance().sm_newgame_BackBtn){
				
				@Override
				public void onClicked()
				{
					StartScreen.changeCam(1250, 0);
				}
			};
			actors.add(backButton);

			//Add Actors to Stage
			for (Actor a : actors){
				a.setTouchable(Touchable.enabled);
				stage.addActor(a);
			}
		}
	}
}