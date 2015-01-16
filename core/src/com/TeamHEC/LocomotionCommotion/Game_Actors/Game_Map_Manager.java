package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Sprite;
import com.badlogic.gdx.Gdx;
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

public class Game_Map_Manager {

	private final static Array<Actor> actors = new Array<Actor>();
	private final static Array<Actor> infoactors = new Array<Actor>();

	public static Sprite map;
	public static Game_Map_Info mapInfo;

	public static Sprite stationInfo;
	public static Game_Map_StationBtn stationSelect;

	public static boolean infoVisible= false;
	public static int  stagestart, mapActors, stationTracker, numberOfStations, junctionTracker, numberOfJunctions = 2;
	public static Label stationLabelFuel,stationLabelName, stationLabelCost;
	public LabelStyle style;

	public static Sprite planBackground;

	public Game_Map_Manager(){	}

	public void create(Stage stage){

		actors.clear();
		infoactors.clear();
		resetMap();
		stagestart =0;
		mapActors=0;
		stationTracker=0;
		numberOfStations=0;


		planBackground = new Sprite(-1,50,Game_TextureManager.getInstance().game_pause_blackoutscreen);
		planBackground.setVisible(false);
		actors.add(planBackground);

		map = new Sprite(100, 60, Game_Map_TextureManager.getInstance().map);		
		actors.add(map);

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

		// Add train stuff

		stationInfo = new Sprite(0, 0, Game_Map_TextureManager.getInstance().stationInfo);
		infoactors.add(stationInfo);

		//=========================================================

		stationSelect = new Game_Map_StationBtn(0, 0, Game_Map_TextureManager.getInstance().stationSelect);
		infoactors.add(stationSelect);
		//=========================================================

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

		infoactors.add(stationLabelName);
		infoactors.add(stationLabelFuel);
		infoactors.add(stationLabelCost);


		for (Actor a : actors){
			a.setTouchable(Touchable.enabled);
			stage.addActor(a);
		}
		stagestart= stage.getActors().size;
		for (Actor a : infoactors){
			a.setTouchable(Touchable.enabled);
			a.setVisible(false);
			stage.addActor(a);
			mapActors ++;
		}

		mapInfo = new Game_Map_Info();
		mapInfo.setVisible(infoVisible);
		stage.addActor(mapInfo);
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
				if (GameScreen.getStage().getActors().get(i).getClass() == Game_Map_Station.class){
					((Game_Map_Station) GameScreen.getStage().getActors().get(i)).setOwned(false);
				}
			}
		}
	}
}