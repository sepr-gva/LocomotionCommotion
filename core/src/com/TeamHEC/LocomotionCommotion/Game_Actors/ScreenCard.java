package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

class ScreenCard extends Actor {
	boolean started = false;
	private boolean expanded =false;
	private Texture texture;
	private float actorX;
	private float actorY;
	private boolean empty;
	public ScreenCard(Texture texture, int actorX, int actorY, boolean empty){
		this.empty= empty;
		this.texture = texture; 
		this.actorX = actorX;
		this.actorY = actorY;

		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((ScreenCard)event.getTarget()).started = true;
				return true;
			}
		});
		
	}


	@Override
	public void draw(Batch batch, float alpha){
			batch.draw(this.texture,actorX,actorY);
			if (empty)
				this.setVisible(false);
				
	}

	@Override
	public void act(float delta){
		if(started){
			if (isExpanded()){
				this.cardCollapse();
			}
			else{
				this.cardExpand();
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
	public void setActorY(float y){
		this.actorY=y;
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());				
	}
	public void cardExpand(){
		Game_CardHandManager.selectedCard=this;
		Game_CardHandManager.organiseDeck();
		this.actorY+=200;
		setexpanded(true);
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());

	}
	public void cardCollapse(){
		if (expanded){
			if (Game_ResourcesManager.resourcebarexpanded)
				this.actorY=80;
			else
				this.actorY=-100;
			setexpanded(false);
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			Game_CardHandManager.selectedCard=null;
			Game_CardHandManager.organiseDeck();
			}
		else
		{if (Game_ResourcesManager.resourcebarexpanded)
			this.actorY=80;
		else
			this.actorY=-100;}
			
	}
}