package com.TeamHEC.LocomotionCommotion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
	//Start Menu
	//Start Menu Title
	public static Texture sm_title = new Texture(Gdx.files.internal("smTitle.png"));
	//Start Menu Buttons
	public static Texture sm_newgame = new Texture(Gdx.files.internal("sm_newgame.png"));
	public static Texture sm_loadgame = new Texture(Gdx.files.internal("sm_loadgame.png"));
	public static Texture sm_preferences = new Texture(Gdx.files.internal("sm_preferences.png"));
	public static Texture sm_howtoplay = new Texture(Gdx.files.internal("sm_howtoplay.png"));
	//Start Menu Lines
	public static Texture mainpagelines = new Texture(Gdx.files.internal("lines.png"));
	
	// tempscreens
	public static Texture prefscreen = new Texture(Gdx.files.internal("PREFSCREEN.png"));
	public static Texture newgamescreen = new Texture(Gdx.files.internal("newgamescreen.png"));

}
