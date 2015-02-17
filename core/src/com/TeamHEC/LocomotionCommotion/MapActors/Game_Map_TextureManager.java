package com.TeamHEC.LocomotionCommotion.MapActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
/*
 * Holds all the textures and file paths for all actors in StartMenu
 * This means if we need to change a file path you come here.
 */
public class Game_Map_TextureManager{
	private static Game_Map_TextureManager instance = null;
	
	protected Game_Map_TextureManager()
	{}
	
	public static Game_Map_TextureManager getInstance() {
		if(instance == null)
			instance = new Game_Map_TextureManager();
		return instance;
	}	
	
	//Map
	public Texture map = new Texture(Gdx.files.internal("gameScreen/game_map/map.png"));
	public Texture mapLines = new Texture(Gdx.files.internal("gameScreen/game_map/lines.png"));
	public Texture cityNames = new Texture(Gdx.files.internal("gameScreen/game_map/cities.png"));
	public Texture mapInfo = new Texture(Gdx.files.internal("gameScreen/game_map/mapinfo.png"));
	public Texture station = new Texture(Gdx.files.internal("gameScreen/game_map/station.png"));
	public Texture stationx2 = new Texture(Gdx.files.internal("gameScreen/game_map/Stop.png"));
	
	public Texture stationInfo = new Texture(Gdx.files.internal("gameScreen/game_map/stationInfoframe.png"));
	public Texture stationSelect = new Texture(Gdx.files.internal("gameScreen/game_map/stationSelectBtn.png"));
	public Texture trainInfo = new Texture(Gdx.files.internal("gameScreen/game_map/trainInfo.png"));
	public Texture trainInfoPlanRoute = new Texture(Gdx.files.internal("gameScreen/game_map/trainInfoPlanRoute.png"));
	
	public Texture junction = new Texture(Gdx.files.internal("gameScreen/game_map/junction.png"));
	public Texture junctionx2 = new Texture(Gdx.files.internal("gameScreen/game_map/junction2.png"));
	
	public Texture p1Station = new Texture(Gdx.files.internal("gameScreen/game_map/p1station.png"));
	public Texture p1Stationx2 = new Texture(Gdx.files.internal("gameScreen/game_map/p1station2.png"));
	public Texture p1Train = new Texture(Gdx.files.internal("gameScreen/game_map/p1train.png"));
	public Texture p1Trainx2 = new Texture(Gdx.files.internal("gameScreen/game_map/p1train2.png"));
	
	public Texture p2Station = new Texture(Gdx.files.internal("gameScreen/game_map/p2station.png"));
	public Texture p2Stationx2 = new Texture(Gdx.files.internal("gameScreen/game_map/p2station2.png"));
	public Texture p2Train = new Texture(Gdx.files.internal("gameScreen/game_map/p2train.png"));
	public Texture p2Trainx2 = new Texture(Gdx.files.internal("gameScreen/game_map/p2train2.png"));
	
	public Texture routeBlip = new Texture(Gdx.files.internal("gameScreen/game_map/routeBlip.png"));
	public Texture redRouteBlip = new Texture(Gdx.files.internal("gameScreen/game_map/routeBlip2.png"));
	//Broken connections
	public Texture obsAmsterdamBerlin = new Texture(Gdx.files.internal("gameScreen/game_map/obstAmsterdamBerlin.png"));
	public Texture obsAmsterdamDublin = new Texture(Gdx.files.internal("gameScreen/game_map/obstAmsterdamDublin.png"));
	public Texture obsAthensRome = new Texture(Gdx.files.internal("gameScreen/game_map/obstAthensRome.png"));
	public Texture obsAthensVienna = new Texture(Gdx.files.internal("gameScreen/game_map/obstAthensVienna.png"));
	public Texture obsBerlinJunct = new Texture(Gdx.files.internal("gameScreen/game_map/obstBerlinJunct.png"));
	public Texture obsBerlinOslo = new Texture(Gdx.files.internal("gameScreen/game_map/obstBerlinOslo.png"));
	public Texture obsBernJunct = new Texture(Gdx.files.internal("gameScreen/game_map/obstBernJunct.png"));
	public Texture obsBernMonaco = new Texture(Gdx.files.internal("gameScreen/game_map/obstBernMonaco.png"));
	public Texture obsBernPrague = new Texture(Gdx.files.internal("gameScreen/game_map/obstBernPrague.png"));
	public Texture obsBernRome = new Texture(Gdx.files.internal("gameScreen/game_map/obstBernRome.png"));
	public Texture obsDublinLondon = new Texture(Gdx.files.internal("gameScreen/game_map/obstDublinLondon.png"));
	public Texture obsDublinReykjavic = new Texture(Gdx.files.internal("gameScreen/game_map/obstDublinReykjavic.png"));
	public Texture obsHelsinkiMoscow = new Texture(Gdx.files.internal("gameScreen/game_map/obstHelsinkiMoscow.png"));
	public Texture obsHelsinkiStockholm = new Texture(Gdx.files.internal("gameScreen/game_map/obstHelsinkiStockholm.png"));
	public Texture obsHelsinkiVilnius = new Texture(Gdx.files.internal("gameScreen/game_map/obstHelsinkiVilnius.png"));
	public Texture obsLisbonMadrid = new Texture(Gdx.files.internal("gameScreen/game_map/obstLisbonMadrid.png"));
	public Texture obsLisbonRome = new Texture(Gdx.files.internal("gameScreen/game_map/obstLisbonRome.png"));
	public Texture obsLondonParis = new Texture(Gdx.files.internal("gameScreen/game_map/obstLondonParis.png"));
	public Texture obsMadridMonaco = new Texture(Gdx.files.internal("gameScreen/game_map/obstMadridMonaco.png"));
	public Texture obsMadridParis = new Texture(Gdx.files.internal("gameScreen/game_map/obstMadridParis.png"));
	public Texture obsMonacoParis = new Texture(Gdx.files.internal("gameScreen/game_map/obstMonacoParis.png"));
	public Texture obsMoscowJunct = new Texture(Gdx.files.internal("gameScreen/game_map/obstMoscowJunct.png"));
	public Texture obsOsloReykjavic = new Texture(Gdx.files.internal("gameScreen/game_map/obstOsloReykjavic.png"));
	public Texture obsOsloStockholm = new Texture(Gdx.files.internal("gameScreen/game_map/obstOsloStockholm.png"));
	public Texture obsParisJunct = new Texture(Gdx.files.internal("gameScreen/game_map/obstParisJunct.png"));
	public Texture obsPragueRjunct = new Texture(Gdx.files.internal("gameScreen/game_map/obstPragueRJunct.png"));
	public Texture obsPragueLjunct = new Texture(Gdx.files.internal("gameScreen/game_map/obstPragueLJunct.png"));
	public Texture obsPragueVienna = new Texture(Gdx.files.internal("gameScreen/game_map/obstPragueVienna.png"));
	public Texture obsPragueWarsaw = new Texture(Gdx.files.internal("gameScreen/game_map/obstPragueWarsaw.png"));
	public Texture obsStockholmWarsaw = new Texture(Gdx.files.internal("gameScreen/game_map/obstStockholmWarsaw.png"));
	public Texture obsVilniusJunct = new Texture(Gdx.files.internal("gameScreen/game_map/obstVilniusJunct.png"));
	public Texture obsWarsawJunct = new Texture(Gdx.files.internal("gameScreen/game_map/obstWarsawJunct.png"));
	public Texture obsWarsawBerlin = new Texture(Gdx.files.internal("gameScreen/game_map/obstBerlinWarsaw.png"));
}
