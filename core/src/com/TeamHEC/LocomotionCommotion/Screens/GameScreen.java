package com.TeamHEC.LocomotionCommotion.Screens;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_ActorManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_MapManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TicketsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen {
	private static Stage stage;
	public static SpriteBatch sb;
	public Camera camera;

	public static void create(){
		setStage(new Stage());
		Camera camera = getStage().getCamera();
		camera.update();
		Gdx.input.setInputProcessor(getStage());	
		Game_MapManager.create(getStage());
		Game_ActorManager.create(getStage());
		Game_TicketsManager.create(getStage());
		
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
