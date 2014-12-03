package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_CardHandManager {

	private final static Array<Actor> actors = new Array<Actor>();
	
		
	public static boolean open=false;
	
	public static int  stagestart, cardActors, height=-100;


	public Game_CardHandManager(){	}
		
	public void create(Stage stage){
		
		actors.clear();
		stagestart =0;
		cardActors=0;
		
		//Card 1
		class Card extends Actor {
			boolean started = false;
			private boolean expanded =false;
			private Texture texture;
			private float actorX;
			private float actorY;
			public Card(Texture texture, int actorX, int actorY){
				 this.texture = texture; 
				 this.actorX = actorX;
				 this.actorY = actorY;
				
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				addListener(new InputListener(){
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						((Card)event.getTarget()).started = true;
						return true;
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
					if (isExpanded()){
						this.actorY-=200;
						setexpanded(false);
						setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
					}
					else{
						this.actorY+=200;
						setexpanded(true);
						setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
					}
					started = false;
				}
			}


			public boolean isExpanded() {
				return expanded;
			}


			public boolean setexpanded(boolean open) {
				this.expanded = open;
				return open;
			}
		}	
		int x= 1130;
		int heightY = height;
		Card card1= new Card(Game_TextureManager.game_card_oilcard, x, heightY);
		actors.add(card1);
		Card card2= new Card(Game_TextureManager.game_card_oilcard, (x=x-130), heightY);
		actors.add(card2);
		Card card3= new Card(Game_TextureManager.game_card_oilcard, (x=x-130), heightY);
		actors.add(card3);
		Card card4= new Card(Game_TextureManager.game_card_oilcard, (x=x-130), heightY);
		actors.add(card4);
		Card card5= new Card(Game_TextureManager.game_card_oilcard, (x=x-130), heightY);
		actors.add(card5);
		Card card6= new Card(Game_TextureManager.game_card_oilcard, (x=x-130), heightY);
		actors.add(card6);
		Card card7= new Card(Game_TextureManager.game_card_oilcard, (x=x-130), heightY);
		actors.add(card7);
	

		
		
		
		stagestart= stage.getActors().size;
		for (Actor a : actors){
			if(open == true){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);}
			else
				a.setVisible(false);

			stage.addActor(a);
			cardActors ++;
		}
		
	

	}
	
	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */
	

	
	


}

