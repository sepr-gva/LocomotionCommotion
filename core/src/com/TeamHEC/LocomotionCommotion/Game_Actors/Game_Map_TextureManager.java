package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
/*
 * Holds all the textures and file paths for all actors in StartMenu
 * This means if we need to change a file path you come here.
 */
public class Game_Map_TextureManager {
	//Map
	public static Texture map = new Texture(Gdx.files.internal("gameScreen/game_map/map.png"));
	public static Texture mapInfo = new Texture(Gdx.files.internal("gameScreen/game_map/mapinfo.png"));
	public static Texture station = new Texture(Gdx.files.internal("gameScreen/game_map/station.png"));
	public static Texture stationx2 = new Texture(Gdx.files.internal("gameScreen/game_map/Stop.png"));
	public static Texture stationInfo = new Texture(Gdx.files.internal("gameScreen/game_map/stationInfoframe.png"));


}
