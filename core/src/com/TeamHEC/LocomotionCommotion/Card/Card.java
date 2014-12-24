package com.TeamHEC.LocomotionCommotion.Card;

import java.io.Serializable;

import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.badlogic.gdx.graphics.Texture;

/**
 * 
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 *
 */

public class Card implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final String cardName;
	private final String cardDescription;
	private final int cardValue;
	private Player owner;
	private Texture cardImage;
	
	// If created in the shop, the player can be initialised to null:
	public Card(String name, String description, int value, Player player, Texture image)
	{
		cardName = name;
		cardDescription = description;
		owner = player;
		cardValue = value;
		cardImage = image; // this for implementing the card
	}
		
	public Player getOwner()
	{
		return owner;
	}
	
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}
	
	// For the shop:
	public String getName()
	{
		return cardName;
	}
	
	public String getDescription()
	{
		return cardDescription;
	}
	
	public int getValue()
	{
		return cardValue;
	}
	
	public Texture getImage(){
		return cardImage;
	}

	public void implementCard(){}
	
	public void sellCard()
	{
		getOwner().addGold(cardValue);
		getOwner().getCards().remove(this);
		setOwner(null);
		
		// Something else to dispose of the card
	}
}