package com.TeamHEC.LocomotionCommotion.Game_Actors;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.StringBuilder;

public class Game_shop_train {
	ArrayList<Actor> actors ;
	public static Label quantityLabel,costLabel, goldLabel;
	public int quantity, cost, posx=1100, posy=100;
	public static LabelStyle style;
	public Game_shop_train(){
		this.actors = new ArrayList<Actor>();
		TrainItem coalitem = new TrainItem();
		BuyButton buy = new BuyButton();
		actors.add(coalitem);
		actors.add(buy);

		//Stuff for Labels
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 32;

		BitmapFont font = generator.generateFont(parameter); 
		generator.dispose();
		style = new LabelStyle();
		style.font = font;

		//end
		
		quantity =100;
		
	
		
		costLabel= new Label(null,style);
		costLabel.setX(posx+ 100);
		costLabel.setY(posy +43);
		costLabel.setColor(0,0,0,1);
		costLabel.setText("Buy Trains");
		
		actors.add(costLabel);


	}

	

	public class TrainItem extends Actor{
		Texture texture = Game_TextureManager.getInstance().game_shop_trainitem; // reuse the new game back btn texture
		float actorX = posx ,actorY = posy;
		boolean started = false;


		public TrainItem(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((TrainItem)event.getTarget()).started = true;
					return true;
				}
			});

		}


		@Override
		public void draw(Batch batch, float alpha){
			batch.draw(texture,actorX,actorY);
		}

		@Override
		public void act(float delta){
			if(started){
				started = false;
			}
		}
	}


	public class BuyButton extends Actor{
		Texture texture = Game_TextureManager.getInstance().game_shop_blankbuybtn; // reuse the new game back btn texture
		float actorX = posx+75 ,actorY = posy+20;
		boolean started = false;


		public BuyButton(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((BuyButton)event.getTarget()).started = true;
					return true;
				}
			});

		}


		@Override
		public void draw(Batch batch, float alpha){
			batch.draw(texture,actorX,actorY);
		}

		@Override
		public void act(float delta){
			if(started){
				
				}
				started = false;
			}
		}


	public ArrayList<Actor> getActors() {
		return this.actors;
	}
	
	public static int strToInt( StringBuilder stringBuilder ){
	    int i = 0;
	    int num = 0;
	    boolean isNeg = false;

	    //Check for negative sign; if it's there, set the isNeg flag
	    if (stringBuilder.charAt(0) == '-') {
	        isNeg = true;
	        i = 1;
	    }

	    //Process each character of the string;
	    while( i < stringBuilder.length()) {
	        num *= 10;
	        num += stringBuilder.charAt(i++) - '0'; //Minus the ASCII code of '0' to get the value of the charAt(i++).
	    }

	    if (isNeg)
	        num = -num;
	    return num;
	}
	
	

}
