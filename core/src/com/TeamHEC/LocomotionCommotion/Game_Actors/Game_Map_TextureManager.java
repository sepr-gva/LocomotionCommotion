package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
/*
 * Holds all the textures and file paths for all actors in StartMenu
 * This means if we need to change a file path you come here.
 */
public class Game_Map_TextureManager{
	//Map
	public static Texture map = new Texture(Gdx.files.internal("gameScreen/game_map/map.png"));
	public static Texture mapInfo = new Texture(Gdx.files.internal("gameScreen/game_map/mapinfo.png"));
	public static Texture station = new Texture(Gdx.files.internal("gameScreen/game_map/station.png"));
	public static Texture stationx2 = new Texture(Gdx.files.internal("gameScreen/game_map/Stop.png"));
	
	public static Texture stationInfo = new Texture(Gdx.files.internal("gameScreen/game_map/stationInfoframe.png"));
	public static Texture stationSelect = new Texture(Gdx.files.internal("gameScreen/game_map/stationSelectBtn.png"));
	public static Texture junction = new Texture(Gdx.files.internal("gameScreen/game_map/junction.png"));
	public static Texture junctionx2 = new Texture(Gdx.files.internal("gameScreen/game_map/junction2.png"));
	
	public static Texture p1Station = new Texture(Gdx.files.internal("gameScreen/game_map/p1station.png"));
	public static Texture p1Stationx2 = new Texture(Gdx.files.internal("gameScreen/game_map/p1station2.png"));
	public static Texture p1Train = new Texture(Gdx.files.internal("gameScreen/game_map/p1train.png"));
	public static Texture p1Trainx2 = new Texture(Gdx.files.internal("gameScreen/game_map/p1train2.png"));
	
	public static Texture p2Station = new Texture(Gdx.files.internal("gameScreen/game_map/p2station.png"));
	public static Texture p2Stationx2 = new Texture(Gdx.files.internal("gameScreen/game_map/p2station2.png"));
	public static Texture p2Train = new Texture(Gdx.files.internal("gameScreen/game_map/p2train.png"));
	public static Texture p2Trainx2 = new Texture(Gdx.files.internal("gameScreen/game_map/p2train2.png"));
}
