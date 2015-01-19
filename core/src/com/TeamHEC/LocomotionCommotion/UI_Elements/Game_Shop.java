package com.TeamHEC.LocomotionCommotion.UI_Elements;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Card.Game_CardHand;
import com.TeamHEC.LocomotionCommotion.Game_Actors.GameScreen_ActorManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Player.Shop;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_Shop.ShopHomeScreen.Game_shop_card;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_Shop.ShopHomeScreen.Game_shop_coal;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_Shop.ShopHomeScreen.Game_shop_electric;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_Shop.ShopHomeScreen.Game_shop_nuclear;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_Shop.ShopHomeScreen.Game_shop_oil;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_Shop.ShopHomeScreen.Game_shop_train;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.StringBuilder;

/**
 * 
 * @author Robert Precious <rp825@york.ac.uk>
 *
 */
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

		public Sprite game_shop_backdrop, game_shop_title;
		public SpriteButton game_shop_backbtn;
		public Game_shop_coal coalitem;
		public Game_shop_oil oilitem;
		public Game_shop_electric electricityitem;
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


			game_shop_backdrop = new Sprite(-20,-15,Game_TextureManager.getInstance().game_shop_backdrop);
			actors.add(game_shop_backdrop);
			game_shop_title = new Sprite(170,820,Game_TextureManager.getInstance().game_shop_title);
			actors.add(game_shop_title);
			game_shop_backbtn = new SpriteButton(1350,860,Game_TextureManager.getInstance().game_shop_backbtn){
				@Override
				protected void onClicked(){
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
				}
			};
			actors.add(game_shop_backbtn);

			coalitem = new Game_shop_coal();
			coalitem = new Game_shop_coal();
			oilitem = new Game_shop_oil();
			electricityitem = new Game_shop_electric();
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
			GameScreen_ActorManager.goldQuant.setText(g);
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
	//Shop Object Classes
	//SHOP HOME Screen---------------------------------------------------------------
	public static class ShopHomeScreen {
		ArrayList<Actor> actors ;
		public boolean buy=false;
		public boolean sell=false;

		public ShopHomeScreen(){
			this.actors = new ArrayList<Actor>();
			Sprite shopscreen = new Sprite(45, 17, Game_TextureManager.getInstance().game_shop_startscreen);
			this.actors.add(shopscreen);
			SpriteButton back = new SpriteButton(1350,860, Game_TextureManager.getInstance().game_shop_backbtn){
				@Override
				protected void onClicked(){
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

				}
			};
			this.actors.add(back);

			SpriteButton shopbuyButton = new SpriteButton(250,350,Game_TextureManager.getInstance().game_shop_startbuy){
				@Override
				protected void onClicked(){
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

				}
			};
			this.actors.add(shopbuyButton);

			SpriteButton shopsellButton = new SpriteButton(650,350,Game_TextureManager.getInstance().game_shop_startsell){
				@Override
				protected void onClicked(){
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

				}
			};
			this.actors.add(shopsellButton);
			SpriteButton train = new SpriteButton(1050,350, Game_TextureManager.getInstance().game_shop_starttrain){
				@Override
				protected void onClicked(){
				}

			};
			this.actors.add(train);


		}

		public ArrayList<Actor> getActors() {
			return this.actors;
		}

		//METHODS TO SWITCH BETWEEN BUY AND SELL-----------
		public void  setToSell(){
			buy=false;
			sell=true;
			Texture t = Game_TextureManager.getInstance().game_shop_sellbtn;
			Game_Shop.actorManager.carditem.buyButton.setTexture(t);
			Game_Shop.actorManager.oilitem.buyButton.setTexture(t);
			Game_Shop.actorManager.electricityitem.buyButton.setTexture(t);
			Game_Shop.actorManager.nuclearitem.buyButton.setTexture(t);
			Game_Shop.actorManager.carditem.buyButton.setTexture(t);
			Game_Shop.actorManager.trainitem.costLabel.setText("Sell Trains");
			Game_Shop.actorManager.titleLabel.setText("Sell");
		}

		public void  setToBuy(){
			buy=true;
			sell=false;
			Texture t = Game_TextureManager.getInstance().game_shop_buybtn;
			Game_Shop.actorManager.coalitem.buyButton.setTexture(t);
			Game_Shop.actorManager.oilitem.buyButton.setTexture(t);
			Game_Shop.actorManager.electricityitem.buyButton.setTexture(t);
			Game_Shop.actorManager.nuclearitem.buyButton.setTexture(t);
			Game_Shop.actorManager.carditem.buyButton.setTexture(t);
			Game_Shop.actorManager.trainitem.costLabel.setText("Buy Trains");
			Game_Shop.actorManager.titleLabel.setText("Buy");
		}


		//Card
		public static class Game_shop_card {
			ArrayList<Actor> actors ;
			public static Label quantityLabel,costLabel, goldLabel;
			public int quantity, cost;
			public static int posx=700;
			public static int posy=100;
			public static LabelStyle style;
			SpriteButton buyButton ;

			public Game_shop_card(){
				this.actors = new ArrayList<Actor>();

				Sprite cardItem = new Sprite(posx,posy,Game_TextureManager.getInstance().game_shop_carditem);
				buyButton = new SpriteButton(posx+75,posy+20,Game_TextureManager.getInstance().game_shop_buybtn){
					@Override
					protected void onClicked(){
						if (Game_Shop.actorManager.startpage.buy){						
							if(GameScreen.game.getPlayerTurn().getCards().size()<7){
								int newAdditionIndex = GameScreen.game.getPlayerTurn().getCards().size();
								GameScreen.game.getPlayerTurn().getShop().buyCard();
								if(GameScreen.game.getPlayerTurn().getCards().size()>newAdditionIndex){
									Game_CardHand.actorManager.addCard(GameScreen.game.getPlayerTurn().getCards().get(newAdditionIndex));
									GameScreen_ActorManager.refreshResources();
									Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
								}
							}
						}
					}

				};

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
				costLabel.setText("1000");

				actors.add(costLabel);
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
			SpriteButton buyButton, minus, add;

			public Game_shop_coal(){
				this.actors = new ArrayList<Actor>();
				Sprite coalitem = new Sprite(posx,posy,Game_TextureManager.getInstance().game_shop_coalitem);
				add = new SpriteButton(posx+75,posy+42,Game_TextureManager.getInstance().game_shop_addbtn){
					@Override
					protected void onClicked(){
						quantity+=100;
						changeQuantity(100);

					}

				};
				minus = new SpriteButton(posx+220,posy+48,Game_TextureManager.getInstance().game_shop_minusbtn){
					@Override
					protected void onClicked(){
						if(quantity!=0){
							quantity-=100;
							changeQuantity(-100);}

					}

				};

				buyButton = new SpriteButton(posx+75,posy+20,Game_TextureManager.getInstance().game_shop_buybtn){
					@Override
					protected void onClicked(){
						if (Game_Shop.actorManager.startpage.buy){
							int quantity = strToInt(quantityLabel.getText());
							GameScreen.game.getPlayerTurn().getShop().buyFuel("Coal",quantity );									
						}
						if (Game_Shop.actorManager.startpage.sell){						
							int quantity = strToInt(quantityLabel.getText());
							GameScreen.game.getPlayerTurn().getShop().sellFuel("Coal", quantity);
						}
						GameScreen_ActorManager.refreshResources();
						Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
					}
					
				};

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
				costLabel.setText(""+strToInt(quantityLabel.getText())*Shop.coalPrice);

				actors.add(quantityLabel);
				actors.add(costLabel);
			}

			public static void changeQuantity(int change){
				int newQuantity = strToInt(quantityLabel.getText());
				newQuantity+=change;
				costLabel.setText(""+(newQuantity*Shop.coalPrice));

				String l = new Integer(newQuantity).toString();
				quantityLabel.setText(l);
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
			SpriteButton buyButton, minus, add;

			public Game_shop_oil(){
				this.actors = new ArrayList<Actor>();
				Sprite oilitem = new Sprite(posx,posy,Game_TextureManager.getInstance().game_shop_oilitem);
				add = new SpriteButton(posx+75,posy+42,Game_TextureManager.getInstance().game_shop_addbtn){
					@Override
					protected void onClicked(){
						quantity+=100;
						changeQuantity(100);

					}

				};
				minus = new SpriteButton(posx+220,posy+48,Game_TextureManager.getInstance().game_shop_minusbtn){
					@Override
					protected void onClicked(){
						if(quantity!=0){
							quantity-=100;
							changeQuantity(-100);}

					}

				};

				buyButton = new SpriteButton(posx+75,posy+20,Game_TextureManager.getInstance().game_shop_buybtn){
					@Override
					protected void onClicked(){
						if (Game_Shop.actorManager.startpage.buy){
							int quantity = strToInt(quantityLabel.getText());
							GameScreen.game.getPlayerTurn().getShop().buyFuel("Oil",quantity );									
						}
						if (Game_Shop.actorManager.startpage.sell){						
							int quantity = strToInt(quantityLabel.getText());
							GameScreen.game.getPlayerTurn().getShop().sellFuel("Oil", quantity);
						}
						GameScreen_ActorManager.refreshResources();
						Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
					}
					
				};

				actors.add(oilitem);
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
				costLabel.setText(""+strToInt(quantityLabel.getText())*Shop.oilPrice);

				actors.add(quantityLabel);
				actors.add(costLabel);
			}

			public static void changeQuantity(int change){
				int newQuantity = strToInt(quantityLabel.getText());
				newQuantity+=change;
				costLabel.setText(""+(newQuantity*Shop.oilPrice));

				String l = new Integer(newQuantity).toString();
				quantityLabel.setText(l);
			}


			public ArrayList<Actor> getActors() {
				return this.actors;
			}
		}


		//Electricity
		public static class Game_shop_electric {
			ArrayList<Actor> actors ;
			public static Label quantityLabel,costLabel, goldLabel;
			public int quantity, cost;
			public static int posx=1100;
			public static int posy=470;
			public static LabelStyle style;
			SpriteButton buyButton, minus, add;

			public Game_shop_electric(){
				this.actors = new ArrayList<Actor>();
				Sprite electricitem = new Sprite(posx,posy,Game_TextureManager.getInstance().game_shop_electricityitem);
				add = new SpriteButton(posx+75,posy+42,Game_TextureManager.getInstance().game_shop_addbtn){
					@Override
					protected void onClicked(){
						quantity+=100;
						changeQuantity(100);

					}

				};
				minus = new SpriteButton(posx+220,posy+48,Game_TextureManager.getInstance().game_shop_minusbtn){
					@Override
					protected void onClicked(){
						if(quantity!=0){
							quantity-=100;
							changeQuantity(-100);}

					}

				};

				buyButton = new SpriteButton(posx+75,posy+20,Game_TextureManager.getInstance().game_shop_buybtn){
					@Override
					protected void onClicked(){
						if (Game_Shop.actorManager.startpage.buy){
							int quantity = strToInt(quantityLabel.getText());
							GameScreen.game.getPlayerTurn().getShop().buyFuel("Electric",quantity );									
						}
						if (Game_Shop.actorManager.startpage.sell){						
							int quantity = strToInt(quantityLabel.getText());
							GameScreen.game.getPlayerTurn().getShop().sellFuel("Electric", quantity);
						}
						GameScreen_ActorManager.refreshResources();
						Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
					}
				
				};

				actors.add(electricitem);
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
				costLabel.setText(""+strToInt(quantityLabel.getText())*Shop.electricPrice);

				actors.add(quantityLabel);
				actors.add(costLabel);
			}

			public static void changeQuantity(int change){
				int newQuantity = strToInt(quantityLabel.getText());
				newQuantity+=change;
				costLabel.setText(""+(newQuantity*Shop.coalPrice));

				String l = new Integer(newQuantity).toString();
				quantityLabel.setText(l);
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
			SpriteButton buyButton, minus, add;

			public Game_shop_nuclear(){
				this.actors = new ArrayList<Actor>();
				Sprite nuclearitem = new Sprite(posx,posy,Game_TextureManager.getInstance().game_shop_electricityitem);
				add = new SpriteButton(posx+75,posy+42,Game_TextureManager.getInstance().game_shop_addbtn){
					@Override
					protected void onClicked(){
						quantity+=100;
						changeQuantity(100);

					}

				};
				minus = new SpriteButton(posx+220,posy+48,Game_TextureManager.getInstance().game_shop_minusbtn){
					@Override
					protected void onClicked(){
						if(quantity!=0){
							quantity-=100;
							changeQuantity(-100);}

					}

				};

				buyButton = new SpriteButton(posx+75,posy+20,Game_TextureManager.getInstance().game_shop_buybtn){
					@Override
					protected void onClicked(){
						if (Game_Shop.actorManager.startpage.buy){
							int quantity = strToInt(quantityLabel.getText());
							GameScreen.game.getPlayerTurn().getShop().buyFuel("Nuclear",quantity );									
						}
						if (Game_Shop.actorManager.startpage.sell){						
							int quantity = strToInt(quantityLabel.getText());
							GameScreen.game.getPlayerTurn().getShop().sellFuel("Nuclear", quantity);
						}
						GameScreen_ActorManager.refreshResources();
						Game_ShopManager.refreshgold(GameScreen.game.getPlayerTurn().getGold());
					}
				
				};

				actors.add(nuclearitem);
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
				costLabel.setText(""+strToInt(quantityLabel.getText())*Shop.nuclearPrice);

				actors.add(quantityLabel);
				actors.add(costLabel);
			}

			public static void changeQuantity(int change){
				int newQuantity = strToInt(quantityLabel.getText());
				newQuantity+=change;
				costLabel.setText(""+(newQuantity*Shop.nuclearPrice));

				String l = new Integer(newQuantity).toString();
				quantityLabel.setText(l);
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
			SpriteButton buyButton;
			public Game_shop_train(){
				this.actors = new ArrayList<Actor>();
				Sprite trainItem = new Sprite(posx,posy,Game_TextureManager.getInstance().game_shop_trainitem);
				buyButton = new SpriteButton(posx+75,posy+20,Game_TextureManager.getInstance().game_shop_blankbuybtn);
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
			public ArrayList<Actor> getActors() {
				return this.actors;
			}
		}
	}
}

