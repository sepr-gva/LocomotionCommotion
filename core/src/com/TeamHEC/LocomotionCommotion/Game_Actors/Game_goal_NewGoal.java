package com.TeamHEC.LocomotionCommotion.Game_Actors;
/*
 * @author Robert Precious <rp825@york.ac.uk>
 * This the transparent backing of the menu.
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
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Game_goal_NewGoal extends Actor {
	boolean started = false;
	boolean touchedDown = false;
	private Texture texture;
	private float actorX;
	private float actorY;
	private boolean empty, btnvisible;
	private Goal goal;
	public int index;

	public Game_goal_NewGoal( int actorY, int actorX, boolean empty, Goal goal){
		this.goal = goal;
		this.empty= empty;
		this.index =0;
		if (this.empty)
			this.texture = Game_TextureManager.game_menuobject_emptyticket;
		else
		{
			if (this.goal.isSpecial()==false)
				this.texture = Game_TextureManager.game_menuobject_ticket;
			else
				this.texture = Game_TextureManager.game_menuobject_ticket;

		}

		this.actorX = actorX;
		this.actorY = actorY;
		this.btnvisible=false;

		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((Game_goal_NewGoal)event.getTarget()).touchedDown = true;
				return true;
			}
		});
		addListener(new InputListener(){
			public void enter(InputEvent event, float x, float y, int pointer, Actor ScreenCard) {
				((Game_goal_NewGoal)event.getTarget()).started = true;
			}

		});
		addListener(new InputListener(){
			public void exit(InputEvent event, float x, float y, int pointer, Actor ScreenCard) {
				((Game_goal_NewGoal)event.getTarget()).started = true;
			}

		});

	}


	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(this.texture,actorX,actorY);


	}

	@Override
	public void act(float delta){
		if(started){
			if (this.isEmpty()){

			}
			else
			{
				if  (this.btnvisible){
					Game_Goal_GoalScreenManager.Game_goal_addgoalbtn.setVisible(false);
					this.btnvisible=false;
				}
				else
				{
					Game_Goal_GoalScreenManager.selectedGoal=this;
					Game_Goal_GoalScreenManager.Game_goal_addgoalbtn.setX(actorX+60);
					Game_Goal_GoalScreenManager.Game_goal_addgoalbtn.setY(actorY+75);
					Game_Goal_GoalScreenManager.Game_goal_addgoalbtn.setVisible(true);
					Game_Goal_GoalScreenManager.Game_goal_addgoalbtn.refreshBounds();
					this.btnvisible=true;
				}
			}
			started = false;
		}
	
	}


	public boolean isEmpty(){
		return this.empty;
	}
	public void setEmpty(Boolean empty){
		this.empty=empty;
		if (this.empty)
			this.texture = Game_TextureManager.game_menuobject_emptyticket;
		else
		{
			if (this.goal.isSpecial()==false)
				this.texture = Game_TextureManager.game_menuobject_ticket;
			else
				this.texture = Game_TextureManager.game_menuobject_ticket;

		}
	}
	public void setGoal(Goal goal){
		this.goal= goal;
	}
	public  Goal getGoal(){
		return this.goal;
	}

	public void setX(float x){
		this.actorX = x;
	}
	public void setY(float y){
		this.actorY = y;
	}
	public float getX(){
		return this.actorX;
	}
	public float getY(){
		return this.actorY;
	}
	public int getIndex(){
		return this.index;
	}
	public void setIndex(int i){
		this.index=i;
	}
}
