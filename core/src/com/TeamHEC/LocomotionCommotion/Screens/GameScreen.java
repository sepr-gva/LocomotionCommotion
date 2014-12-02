package com.TeamHEC.LocomotionCommotion.Screens;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_ActorManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_MapManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_PauseMenuManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_ShopManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TicketsManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TrainDepotManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen {
	private static Stage stage;
	public static SpriteBatch sb;
	public OrthographicCamera camera;
	

	public static void create(){
//		
		Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		stage = new Stage(); 
		
		Camera camera = stage.getCamera();
		camera.viewportHeight= LocomotionCommotion.screenY;
		camera.viewportWidth= LocomotionCommotion.screenX;
		camera.update();
		Gdx.input.setInputProcessor(getStage());	
		stage.getActors().clear();
		Game_MapManager mapManger = new Game_MapManager();
		mapManger.create(getStage());
		
		Game_ActorManager actorManager = new Game_ActorManager();
		actorManager.create(getStage());
		
		Game_TicketsManager ticketManager = new Game_TicketsManager();
		ticketManager.create(getStage());
		
		Game_PauseMenuManager pauseManager= new Game_PauseMenuManager();
		pauseManager.create(getStage());
		
		Game_ShopManager shopManager = new Game_ShopManager();
		shopManager.create(getStage());
		
		Game_TrainDepotManager trainDepotManager = new Game_TrainDepotManager();
		trainDepotManager.create(getStage());
		}

	@Override
	public void render(float delta) {
		getStage().getCamera().update();

		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		getStage().act(Gdx.graphics.getDeltaTime());
		getStage().draw();

	}

	@Override
	public void resize(int width, int height) {
		getStage().getViewport().update(width, height, true);	
		LocomotionCommotion.screenX = width;
		LocomotionCommotion.screenY = height;
	}

	@Override
	public void show() {
		GameScreen.create();

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}
	public static void resetStage(){
	}

	@Override
	public  void dispose() {
		getStage().dispose();
		getStage().getActors().clear();
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		GameScreen.stage = stage;
	}

	public void  resetScreen(){
		Game_MapManager.infoVisible= false;
		Game_PauseMenuManager.open = false;
		Game_TicketsManager.open = false;
		Game_ShopManager.open = false;
		Game_TrainDepotManager.open = false;

		
		
	
	}
}
