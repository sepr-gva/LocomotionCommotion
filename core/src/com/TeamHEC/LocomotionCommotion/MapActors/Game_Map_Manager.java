package com.TeamHEC.LocomotionCommotion.MapActors;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Card.BreakRailCard;
import com.TeamHEC.LocomotionCommotion.Card.Card;
import com.TeamHEC.LocomotionCommotion.Card.FixRailCard;
import com.TeamHEC.LocomotionCommotion.Card.TeleportCard;
import com.TeamHEC.LocomotionCommotion.Game.GameScreen;
import com.TeamHEC.LocomotionCommotion.Map.Connection;
import com.TeamHEC.LocomotionCommotion.Map.ConnectionSprite;
import com.TeamHEC.LocomotionCommotion.Map.Junction;
import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
import com.TeamHEC.LocomotionCommotion.Train.Train;
import com.TeamHEC.LocomotionCommotion.Train.TrainInfoUI;
import com.TeamHEC.LocomotionCommotion.UI_Elements.GameScreenUI;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Sprite;
import com.TeamHEC.LocomotionCommotion.UI_Elements.SpriteButton;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.Array;
/**
 * 
 * @author Robert Precious/ Matthew Taylor <rp825@york.ac.uk>
 * Map Manager is used to 'manage' the map. It creates the map actors for the map. Handles routing UI and map/station information.
 */
public class Game_Map_Manager {

	private final static Array<Actor> actors = new Array<Actor>();
	private final static Array<Actor> infoactors = new Array<Actor>();
	private final static Array<Actor> trainInfoActors = new Array<Actor>();

	public static Sprite mapInfo, mapLines, cityNames;
	
	public static Array<ConnectionSprite> connectionSprites = new Array<ConnectionSprite>();
	
	public static Sprite stationInfo;
	public static Game_Map_StationBtn stationSelect;
	
	public static boolean sellTrain = false, teleportTrain = false, 
			teleportCity = false, firstBreakCity = false, secondBreakCity = false,
			firstFixCity = false, secondFixCity = false;
	
	public static int brokenOffset = 0;
	
	public static TeleportCard currentTeleportCard = null;
	public static BreakRailCard currentBreakCard = null;
	public static FixRailCard currentFixCard = null;
	
	public static TrainInfoUI trainInfo;

	public static boolean infoVisible= false;
	public static int  stagestart, mapActors, stationTracker, numberOfStations, junctionTracker, numberOfJunctions = 2;
	public static Label stationLabelFuel,stationLabelName, stationLabelCost;
	public LabelStyle style;

	public static Sprite planBackground, routingModeWindow;
	public static Label routeLength, routeRemaining, routeFuelCost;
	public static SpriteButton confirmRouteBtn, undoLastRouteButton, abortRouteBtn, cancelRouteBtn;
	public static Array<Game_Map_Train> trainBlips = new Array<Game_Map_Train>();

	public Game_Map_Manager(){	}

	public void create(Stage stage){
	
		actors.clear();
		infoactors.clear();
		resetMap();
		stagestart =0;
		mapActors=0;
		stationTracker=0;
		numberOfStations=0;
		
		// Create the broken connection sprites
		
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsAmsterdamBerlin, WorldMap.getInstance().stationsList.get(4), WorldMap.getInstance().stationsList.get(18)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsAmsterdamDublin, WorldMap.getInstance().stationsList.get(4), WorldMap.getInstance().stationsList.get(3)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsAthensRome, WorldMap.getInstance().stationsList.get(17), WorldMap.getInstance().stationsList.get(13)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsAthensVienna, WorldMap.getInstance().stationsList.get(17), WorldMap.getInstance().stationsList.get(12)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsBerlinJunct, WorldMap.getInstance().stationsList.get(18), WorldMap.getInstance().junction[0]));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsBerlinOslo, WorldMap.getInstance().stationsList.get(18), WorldMap.getInstance().stationsList.get(5)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsWarsawBerlin, WorldMap.getInstance().stationsList.get(10), WorldMap.getInstance().stationsList.get(18)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsBernJunct, WorldMap.getInstance().stationsList.get(19), WorldMap.getInstance().junction[0]));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsBernMonaco, WorldMap.getInstance().stationsList.get(19), WorldMap.getInstance().stationsList.get(16)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsBernPrague, WorldMap.getInstance().stationsList.get(19), WorldMap.getInstance().stationsList.get(11)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsBernRome, WorldMap.getInstance().stationsList.get(19), WorldMap.getInstance().stationsList.get(13)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsDublinLondon, WorldMap.getInstance().stationsList.get(3), WorldMap.getInstance().stationsList.get(0)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsDublinReykjavic, WorldMap.getInstance().stationsList.get(3), WorldMap.getInstance().stationsList.get(2)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsHelsinkiMoscow, WorldMap.getInstance().stationsList.get(7), WorldMap.getInstance().stationsList.get(9)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsHelsinkiStockholm, WorldMap.getInstance().stationsList.get(7), WorldMap.getInstance().stationsList.get(6)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsHelsinkiVilnius, WorldMap.getInstance().stationsList.get(7), WorldMap.getInstance().stationsList.get(8)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsLisbonMadrid, WorldMap.getInstance().stationsList.get(15), WorldMap.getInstance().stationsList.get(14)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsLisbonRome, WorldMap.getInstance().stationsList.get(15), WorldMap.getInstance().stationsList.get(13)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsLondonParis, WorldMap.getInstance().stationsList.get(0), WorldMap.getInstance().stationsList.get(1)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsMadridMonaco, WorldMap.getInstance().stationsList.get(14), WorldMap.getInstance().stationsList.get(16)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsMadridParis, WorldMap.getInstance().stationsList.get(14), WorldMap.getInstance().stationsList.get(1)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsMonacoParis, WorldMap.getInstance().stationsList.get(16), WorldMap.getInstance().stationsList.get(1)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsMoscowJunct, WorldMap.getInstance().stationsList.get(9), WorldMap.getInstance().junction[1]));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsOsloReykjavic, WorldMap.getInstance().stationsList.get(5), WorldMap.getInstance().stationsList.get(2)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsOsloStockholm, WorldMap.getInstance().stationsList.get(5), WorldMap.getInstance().stationsList.get(6)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsParisJunct, WorldMap.getInstance().stationsList.get(1), WorldMap.getInstance().junction[0]));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsPragueLjunct, WorldMap.getInstance().stationsList.get(11), WorldMap.getInstance().junction[0]));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsPragueRjunct, WorldMap.getInstance().stationsList.get(11), WorldMap.getInstance().junction[1]));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsPragueVienna, WorldMap.getInstance().stationsList.get(11), WorldMap.getInstance().stationsList.get(12)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsPragueWarsaw, WorldMap.getInstance().stationsList.get(11), WorldMap.getInstance().stationsList.get(10)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsStockholmWarsaw, WorldMap.getInstance().stationsList.get(6), WorldMap.getInstance().stationsList.get(10)));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsVilniusJunct, WorldMap.getInstance().stationsList.get(8), WorldMap.getInstance().junction[1]));
		connectionSprites.add(new ConnectionSprite(100, 60, Game_Map_TextureManager.getInstance().obsWarsawJunct, WorldMap.getInstance().stationsList.get(10), WorldMap.getInstance().junction[1]));
		

		planBackground = new Sprite(-1,50,Game_TextureManager.getInstance().game_pause_blackoutscreen);
		planBackground.setVisible(false);
		actors.add(planBackground);
		
		routingModeWindow = new Sprite(-20,65,Game_TextureManager.getInstance().routingModeWindow);
		routingModeWindow.setVisible(false);
		actors.add(routingModeWindow);
		
		confirmRouteBtn = new SpriteButton(20, 125, Game_TextureManager.getInstance().confirmroutingModebtn){
			@Override
			protected void onClicked(){
				exitRoutingMode();
			}
		};
		confirmRouteBtn.setVisible(false);
		actors.add(confirmRouteBtn);
		
		undoLastRouteButton = new SpriteButton(130, 125, Game_TextureManager.getInstance().undoRouteBtn){
			@Override
			protected void onClicked()
			{
				if(Game_Map_Manager.trainInfo.train != null)
					Game_Map_Manager.trainInfo.train.route.removeConnection();
			}
		};
		undoLastRouteButton.setVisible(false);
		actors.add(undoLastRouteButton);
		
		abortRouteBtn = new SpriteButton(130, 80, Game_TextureManager.getInstance().abortRouteBtn){
			@Override
			protected void onClicked()
			{
				if(Game_Map_Manager.trainInfo.train != null)
					Game_Map_Manager.trainInfo.train.route.abortRoute();
			}
		};
		abortRouteBtn.setVisible(false);
		actors.add(abortRouteBtn);
		
		cancelRouteBtn = new SpriteButton(20, 80, Game_TextureManager.getInstance().cancelRouteBtn){
			@Override
			protected void onClicked()
			{
				if(Game_Map_Manager.trainInfo.train != null)
					Game_Map_Manager.trainInfo.train.route.cancelRoute();;
			}
		};
		cancelRouteBtn.setVisible(false);
		actors.add(cancelRouteBtn);

		mapLines = new Sprite(100, 60, Game_Map_TextureManager.getInstance().mapLines);		
		actors.add(mapLines);
		
		for (ConnectionSprite sprite : connectionSprites){
			sprite.setVisible(false);
			actors.add(sprite);
		}
		
		cityNames = new Sprite(100, 60, Game_Map_TextureManager.getInstance().cityNames);
		actors.add(cityNames);
	
		stationTracker=stage.getActors().size;
		for(int i = 0; i < WorldMap.getInstance().stationsList.size(); i++)
		{
			actors.add(WorldMap.getInstance().stationsList.get(i).getActor());
			numberOfStations++;
		}

		junctionTracker =stage.getActors().size;
		for(int i = 0; i < WorldMap.getInstance().junction.length; i++)
		{
			actors.add(WorldMap.getInstance().junction[i].getActor());
		}
		
		// Creates UI Train blips for 6 trains:
		for(int i = 0; i < 6; i++)
		{
			trainBlips.add(new Game_Map_Train());
		}
		actors.addAll(trainBlips);
		
		// Add train stuff

		stationInfo = new Sprite(0, 0, Game_Map_TextureManager.getInstance().stationInfo);
		infoactors.add(stationInfo);
		
		trainInfo = new TrainInfoUI();		
		trainInfoActors.add(trainInfo);
		trainInfoActors.addAll(trainInfo.getActors());

		stationSelect = new Game_Map_StationBtn(0, 0, Game_Map_TextureManager.getInstance().stationSelect);
		infoactors.add(stationSelect);

		//Stuff for Labels
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 23;

		BitmapFont font = generator.generateFont(parameter); 
		generator.dispose();
		style = new LabelStyle();
		style.font = font;
		//end

		stationLabelName = new Label(null, style);
		stationLabelFuel = new Label(null, style);
		stationLabelCost = new Label(null, style);
			
		stationLabelName.setText("LONDON");
		stationLabelName.setAlignment(Align.center);		
		stationLabelName.setColor(1,1,1,1);
		stationLabelName.setX(stationInfo.getX()+100);
		stationLabelName.setY(stationInfo.getY()+142);

		stationLabelFuel.setText("Type x 100");
		stationLabelFuel.setAlignment(Align.center);		
		stationLabelFuel.setColor(0,0,0,1);
		stationLabelFuel.setX(stationInfo.getX()+100);
		stationLabelFuel.setY(stationInfo.getY()+100);

		stationLabelCost.setText("");
		stationLabelCost.setAlignment(Align.center);		
		stationLabelCost.setColor(0,0,0,1);
		stationLabelCost.setX(stationInfo.getX()+100);
		stationLabelCost.setY(stationInfo.getY()+60);
		
		// Route Labels
		routeLength = new Label(null, style);
		routeRemaining = new Label(null, style);
		routeFuelCost =  new Label(null, style);
		
		routeLength.setText("Route length: 0");
		routeRemaining.setText("Route remaining: 0");
		routeFuelCost.setText("Fuel cost (): 0");
		
		routeLength.setPosition(10, 245, Align.center);
		routeRemaining.setPosition(10, 215, Align.center);
		routeFuelCost.setPosition(10, 185, Align.center);
		
		routeLength.setVisible(false);
		routeRemaining.setVisible(false);
		routeFuelCost.setVisible(false);
		routeLength.setColor(Color.BLACK);
		routeRemaining.setColor(Color.BLACK);
		routeFuelCost.setColor(Color.BLACK);
		actors.add(routeLength);
		actors.add(routeRemaining);
		actors.add(routeFuelCost);

		infoactors.add(stationLabelName);
		infoactors.add(stationLabelFuel);
		infoactors.add(stationLabelCost);
		
		for(Actor a : actors)
		{
			a.setTouchable(Touchable.enabled);
			stage.addActor(a);
		}
		
		stagestart = stage.getActors().size;
		
		for (Actor a : infoactors){
			a.setTouchable(Touchable.enabled);
			a.setVisible(false);
			stage.addActor(a);
			mapActors ++;
		}

		for(Actor a : trainInfoActors)
		{
			a.setTouchable(Touchable.enabled);
			a.setVisible(false);
			stage.addActor(a);
		}
		
		mapInfo = new Sprite(500, 100, Game_TextureManager.getInstance().mapInfo);

		mapInfo.setVisible(infoVisible);
		stage.addActor(mapInfo);
	}
	
	public static void enterRoutingMode()
	{		
		trainInfo.train.getRoute().showRouteBlips();
				
		trainsUntouchable();
		
		GameScreenUI.game_menuobject_endturnbutton.setVisible(false);
		
		planBackground.setVisible(true);
		routingModeWindow.setVisible(true);
		confirmRouteBtn.setVisible(true);
		undoLastRouteButton.setVisible(true);
		abortRouteBtn.setVisible(true);
		cancelRouteBtn.setVisible(true);
		
		routeLength.setVisible(true);
		routeRemaining.setVisible(true);
		routeFuelCost.setVisible(true);
		undoLastRouteButton.setVisible(true);
	}
	
	public static void exitRoutingMode()
	{
		trainInfo.unhighlightAdjacent();
		trainInfo.train.getRoute().hideRouteBlips();
		
		trainsTouchable();
		
		GameScreenUI.game_menuobject_endturnbutton.setVisible(true);
		
		planBackground.setVisible(false);
		routingModeWindow.setVisible(false);
		confirmRouteBtn.setVisible(false);
		undoLastRouteButton.setVisible(false);
		abortRouteBtn.setVisible(false);
		cancelRouteBtn.setVisible(false);
		
		routeLength.setVisible(false);
		routeRemaining.setVisible(false);
		routeFuelCost.setVisible(false);
		undoLastRouteButton.setVisible(false);
	}

	public static void moveInfoBox(float x,float y){
		showInfoBox();
		stationInfo.setX(x);
		stationInfo.setY(y);
		stationInfo.refreshBounds();
		Game_Map_Manager.stationSelect.setX(x+20);
		Game_Map_Manager.stationSelect.setY(y+10);
		Game_Map_Manager.stationSelect.refreshBounds();

		stationLabelName.setX(x+100);
		stationLabelName.setY(y+142);

		stationLabelFuel.setX(x+100);
		stationLabelFuel.setY(y+100);

		stationLabelCost.setX(x+100);
		stationLabelCost.setY(y+60);
	}

	public static void hideInfoBox(){
		stationInfo.setVisible(false);
		Game_Map_Manager.stationSelect.setVisible(false);

		stationLabelName.setVisible(false);
		stationLabelFuel.setVisible(false);
		stationLabelCost.setVisible(false);
	}
	
	public static void showInfoBox(){
		stationInfo.setVisible(true);
		Game_Map_Manager.stationSelect.setVisible(true);

		stationLabelName.setVisible(true);
		stationLabelFuel.setVisible(true);
		stationLabelCost.setVisible(true);
	}

	public static void resetMap(){
		for(int i=Game_Map_Manager.stationTracker; i<=Game_Map_Manager.stationTracker +Game_Map_Manager.numberOfStations-1;i++)	//All the stations on the stage
		{ 	
			if (i > GameScreen.getStage().getActors().size-1)
			{//This is just to avoid range errors
			}
			else{
				if (GameScreen.getStage().getActors().get(i).getClass() == Game_Map_Station.class)
				{
					((Game_Map_Station) GameScreen.getStage().getActors().get(i)).setOwned(false);
				}
			}
		}
	}
	
	public static void breakConnection(MapObj start, MapObj end){
		boolean validConnection = false;
		for (Station station : WorldMap.getInstance().stationsList){
			if (start == station){
				for (Connection connection : station.connections){
					if (connection.getDestination() == end){
						if (!connection.getTraversable()){
							System.out.println("Connection between " + start.getName() +
							" and " + end.getName() + " is already broken.");
						}
						connection.setTraversable(false);
						validConnection = true;
						for (ConnectionSprite sprite : connectionSprites){
							if ((connection.getStartMapObj() == sprite.getCity1() &&
									connection.getDestination() == sprite.getCity2()) ||
									connection.getDestination() == sprite.getCity1() &&
									connection.getStartMapObj() == sprite.getCity2()){
								sprite.setVisible(true);
								brokenOffset += 1;
							}
						}
					}
				}
			}
			else if (end == station){
				for (Connection connection : station.connections){
					if (connection.getDestination() == start){
						connection.setTraversable(false);
					}
				}
			}
		}
		for (Junction junction : WorldMap.getInstance().junction){
			if (start == junction){
				for (Connection connection : junction.connections){
					if (connection.getDestination() == end){
						if (!connection.getTraversable()){
							System.out.println("Connection between " + start.getName() +
							" and " + end.getName() + " is already broken.");
						}
						connection.setTraversable(false);
						validConnection = true;
						for (ConnectionSprite sprite : connectionSprites){
							if ((connection.getStartMapObj() == sprite.getCity1() &&
									connection.getDestination() == sprite.getCity2()) ||
									connection.getDestination() == sprite.getCity1() &&
									connection.getStartMapObj() == sprite.getCity2()){
								sprite.setVisible(true);
								brokenOffset -= 1;
							}
						}
					}
				}
			}
			else if (end == junction){
				for (Connection connection : junction.connections){
					if (connection.getDestination() == start){
						connection.setTraversable(false);
					}
				}
			}
		}
		
		if (!validConnection){
			System.out.println("There is no connection between " + start.getName() + 
					" and " + end.getName() + ".");
		}
	}
	
	public static void repairConnection(MapObj start, MapObj end){
		boolean validConnection = false;
		for (Station station : WorldMap.getInstance().stationsList){
			if (start == station){
				for (Connection connection : station.connections){
					if (connection.getDestination() == end){
						if (connection.getTraversable()){
							System.out.println("Connection between " + start.getName() +
							" and " + end.getName() + " is not broken.");
						}
						connection.setTraversable(true);
						validConnection = true;
						for (ConnectionSprite sprite : connectionSprites){
							if ((connection.getStartMapObj() == sprite.getCity1() &&
									connection.getDestination() == sprite.getCity2()) ||
									(connection.getDestination() == sprite.getCity1() &&
									connection.getStartMapObj() == sprite.getCity2())){
								sprite.setVisible(false);
							}
						}
					}
				}
			}
			else if (end == station){
				for (Connection connection : station.connections){
					if (connection.getDestination() == start){
						connection.setTraversable(true);
					}
				}
			}
		}
		for (Junction junction : WorldMap.getInstance().junction){
			if (start == junction){
				for (Connection connection : junction.connections){
					if (connection.getDestination() == end){
						if (connection.getTraversable()){
							System.out.println("Connection between " + start.getName() +
							" and " + end.getName() + " is not broken.");
						}
						connection.setTraversable(true);
						validConnection = true;
						for (ConnectionSprite sprite : connectionSprites){
							if ((connection.getStartMapObj() == sprite.getCity1() &&
									connection.getDestination() == sprite.getCity2()) ||
									(connection.getDestination() == sprite.getCity1() &&
									connection.getStartMapObj() == sprite.getCity2())){
								sprite.setVisible(false);
							}
						}
					}
				}
			}
			else if (end == junction){
				for (Connection connection : junction.connections){
					if (connection.getDestination() == start){
						connection.setTraversable(true);
					}
				}
			}
		}
		if (!validConnection){
			System.out.println("There is no connection between " + start.getName() + 
					" and " + end.getName() + ".");
		}
	}
	
	public static void trainsUntouchable(){
		// Allows you to click on stations that are covered by trains:
				for(Train t : GameScreen.game.getPlayer1().getTrains())
				{
					t.getActor().setTouchable(Touchable.disabled);
				}
				for(Train t : GameScreen.game.getPlayer2().getTrains())
				{
					t.getActor().setTouchable(Touchable.disabled);
				}
	}
	
	public static void trainsTouchable(){
		//Makes trains clickable again
				for(Train t : GameScreen.game.getPlayer1().getTrains())
				{
					t.getActor().setTouchable(Touchable.enabled);
				}
				for(Train t : GameScreen.game.getPlayer2().getTrains())
				{
					t.getActor().setTouchable(Touchable.enabled);
				}
	}
	
	public static Array<Actor> getActors(){
		return actors;
	}
}