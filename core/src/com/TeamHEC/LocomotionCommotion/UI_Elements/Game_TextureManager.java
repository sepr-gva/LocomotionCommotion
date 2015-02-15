package com.TeamHEC.LocomotionCommotion.UI_Elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
/**
 * 
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * This is the centre for all the Texture's used in the game except for Map textures.
 * When fetching a Texture use : Game_TextureManager.getInstance().<desired texture name>
 *
 */
public class Game_TextureManager {
	private static Game_TextureManager instance;
	public Texture game_menuobject_topbar, game_menuobject_menubtn, game_menuobject_resourcesbar, game_menuobject_endturnbutton, game_menuobject_cornerframe,
	game_menuobject_infobutton, mapTexture, mapInfo, game_pause_blackoutscreen, game_pause_pauselogo, game_pause_resumegame, game_pause_savegame, game_pause_settings,
	game_pause_mainmenu, game_pause_background, game_shop_backdrop, game_shop_backbtn, game_shop_shopbtn, game_shop_title, game_traindepot_title, game_traindepot_traindepotbtn,
	game_menuobject_ticketbtn, game_menuobject_ticket, game_menuobject_emptyticket, game_menuobject_ticketenclosure, game_menuobject_removegoalbtn, game_menuobject_redobtn,
	game_menuobject_addgoalbtn, game_menuobject_planroutebtn, game_menuobject_editroutebtn, routingModeWindow, confirmroutingModebtn, undoRouteBtn, abortRouteBtn, cancelRouteBtn,
	game_goals_goalscreenbtn, game_goals_newgoals, game_goals_backdrop, game_card_gofasterstripescard, game_card_teleportcard, game_card_goldcard, game_card_coalcard,
	game_card_oilcard, game_card_electriccard, game_card_nuclearcard, game_card_cardtoggle, game_card_usecardbtn, game_card_fixrailcard, game_card_breakrailcard,
	game_shop_startscreen, game_shop_startbuy, game_shop_startsell, game_shop_starttrain,game_shop_coalitem, game_shop_oilitem, game_shop_electricityitem, game_shop_nuclearitem,
	game_shop_carditem, game_shop_trainitem, game_shop_addbtn, game_shop_minusbtn, game_shop_buybtn, game_shop_sellbtn, game_shop_blankbuybtn, game_start_getstartedwindow,
	game_start_getstartedwindow2, game_warningwindow;
	
	protected Game_TextureManager(){
		//Top Bar
		game_menuobject_topbar = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/TopBar.png"));
		game_menuobject_menubtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/menubtn.png"));
		
		//Resources
		game_menuobject_resourcesbar = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/resourcesbar.png"));
		//Bottom right corner
		game_menuobject_endturnbutton = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/endTurnBtn.png"));
		game_menuobject_cornerframe = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/cornerframe.png"));
		game_menuobject_infobutton = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/infobutton.png"));
		
		//Map
		mapTexture = new Texture(Gdx.files.internal("gameScreen/game_map/map.png"));
		mapInfo = new Texture(Gdx.files.internal("gameScreen/game_map/mapinfo.png"));
		
		//Pause Menu
		game_pause_blackoutscreen = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/screen.png"));
		game_pause_pauselogo = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/pauselogo.png"));
		game_pause_resumegame = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/resumegamebtn.png"));
		game_pause_savegame = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/savegamebtn.png"));
		game_pause_settings = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/settingsbtn.png"));
		game_pause_mainmenu = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/mainmenubtn.png"));
		game_pause_background = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/pausebackground.png"));
		
		//shop
		game_shop_backdrop = new Texture(Gdx.files.internal("gameScreen/game_shop/shopbackdrop.png"));
		game_shop_backbtn = new Texture(Gdx.files.internal("gameScreen/game_shop/backbtn.png"));
		game_shop_shopbtn = new Texture(Gdx.files.internal("gameScreen/game_shop/shopbtn.png"));
		game_shop_title = new Texture(Gdx.files.internal("gameScreen/game_shop/title.png"));
		
		//train depot
		game_traindepot_title = new Texture(Gdx.files.internal("gameScreen/game_traindepot/title.png"));
		game_traindepot_traindepotbtn = new Texture(Gdx.files.internal("gameScreen/game_traindepot/traindepotbtn.png"));

		//Goals
		game_menuobject_ticketbtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/ticketbtn.png"));
		game_menuobject_ticket = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/ticket.png"));
		game_menuobject_emptyticket = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/emptyticket.png"));
		game_menuobject_ticketenclosure = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/ticketenclosure.png"));
		game_menuobject_removegoalbtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/removebtn.png"));
		game_menuobject_redobtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/redobtn.png"));
		game_menuobject_addgoalbtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/addgoalbtn.png"));
		
		//Routing
		game_menuobject_planroutebtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/planroutebtn.png"));
		game_menuobject_editroutebtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/editroutebtn.png"));
		routingModeWindow = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/routingModeWindow.png")); 
		confirmroutingModebtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/confirmRoute.png"));
		undoRouteBtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/undoRoute.png")); 
		abortRouteBtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/abortRoute.png")); 
		cancelRouteBtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/routeCancel.png"));
		
		game_goals_goalscreenbtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/goalScreenBtn.png"));
		game_goals_newgoals= new Texture(Gdx.files.internal("gameScreen/game_goalScreen/newgoals.png"));
		game_goals_backdrop = new Texture(Gdx.files.internal("gameScreen/game_goalScreen/screen.png"));

		//Cards
		game_card_gofasterstripescard = new Texture(Gdx.files.internal("gameScreen/game_cards/gofasterstripecard.png"));
		game_card_teleportcard = new Texture(Gdx.files.internal("gameScreen/game_cards/teleportCard.png"));
		game_card_goldcard = new Texture(Gdx.files.internal("gameScreen/game_cards/goldCard.png"));
		game_card_coalcard = new Texture(Gdx.files.internal("gameScreen/game_cards/coalCard.png"));
		game_card_oilcard = new Texture(Gdx.files.internal("gameScreen/game_cards/oilCard.png"));
		game_card_electriccard = new Texture(Gdx.files.internal("gameScreen/game_cards/electricCard.png"));
		game_card_nuclearcard = new Texture(Gdx.files.internal("gameScreen/game_cards/nuclearCard.png"));
		game_card_cardtoggle = new Texture(Gdx.files.internal("gameScreen/game_cards/Cardbtn-1.png"));
		game_card_usecardbtn = new Texture(Gdx.files.internal("gameScreen/game_cards/usecardbtn.png"));
		game_card_fixrailcard = new Texture(Gdx.files.internal("gameScreen/game_cards/FixRail.png"));
		game_card_breakrailcard = new Texture(Gdx.files.internal("gameScreen/game_cards/BreakRail.png"));
				
		//SHOP
		game_shop_startscreen = new Texture(Gdx.files.internal("gameScreen/game_shop/startpage.png"));
		game_shop_startbuy = new Texture(Gdx.files.internal("gameScreen/game_shop/startBuy.png"));
		game_shop_startsell = new Texture(Gdx.files.internal("gameScreen/game_shop/startSell.png"));
		game_shop_starttrain = new Texture(Gdx.files.internal("gameScreen/game_shop/startTrains.png"));
		
		game_shop_coalitem = new Texture(Gdx.files.internal("gameScreen/game_shop/item_coal.png"));
		game_shop_oilitem = new Texture(Gdx.files.internal("gameScreen/game_shop/item_oil.png"));
		game_shop_electricityitem = new Texture(Gdx.files.internal("gameScreen/game_shop/item_electricity.png"));
		game_shop_nuclearitem = new Texture(Gdx.files.internal("gameScreen/game_shop/item_nuclear.png"));
		game_shop_carditem = new Texture(Gdx.files.internal("gameScreen/game_shop/item_card.png"));
		game_shop_trainitem = new Texture(Gdx.files.internal("gameScreen/game_shop/item_train.png"));
		
		game_shop_addbtn = new Texture(Gdx.files.internal("gameScreen/game_shop/addbutton.png"));
		game_shop_minusbtn = new Texture(Gdx.files.internal("gameScreen/game_shop/minusbutton.png"));
		game_shop_buybtn = new Texture(Gdx.files.internal("gameScreen/game_shop/buybtn.png"));
		game_shop_sellbtn = new Texture(Gdx.files.internal("gameScreen/game_shop/sellbtn.png"));
		game_shop_blankbuybtn = new Texture(Gdx.files.internal("gameScreen/game_shop/blankbuybtn.png"));
		
		//StartGame
		game_start_getstartedwindow = new Texture(Gdx.files.internal("gameScreen/game_startsequence/getstartedwindow.png"));
		game_start_getstartedwindow2 = new Texture(Gdx.files.internal("gameScreen/game_startsequence/getstartedwindow-witharrow.png"));
		
		//Warning Window
		game_warningwindow = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/warningwindow.png"));
	}
	
	public static Game_TextureManager getInstance() {
		if(instance == null)
			instance = new Game_TextureManager();
		return instance;
	}	
}
