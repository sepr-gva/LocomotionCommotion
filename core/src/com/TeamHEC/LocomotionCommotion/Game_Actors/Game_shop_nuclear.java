package com.TeamHEC.LocomotionCommotion.Game_Actors;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
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

public class Game_shop_nuclear {
	ArrayList<Actor> actors ;
	public static Label quantityLabel,costLabel, goldLabel;
	public int quantity, cost;
	public static int posx=300;
	public static int posy=100;
	public static LabelStyle style;
	public Game_shop_nuclear(){
		this.actors = new ArrayList<Actor>();
		NuclearItem coalitem = new NuclearItem();
		AddButton add = new AddButton();
		MinusButton minus = new MinusButton();
		BuyButton buy = new BuyButton();
		actors.add(coalitem);
		actors.add(buy);
		actors.add(add);
		actors.add(minus);

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

		quantityLabel= new Label(null,style);
		quantityLabel.setX(posx+ 145);
		quantityLabel.setY(posy +90);
		quantityLabel.setColor(0,0,0,1);
		quantityLabel.setText("100");

		costLabel= new Label(null,style);
		costLabel.setX(posx+ 160);
		costLabel.setY(posy +43);
		costLabel.setColor(0,0,0,1);
		costLabel.setText("100");

		actors.add(quantityLabel);
		actors.add(costLabel);


	}

	public static void increase(int i){
		int quant = strToInt(costLabel.getText());
		String l = new Integer(quant + i).toString();
		costLabel.setText(l);
		quantityLabel.setText(l);
	}


	public class NuclearItem extends Actor{
		Texture texture = Game_TextureManager.getInstance().game_shop_nuclearitem; // reuse the new game back btn texture
		float actorX = posx ,actorY = posy;
		boolean started = false;


		public NuclearItem(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((NuclearItem)event.getTarget()).started = true;
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

	public class AddButton extends Actor{
		Texture texture = Game_TextureManager.getInstance().game_shop_addbtn; // reuse the new game back btn texture
		float actorX = posx+75 ,actorY = posy+42;
		boolean started = false;


		public AddButton(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((AddButton)event.getTarget()).started = true;
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
				quantity+=100;
				increase(100);
				started = false;
			}
		}
	}

	public class MinusButton extends Actor{
		Texture texture = Game_TextureManager.getInstance().game_shop_minusbtn; // reuse the new game back btn texture
		float actorX = posx+220 ,actorY = posy+48;
		boolean started = false;


		public MinusButton(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((MinusButton)event.getTarget()).started = true;
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
				if(quantity!=0){
					quantity-=100;
					increase(-100);}
				started = false;
			}
		}
	}

	public static class BuyButton extends Actor{
		public static Texture texture = Game_TextureManager.getInstance().game_shop_buybtn; // reuse the new game back btn texture
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
				if (Game_shop_startpage.buy){
					int goldcost = strToInt(costLabel.getText());
					int nuclear = strToInt(quantityLabel.getText());
					if (goldcost <= GameScreen.gold){
						GameScreen.gold -= goldcost;
						GameScreen.nuclear += nuclear;
						Game_ResourcesManager.refreshResources();
						Game_ShopManager.refreshgold(GameScreen.gold);
					}
				}
				if (Game_shop_startpage.sell){
					int goldcost = strToInt(costLabel.getText());
					int nuclear = strToInt(quantityLabel.getText());
					if (nuclear <= GameScreen.nuclear){
						GameScreen.gold += goldcost;
						GameScreen.nuclear -= nuclear;
						Game_ResourcesManager.refreshResources();
						Game_ShopManager.refreshgold(GameScreen.gold);
					}
				}
				started = false;
			}
		}
		public static void changeTexture(){
			if (Game_shop_startpage.buy==true)
				texture=Game_TextureManager.getInstance().game_shop_buybtn;
			if (Game_shop_startpage.sell==true)
				texture=Game_TextureManager.getInstance().game_shop_sellbtn;
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
