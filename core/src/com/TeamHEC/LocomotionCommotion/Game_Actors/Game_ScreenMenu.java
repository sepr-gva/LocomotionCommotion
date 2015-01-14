package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Array;

public class Game_ScreenMenu {
	public static ScreenMenuManager actorManager;
	public static Game_ResourcesManager resourceActorManager;

	public void create(Stage stage){
		actorManager = new ScreenMenuManager();
		actorManager.create(stage);
		resourceActorManager = new Game_ResourcesManager();
		resourceActorManager.create(stage);
	}
	public static class ScreenMenuManager {

		private final static Array<Actor> actors = new Array<Actor>();

		public  Game_Asset game_menuobject_topbar;
		public  Game_menuobject_MenuBtn game_menuobject_menubtn;

		public  Game_menuobject_TicketToggleBtn game_menuobject_tickettoggle;
		public Game_Asset game_menuobject_ticketenclosure;
		public  Game_menuobject_EndTurnBtn game_menuobject_endturnbutton;
		public  Game_Asset game_menuobject_cornerframe;
		public  Game_menuobject_InfoToggleBtn game_menuobject_infobutton;

		public  Game_menuobject_ShopBtn game_menuobject_shopbtn;
		public  Game_menuobject_TrainDepotBtn game_menuobject_traindepotbtn;

		public  Game_menuobjects_GoalScreenBtn game_menuobject_goalscreenbtn;
		public  Label playerScore;

		public  int menuobjectsStageStart, menuobjectsStageEnd;



		public ScreenMenuManager(){		}

		public void create(Stage stage){
			actors.clear();

			FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
			FreeTypeFontParameter parameter = new FreeTypeFontParameter();
			parameter.size = 32;

			BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
			generator.dispose();
			LabelStyle style = new LabelStyle();
			style.font = font;


			playerScore = new Label(null, style);
			playerScore.setColor(0,0,0,1);
			//			playerScore.setText(GameScreen.game.getPlayer1()+"    " + GameScreen.game.getPlayer1().points +
			//					"     SCORE     "+ GameScreen.game.getPlayer2()+"     "+GameScreen.game.getPlayer2().points );


			playerScore.setText(GameScreen.player1name+"    " + GameScreen.player1score +
					"     SCORE     "+ GameScreen.player2score+"     "+GameScreen.player2name
					+"                      "+ GameScreen.player1name+" it's your turn ");
			playerScore.setX(600);
			playerScore.setY(Gdx.graphics.getHeight()- playerScore.getHeight() -45);


			game_menuobject_topbar = new Game_Asset(-20, Gdx.graphics.getHeight()- Game_TextureManager.getInstance().game_menuobject_topbar.getHeight() +10,
					Game_TextureManager.getInstance().game_menuobject_topbar );
			actors.add(game_menuobject_topbar);	
			
			game_menuobject_cornerframe=new Game_Asset((LocomotionCommotion.screenX-Game_TextureManager.getInstance().game_menuobject_cornerframe.getWidth()),14
					,Game_TextureManager.getInstance().game_menuobject_cornerframe);
			actors.add(game_menuobject_cornerframe);

			game_menuobject_menubtn = new Game_menuobject_MenuBtn();
			actors.add(game_menuobject_menubtn);
			
			//Add the enclosure straight in as is not visible at start
			game_menuobject_ticketenclosure=new Game_Asset(-1,game_menuobject_topbar.actorY-Game_TextureManager.getInstance().game_menuobject_ticketenclosure.getHeight()
												,Game_TextureManager.getInstance().game_menuobject_ticketenclosure);
			game_menuobject_ticketenclosure.setVisible(false);
			stage.addActor(game_menuobject_ticketenclosure);
			
			game_menuobject_tickettoggle=new Game_menuobject_TicketToggleBtn();
			actors.add(game_menuobject_tickettoggle);

			game_menuobject_endturnbutton=new Game_menuobject_EndTurnBtn();
			actors.add(game_menuobject_endturnbutton);


			game_menuobject_infobutton=new Game_menuobject_InfoToggleBtn();
			actors.add(game_menuobject_infobutton);

			game_menuobject_shopbtn = new Game_menuobject_ShopBtn();
			actors.add(game_menuobject_shopbtn);

			game_menuobject_traindepotbtn = new Game_menuobject_TrainDepotBtn();
			actors.add(game_menuobject_traindepotbtn);

			game_menuobject_goalscreenbtn = new Game_menuobjects_GoalScreenBtn();
			actors.add(game_menuobject_goalscreenbtn);

			actors.add(playerScore);

			menuobjectsStageStart = stage.getActors().size;
			menuobjectsStageEnd = menuobjectsStageStart+ actors.size-1;
			for (Actor a : actors){
				a.setTouchable(Touchable.enabled);
				a.setVisible(false);
				stage.addActor(a);
			}
		
		


		}
		public int getStageStart(){
			return menuobjectsStageStart;
		}
		public int getStageEnd(){
			return menuobjectsStageEnd;
		}

		/*
		 * Serializes all actors and stores them in an array. This and the Game object
		 * are then saved and stored to be loaded.
		 */
		public static void saveActors()
		{


		}


	}

	//Screen Menu Actors--------------------------------------------------------------------------
	//End Turn Button
	public static class Game_menuobject_EndTurnBtn extends Game_Actor {
		public Game_menuobject_EndTurnBtn(){
			texture = Game_TextureManager.getInstance().game_menuobject_endturnbutton; // reuse the new game back btn texture
			actorX = (LocomotionCommotion.screenX-texture.getWidth()-15) ;
			actorY = 15;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobject_EndTurnBtn)event.getTarget()).started = true;
					return true;
				}
			});

		}
		public void act(float delta){
			if(started){
				started = false;
			}
		}
	}
	//InfoToggleButton
	public static class Game_menuobject_InfoToggleBtn extends Game_Actor {
		public Game_menuobject_InfoToggleBtn(){
			texture = Game_TextureManager.getInstance().game_menuobject_infobutton; // reuse the new game back btn texture
			actorX = LocomotionCommotion.screenX-310 ;
			actorY = 63;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobject_InfoToggleBtn)event.getTarget()).started = true;
					return true;
				}
			});

		}
		public void act(float delta){
			if(started){
				if (Game_Map_Manager.infoVisible== false)
				{
					Game_Map_Manager.infoVisible= true;
					for(int i=Game_Map_Manager.stagestart; i<=Game_Map_Manager.stagestart +Game_Map_Manager.mapActors-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_Map_Manager.infoVisible= false;
				for(int i=Game_Map_Manager.stagestart; i<=Game_Map_Manager.stagestart +Game_Map_Manager.mapActors-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}

				}
				started = false;
			}
		}



	}
	//Pause Menu Button
	public static class Game_menuobject_MenuBtn extends Game_Actor {
		public Game_menuobject_MenuBtn(){
			texture = Game_TextureManager.getInstance().game_menuobject_menubtn; // reuse the new game back btn texture
			actorX = LocomotionCommotion.screenX-60 ;
			actorY = Gdx.graphics.getHeight()- texture.getHeight() - 30;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobject_MenuBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}

		public void act(float delta){
			if(started){
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
				//				//NEW CARD PROTOTYPING
				//				OilCard newcard = new OilCard();
				//				Game_CardHandManager.addCard(newcard);
				started = false;
			}
		}
	}
	//ShopBtn
	public static class Game_menuobject_ShopBtn extends Game_Actor {
		public Game_menuobject_ShopBtn(){
			texture = Game_TextureManager.getInstance().game_shop_shopbtn; // reuse the new game back btn texture
			actorX = LocomotionCommotion.screenX-310 ;
			actorY = 125;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobject_ShopBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}

		public void act(float delta){
			if(started){
				if (Game_Shop.actorManager.open== false)
				{
					Game_Shop.actorManager.open= true;
					for(int i=Game_Shop.actorManager.getStageStart(); i<=Game_Shop.actorManager.getStageEnd(); i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_Shop.actorManager.open= false;
				for(int i=Game_Shop.actorManager.getStageStart(); i<=Game_Shop.actorManager.getStageEnd(); i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}

				}
				started = false;
			}
		}
	}
	//TicketToggle
	public static class Game_menuobject_TicketToggleBtn extends Game_Actor {
		public Game_menuobject_TicketToggleBtn(){
			texture = Game_TextureManager.getInstance().game_menuobject_ticketbtn; 
			actorX = 30 ;
			actorY = Gdx.graphics.getHeight()- texture.getHeight() -15;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobject_TicketToggleBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}

		public void act(float delta){
			if(started){
				if (Game_goal_PlayerGoals.open== false)
				{
					Game_goal_PlayerGoals.open= true;
					for(int i=Game_goal_PlayerGoals.stagestart; i<=Game_goal_PlayerGoals.stagestart +Game_goal_PlayerGoals.ticketActors-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}
					Game_ScreenMenu.actorManager.game_menuobject_ticketenclosure.setVisible(true);
					}
				else
				{	Game_goal_PlayerGoals.open= false;
				for(int i=Game_goal_PlayerGoals.stagestart; i<=Game_goal_PlayerGoals.stagestart +Game_goal_PlayerGoals.ticketActors-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}
				Game_ScreenMenu.actorManager.game_menuobject_ticketenclosure.setVisible(false);
				}
				started = false;
			}
		}


	}
	
	//GoalScreenButton
	public static class Game_menuobjects_GoalScreenBtn extends Game_Actor {
		public Game_menuobjects_GoalScreenBtn(){
			texture = Game_TextureManager.getInstance().game_goals_goalscreenbtn; // reuse the new game back btn texture
			actorX = 110 ;
			actorY = Gdx.graphics.getHeight()- texture.getHeight() -25;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobjects_GoalScreenBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				if (Game_Goal_GoalScreenManager.open== false)
				{
					Game_Goal_GoalScreenManager.open= true;
					Game_goal_PlayerGoals.goalMenuOpen();
					for(int i=Game_Goal_GoalScreenManager.stagestart; i<=Game_Goal_GoalScreenManager.stagestart +Game_Goal_GoalScreenManager.goalActors-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_Goal_GoalScreenManager.open= false;
				Game_goal_PlayerGoals.goalMenuClose();
				for(int i=Game_Goal_GoalScreenManager.stagestart; i<=Game_Goal_GoalScreenManager.stagestart +Game_Goal_GoalScreenManager.goalActors-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}

				}
				started = false;
				}
			}
	}
	//TrainDeptButton
	public static class Game_menuobject_TrainDepotBtn extends Game_Actor {
		public Game_menuobject_TrainDepotBtn(){
			texture = Game_TextureManager.getInstance().game_traindepot_traindepotbtn; // reuse the new game back btn texture
			actorX = LocomotionCommotion.screenX-310 ;
			actorY = 193;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobject_TrainDepotBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}

		public void act(float delta){
			if(started){
				if (Game_TrainDepot.actorManager.open== false)
				{
					Game_TrainDepot.actorManager.open= true;
					for(int i=Game_TrainDepot.actorManager.getStageStart(); i<=Game_TrainDepot.actorManager.getStageEnd();i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_TrainDepot.actorManager.open= false;
				for(int i=Game_TrainDepot.actorManager.getStageStart(); i<=Game_TrainDepot.actorManager.getStageEnd();i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}

				}
				started = false;
				}
			}
	}
	//Resources toggle button
	public static class Game_resources_ToggleBtn extends Game_Actor {
		public Game_resources_ToggleBtn(){
			texture = Game_TextureManager.getInstance().game_menuobject_menubtn; // reuse the new game back btn texture
			actorX = 10 ;
			actorY = 30;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_resources_ToggleBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}

		public void act(float delta){
			int expandedheight=180;
			if(started){
				if (Game_ScreenMenu.resourceActorManager.resourcebarexpanded== false)
				{	
				//Move up button, bar and quantities
					Game_ScreenMenu.resourceActorManager.game_resources_togglebtn.actorY+=expandedheight;
					setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
					Game_ScreenMenu.resourceActorManager.game_menuobject_resourcesbar.actorY+=expandedheight;
					Game_ResourcesManager.setResourcesHeight(Game_ScreenMenu.resourceActorManager.cardQuant.getY()+expandedheight);
					//move cards up
					Game_ScreenMenu.resourceActorManager.game_card_togglebtn.actorY+=expandedheight;
					Game_ScreenMenu.resourceActorManager.game_card_togglebtn.refreshBounds();
					Game_CardHandManager.organiseDeck();
					Game_CardHandManager.changeHeight(expandedheight);
					Game_CardHandManager.usecardbtn.setVisible(false);
					
					
					
					
					Game_ScreenMenu.resourceActorManager.resourcebarexpanded= true;
					for(int i=Game_ResourcesManager.resourcesStageStart; i<=Game_ResourcesManager.resourcesStageStart +Game_ResourcesManager.resourcesStageEnd-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_ScreenMenu.resourceActorManager.resourcebarexpanded= false;
				Game_CardHandManager.usecardbtn.setVisible(false);
				//Move up
				Game_ScreenMenu.resourceActorManager.game_resources_togglebtn.actorY-=expandedheight;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				Game_ScreenMenu.resourceActorManager.game_menuobject_resourcesbar.actorY-=expandedheight;
				Game_ResourcesManager.setResourcesHeight(Game_ScreenMenu.resourceActorManager.cardQuant.getY()-expandedheight);
				
				Game_ScreenMenu.resourceActorManager.game_card_togglebtn.actorY-=expandedheight;
				Game_ScreenMenu.resourceActorManager.game_card_togglebtn.refreshBounds();
				Game_CardHandManager.selectedCard=0;
				Game_CardHandManager.changeHeight(-expandedheight);
				Game_CardHandManager.organiseDeck();
			//end
				for(int i=Game_ResourcesManager.resourcesStageStart; i<=Game_ResourcesManager.resourcesStageStart +Game_ResourcesManager.resourcesStageEnd-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(true);

				}

				}
				started = false;
			}
		}
	}
	//Resources
	public static class Game_ResourcesManager {

		private final static Array<Actor> visibleActors = new Array<Actor>();
		

		public Game_Asset game_menuobject_resourcesbar;
		public Game_resources_ToggleBtn game_resources_togglebtn;
		public Game_card_CardToggleBtn game_card_togglebtn;
		public boolean resourcebarexpanded = false;
		public static int  resourcesStageStart, resourcesStageEnd, expandedheight= 40;
		public static Label  goldQuant, coalQuant, oilQuant, electricityQuant, nuclearQuant;


		public Label cardQuant;
		
		
		public Game_ResourcesManager(){		}

		public void create(Stage stage){
			visibleActors.clear();
			resourcesStageStart=0;
			resourcesStageEnd =0;
			
			
			FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
			FreeTypeFontParameter parameter = new FreeTypeFontParameter();
			parameter.size = 19;
			
			BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
			generator.dispose();
			LabelStyle style = new LabelStyle();
			style.font = font;
		
			
			//Resources bar is now connected to variables for easy update of quantities.
			game_menuobject_resourcesbar = new Game_Asset(-13,-175,Game_TextureManager.getInstance().game_menuobject_resourcesbar);
			visibleActors.add(game_menuobject_resourcesbar);
			
			game_resources_togglebtn = new Game_resources_ToggleBtn();
			visibleActors.add(game_resources_togglebtn);
			
					
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
			
			refreshResources();
			
			visibleActors.add(goldQuant);
			visibleActors.add(coalQuant);
			visibleActors.add(oilQuant);
			visibleActors.add(electricityQuant);
			visibleActors.add(nuclearQuant);
			
			
			
			resourcesStageStart= stage.getActors().size;
			for (Actor a : visibleActors){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);
				stage.addActor(a);
				resourcesStageEnd ++;
			}
			game_card_togglebtn = new Game_card_CardToggleBtn();
			game_card_togglebtn.setVisible(false);
			stage.addActor(game_card_togglebtn);
			cardQuant.setVisible(false);
			stage.addActor(cardQuant);
			
			
			
				

		}
		
		public void refreshResources(){
			goldQuant.setText(""+GameScreen.gold);
			coalQuant.setText(""+GameScreen.coal);
			oilQuant.setText(""+GameScreen.oil);
			electricityQuant.setText(""+GameScreen.electricity);
			nuclearQuant.setText(""+GameScreen.nuclear);
			Game_ScreenMenu.resourceActorManager.cardQuant.setText(""+GameScreen.cards);
		}
		
		public static void setResourcesHeight(float height){
			goldQuant.setY(height);
			coalQuant.setY(height);
			oilQuant.setY(height);
			electricityQuant.setY(height);
			nuclearQuant.setY(height);
			Game_ScreenMenu.resourceActorManager.cardQuant.setY(height);
		}
		
		
		/*
		 * Serializes all actors and stores them in an array. This and the Game object
		 * are then saved and stored to be loaded.
		 */
		public static void saveActors()
		{
			
			
		}
		


	}




}
