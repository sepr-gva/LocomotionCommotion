package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Train.SpeedUpgrade;
import com.TeamHEC.LocomotionCommotion.Train.Train;

public class GoFasterStripesCard extends Card {

	private static final long serialVersionUID = 1L;

	public GoFasterStripesCard(Player player)
	{
		super(player, Game_TextureManager.getInstance().game_card_gofasterstripescard);
	}
	
	@Override
	public void implementCard()
	{
		Train train = getOwner().trains.get(0);
		SpeedUpgrade speedUpgrade = new SpeedUpgrade(train);
		train.addUpgrade(speedUpgrade);
	}
}