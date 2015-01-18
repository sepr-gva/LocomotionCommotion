package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_PauseMenu {
	
	public static Game_Pause_Manager actorManager;
	
	public void create(Stage stage){
		actorManager = new Game_Pause_Manager();
		actorManager.create(stage);
	}
	public static class Game_Pause_Manager {
		

		private final static Array<Actor> actors = new Array<Actor>();

		public  Game_Asset game_pause_blackoutscreen;
		public static Game_Asset game_pause_background;
		public  Game_Asset game_pause_logo;
		public  Game_pause_ResumeGame game_pause_resume;
		public  Game_pause_LoadGame game_pause_load;
		public  Game_pause_Settings game_pause_settings;
		public  Game_pause_MainMenu game_pause_mainmenu;


		public boolean open=false;

		public static int  stagestart, stageend;


		public Game_Pause_Manager(){	}

		public void create(Stage stage){
			stagestart =0;
			actors.clear();

		
			
			game_pause_blackoutscreen = new Game_Asset(0, 0, Game_TextureManager.getInstance().game_pause_blackoutscreen);
			actors.add(game_pause_blackoutscreen);
			game_pause_background = new Game_Asset(550, 100, Game_TextureManager.getInstance().game_pause_background);
			actors.add(game_pause_background);
			game_pause_logo = new Game_Asset(740, 700, Game_TextureManager.getInstance().game_pause_pauselogo);
			actors.add(game_pause_logo);
			
			game_pause_resume = new Game_pause_ResumeGame();
			actors.add(game_pause_resume);
			game_pause_load = new Game_pause_LoadGame();
			actors.add(game_pause_load);
			game_pause_settings = new Game_pause_Settings();
			actors.add(game_pause_settings);
			game_pause_mainmenu = new Game_pause_MainMenu();
			actors.add(game_pause_mainmenu);




			stagestart= stage.getActors().size;
			stageend = stagestart+actors.size-1;
			for (Actor a : actors){
				if(open == true){
					a.setTouchable(Touchable.enabled);
					a.setVisible(true);}
				else
					a.setVisible(false);

				stage.addActor(a);
			}



		}

		public int getStageStart(){
			return stagestart;
		}
		public int getStageEnd(){
			return stageend;
		}





	}


	//Pause Menu Options------------------------------------------------------
	//Resume Game Button
	public static class Game_pause_ResumeGame extends Game_Actor {
		public Game_pause_ResumeGame(){
			texture = Game_TextureManager.getInstance().game_pause_resumegame;
			setActorX(590) ;
			setActorY(550);
			setBounds(getActorX(),getActorY(),texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_pause_ResumeGame)event.getTarget()).started = true;
					return true;
				}
			});

		}
		public void act(float delta){
			if(started){
				if (Game_PauseMenu.actorManager.open== false)
				{
					Game_PauseMenu.actorManager.open= true;
					for(int i=Game_PauseMenu.actorManager.getStageStart(); i<=Game_PauseMenu.actorManager.getStageEnd();i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_PauseMenu.actorManager.open= false;
				for(int i=Game_PauseMenu.actorManager.getStageStart(); i<=Game_PauseMenu.actorManager.getStageEnd();i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}

				}
				started = false;
			}
		}
	
	}
	//Load Game Button
	public static class Game_pause_LoadGame extends Game_Actor {
		public Game_pause_LoadGame(){
			texture = Game_TextureManager.getInstance().game_pause_loadgame; // reuse the new game back btn texture
			setActorX(Game_PauseMenu.actorManager.game_pause_resume.getActorX());
			setActorY(Game_PauseMenu.actorManager.game_pause_resume.getActorY()-100);
			setBounds(getActorX(),getActorY(),texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_pause_LoadGame)event.getTarget()).started = true;
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
	//Setting Button
	public static class Game_pause_Settings extends Game_Actor {
		public Game_pause_Settings(){
			texture = Game_TextureManager.getInstance().game_pause_settings; // reuse the new game back btn texture
			setActorX(Game_PauseMenu.actorManager.game_pause_resume.getActorX()) ;
			setActorY(Game_PauseMenu.actorManager.game_pause_resume.getActorY()-200);
			setBounds(getActorX(),getActorY(),texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_pause_Settings)event.getTarget()).started = true;
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
	//Main Menu Button
	public static class Game_pause_MainMenu extends Game_Actor {
		public Game_pause_MainMenu(){
			texture = Game_TextureManager.getInstance().game_pause_mainmenu; // reuse the new game back btn texture
			setActorX(Game_PauseMenu.actorManager.game_pause_resume.getActorX()) ;
			setActorY(Game_PauseMenu.actorManager.game_pause_resume.getActorY()-300);
			setBounds(getActorX(),getActorY(),texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_pause_MainMenu)event.getTarget()).started = true;
					return true;
				}
			});
			
		}
		public void act(float delta){
			if(started){
				LocomotionCommotion.getInstance().setMenuScreen();
				started = false;
			}
		}
	}
}
