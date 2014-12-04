package com.TeamHEC.LocomotionCommotion.Game_Actors;


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

public class Game_resources_ToggleBtn extends Actor {

	Texture texture = Game_TextureManager.game_menuobject_menubtn; // reuse the new game back btn texture
	float actorX = 10 ,actorY = 30;
	public boolean started = false;

	public Game_resources_ToggleBtn(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((Game_resources_ToggleBtn)event.getTarget()).started = true;
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
		int expandedheight=180;
		if(started){
			if (Game_ResourcesManager.resourcebarexpanded== false)
			{	
			//Move up button, bar and quantities
				Game_ResourcesManager.game_resources_togglebtn.actorY+=expandedheight;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				Game_ResourcesManager.game_menuobject_resourcesbar.actorY+=expandedheight;
				Game_ResourcesManager.resourcesQuant.setY(Game_ResourcesManager.resourcesQuant.getY()+expandedheight);
				//move cards up
				Game_ResourcesManager.game_card_togglebtn.actorY+=expandedheight;
				Game_ResourcesManager.game_card_togglebtn.refreshBounds();
				Game_CardHandManager.organiseDeck();
				Game_CardHandManager.changeHeight(expandedheight);
				Game_CardHandManager.usecardbtn.setVisible(false);
				
				
				
				
				Game_ResourcesManager.resourcebarexpanded= true;
				for(int i=Game_ResourcesManager.stagestart; i<=Game_ResourcesManager.stagestart +Game_ResourcesManager.resourceActors-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(true);

				}			}
			else
			{	Game_ResourcesManager.resourcebarexpanded= false;
			Game_CardHandManager.usecardbtn.setVisible(false);
			//Move up
			Game_ResourcesManager.game_resources_togglebtn.actorY-=expandedheight;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			Game_ResourcesManager.game_menuobject_resourcesbar.actorY-=expandedheight;
			Game_ResourcesManager.resourcesQuant.setY(Game_ResourcesManager.resourcesQuant.getY()-expandedheight);
			
			Game_ResourcesManager.game_card_togglebtn.actorY-=expandedheight;
			Game_ResourcesManager.game_card_togglebtn.refreshBounds();
			Game_CardHandManager.selectedCard=0;
			Game_CardHandManager.changeHeight(-expandedheight);
			Game_CardHandManager.organiseDeck();
		//end
			for(int i=Game_ResourcesManager.stagestart; i<=Game_ResourcesManager.stagestart +Game_ResourcesManager.resourceActors-1;i++){
				if (i > GameScreen.getStage().getActors().size-1){

				}else
					GameScreen.getStage().getActors().get(i).setVisible(true);

			}

			}
			started = false;
		}
	}
}