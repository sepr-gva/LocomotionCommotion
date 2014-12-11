package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.Card.Card;
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
	private int slot;
	private Card card;
	
	public ScreenCard(Texture texture, int actorX, int actorY, boolean empty, int slot){
		this.slot = slot;
		this.empty= empty;
		this.texture = texture; 
		this.actorX = actorX;
		this.actorY = actorY;

		setBounds(this.actorX,this.actorY,this.texture.getWidth(),this.texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((ScreenCard)event.getTarget()).started = true;
				return true;
			}
		});
		
		//UNCOMMENT THIS TO ALLOW MOUSE OVER (VERY BUGGY)
//		addListener(new InputListener(){
//			public void enter(InputEvent event, float x, float y, int pointer, Actor ScreenCard) {
//				((ScreenCard)event.getTarget()).started = true;
//			}
//		
//		});
//		addListener(new InputListener(){
//			public void exit(InputEvent event, float x, float y, int pointer, Actor ScreenCard) {
//				((ScreenCard)event.getTarget()).started = true;
//			}
//		
//		});
		
	}


	@Override
	public void draw(Batch batch, float alpha){
			if (empty)
				this.setVisible(false);
			else
				batch.draw(this.texture,actorX,actorY);
				
	}

	@Override
	public void act(float delta){
		if(started){
			if (isExpanded()){
				this.cardCollapse();
				Game_CardHandManager.usecardbtn.setVisible(false);
				Game_CardHandManager.selectedCard=0;
				
			}
			else{
				Game_CardHandManager.selectedCard=this.getSlot();
				Game_CardHandManager.usecardbtn.setVisible(true);
				Game_card_UseCardBtn.actorX=this.actorX+40;
				Game_card_UseCardBtn.actorY=this.actorY+550;
				this.cardExpand();
				
			}
			setBounds(this.actorX,this.actorY,this.texture.getWidth(),this.texture.getHeight());
			Game_CardHandManager.usecardbtn.refreshBounds();
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
	
	public void setCard(Card card){
		this.card = card;
	}
	public Card getCard(){
		return this.card;
	}
	public void setTexture(Texture texture){
		this.texture = texture;
	}
	public Texture getTexture(){
		return texture;
	}
	
	public int getSlot(){
		return this.slot;
	}
	public void setActorY(float y){
		this.actorY=y;
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());				
	}
	
	public void cardExpand(){
		Game_CardHandManager.organiseDeck();
		this.actorY+=200;
		setexpanded(true);
		setBounds(this.actorX,this.actorY,this.texture.getWidth(),this.texture.getHeight());
	}
	
	public void cardCollapse(){
		if (expanded){
			if (Game_ResourcesManager.resourcebarexpanded)
				this.actorY=80;
			else
				this.actorY=-100;
			setexpanded(false);
			setBounds(this.actorX,this.actorY,this.texture.getWidth(),this.texture.getHeight());
			Game_CardHandManager.organiseDeck();
			}
		else
		{if (Game_ResourcesManager.resourcebarexpanded)
			this.actorY=80;
		else
			this.actorY=-100;}
			
	}


	public void setEmpty(boolean b) {
		this.empty=b;
	}


	public void setSlot(int slot) {
		this.slot= slot;
	}
}