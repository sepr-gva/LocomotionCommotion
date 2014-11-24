package com.TeamHEC.LocomotionCommotion.Screens;

import com.TeamHEC.LocomotionCommotion.Screens.SM_Actors.SM_ActorManager;
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
	
	public static String gameMode, player1name, player2name;
	public static int turnChoice;
	
	
	/*
	 * 
	 */
	public static void create(){
		
		stage = new Stage(); 
		Camera camera = stage.getCamera();
		//camera.translate(0, -100, 0);
		camera.update();
        SM_ActorManager.create(stage);
        Gdx.input.setInputProcessor(stage);
        //TextBox
    	Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
    	
		TextField textbox1 = new TextField("", skin);
		skin.getFont("default-font").setScale(1.5f, 1.5f);
		textbox1.setX(480);
		textbox1.setY(1150+430);
		textbox1.setSize(430, 60);
		textbox1.setMessageText("Player 1");
		TextFieldListener player1 = new TextFieldListener() {
			 @Override
			 public void keyTyped (TextField textbox1, char key) {
			         if (key == '\n') textbox1.getOnscreenKeyboard().show(false);
			         player1name = textbox1.getText();
			     }};
		textbox1.setTextFieldListener(player1);
	 
		TextField textbox2 = new TextField("", skin);
		textbox2.setX(480);
		textbox2.setY(1150+350);
		textbox2.setSize(430, 60);
		textbox2.setMessageText("Player 2");
		TextFieldListener player2 = new TextFieldListener() {
			 @Override
			 public void keyTyped (TextField textbox2, char key) {
			         if (key == '\n') textbox2.getOnscreenKeyboard().show(false);
			         player2name = textbox2.getText();
			     }};
		textbox2.setTextFieldListener(player2);
		stage.addActor(textbox1);
		stage.addActor(textbox2);
		

    }
	
	public static void changeCam(int x,int y){
		stage.getCamera().translate(x, y, 0);
		
		// Matt: Just looking into smooth camera transitions:
		//Vector3 cameraPos = stage.getCamera().position;
		//Vector3 target = new Vector3(x, y, 0);
		//cameraPos.lerp(target, 0.1f);
		//stage.getCamera().translate(cameraPos);
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

	@SuppressWarnings("static-access")
	@Override
	public void show() {
		this.create();
	}
	
	

}
