package com.TeamHEC.LocomotionCommotion.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
/*
 * Holds all the textures and file paths for all actors in StartMenu
 * This means if we need to change a file path you come here.
 */
public class Game_TextureManager {
	
	//Top Bar
	public static  Texture game_menuobject_topbar = new Texture(Gdx.files.internal("game_MenuObjects/TopBar.png"));
	public static  Texture game_menuobject_menubtn = new Texture(Gdx.files.internal("game_MenuObjects/menubtn.png"));
	
	//Ticket
	
	public static  Texture game_menuobject_ticket = new Texture(Gdx.files.internal("game_MenuObjects/game_tickets/ticket.png"));
	
	
}
