package com.TeamHEC.LocomotionCommotion.Game_Actors;
/*
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * 
 */

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

public class Game_ResourcesManager {

	private final static Array<Actor> visibleActors = new Array<Actor>();
	private final static Array<Actor> invisibleActors = new Array<Actor>();
	

	public static Game_menuobject_ResourcesBar game_menuobject_resourcesbar;
	public static Game_resources_ToggleBtn game_resources_togglebtn;
	public static Game_card_CardToggleBtn game_card_togglebtn;
	public static boolean resourcebarexpanded = false;
	public static int  stagestart, resourceActors, expandedheight= 40;
	public static Label  goldQuant, coalQuant, oilQuant, electricityQuant, nuclearQuant, cardQuant;
	
	
	public Game_ResourcesManager(){		}

	public void create(Stage stage){
		visibleActors.clear();
		stagestart=0;
		resourceActors =0;
		
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 19;
		
		BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose();
		LabelStyle style = new LabelStyle();
		style.font = font;
	
		
		//Resources bar is now connected to variables for easy update of quantities.
		game_menuobject_resourcesbar = new Game_menuobject_ResourcesBar();
		visibleActors.add(game_menuobject_resourcesbar);
		
		game_resources_togglebtn = new Game_resources_ToggleBtn();
		visibleActors.add(game_resources_togglebtn);
		
		game_card_togglebtn = new Game_card_CardToggleBtn();
		visibleActors.add(game_card_togglebtn);


		
		goldQuant= new Label(null, style);
		goldQuant.setX(100);
		goldQuant.setY(expandedheight);
		goldQuant.setColor(0,0,0,1);
		
		coalQuant= new Label(null,style);
		coalQuant.setX(240);
		coalQuant.setY(expandedheight);
		coalQuant.setColor(0,0,0,1);
		
		
		oilQuant= new Label(null,style);
		oilQuant.setX(350);
		oilQuant.setY(expandedheight);
		oilQuant.setColor(0,0,0,1);

		electricityQuant= new Label(null,style);
		electricityQuant.setX(450);
		electricityQuant.setY(expandedheight);
		electricityQuant.setColor(0,0,0,1);
		
		nuclearQuant= new Label(null,style);
		nuclearQuant.setX(590);
		nuclearQuant.setY(expandedheight);
		nuclearQuant.setColor(0,0,0,1);
		
		cardQuant= new Label(null,style);
		cardQuant.setX(920);
		cardQuant.setY(expandedheight);
		cardQuant.setColor(0,0,0,1);
		
		refreshResources();
		
		visibleActors.add(goldQuant);
		visibleActors.add(coalQuant);
		visibleActors.add(oilQuant);
		visibleActors.add(electricityQuant);
		visibleActors.add(nuclearQuant);
		visibleActors.add(cardQuant);
		
		for (Actor a : visibleActors){
			a.setTouchable(Touchable.enabled);
			stage.addActor(a);
			resourceActors ++;
		}
		
		stagestart= stage.getActors().size;
		for (Actor a : invisibleActors){
			a.setTouchable(Touchable.enabled);
			a.setVisible(false);;
			stage.addActor(a);
			resourceActors ++;
		}
		
			

	}
	
	public static void refreshResources(){
		goldQuant.setText(""+GameScreen.gold);
		coalQuant.setText(""+GameScreen.coal);
		oilQuant.setText(""+GameScreen.oil);
		electricityQuant.setText(""+GameScreen.electricity);
		nuclearQuant.setText(""+GameScreen.nuclear);
		cardQuant.setText(""+GameScreen.cards);
	}
	
	public static void setResourcesHeight(float height){
		goldQuant.setY(height);
		coalQuant.setY(height);
		oilQuant.setY(height);
		electricityQuant.setY(height);
		nuclearQuant.setY(height);
		cardQuant.setY(height);
	}
	
	
	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */
	public static void saveActors()
	{
		
		
	}
	


}

