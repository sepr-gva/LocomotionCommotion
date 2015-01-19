package com.TeamHEC.LocomotionCommotion.Card;

import java.io.Serializable;

import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.badlogic.gdx.graphics.Texture;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public abstract class Card implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Player owner;
	private Texture cardImage;
	private String name;
	
	// The player can be initialised to null if necessary:
	public Card(Player player, Texture image, String name)
	{		
		owner = player;	
		cardImage = image;
		this.name = name;
	}
		
	public Player getOwner()
	{
		return owner;
	}
	
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}	
	
	public Texture getImage(){
		return cardImage;
	}
	
	public String getName(){
		return name;
	}

	public void implementCard(){}
	
}