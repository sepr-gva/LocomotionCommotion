package com.TeamHEC.LocomotionCommotion.Screens;

import com.TeamHEC.LocomotionCommotion.Screens.Actors.ActorManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class StartMenu implements Screen{ 
	
	private static Stage stage;
	public static SpriteBatch sb;
	public Camera camera;
	
	
	public static void create(){
		
		stage = new Stage();
		Camera camera = stage.getCamera();
		//camera.translate(0, -100, 0);
		camera.update();
        Gdx.input.setInputProcessor(stage);
        ActorManager.create(stage);
    }
	
	public static void changeCam(int x,int y){
		stage.getCamera().translate(x, y, 0);
	
	}

	@Override
	public void render(float delta) {
		stage.getCamera().update();
		
		
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getCamera().update();
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		stage.dispose();
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

}
