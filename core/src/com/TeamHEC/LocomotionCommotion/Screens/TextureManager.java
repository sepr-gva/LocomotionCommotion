package com.TeamHEC.LocomotionCommotion.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
	//Start Menu Main Page
	public static  Texture sm_main_title = new Texture(Gdx.files.internal("smTitle.png"));
	public static Texture sm_main_newgamebtn = new Texture(Gdx.files.internal("sm_newgame.png"));
	public static Texture sm_main_loadgamebtn = new Texture(Gdx.files.internal("sm_loadgame.png"));
	public static Texture sm_main_preferencesbtn = new Texture(Gdx.files.internal("sm_preferences.png"));
	public static Texture sm_main_howtoplaybtn = new Texture(Gdx.files.internal("sm_howtoplay.png"));
	public static Texture sm_main_linesimg = new Texture(Gdx.files.internal("lines.png"));
	
	//Start Menu NewGame Page
	public static Texture sm_newgame_MenuText = new Texture(Gdx.files.internal("newgamescreen.png"));
	public static Texture sm_newgame_BackBtn = new Texture(Gdx.files.internal("backButton.png"));
	public static Texture sm_newgame_GoBtn = new Texture(Gdx.files.internal("startmenuButtons/goBtn.png"));
	public static Texture sm_newgame_TempTextBox = new Texture(Gdx.files.internal("startmenuButtons/tempTextBox.png"));
	public static Texture sm_newgame_TurnTimeOutBtn = new Texture(Gdx.files.internal("startmenuButtons/turnTimeoutBtn.png"));
	public static Texture sm_newgame_StationDomBtn = new Texture(Gdx.files.internal("startmenuButtons/stationDominationBtn.png"));
	public static Texture sm_newgame_Turn50Btn = new Texture(Gdx.files.internal("startmenuButtons/turn50.png"));
	public static Texture sm_newgame_Turn100Btn = new Texture(Gdx.files.internal("startmenuButtons/turn100.png"));
	public static Texture sm_newgame_Turn150Btn = new Texture(Gdx.files.internal("startmenuButtons/turn150.png"));

}
