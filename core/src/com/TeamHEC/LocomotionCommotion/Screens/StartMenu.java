package com.TeamHEC.LocomotionCommotion.Screens;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
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
/*
 * StartMenu is the Screen shown at the start of the game (maybe after a splash screen).
 * It is formatted in a way that the four sub pages are in up,down, left and right directions.
 * Moving between pages is achieved by changing the orthographic camera.
 * Start Menu has parameters:
 * @param	stage - The structure used to implement actors by addActor()
 * @param	sb - The SpriteBatch, structure needed to display some elements.
 * @param 	camera - The camera used to display to the user
 * @param	gameMode - keeps track of game mode selected in new game page
 * @param	player1name - holds the inputed player1 name given in textfield in new game page
 * @param	player1name - holds the inputed player2 name given in textfield in new game page
 * @param	turnChoice	- holds the choice of number of turns in new game page
 * @param	textbox1	- the TextField used to get the input from user for player1 name
 * @param	textbox2	- the TextField used to get the input from user for player2 name
 * @param	skin		- the skin used for textbox's (formating json file)
 * @param	player1		- the listener for textbox1
 * @param	player2		- the listener for textbox2
 * 
 *@method	create method is used initialize page (called entirely by show) 
 *@method 	changeCam Method is used to move the camera 
 *@method 	resize	-updates the viewport of the camera
 *@method	render	-renders the screen and outputs to the user
 *
 *
 * 
 * 
 */
public class StartMenu implements Screen{ 
	
	private static Stage stage;
	public static SpriteBatch sb;
	public Camera camera;
	
	public static String gameMode, player1name, player2name;
	public static int turnChoice;
	public static TextField textbox1, textbox2;
	public static int screenX = 1680; //Gdx.graphics.getWidth();
	public static int screenY = 1050;//Gdx.graphics.getHeight();
	
	
	/*
	 * 
	 */
	public static void create(){
		
		stage = new Stage(); 
		Camera camera = stage.getCamera();
		camera.viewportHeight= screenY;
		camera.viewportWidth= screenX;
		camera.update();
        SM_ActorManager.create(stage);
        Gdx.input.setInputProcessor(stage);
        
        
        
        //Text boxes for Player 1 and 2 names
    	Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
    	
		textbox1 = new TextField("", skin);
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
	 
		textbox2 = new TextField("", skin);
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
