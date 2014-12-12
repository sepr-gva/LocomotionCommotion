package com.TeamHEC.LocomotionCommotion.Game_Actors;


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
 * @param touchedDown	Boolean used to show if an Actor has been interacted with. Used to stop and start interactions.
 * 
 * setBounds	This is the bounds for the interaction, we make it the whole image.
 * addListener	This adds a listener for a particular interaction in this case touchDown (click)
 * draw			Actor is drawn
 * act			The action taken if the listener detects interaction
 * 				Action- Calls add goal which add the selected goal to the players goals
 * 
 * Other Notes:
 * 				There are 2  listeners here one for mouse over because when you moused over with just the listener from the goals it read it as exiting when entering the addgoalbtn
 * 				touchedDown handles the action.
 */

public class Game_goal_AddGoalBtn extends Actor {

	public static Texture texture = Game_TextureManager.game_menuobject_addgoalbtn;
	public  float actorX  ,actorY ;
	public boolean started = false;
	public boolean touchedDown = false;

	public Game_goal_AddGoalBtn(){
		this.actorX=720;
		this.actorY=575;
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((Game_goal_AddGoalBtn)event.getTarget()).touchedDown = true;
				return true;
			}
		});
		addListener(new InputListener(){
			public void enter(InputEvent event, float x, float y, int pointer, Actor ScreenCard) {
				((Game_goal_AddGoalBtn)event.getTarget()).started = true;
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
			this.setVisible(true);
			started = false;
		}
	if(touchedDown){
		if (Game_goal_PlayerGoals.addGoal(Game_Goal_GoalScreenManager.selectedGoal)){ 				//If the addGoal function returns true 
			Game_Goal_GoalScreenManager.selectedGoal.setEmpty(true);								//Sets the slot from which the goal is added to empty
			String a = new Integer(Game_Goal_GoalScreenManager.selectedGoal.getIndex()).toString();	//turns the goal index int to a string
			Game_Goal_GoalScreenManager.goalLabels.get(a).setText("");;								//clears the label (text on the ticket)
			this.setVisible(false);																	//Hides the AddGoal Buttons
			
		}
			
			touchedDown=false;
		}
	}

	public  void setY(float y){
		this.actorY= y;
	}
	public  void setX(float x){
		this.actorX= x;
	}
	@Override
	public  float getY(){
		return this.actorY;
	}
	public  float getX(){
		return this.actorX;
	}
	public void refreshBounds(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());

	}

}
