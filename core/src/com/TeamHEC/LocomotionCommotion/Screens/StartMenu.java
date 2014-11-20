package com.TeamHEC.LocomotionCommotion.Screens;

import com.TeamHEC.LocomotionCommotion.Screens.Actors.LinesActor;
import com.TeamHEC.LocomotionCommotion.Screens.Actors.NewGameActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class StartMenu implements Screen{ 
	
	private static Stage stage;
	
	public static void create(){
		stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        
        LinesActor lines = new LinesActor();
        lines.setTouchable(Touchable.enabled);
        NewGameActor newGame = new NewGameActor();
        newGame.setTouchable(Touchable.enabled);
        stage.addActor(lines);
        stage.addActor(newGame);
    }
	

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
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
