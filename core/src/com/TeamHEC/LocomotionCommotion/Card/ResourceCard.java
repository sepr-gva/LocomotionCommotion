package com.TeamHEC.LocomotionCommotion.Card;

import java.util.Random;

import com.TeamHEC.LocomotionCommotion.Game_Actors.GameScreen_ActorManager;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Player.Shop;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.badlogic.gdx.graphics.Texture;

/**
 * 
 * @author Callum Hewitt <ch1194@york.ac.uk>
 *
 */
public abstract class ResourceCard extends Card {

	private static final long serialVersionUID = 1L;
	private String fuelType;

	public ResourceCard(Player owner, Texture cardTexture, String fuelType)
	{
			super(owner, cardTexture, fuelType);			
			this.fuelType = fuelType;
	}
	
	@Override
	public void implementCard()
	{
		Random random = new Random();
		int fuelToAdd = ((Shop.cardPrice/2) + random.nextInt(Shop.cardPrice)) / getFuelPrice();
		getOwner().addFuel(fuelType, fuelToAdd);
		GameScreen.oil+= fuelToAdd;
		GameScreen_ActorManager.refreshResources();
		// Need to destroy card instance here or something
	}
	
	private int getFuelPrice()
	{
		if(fuelType == "Coal")
			return Shop.coalPrice;	
		if(fuelType == "Oil")
			return Shop.oilPrice;		
		if(fuelType == "Electric")
			return Shop.electricPrice;			
		if(fuelType == "Nuclear")
			return Shop.nuclearPrice;	
		return 0;
	}

}