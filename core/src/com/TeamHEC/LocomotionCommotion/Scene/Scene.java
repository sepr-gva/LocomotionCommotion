package com.TeamHEC.LocomotionCommotion.Scene;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Scene implements Screen{
	
	public Stage stage;
	public static Camera camera;
	public static int screenX = 1680;
	public static int screenY = 1050;
	
	public static Array<Actor> actors;
	
	public Scene()
	{
		stage = new Stage();
		camera = stage.getCamera();
		camera.viewportHeight= screenY;
		camera.viewportWidth= screenX;
		camera.update();
        Gdx.input.setInputProcessor(stage);
		
		actors = new Array<Actor>();
	}
	
	public void addToStage()
	{
		for (Actor a : actors)
		{
			a.setTouchable(Touchable.enabled);
			stage.addActor(a);
		}
	}
	
	public void setVisibility(boolean visible)
	{
		for (Actor a : actors)
		{
			a.setVisible(visible);
		}
	}
	
	public void removeFromStage()
	{
		for (Actor a : actors)
		{
			int index = stage.getActors().indexOf(a, false);
			if(index != -1)
				stage.getActors().removeIndex(index);
		}
	}

	public void changeCam(int x,int y){
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
		stage.getViewport().update(width, height, true);	
		LocomotionCommotion.screenX = width;
		LocomotionCommotion.screenY = height;
	}

	@Override
	public void dispose() {
		stage.dispose();
		stage.getActors().clear();
	}

	@Override
	public void show() {
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

	@Override
	public void hide() {
	}
}
