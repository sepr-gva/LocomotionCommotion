package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Array;

public class Game_ShopManager {

	private final static Array<Actor> actors = new Array<Actor>();
	private final static Array<Actor> startactors = new Array<Actor>();

	public static Game_shop_Backdrop game_shop_backdrop;
	public static Game_shop_BackBtn game_shop_backbtn;
	public static Game_shop_Title game_shop_title;
	public static Game_shop_coal coalitem;
	public static Game_shop_oil oilitem;
	public static Game_shop_electricity electricityitem;
	public static Game_shop_nuclear nuclearitem;
	public static Game_shop_card carditem;
	public static Game_shop_train trainitem;
	public static Game_shop_startpage startpage;
	
	public static Label goldLabel, titleLabel;
	public static LabelStyle style;


	public static boolean open=false;
	public static boolean start=true;

	public static int  stagestart, shopActors;
	public static int  startstagestart, startscreenActors;


	public Game_ShopManager(){	}

	public void create(Stage stage){
		
		actors.clear();
		stagestart =0;
		shopActors=0;
		startstagestart=0;
		startscreenActors=0;
		
		
		game_shop_backdrop = new Game_shop_Backdrop();
		actors.add(game_shop_backdrop);
		game_shop_backbtn = new Game_shop_BackBtn();
		actors.add(game_shop_backbtn);
		game_shop_title = new Game_shop_Title();
		actors.add(game_shop_title);
		
		coalitem = new Game_shop_coal();
		coalitem = new Game_shop_coal();
		oilitem = new Game_shop_oil();
		electricityitem = new Game_shop_electricity();
		nuclearitem = new Game_shop_nuclear();
		carditem = new Game_shop_card();
		trainitem = new Game_shop_train();
		startpage = new Game_shop_startpage();
		//Stuff for Labels for gold
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 50;

		BitmapFont font = generator.generateFont(parameter); 
		generator.dispose();
		style = new LabelStyle();
		style.font = font;

		//end
		goldLabel= new Label(null,style);
		goldLabel.setX(750);
		goldLabel.setY(880);
		goldLabel.setColor(0,0,0,1);
		goldLabel.setText(""+GameScreen.gold);
		
		//Stuff for Labels for gold
				generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
				parameter = new FreeTypeFontParameter();
				parameter.size = 80;

				font = generator.generateFont(parameter); 
				generator.dispose();
				style = new LabelStyle();
				style.font = font;

				//end
		titleLabel= new Label(null,style);
		titleLabel.setX(380);
		titleLabel.setY(880);
		titleLabel.setColor(0,0,0,1);
		titleLabel.setText("");
		
		actors.add(Game_ShopManager.goldLabel);
		actors.add(Game_ShopManager.titleLabel);
		
		for(Actor a : oilitem.getActors()){
			actors.add(a);
		}
		for(Actor a : coalitem.getActors()){
			actors.add(a);
		}
		for(Actor a : electricityitem.getActors()){
			actors.add(a);
		}
		for(Actor a : nuclearitem.getActors()){
			actors.add(a);
		}
		for(Actor a : carditem.getActors()){
			actors.add(a);
		}
		for(Actor a : trainitem.getActors()){
			actors.add(a);
		}
		for(Actor a : startpage.getActors()){
			startactors.add(a);
		}






		stagestart= stage.getActors().size;
		for (Actor a : actors){
			if(open == true){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);}
			else
				a.setVisible(false);

			stage.addActor(a);
			shopActors ++;
		}
		startstagestart= stage.getActors().size;
		for (Actor a : startactors){
			if(open == true){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);}
			else
				a.setVisible(false);

			stage.addActor(a);
			startscreenActors ++;
			shopActors ++;
		}


	}
	
	public static void refreshgold(int i){
		String g = new Integer(i).toString();
		goldLabel.setText(g);
	}
	


	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */






}

