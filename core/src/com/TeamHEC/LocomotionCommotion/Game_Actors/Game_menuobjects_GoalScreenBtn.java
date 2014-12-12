package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
/*
 * @author Robert Precious <rp825@york.ac.uk>
 * 
 * This is an Actor- meaning it's given texture is displayed on the stage and actions (acts) can be performed.
 * @param texture	The image used for the Actor pulled in from SM_TextureManager (see documentation)
 * @param actorX	The x coordinate of the bottom left corner of the image
 * @param actorY	The y coordinate of the bottom left corner of the image
 * @param started	Boolean used to show if an Actor has been interacted with. Used to stop and start interactions.
 * 
 * setBounds	This is the bounds for the interaction, we make it the whole image.
 * addListener	This adds a listener for a particular interaction in this case touchDown (click)
 * draw			Actor is drawn
 * act			The action taken if the listener detects interaction
 * 				Action- None
 */

public class Game_menuobjects_GoalScreenBtn extends Actor {

	Texture texture = Game_TextureManager.game_goals_goalscreenbtn; // reuse the new game back btn texture
	float actorX = 110 ,actorY = LocomotionCommotion.screenY-110;
	public boolean started = false;

	public Game_menuobjects_GoalScreenBtn(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((Game_menuobjects_GoalScreenBtn)event.getTarget()).started = true;
				return true;
			}
		});
	}


	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(texture,actorX,actorY);
	}

	@Override
	public void act(float delta){
		if(started){
			if (Game_Goal_GoalScreenManager.open== false)
			{
				Game_Goal_GoalScreenManager.open= true;
				Game_goal_PlayerGoals.goalMenuOpen();
				for(int i=Game_Goal_GoalScreenManager.stagestart; i<=Game_Goal_GoalScreenManager.stagestart +Game_Goal_GoalScreenManager.goalActors-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(true);

				}			}
			else
			{	Game_Goal_GoalScreenManager.open= false;
			Game_goal_PlayerGoals.goalMenuClose();
			for(int i=Game_Goal_GoalScreenManager.stagestart; i<=Game_Goal_GoalScreenManager.stagestart +Game_Goal_GoalScreenManager.goalActors-1;i++){
				if (i > GameScreen.getStage().getActors().size-1){

				}else
					GameScreen.getStage().getActors().get(i).setVisible(false);

			}

			}
			started = false;
			}
		}
}