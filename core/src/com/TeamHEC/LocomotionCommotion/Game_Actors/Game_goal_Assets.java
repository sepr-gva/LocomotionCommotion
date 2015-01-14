package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Game_goal_Assets {

	public static class Game_goal_AddGoalBtn extends Game_Actor {
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

		public boolean touchedDown = false;
		public Game_goal_AddGoalBtn(){
			this.actorX=720;
			this.actorY=575;
			texture = Game_TextureManager.getInstance().game_menuobject_addgoalbtn;
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

	public static class Game_goal_BackBtn extends Game_Actor {
		/*
		 * @author Robert Precious <rp825@york.ac.uk>
		 * 
		 * This class holds the actor of the Back button. When clicked it finds the stagestart and the number of goalActors, finds them in the stage and hides them.
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
		 * 				Action- Closes the GoalScreen
		 */
		public Game_goal_BackBtn(){
			texture = Game_TextureManager.getInstance().game_shop_backbtn; 
			actorX = 1350;
			actorY = 880;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_goal_BackBtn)event.getTarget()).started = true;
					return true;
				}
			});

		}
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

	public static class Game_goal_Backdrop extends Game_Actor {
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
		public Game_goal_Backdrop(){
			texture = Game_TextureManager.getInstance().game_goals_backdrop; 
			actorX = -1 ;
			actorY = -35;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_goal_Backdrop)event.getTarget()).started = true;
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
				started = false;
			}
		}
	}

	public static class Game_goal_RemoveBtn extends Game_Actor {
		/*
		 * @author Robert Precious <rp825@york.ac.uk>
		 * 
		 * This button is replicated for all 3 "owned" goals
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
		 * 				Action- 
		 */

		public boolean started = false, undostart= false,undo;
		public int index, newgoalindex;
		public Game_goal_RemoveBtn(int index){
			this.index=index;
			this.actorX=250;
			this.actorY=470;
			this.undo = false;
			this.newgoalindex=0;
			this.texture=Game_TextureManager.getInstance().game_menuobject_removegoalbtn;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_goal_RemoveBtn)event.getTarget()).started = true;
					return true;
				}
			});
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_goal_RemoveBtn)event.getTarget()).undostart = true;
					return true;
				}
			});

		}

		public void act(float delta){
			if (undo){
				if(undostart){
					Game_goal_PlayerGoals.resetGoal(index);
					undostart=false;
					started=false;
				}
			}
			else
			{
				if(started){

					Game_goal_PlayerGoals.removeGoal(index);
					started = false;
					undostart = false;
				}
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
		public boolean getUndo(){
			return this.undo;
		}
		public void setUndo(boolean b){
			this.undo=b;
			if (undo){
				this.texture=Game_TextureManager.getInstance().game_menuobject_redobtn;
			}
		}
		public int getnewgoalindex(){
			return this.newgoalindex;
		}
		public void setnewgoalindex(int i){
			this.newgoalindex=i;
		}
		public void refreshBounds(){
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());

		}
		public void resetButtons(){
			this.undo=false;
			this.texture=Game_TextureManager.getInstance().game_menuobject_removegoalbtn;
		}


		public void setRedoBtn() {
			this.undo=true;
			this.texture=Game_TextureManager.getInstance().game_menuobject_redobtn;
		}

	}



}
