package com.TeamHEC.LocomotionCommotion.Game_Actors;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.TeamHEC.LocomotionCommotion.Card.Game_CardHand;
import com.TeamHEC.LocomotionCommotion.Goal.GoalMenu;
import com.TeamHEC.LocomotionCommotion.Goal.PlayerGoals;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.Train.TrainDepotUI;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_PauseMenu;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_Shop;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_Shop.Game_ShopManager;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Sprite;
import com.TeamHEC.LocomotionCommotion.UI_Elements.SpriteButton;
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
/**
 * 
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 */
public class GameScreen_ActorManager {

	private final static Array<Actor> actors = new Array<Actor>();

	//Upper UI Elements (On the top)
	public static Label playerScore;
	public static Sprite game_menuobject_topbar, game_menuobject_ticketenclosure;
	public static SpriteButton game_menuobject_tickettoggle, game_menuobject_goalscreenbtn, game_menuobject_menubtn;
	//Lower UI Elements (At the Bottom- not including resources)
	public static Label currentPlayerName;
	public static Sprite game_menuobject_cornerframe;
	public static SpriteButton game_menuobject_infobutton,game_menuobject_shopbtn,game_menuobject_traindepotbtn, game_menuobject_endturnbutton;

	//Menu Actors start index and end index - used to toggle visibility
	public static  int menuobjectsStageStart, menuobjectsStageEnd;

	//Resources UI Elements
	public static Label  goldQuant, coalQuant, oilQuant, electricityQuant, nuclearQuant;

	public static Label cardQuant;
	public static Sprite game_menuobject_resourcesbar;
	public static SpriteButton game_card_togglebtn, game_resources_togglebtn;

	//Resource Actors start index and end index - used to toggle expanded resources menu
	public static  int  resourcesStageStart, resourcesStageEnd;
	//Height value for expanded height
	public static int expandedheight= 40;
	//Boolean for expanded
	public static boolean resourcebarexpanded = false;
	LabelStyle style;

	/**
	 * Create method instantiates all Labels, Sprites and SpriteButtons in the Main game screen and then addes them to the stage.
	 * Method follows simple formula throughout -
	 * 		Sprite:
	 * 			1.Create new Sprite - requires x , y and texture
	 * 			2.Add to actors array
	 * 		SpriteButtton:
	 * 			1.Create new Sprite - requires x , y and texture
	 * 			2.Add onClicked method -- an action for the sprite
	 * 			3.Add to actors array
	 * 		Label:
	 * 			1.Create new Label with LabelStyle style (If you need to change font size call style= getLabelStyle(fontsize) )
	 * 			2.Set Colour, Text , x and y
	 * 			3.Add to actors array
	 * 
	 * @param stage The stage is the central collection of actors(Sprites and SpriteButtons) passed from GameScreen
	 * 
	 */
	public void create(Stage stage) {
		//Clear Actors -- fixes an error caused from exiting to main menu and returning to game.
		actors.clear();
		//Actors----------------------------------------------------------------------------------------------------------------------------------------------------
		//The Top Bar
		game_menuobject_topbar = new Sprite(-20, Gdx.graphics.getHeight()- Game_TextureManager.getInstance().game_menuobject_topbar.getHeight() +10,
				Game_TextureManager.getInstance().game_menuobject_topbar );
		actors.add(game_menuobject_topbar);	

		//The Corner Frame -- Bottom right corner
		game_menuobject_cornerframe=new Sprite((LocomotionCommotion.screenX-Game_TextureManager.getInstance().game_menuobject_cornerframe.getWidth())+3,2
				,Game_TextureManager.getInstance().game_menuobject_cornerframe);
		actors.add(game_menuobject_cornerframe);

		//The Pause Menu Button -- Top right corner
		game_menuobject_menubtn = new SpriteButton(LocomotionCommotion.screenX-60, 
				Gdx.graphics.getHeight()- Game_TextureManager.getInstance().game_menuobject_menubtn.getHeight() - 30, Game_TextureManager.getInstance().game_menuobject_menubtn){

			@Override
			protected void onClicked()
			{
				if (Game_PauseMenu.actorManager.open== false)
				{
					Game_PauseMenu.actorManager.open= true;
					for(int i=Game_PauseMenu.actorManager.getStageStart(); i<=Game_PauseMenu.actorManager.getStageEnd();i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_PauseMenu.actorManager.open= false;
				for(int i=Game_PauseMenu.actorManager.getStageStart(); i<=Game_PauseMenu.actorManager.getStageEnd();i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}

				}
			}
		};
		actors.add(game_menuobject_menubtn);	

		//Ticket (OwnedGoals) toggle button -- Top Left corner
		game_menuobject_tickettoggle=new SpriteButton(30, Gdx.graphics.getHeight() - Game_TextureManager.getInstance().game_menuobject_ticketbtn.getHeight()-15,
				Game_TextureManager.getInstance().game_menuobject_ticketbtn){

			@Override
			protected void onClicked()
			{
				if (PlayerGoals.open== false)
				{
					PlayerGoals.open= true;
					for(int i=PlayerGoals.stagestart; i<=PlayerGoals.stagestart +PlayerGoals.ticketActors-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}
					game_menuobject_ticketenclosure.setVisible(true);
				}
				else
				{	PlayerGoals.open= false;
				for(int i=PlayerGoals.stagestart; i<=PlayerGoals.stagestart +PlayerGoals.ticketActors-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}
				game_menuobject_ticketenclosure.setVisible(false);
				}
			}
		};
		actors.add(game_menuobject_tickettoggle);

		//End Turn Button -- Bottom right button
		game_menuobject_endturnbutton = new SpriteButton(LocomotionCommotion.screenX-Game_TextureManager.getInstance().game_menuobject_endturnbutton.getWidth()-15,
				15, Game_TextureManager.getInstance().game_menuobject_endturnbutton){

			@SuppressWarnings("static-access")
			@Override
			protected void onClicked()
			{	
				ArrayList<Train> playerTrains = GameScreen.game.getPlayerTurn().getTrains();	
				for(Train t : playerTrains)
				{
					t.moveTrain();
				}

				GameScreen.game.EndTurn();
				GameScreen_ActorManager.refreshResources();
				Game_Shop.actorManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
				PlayerGoals.changePlayer(GameScreen.game.getPlayerTurn());
				Game_CardHand.actorManager.changePlayer(GameScreen.game.getPlayerTurn());
				playerScore.setText(GameScreen.game.getPlayer1().getName()+"    " + GameScreen.player1score +
						"     SCORE     "+ GameScreen.player2score+"     "+GameScreen.game.getPlayer2().getName()
						+"     "+GameScreen.game.getPlayerTurn().getName()+" it's your turn ");
				currentPlayerName.setText(GameScreen.game.getPlayerTurn().getName()+"'s TURN");
				GoalMenu.fillGoalScreen();
			}
		};
		actors.add(game_menuobject_endturnbutton);

		//Map Info Toggle Button -- Bottom right group
		game_menuobject_infobutton = new SpriteButton(LocomotionCommotion.screenX-310, 63, Game_TextureManager.getInstance().game_menuobject_infobutton){

			@Override
			protected void onClicked()
			{
				if (Game_Map_Manager.infoVisible){
					Game_Map_Manager.mapInfo.setVisible(false);
					Game_Map_Manager.infoVisible= false;

				}else{
					Game_Map_Manager.mapInfo.setVisible(true);
					Game_Map_Manager.infoVisible= true;
				}
			}
		};
		actors.add(game_menuobject_infobutton);

		//Access Shop Button -- Bottom right group
		game_menuobject_shopbtn = new SpriteButton(LocomotionCommotion.screenX-310, 125, Game_TextureManager.getInstance().game_shop_shopbtn){

			@Override
			protected void onClicked()
			{
				if (Game_Shop.actorManager.open== false)
				{
					Game_Shop.actorManager.open= true;
					for(int i=Game_Shop.actorManager.getStageStart(); i<=Game_Shop.actorManager.getStageEnd(); i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			
					Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
				}
				else
				{	Game_Shop.actorManager.open= false;
				for(int i=Game_Shop.actorManager.getStageStart(); i<=Game_Shop.actorManager.getStageEnd(); i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}
				}
			}
		};
		actors.add(game_menuobject_shopbtn);

		//Access Train Depot Button -- Bottom right group
		game_menuobject_traindepotbtn = new SpriteButton(LocomotionCommotion.screenX-310, 193, Game_TextureManager.getInstance().game_traindepot_traindepotbtn){

			@Override
			protected void onClicked()
			{
				if (TrainDepotUI.actorManager.open== false)
				{
					TrainDepotUI.actorManager.open= true;
					for(int i=TrainDepotUI.actorManager.getStageStart(); i<=TrainDepotUI.actorManager.getStageEnd();i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	
					TrainDepotUI.actorManager.open= false;
					for(int i=TrainDepotUI.actorManager.getStageStart(); i<=TrainDepotUI.actorManager.getStageEnd();i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(false);

					}
				}
			}
		};
		actors.add(game_menuobject_traindepotbtn);

		//Access Goal Screen Button -- Top Left Corner
		game_menuobject_goalscreenbtn = new SpriteButton(110, Gdx.graphics.getHeight()- Game_TextureManager.getInstance().game_goals_goalscreenbtn.getHeight() -25,
				Game_TextureManager.getInstance().game_goals_goalscreenbtn){

			@Override
			protected void onClicked()
			{
				if (GoalMenu.open== false)
				{
					GoalMenu.open= true;
					PlayerGoals.goalMenuOpen();
					for(int i=GoalMenu.stagestart; i<=GoalMenu.stagestart +GoalMenu.goalActors-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			
					Game_startGameManager.getStartedWindow.setVisible(false);
					Game_startGameManager.selectLabel.setVisible(false);

				}
				else
				{	
					GoalMenu.open= false;
					PlayerGoals.goalMenuClose();

					for(int i=GoalMenu.stagestart; i<=GoalMenu.stagestart +GoalMenu.goalActors-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(false);

					}
				}
			}
		};
		actors.add(game_menuobject_goalscreenbtn);

		//Add Labels
		//Player Score Label -- Top Centre (NOT FUNCTIONAL IN ASSESSMENT 2 VERSION)
		style= getLabelStyle(32);
		playerScore = new Label(null, style);
		playerScore.setColor(0,0,0,1);
		playerScore.setText("");
		playerScore.setX(600);
		playerScore.setY(Gdx.graphics.getHeight()- playerScore.getHeight() -45);
		actors.add(playerScore);

		//Player Name Label -- Bottom group Corner
		currentPlayerName = new Label(null,style);
		currentPlayerName.setColor(1,1,1,1);
		currentPlayerName.setX(Gdx.graphics.getWidth()-260);
		currentPlayerName.setY(280);
		actors.add(currentPlayerName);
		
		//Get current stage end - where menuObjects start
		menuobjectsStageStart = stage.getActors().size;
		//Assign the index of the last MenuObject
		menuobjectsStageEnd = menuobjectsStageStart+ actors.size-1;

		//Resource Actors----------------------------------------------------------------------------------------------------------------------------------------
		//Resource Bar -
		game_menuobject_resourcesbar = new Sprite(-13,-175,Game_TextureManager.getInstance().game_menuobject_resourcesbar);
		actors.add(game_menuobject_resourcesbar);

		game_resources_togglebtn = new SpriteButton(10,30,Game_TextureManager.getInstance().game_menuobject_menubtn){
			@Override
			protected void onClicked(){
				int expandedheight=180;
				if (GameScreen_ActorManager.resourcebarexpanded== false)
				{	
					//Move up button, bar and quantities
					GameScreen_ActorManager.game_resources_togglebtn.setY(game_resources_togglebtn.getY()+ expandedheight);
					setBounds(getX(),getY(),getTexture().getWidth(),getTexture().getHeight());
					GameScreen_ActorManager.game_menuobject_resourcesbar.increaseY(expandedheight);
					setResourcesHeight(GameScreen_ActorManager.cardQuant.getY()+expandedheight);
					//move cards up
					GameScreen_ActorManager.game_card_togglebtn.increaseY(expandedheight);
					GameScreen_ActorManager.game_card_togglebtn.refreshBounds();
					Game_CardHand.actorManager.organiseDeck();
					Game_CardHand.actorManager.changeHeight(expandedheight);
					Game_CardHand.actorManager.usecardbtn.setVisible(false);


					GameScreen_ActorManager.resourcebarexpanded= true;
					for(int i=GameScreen_ActorManager.resourcesStageStart; i<=GameScreen_ActorManager.resourcesStageStart +GameScreen_ActorManager.resourcesStageEnd-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	GameScreen_ActorManager.resourcebarexpanded= false;
				Game_CardHand.actorManager.usecardbtn.setVisible(false);
				//Move up
				GameScreen_ActorManager.game_resources_togglebtn.setY(GameScreen_ActorManager.game_resources_togglebtn.getY() - expandedheight);
				setBounds(getX(),getY(),getTexture().getWidth(),getTexture().getHeight());
				GameScreen_ActorManager.game_menuobject_resourcesbar.increaseY(-expandedheight);
				setResourcesHeight(GameScreen_ActorManager.cardQuant.getY()-expandedheight);

				GameScreen_ActorManager.game_card_togglebtn.increaseY(-expandedheight);
				GameScreen_ActorManager.game_card_togglebtn.refreshBounds();
				Game_CardHand.actorManager.selectedCard=0;
				Game_CardHand.actorManager.changeHeight(-expandedheight);
				Game_CardHand.actorManager.organiseDeck();
				//end
				for(int i=GameScreen_ActorManager.resourcesStageStart; i<=GameScreen_ActorManager.resourcesStageStart +GameScreen_ActorManager.resourcesStageEnd-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(true);

				}

				}

			}
		};
		actors.add(game_resources_togglebtn);

		style= getLabelStyle(19);

		goldQuant= new Label(null, style);
		goldQuant.setX(100);
		goldQuant.setY(expandedheight);
		goldQuant.setColor(0,0,0,1);

		coalQuant= new Label(null,style);
		coalQuant.setX(240);
		coalQuant.setY(expandedheight);
		coalQuant.setColor(0,0,0,1);


		oilQuant= new Label(null,style);
		oilQuant.setX(350);
		oilQuant.setY(expandedheight);
		oilQuant.setColor(0,0,0,1);

		electricityQuant= new Label(null,style);
		electricityQuant.setX(450);
		electricityQuant.setY(expandedheight);
		electricityQuant.setColor(0,0,0,1);

		nuclearQuant= new Label(null,style);
		nuclearQuant.setX(590);
		nuclearQuant.setY(expandedheight);
		nuclearQuant.setColor(0,0,0,1);

		cardQuant= new Label(null,style);
		cardQuant.setX(920);
		cardQuant.setY(expandedheight);
		cardQuant.setColor(0,0,0,1);

		actors.add(goldQuant);
		actors.add(coalQuant);
		actors.add(oilQuant);
		actors.add(electricityQuant);
		actors.add(nuclearQuant);

		resourcesStageStart= menuobjectsStageEnd+1;
		resourcesStageEnd = menuobjectsStageStart+actors.size-1;

		for (Actor a : actors){
			a.setTouchable(Touchable.enabled);
			a.setVisible(false);
			stage.addActor(a);
		}
		//Add the enclosure straight in as is not visible at start
		game_menuobject_ticketenclosure=new Sprite(-1,Gdx.graphics.getHeight()-Game_TextureManager.getInstance().game_menuobject_ticketenclosure.getHeight()-82
				,Game_TextureManager.getInstance().game_menuobject_ticketenclosure);
		game_menuobject_ticketenclosure.setVisible(false);
		stage.addActor(game_menuobject_ticketenclosure);

		game_card_togglebtn = new SpriteButton(670, 25, Game_TextureManager.getInstance().game_card_cardtoggle){

			@Override
			protected void onClicked()
			{
				if (Game_CardHand.actorManager.open== false)
				{
					Game_CardHand.actorManager.open= true; //set hand as open (visible)
					for(int i=Game_CardHand.actorManager.stagestart; i<=Game_CardHand.actorManager.stagestart +Game_CardHand.actorManager.cardActors-1;i++)	//Range of Card Actors
					{ 	
						if (i > GameScreen.getStage().getActors().size-1)
						{//This is just to avoid range errors
						}
						else
							GameScreen.getStage().getActors().get(i).setVisible(true); //Make Card Actors Visible
					}			
				}
				else
				{	
					Game_CardHand.actorManager.open= false; //set hand as closed (hidden)
					for(int i=Game_CardHand.actorManager.stagestart; i<=Game_CardHand.actorManager.stagestart +Game_CardHand.actorManager.cardActors-1;i++) //Range of Card Actors
					{		
						if (i > GameScreen.getStage().getActors().size-1)
						{//This is just to avoid range errors
						}
						else
							GameScreen.getStage().getActors().get(i).setVisible(false); //Make Card Actors Hidden
					}

					Game_CardHand.actorManager.selectedCard=0;	// 0 means that no card is selected 
					Game_CardHand.actorManager.organiseDeck(); 	//call OrganiseDeck - see Game_CardHand.organiseDeck() documentation
					Game_CardHand.actorManager.usecardbtn.setVisible(false);	//hide the usecard button
				}
			}
		};
		game_card_togglebtn.setVisible(false);

		stage.addActor(game_card_togglebtn);
		cardQuant.setVisible(false);
		stage.addActor(cardQuant);
	}

	public static int getStageStart(){
		return menuobjectsStageStart;
	}

	public static int getStageEnd(){
		return resourcesStageEnd;
	}

	public static void refreshResources()
	{
		goldQuant.setText(""+GameScreen.game.getPlayerTurn().getGold());
		coalQuant.setText(""+GameScreen.game.getPlayerTurn().getFuel("Coal"));
		oilQuant.setText(""+GameScreen.game.getPlayerTurn().getFuel("Oil"));
		electricityQuant.setText(""+GameScreen.game.getPlayerTurn().getFuel("Electric"));
		nuclearQuant.setText(""+GameScreen.game.getPlayerTurn().getFuel("Nuclear"));
		GameScreen_ActorManager.cardQuant.setText(""+GameScreen.game.getPlayerTurn().getCards().size());
	}

	public static void setResourcesHeight(float height)
	{
		GameScreen_ActorManager.goldQuant.setY(height);
		GameScreen_ActorManager.coalQuant.setY(height);
		GameScreen_ActorManager.oilQuant.setY(height);
		GameScreen_ActorManager.electricityQuant.setY(height);
		GameScreen_ActorManager.nuclearQuant.setY(height);
		GameScreen_ActorManager.cardQuant.setY(height);
	}

	public LabelStyle  getLabelStyle(int fontsize){
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = fontsize;

		BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose();
		LabelStyle style = new LabelStyle();
		style.font = font;

		return style;

	}

}