package com.TeamHEC.LocomotionCommotion.Game_Actors;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Card.OilCard;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.StringBuilder;

public class Game_Shop {
	public static Game_ShopManager actorManager;

	public void create(Stage stage){
		actorManager = new Game_ShopManager();
		actorManager.create(stage);


	}
	//ACTOR MANAGER
	public static class Game_ShopManager {

		private final static Array<Actor> actors = new Array<Actor>();
		private final static Array<Actor> startactors = new Array<Actor>();

		public Game_Asset game_shop_backdrop;
		public Game_shop_BackBtn game_shop_backbtn;
		public Game_Asset game_shop_title;
		public Game_shop_coal coalitem;
		public Game_shop_oil oilitem;
		public Game_shop_electricity electricityitem;
		public Game_shop_nuclear nuclearitem;
		public Game_shop_card carditem;
		public Game_shop_train trainitem;
		public  ShopHomeScreen startpage;

		public Label goldLabel;
		public Label titleLabel;
		public static LabelStyle style;


		public boolean open=false;
		public boolean start=true;

		public static int  stageStart, stageEnd;
		public static int  startScreenStageStart, startScreenStageEnd;


		public Game_ShopManager(){	}

		public void create(Stage stage){

			actors.clear();
			stageStart =0;
			stageEnd=0;
			startScreenStageStart=0;
			startScreenStageEnd=0;


			game_shop_backdrop = new Game_Asset(-1,-20,Game_TextureManager.getInstance().game_shop_backdrop);
			actors.add(game_shop_backdrop);
			game_shop_backbtn = new Game_shop_BackBtn();
			actors.add(game_shop_backbtn);
			game_shop_title = new Game_Asset(170,820,Game_TextureManager.getInstance().game_shop_title);
			actors.add(game_shop_title);

			coalitem = new Game_shop_coal();
			coalitem = new Game_shop_coal();
			oilitem = new Game_shop_oil();
			electricityitem = new Game_shop_electricity();
			nuclearitem = new Game_shop_nuclear();
			carditem = new Game_shop_card();
			trainitem = new Game_shop_train();
			startpage = new ShopHomeScreen();
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

			actors.add(Game_Shop.actorManager.goldLabel);
			actors.add(Game_Shop.actorManager.titleLabel);

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






			stageStart= stage.getActors().size;
			for (Actor a : actors){
				if(open == true){
					a.setTouchable(Touchable.enabled);
					a.setVisible(true);}
				else
					a.setVisible(false);

				stage.addActor(a);
				stageEnd ++;
			}
			startScreenStageStart= stage.getActors().size;
			startScreenStageEnd = startScreenStageStart + startactors.size-1;

			for (Actor a : startactors){
				if(open == true){
					a.setTouchable(Touchable.enabled);
					a.setVisible(true);}
				else
					a.setVisible(false);

				stage.addActor(a);

			}
			stageEnd= stageStart+actors.size+startactors.size-1;


		}
		public  int getStageStart(){
			return stageStart;
		}
		public  int getStageEnd(){
			return stageEnd;
		}
		public int getstartScreenStageStart(){
			return startScreenStageStart;
		}
		public  int getstartScreenStageEnd(){
			return startScreenStageEnd;
		}
		public static void refreshgold(int i){
			String g = new Integer(i).toString();
			Game_Shop.actorManager.goldLabel.setText(g);
			Game_ScreenMenu.resourceActorManager.goldQuant.setText(g);
		}

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

	//SHOP Actors
	//Back Button
	public static class Game_shop_BackBtn extends Game_Actor {
		public Game_shop_BackBtn(){
			texture = Game_TextureManager.getInstance().game_shop_backbtn; 
			actorX = 1350 ;
			actorY = 860;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_shop_BackBtn)event.getTarget()).started = true;
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
				if (Game_Shop.actorManager.start== false)
				{
					Game_Shop.actorManager.start= true;
					for(int i=Game_Shop.actorManager.getstartScreenStageStart(); i<=Game_Shop.actorManager.getstartScreenStageEnd();i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_Shop.actorManager.start= false;
				for(int i=Game_Shop.actorManager.getstartScreenStageStart(); i<=Game_Shop.actorManager.getstartScreenStageEnd();i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}

				}
				started = false;
			}


		}
	}

	//Shop Object Classes
	//SHOP HOME Screen---------------------------------------------------------------
	public static class ShopHomeScreen {
		ArrayList<Actor> actors ;
		public boolean buy=false;
		public boolean sell=false;

		public ShopHomeScreen(){
			this.actors = new ArrayList<Actor>();
			Game_Asset shopscreen = new Game_Asset(45, 9, Game_TextureManager.getInstance().game_shop_startscreen);
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

		//METHODS TO SWITCH BETWEEN BUY AND SELL-----------
		public void  setToSell(){
			buy=false;
			sell=true;
			Game_Shop.actorManager.coalitem.buyButton.changeTexture();
			Game_Shop.actorManager.oilitem.buyButton.changeTexture();
			Game_Shop.actorManager.electricityitem.buyButton.changeTexture();
			Game_Shop.actorManager.nuclearitem.buyButton.changeTexture();
			Game_Shop.actorManager.carditem.buyButton.changeTexture();
			Game_Shop.actorManager.trainitem.costLabel.setText("Sell Trains");
			Game_Shop.actorManager.titleLabel.setText("Sell");
		}

		public void  setToBuy(){
			buy=true;
			sell=false;
			Game_Shop.actorManager.coalitem.buyButton.changeTexture();
			Game_Shop.actorManager.oilitem.buyButton.changeTexture();
			Game_Shop.actorManager.electricityitem.buyButton.changeTexture();
			Game_Shop.actorManager.nuclearitem.buyButton.changeTexture();
			Game_Shop.actorManager.carditem.buyButton.changeTexture();
			Game_Shop.actorManager.trainitem.costLabel.setText("Buy Trains");
			Game_Shop.actorManager.titleLabel.setText("Buy");
		}

		//Home Screen Actors------------------------------
		//Back Button
		public class ShopBackBtn extends Game_Actor{
			public ShopBackBtn(){
				texture = Game_TextureManager.getInstance().game_shop_backbtn; 
				actorX = 1350 ;
				actorY = 860;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((ShopBackBtn)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					buy=false;
					sell=false;
					if (Game_Shop.actorManager.open== false)
					{
						Game_Shop.actorManager.open= true;
						for(int i=Game_Shop.actorManager.getStageStart(); i<=Game_Shop.actorManager.getStageEnd();i++){
							if (i > GameScreen.getStage().getActors().size-1){

							}else
								GameScreen.getStage().getActors().get(i).setVisible(true);

						}			}
					else
					{	Game_Shop.actorManager.open= false;
					for(int i=Game_Shop.actorManager.getStageStart(); i<=Game_Shop.actorManager.getStageEnd();i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(false);

					}

					}
					started = false;
				}

			}
		}
		//Buy Menu Button
		public class ShopBuyBtn extends Game_Actor{
			public ShopBuyBtn(){
				texture = Game_TextureManager.getInstance().game_shop_startbuy; 
				actorX = 250 ;
				actorY = 350;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((ShopBuyBtn)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					setToBuy();
					if (Game_Shop.actorManager.start== false)
					{
						Game_Shop.actorManager.start= true;
						for(int i=Game_Shop.actorManager.getstartScreenStageStart(); i<=Game_Shop.actorManager.getstartScreenStageEnd();i++){
							if (i > GameScreen.getStage().getActors().size-1){

							}else
								GameScreen.getStage().getActors().get(i).setVisible(true);

						}			}
					else
					{	Game_Shop.actorManager.start= false;
					for(int i=Game_Shop.actorManager.getstartScreenStageStart(); i<=Game_Shop.actorManager.getstartScreenStageEnd();i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(false);

					}

					}
					started = false;
				}


			}
		}
		//Sell Menu Button
		public class ShopSellBtn extends Game_Actor{
			public ShopSellBtn(){
				texture = Game_TextureManager.getInstance().game_shop_startsell; 
				actorX = 650 ;
				actorY = 350;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((ShopSellBtn)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					setToSell();
					if (Game_Shop.actorManager.start== false)
					{
						Game_Shop.actorManager.start= true;
						for(int i=Game_Shop.actorManager.getstartScreenStageStart(); i<=Game_Shop.actorManager.getstartScreenStageEnd();i++){
							if (i > GameScreen.getStage().getActors().size-1){

							}else
								GameScreen.getStage().getActors().get(i).setVisible(true);

						}			}
					else
					{	Game_Shop.actorManager.start= false;
					for(int i=Game_Shop.actorManager.getstartScreenStageStart(); i<=Game_Shop.actorManager.getstartScreenStageEnd();i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(false);

					}

					}
					started = false;
				}


			}
		}
		//Train Menu Button
		public class ShopTrainBtn extends Game_Actor{
			public ShopTrainBtn(){
				texture = Game_TextureManager.getInstance().game_shop_starttrain; 
				actorX = 1050 ;
				actorY = 350;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((ShopTrainBtn)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					started = false;
				}
			}
		}
	}

	//Card
	public static class Game_shop_card {
		ArrayList<Actor> actors ;
		public static Label quantityLabel,costLabel, goldLabel;
		public int quantity, cost;
		public static int posx=700;
		public static int posy=100;
		public static LabelStyle style;
		BuyButton buyButton ;
		public Game_shop_card(){
			this.actors = new ArrayList<Actor>();

			Game_Asset cardItem = new Game_Asset(posx,posy,Game_TextureManager.getInstance().game_shop_carditem);
			buyButton = new BuyButton();

			actors.add(cardItem);
			actors.add(buyButton);

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
			costLabel.setX(posx+ 160);
			costLabel.setY(posy +43);
			costLabel.setColor(0,0,0,1);
			costLabel.setText("");

			actors.add(costLabel);


		}

		public static class BuyButton extends Game_Actor{
			public BuyButton(){
				texture = Game_TextureManager.getInstance().game_shop_buybtn; 
				actorX = posx+75 ;
				actorY = posy+20;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((BuyButton)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					//Card Factory need !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					OilCard card = new OilCard();
					Game_CardHand.actorManager.addCard(card);
					GameScreen.game.getPlayerTurn().subGold(1000);
					Game_ScreenMenu.resourceActorManager.refreshResources();
					Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
					
				}
				started = false;
			}
			public  void changeTexture(){
				if (Game_Shop.actorManager.startpage.buy==true)
					this.texture=Game_TextureManager.getInstance().game_shop_buybtn;
				if (Game_Shop.actorManager.startpage.sell==true)
					this.texture=Game_TextureManager.getInstance().game_shop_sellbtn;
			}
		}

		public ArrayList<Actor> getActors() {
			return this.actors;
		}

	}

	//Coal
	public static class Game_shop_coal {
		ArrayList<Actor> actors ;
		public static Label quantityLabel,costLabel, goldLabel;
		public int quantity, cost;
		public static int posx=300;
		public static int posy=470;
		public static LabelStyle style;
		BuyButton buyButton;
		public Game_shop_coal(){
			this.actors = new ArrayList<Actor>();
			Game_Asset coalitem = new Game_Asset(posx,posy,Game_TextureManager.getInstance().game_shop_coalitem);
			AddButton add = new AddButton();
			MinusButton minus = new MinusButton();
			buyButton = new BuyButton();
			actors.add(coalitem);
			actors.add(buyButton);
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

		//Coal Item Actors
		//Increase (add) Button
		public class AddButton extends Game_Actor{
			public AddButton(){
				texture = Game_TextureManager.getInstance().game_shop_addbtn; 
				actorX = posx+75 ;
				actorY = posy+42;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((AddButton)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					quantity+=100;
					increase(100);
					started = false;
				}
			}
		}
		//Decrease (minus) Button
		public class MinusButton extends Game_Actor{
			public MinusButton(){
				texture = Game_TextureManager.getInstance().game_shop_minusbtn; 
				actorX = posx+220 ;
				actorY = posy+48;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((MinusButton)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					if(quantity!=0){
						quantity-=100;
						increase(-100);}
					started = false;
				}
			}
		}
		//Buy Coal Button
		public class BuyButton extends Game_Actor{
			public BuyButton(){
				texture = Game_TextureManager.getInstance().game_shop_buybtn; // reuse the new game back btn texture
				actorX = posx+75 ;
				actorY = posy+20;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((BuyButton)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					if (Game_Shop.actorManager.startpage.buy){
						int goldcost = strToInt(costLabel.getText());
						int coal = strToInt(quantityLabel.getText());
						if (goldcost <= GameScreen.gold){
							GameScreen.game.getPlayerTurn().subGold(goldcost);
							GameScreen.game.getPlayerTurn().addFuel("Coal", coal);
							Game_ScreenMenu.resourceActorManager.refreshResources();
							Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
						}
					}
					if (Game_Shop.actorManager.startpage.sell){
						int goldcost = strToInt(costLabel.getText());
						int coal = strToInt(quantityLabel.getText());
						if (coal <= GameScreen.coal){
							GameScreen.game.getPlayerTurn().addGold(goldcost);
							GameScreen.game.getPlayerTurn().subFuel("Coal", coal);
							Game_ScreenMenu.resourceActorManager.refreshResources();
							Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
						}
					}
					started = false;
				}
			}
			public void changeTexture(){
				if (Game_Shop.actorManager.startpage.buy==true)
					this.texture=Game_TextureManager.getInstance().game_shop_buybtn;
				if (Game_Shop.actorManager.startpage.sell==true)
					this.texture=Game_TextureManager.getInstance().game_shop_sellbtn;
			}
		}

		public ArrayList<Actor> getActors() {
			return this.actors;
		}
	}

	//Oil
	public static class Game_shop_oil {
		ArrayList<Actor> actors ;
		public static Label quantityLabel,costLabel, goldLabel;
		public int quantity, cost;
		public static int posx=700;
		public static int posy=470;
		public static LabelStyle style;
		BuyButton buyButton;
		public Game_shop_oil(){
			this.actors = new ArrayList<Actor>();
			Game_Asset coalitem = new Game_Asset(posx, posy,Game_TextureManager.getInstance().game_shop_oilitem);
			AddButton add = new AddButton();
			MinusButton minus = new MinusButton();
			buyButton = new BuyButton();
			actors.add(coalitem);
			actors.add(buyButton);
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


		public class AddButton extends Game_Actor{
			public AddButton(){
				texture = Game_TextureManager.getInstance().game_shop_addbtn; 
				actorX = posx+75 ;
				actorY = posy+42;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((AddButton)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					quantity+=100;
					increase(100);
					started = false;
				}
			}
		}

		public class MinusButton extends Game_Actor{
			public MinusButton(){
				texture = Game_TextureManager.getInstance().game_shop_minusbtn; // reuse the new game back btn texture
				actorX = posx+220 ;
				actorY = posy+48;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((MinusButton)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					if(quantity!=0){
						quantity-=100;
						increase(-100);}
					started = false;
				}
			}
		}

		public static class BuyButton extends Game_Actor{
			public BuyButton(){
				texture = Game_TextureManager.getInstance().game_shop_buybtn; // reuse the new game back btn texture
				actorX = posx+75 ;
				actorY = posy+20;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((BuyButton)event.getTarget()).started = true;
						return true;
					}
				});

			}

			public void act(float delta){
				if(started){
					if (Game_Shop.actorManager.startpage.buy){
						int goldcost = strToInt(costLabel.getText());
						int oil = strToInt(quantityLabel.getText());
						if (goldcost <= GameScreen.gold){
							GameScreen.game.getPlayerTurn().subGold(goldcost);
							GameScreen.game.getPlayerTurn().addFuel("Oil", oil);
							Game_ScreenMenu.resourceActorManager.refreshResources();
							Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
						}
					}
					if (Game_Shop.actorManager.startpage.sell){
						int goldcost = strToInt(costLabel.getText());
						int oil = strToInt(quantityLabel.getText());
						if (oil <= GameScreen.oil){
							GameScreen.game.getPlayerTurn().addGold(goldcost);
							GameScreen.game.getPlayerTurn().subFuel("Oil", oil);
							Game_ScreenMenu.resourceActorManager.refreshResources();
							Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
						}
					}
					started = false;
				}
			}
			public void changeTexture(){
				if (Game_Shop.actorManager.startpage.buy==true)
					this.texture=Game_TextureManager.getInstance().game_shop_buybtn;
				if (Game_Shop.actorManager.startpage.sell==true)
					this.texture=Game_TextureManager.getInstance().game_shop_sellbtn;
			}
		}

		public ArrayList<Actor> getActors() {
			return this.actors;
		}

	}

	//Electricity
	public static class Game_shop_electricity {
		ArrayList<Actor> actors ;
		public static Label quantityLabel,costLabel, goldLabel;
		public int quantity, cost;
		public static int posx=1100;
		public static int posy=470;
		public static LabelStyle style;
		BuyButton buyButton;
		public Game_shop_electricity(){
			this.actors = new ArrayList<Actor>();
			Game_Asset coalitem = new Game_Asset(posx,posy,Game_TextureManager.getInstance().game_shop_electricityitem);
			AddButton add = new AddButton();
			MinusButton minus = new MinusButton();
			buyButton = new BuyButton();
			actors.add(coalitem);
			actors.add(buyButton);
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

		public class AddButton extends Game_Actor{
			public AddButton(){
				texture = Game_TextureManager.getInstance().game_shop_addbtn; // reuse the new game back btn texture
				actorX = posx+75 ;
				actorY = posy+42;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((AddButton)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					quantity+=100;
					increase(100);
					started = false;
				}
			}
		}

		public class MinusButton extends Game_Actor{
			public MinusButton(){
				texture = Game_TextureManager.getInstance().game_shop_minusbtn; // reuse the new game back btn texture
				actorX = posx+220 ;
				actorY = posy+48;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((MinusButton)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					if(quantity!=0){
						quantity-=100;
						increase(-100);}
					started = false;
				}
			}
		}

		public static class BuyButton extends Game_Actor{
			public BuyButton(){
				texture = Game_TextureManager.getInstance().game_shop_buybtn; // reuse the new game back btn texture
				actorX = posx+75 ;
				actorY = posy+20;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((BuyButton)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					if (Game_Shop.actorManager.startpage.buy){
						int goldcost = strToInt(costLabel.getText());
						int electricity = strToInt(quantityLabel.getText());
						if (goldcost <= GameScreen.gold){
							GameScreen.game.getPlayerTurn().subGold(goldcost);
							GameScreen.game.getPlayerTurn().addFuel("Electric", electricity);
							Game_ScreenMenu.resourceActorManager.refreshResources();
							Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
						}
					}
					if (Game_Shop.actorManager.startpage.sell){
						int goldcost = strToInt(costLabel.getText());
						int electricity = strToInt(quantityLabel.getText());
						if (electricity <= GameScreen.electricity){
							GameScreen.game.getPlayerTurn().addGold(goldcost);
							GameScreen.game.getPlayerTurn().subFuel("Electric", electricity);
							Game_ScreenMenu.resourceActorManager.refreshResources();
							Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
						}
					}
					started = false;
				}
			}
			public void changeTexture(){
				if (Game_Shop.actorManager.startpage.buy==true)
					texture=Game_TextureManager.getInstance().game_shop_buybtn;
				if (Game_Shop.actorManager.startpage.sell==true)
					texture=Game_TextureManager.getInstance().game_shop_sellbtn;
			}

		}

		public ArrayList<Actor> getActors() {
			return this.actors;
		}





	}
	
	//Nuclear
	public static class Game_shop_nuclear {
		ArrayList<Actor> actors ;
		public static Label quantityLabel,costLabel, goldLabel;
		public int quantity, cost;
		public static int posx=300;
		public static int posy=100;
		public static LabelStyle style;
		BuyButton buyButton;
		public Game_shop_nuclear(){
			this.actors = new ArrayList<Actor>();
			Game_Asset coalitem = new Game_Asset(posx,posy,Game_TextureManager.getInstance().game_shop_nuclearitem);
			AddButton add = new AddButton();
			MinusButton minus = new MinusButton();
			buyButton = new BuyButton();
			actors.add(coalitem);
			actors.add(buyButton);
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


		public class AddButton extends Game_Actor{
			public AddButton(){
				texture = Game_TextureManager.getInstance().game_shop_addbtn; // reuse the new game back btn texture
				actorX = posx+75 ;
				actorY = posy+42;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((AddButton)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					quantity+=100;
					increase(100);
					started = false;
				}
			}
		}

		public class MinusButton extends Game_Actor{
			public MinusButton(){
				texture = Game_TextureManager.getInstance().game_shop_minusbtn; // reuse the new game back btn texture
				actorX = posx+220 ;
				actorY = posy+48;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((MinusButton)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					if(quantity!=0){
						quantity-=100;
						increase(-100);}
					started = false;
				}
			}
		}

		public static class BuyButton extends Game_Actor{
			public BuyButton(){
				texture = Game_TextureManager.getInstance().game_shop_buybtn; // reuse the new game back btn texture
				actorX = posx+75 ;
				actorY = posy+20;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((BuyButton)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					if (Game_Shop.actorManager.startpage.buy){
						int goldcost = strToInt(costLabel.getText());
						int nuclear = strToInt(quantityLabel.getText());
						if (goldcost <= GameScreen.gold){
							GameScreen.game.getPlayerTurn().subGold(goldcost);
							GameScreen.game.getPlayerTurn().addFuel("Nuclear", nuclear);
							Game_ScreenMenu.resourceActorManager.refreshResources();
							Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
						}
					}
					if (Game_Shop.actorManager.startpage.sell){
						int goldcost = strToInt(costLabel.getText());
						int nuclear = strToInt(quantityLabel.getText());
						if (nuclear <= GameScreen.nuclear){
							GameScreen.game.getPlayerTurn().addGold(goldcost);
							GameScreen.game.getPlayerTurn().subFuel("Nuclear", nuclear);
							Game_ScreenMenu.resourceActorManager.refreshResources();
							Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
						}
					}
					started = false;
				}
			}
			public void changeTexture(){
				if (Game_Shop.actorManager.startpage.buy==true)
					texture=Game_TextureManager.getInstance().game_shop_buybtn;
				if (Game_Shop.actorManager.startpage.sell==true)
					texture=Game_TextureManager.getInstance().game_shop_sellbtn;
			}
		}

		public ArrayList<Actor> getActors() {
			return this.actors;
		}




	}

	//Train
	public static class Game_shop_train {
		ArrayList<Actor> actors ;
		public static Label quantityLabel;
		public Label costLabel;
		public static Label goldLabel;
		public int quantity, cost, posx=1100, posy=100;
		public static LabelStyle style;
		BuyButton buyButton;
		public Game_shop_train(){
			this.actors = new ArrayList<Actor>();
			Game_Asset trainItem = new Game_Asset(posx,posy,Game_TextureManager.getInstance().game_shop_trainitem);
			buyButton = new BuyButton();
			actors.add(trainItem);
			actors.add(buyButton);

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

		public class BuyButton extends Game_Actor{
			public BuyButton(){
				texture = Game_TextureManager.getInstance().game_shop_blankbuybtn; // reuse the new game back btn texture
				actorX = posx+75 ;
				actorY = posy+20;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((BuyButton)event.getTarget()).started = true;
						return true;
					}
				});

			}
			public void act(float delta){
				if(started){
					
					}
					started = false;
				}
			}

		public ArrayList<Actor> getActors() {
			return this.actors;
		}

	}
}
