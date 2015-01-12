package com.TeamHEC.LocomotionCommotion.Game_Actors;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;



public class Game_shop_startpage {
	ArrayList<Actor> actors ;
	public static boolean buy=false, sell=false;
	
	public Game_shop_startpage(){
		this.actors = new ArrayList<Actor>();
		ShopScreen shopscreen = new ShopScreen();
		this.actors.add(shopscreen);
		ShopBackBtn back = new ShopBackBtn();
		this.actors.add(back);
		ShopBuyBtn buy = new ShopBuyBtn();
		this.actors.add(buy);
		ShopSellBtn sell = new ShopSellBtn();
		this.actors.add(sell);
		ShopTrainBtn train = new ShopTrainBtn();
		this.actors.add(train);


	}
	public ArrayList<Actor> getActors() {
		return this.actors;
	}

	
	public void  setToSell(){
		buy=false;
		sell=true;
		Game_shop_coal.BuyButton.changeTexture();
		Game_shop_oil.BuyButton.changeTexture();
		Game_shop_electricity.BuyButton.changeTexture();
		Game_shop_nuclear.BuyButton.changeTexture();
		Game_shop_card.BuyButton.changeTexture();
		Game_shop_train.costLabel.setText("Sell Trains");
		Game_ShopManager.titleLabel.setText("Sell");
	}
	public void  setToBuy(){
		buy=true;
		sell=false;
		Game_shop_coal.BuyButton.changeTexture();
		Game_shop_oil.BuyButton.changeTexture();
		Game_shop_electricity.BuyButton.changeTexture();
		Game_shop_nuclear.BuyButton.changeTexture();
		Game_shop_card.BuyButton.changeTexture();
		Game_shop_train.costLabel.setText("Buy Trains");
		Game_ShopManager.titleLabel.setText("Buy");
	}
	
	
	public class ShopScreen extends Actor{
		Texture texture = Game_TextureManager.getInstance().game_shop_startscreen; 
		float actorX = 45 ,actorY = 9;
		boolean started = false;


		public ShopScreen(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((ShopScreen)event.getTarget()).started = true;
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

	public class ShopBackBtn extends Actor{
		Texture texture = Game_TextureManager.getInstance().game_shop_backbtn; 
		public float actorX = 1350 ,actorY = 860;
		boolean started = false;


		public ShopBackBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((ShopBackBtn)event.getTarget()).started = true;
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
				buy=false;
				sell=false;
				if (Game_ShopManager.open== false)
				{
					Game_ShopManager.open= true;
					for(int i=Game_ShopManager.stagestart; i<=Game_ShopManager.stagestart +Game_ShopManager.shopActors-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_ShopManager.open= false;
				for(int i=Game_ShopManager.stagestart; i<=Game_ShopManager.stagestart +Game_ShopManager.shopActors-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}

				}
				started = false;
			}

		}
	}

	public class ShopBuyBtn extends Actor{
		Texture texture = Game_TextureManager.getInstance().game_shop_startbuy; 
		float actorX = 250 ,actorY = 350;
		boolean started = false;


		public ShopBuyBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((ShopBuyBtn)event.getTarget()).started = true;
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
				setToBuy();
				if (Game_ShopManager.start== false)
				{
					Game_ShopManager.start= true;
					for(int i=Game_ShopManager.startstagestart; i<=Game_ShopManager.startstagestart +Game_ShopManager.startscreenActors-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_ShopManager.start= false;
				for(int i=Game_ShopManager.startstagestart; i<=Game_ShopManager.startstagestart +Game_ShopManager.startscreenActors-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}

				}
				started = false;
			}

		
		}
	}

	public class ShopSellBtn extends Actor{
		Texture texture = Game_TextureManager.getInstance().game_shop_startsell; 
		float actorX = 650 ,actorY = 350;
		boolean started = false;


		public ShopSellBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((ShopSellBtn)event.getTarget()).started = true;
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
				setToSell();
				if (Game_ShopManager.start== false)
				{
					Game_ShopManager.start= true;
					for(int i=Game_ShopManager.startstagestart; i<=Game_ShopManager.startstagestart +Game_ShopManager.startscreenActors-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_ShopManager.start= false;
				for(int i=Game_ShopManager.startstagestart; i<=Game_ShopManager.startstagestart +Game_ShopManager.startscreenActors-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}

				}
				started = false;
			}

		
		}
	}

	public class ShopTrainBtn extends Actor{
		Texture texture = Game_TextureManager.getInstance().game_shop_starttrain; 
		float actorX = 1050 ,actorY = 350;
		boolean started = false;


		public ShopTrainBtn(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((ShopTrainBtn)event.getTarget()).started = true;
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
}


