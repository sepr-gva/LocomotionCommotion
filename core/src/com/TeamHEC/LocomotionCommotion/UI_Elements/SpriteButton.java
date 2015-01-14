package com.TeamHEC.LocomotionCommotion.UI_Elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class SpriteButton extends Sprite{

	public SpriteButton(float x, float y, Texture texture)
	{
		super(x, y, texture);
		setBounds(x, y, texture.getWidth(), texture.getHeight());
		
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((SpriteButton)event.getTarget()).onClicked();
				return true;
			}
		});
	}
	
	protected void onClicked()
	{
		// Overwrite me
	}
}
