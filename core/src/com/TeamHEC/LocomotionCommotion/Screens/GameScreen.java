package com.TeamHEC.LocomotionCommotion.Screens;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_ActorManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_MapManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_PauseMenuManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TicketsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen implements Screen {
	private static Stage stage;
	public static SpriteBatch sb;
	public OrthographicCamera camera;
	public static int screenX = 1680; //Gdx.graphics.getWidth();
	public static int screenY = 1050;//Gdx.graphics.getHeight();

	public static void create(){
//		int x =screenX;
//		int y= screenY;
//		OrthographicCamera camera = new OrthographicCamera(x,y);
//		camera.setToOrtho(false,x,y );
//		
//		FitViewport viewp = new FitViewport(x,y,camera);
//		sb = new SpriteBatch();
//		setStage(new Stage(viewp, sb)); 
//		
//		camera.update();
		stage = new Stage(); 
		Camera camera = stage.getCamera();
		camera.viewportHeight= screenY;
		camera.viewportWidth= screenX;
		camera.update();
		Gdx.input.setInputProcessor(getStage());	
		Game_MapManager.create(getStage());
		Game_ActorManager.create(getStage());
		Game_TicketsManager.create(getStage());
		Game_PauseMenuManager.create(getStage());
		
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
		screenX = width;
		screenY = height;
	}

	@SuppressWarnings("static-access")
	@Override
	public void show() {
		this.create();

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
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		GameScreen.stage = stage;
	}

}
