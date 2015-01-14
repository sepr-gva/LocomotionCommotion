package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_TrainDepot {
	public static Game_TrainDepotManager actorManager;
	
	public void create(Stage stage){
		actorManager= new Game_TrainDepotManager();
		actorManager.create(stage);
	}
	
	public static class Game_TrainDepotManager {

		private final static Array<Actor> actors = new Array<Actor>();
		
		public static Game_Asset game_traindepot_backdrop;
		public static Game_traindepot_BackBtn game_traindepot_backbtn;
		public static Game_Asset game_traindepot_title;
		
		
		public boolean open=false;
		
		public static int  stageStart, stageEnd;


		public Game_TrainDepotManager(){	}
			
		public void create(Stage stage){
			actors.clear();
			stageStart= 0;
			stageEnd =0;
			game_traindepot_backdrop = new Game_Asset(-1,-20,Game_TextureManager.getInstance().game_shop_backdrop);
			actors.add(game_traindepot_backdrop);
			game_traindepot_backbtn = new Game_traindepot_BackBtn();
			actors.add(game_traindepot_backbtn);
			game_traindepot_title = new Game_Asset(170,780,Game_TextureManager.getInstance().game_traindepot_title);
			actors.add(game_traindepot_title);
			

		
		
			
			stageStart= stage.getActors().size;
			stageEnd= stageStart + actors.size-1;
			for (Actor a : actors){
				if(open == true){
					a.setTouchable(Touchable.enabled);
					a.setVisible(true);}
				else
					a.setVisible(false);

				stage.addActor(a);
				
			}
			
				

		}
		public  int getStageStart(){
			return stageStart;
		}
		public  int getStageEnd(){
			return stageEnd;
		}
	}
	public static class Game_traindepot_BackBtn extends Game_Actor {
		public Game_traindepot_BackBtn(){
			texture = Game_TextureManager.getInstance().game_shop_backbtn; // reuse the new game back btn texture
			actorX = 1350 ;
			actorY = 800;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_traindepot_BackBtn)event.getTarget()).started = true;
					return true;
				}
			});
			
		}
		public void act(float delta){
			if(started){
				if (Game_TrainDepot.actorManager.open== false)
				{
					Game_TrainDepot.actorManager.open= true;
					for(int i=Game_TrainDepot.actorManager.getStageStart(); i<=Game_TrainDepot.actorManager.getStageEnd();i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_TrainDepot.actorManager.open= false;
				for(int i=Game_TrainDepot.actorManager.getStageStart(); i<=Game_TrainDepot.actorManager.getStageEnd();i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}

				}
				started = false;
				}
			}
	}

}
