package com.TeamHEC.LocomotionCommotion.Game;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.TeamHEC.LocomotionCommotion.Card.Game_CardHand;
import com.TeamHEC.LocomotionCommotion.Goal.GoalMenu;
import com.TeamHEC.LocomotionCommotion.Goal.PlayerGoals;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.MapActors.Game_Map_Manager;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.Train.TrainDepotUI;
import com.TeamHEC.LocomotionCommotion.UI_Elements.GameScreenUI;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_PauseMenu;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_Shop;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_StartingSequence;
import com.TeamHEC.LocomotionCommotion.UI_Elements.TimerText;
import com.TeamHEC.LocomotionCommotion.UI_Elements.WarningMessage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

/**
 * 
 * @author Robert Precious <rp825@york.ac.uk>
 * Game Screen is the Screen that handles everything in the game screen.
 * First we sort the Camera- create the stage, create the camera and set the dimensions and update
 * Then we create all the managers- these manage the actors and they are split up in to separate menu sections.
 *
 * @param stage - The stage for the actors.
 * @param sb - The spritebatch (needed for textbox's etc)
 * @param camera - the camera
 * 
 * we have methods:
 * create - explained above
 * render - updates the camera, lets the actors act and draws the screen
 * resize - updates the screen size when window is resized
 * show - just calls create.
 * dispose - disposes of the stage
 * getStage and setStage - getters and setters for stage
 * resetScreen- used when reentering the screen- it resets all the settings.
 * 
 */
public class GameScreen implements Screen {
	public static CoreGame game;
	private static Stage stage;
	public static SpriteBatch sb;
	public OrthographicCamera camera;
	public static Game_Map_Manager mapManager;
	static boolean started = false;
	public static long gameStartTime, gameDuration;
	public static TimerText gameTimers;
	public long gameTimeLeft;
	public int gameSecondsLeft;
	
	/**
	 * 	
	 */
	public static void create(){
		//Set up stage camera
		stage = new Stage(); 
		Camera camera = stage.getCamera();
		camera.viewportHeight = Gdx.graphics.getHeight();
		camera.viewportWidth = Gdx.graphics.getWidth();
		camera.update();
		
		gameStartTime = -1;
		gameDuration = LocomotionCommotion.timeChoice*60000;

		Gdx.input.setInputProcessor(getStage());	
		stage.getActors().clear();
		
		//Instantiate the Managers
		mapManager = new Game_Map_Manager();
		mapManager.create(getStage());
		
		gameTimers = new TimerText();
		gameTimers.create(getStage());
		
		Game_CardHand cardHand = new Game_CardHand();
		cardHand.create(getStage());

		GameScreenUI actorManager = new GameScreenUI();
		actorManager.create(getStage());

		TrainDepotUI trainDepot = new TrainDepotUI();
		trainDepot.create(getStage());

		GoalMenu goalScreenManager = new GoalMenu();
		goalScreenManager.create(getStage());
		
		PlayerGoals ticketManager = new PlayerGoals();
		ticketManager.create(getStage());	
		
		Game_StartingSequence startgameManager = new Game_StartingSequence();
		startgameManager.create(getStage());
		
		Game_Shop shop = new Game_Shop();
		shop.create(getStage());
		
		Game_PauseMenu pauseMenu= new Game_PauseMenu();
		pauseMenu.create(getStage());
		
		WarningMessage warningMessage = new WarningMessage();
		warningMessage.create(getStage());
	}
	
	public static void createCoreGame(Station p1Station, Station p2Station)
	{
		game = new CoreGame(LocomotionCommotion.player1name, LocomotionCommotion.player2name, p1Station, p2Station, LocomotionCommotion.timeChoice);
		gameStartTime = System.currentTimeMillis();
		GameScreenUI.refreshResources();
		started = true;
	}
	
	@Override
	public void render(float delta) {
		getStage().getCamera().update();

		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		getStage().act(Gdx.graphics.getDeltaTime());
		getStage().draw();
		
		checkForCollisions();
		
		//gameTimers.setText2("Turn time left: null");
		
		if (gameStartTime >= 0){
			gameTimeLeft = gameDuration - (System.currentTimeMillis() - gameStartTime);
			gameSecondsLeft = (int)(gameTimeLeft/1000);
			gameTimers.setText1("Game time left: " + (Integer.toString(gameSecondsLeft)) + "s");
			
			if (gameSecondsLeft <= 0){
				gameTimers.setText1("Game time left: 0s");
				LocomotionCommotion.gameFinished = true;
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		getStage().getViewport().update(width, height, true);	
		LocomotionCommotion.screenX = width;
		LocomotionCommotion.screenY = height;
	}

	@Override
	public void show() {
		GameScreen.create();

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}
	public static void resetStage(){
	}

	@Override
	public  void dispose() {
		getStage().dispose();
		getStage().getActors().clear();
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		GameScreen.stage = stage;
	}
	/**
	 * Reset Screen - Sets all the boolean to start values and clears actors and resets the map. 
	 */
	public void  resetScreen(){
		Game_Map_Manager.infoVisible= false;
		Game_PauseMenu.actorManager.open = false;
		PlayerGoals.open = false;
		Game_Shop.actorManager.open = false;
		TrainDepotUI.actorManager.open = false;
		GameScreenUI.resourcebarexpanded =false;
		GoalMenu.open= false;
		
		//CARDS
		Game_CardHand.actorManager.open=false;
		Game_CardHand.actorManager.cardactors.clear();;
		
		//Map
		Game_StartingSequence.reset();
		Game_Map_Manager.resetMap();
	}
	
	public void checkForCollisions(){
		//checks whether the game has been started, avoids null pointer exception when looking for arrays of
		//trains
		if (started){
			//makes sure that the players both at least have one train
			if (game.getPlayerTurn().getTrains().size() > 0){
				ArrayList<Train> trains = new ArrayList<Train>(game.getPlayer2().getTrains());
				trains.addAll(game.getPlayer1().getTrains());
				//checks for every train paired with every other train than itself, whether the rectangles
				//they are contained within collide
				for (Train train1 : trains){
					for (Train train2 : trains){
						if (train1 != train2){
							if (train1.getActor().getBounds().overlaps(train2.getActor().getBounds())){
								//Checks if both trains are on connections, if they are checks that they are both on
								//the same connection (travelling either way)
								if (train1.route.getRoute().size() > 0 && train2.route.getRoute().size() > 0){
									if (train1.route.getRoute().get(train1.route.getRouteIndex()) == 
											train2.route.getRoute().get(train2.route.getRouteIndex()) ||
											train1.route.getRoute().get(train1.route.getRouteIndex()).getDestination() == 
											train2.route.getRoute().get(train2.route.getRouteIndex()).getStartMapObj()){
										WarningMessage.fireWarningWindow("CRASH", train1.getName() + " has collided with " + train2.getName() +
												"\n they have been destroyed.");
										//break the connection due to the crash
										Game_Map_Manager.breakConnection(train2.route.getRoute().get(train2.route.getRouteIndex()).getStartMapObj(), 
												train2.route.getRoute().get(train2.route.getRouteIndex()).getDestination());
										//remove both the trains from the game
										train1.getOwner().getTrains().remove(train1);
										train1.getActor().setVisible(false);
										train2.getActor().setTouchable(Touchable.disabled);
										train2.getOwner().getTrains().remove(train2);
										train2.getActor().setVisible(false);
										train2.getActor().setTouchable(Touchable.disabled);
									}
								}
								//if one train is in a station it doesnt matter which connection the other is on
								//as we do not break any connections
								else if (train1.isInStation() || train2.isInStation()){
									//remove both the trains from the game
									train1.getOwner().getTrains().remove(train1);
									train1.getActor().setVisible(false);
									train2.getActor().setTouchable(Touchable.disabled);
									train2.getOwner().getTrains().remove(train2);
									train2.getActor().setVisible(false);
									train2.getActor().setTouchable(Touchable.disabled);
									WarningMessage.fireWarningWindow("CRASH", train1.getName() + " has collided with " + train2.getName() +
											"\n they have been destroyed.");
								}
							}
						}
					}
				}
			}
		}
	}
}
