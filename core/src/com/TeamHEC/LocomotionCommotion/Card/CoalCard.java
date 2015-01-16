package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;

/** * 
 * @author  Callum Hewitt <ch1194@york.ac.uk> * 
 *
 */

public class CoalCard extends Card{

	private static final long serialVersionUID = 1L;

	public CoalCard(Player player)
	{
		super(player, Game_TextureManager.getInstance().game_card_coalcard);
	}
	
	@Override
	public void implementCard()
	{
		getOwner().addFuel("Coal", 100);
		GameScreen.coal += 100;
		// Need to destroy card instance here or something
	}
}