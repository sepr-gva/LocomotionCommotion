package com.TeamHEC.LocomotionCommotion.Screens;

import com.TeamHEC.LocomotionCommotion.Screens.Actors.ActorManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;

public class StartMenu implements Screen{ 
	
	private static Stage stage;
	public static SpriteBatch sb;
	public Camera camera;
	
	
	public static void create(){
		
		stage = new Stage();
		Camera camera = stage.getCamera();
		//camera.translate(0, -100, 0);
		camera.update();
        ActorManager.create(stage);
        Gdx.input.setInputProcessor(stage);
        //TextBox
    	Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		TextField textbox = new TextField("", skin);
		skin.getFont("default-font").setScale(1.5f, 1.5f);
		textbox.setX(480);
		textbox.setY(1150+430);
		textbox.setSize(430, 60);
		textbox.setMessageText("Player 1");
		textbox.setTextFieldListener(new TextFieldListener() {
			 @Override
			 public void keyTyped (TextField textbox, char key) {
			         if (key == '\n') textbox.getOnscreenKeyboard().show(false);
			     }
			 });
		TextField textbox1 = new TextField("", skin);
		textbox1.setX(480);
		textbox1.setY(1150+350);
		textbox1.setSize(430, 60);
		textbox1.setMessageText("Player 2");
		textbox1.setTextFieldListener(new TextFieldListener() {
			 @Override
			 public void keyTyped (TextField textbox1, char key) {
			         if (key == '\n') textbox1.getOnscreenKeyboard().show(false);
			     }
			 });
		stage.addActor(textbox);
		stage.addActor(textbox1);

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
		stage.getViewport().update(width, height, true);
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
