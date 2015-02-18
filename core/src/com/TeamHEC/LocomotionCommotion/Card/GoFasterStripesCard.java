package com.TeamHEC.LocomotionCommotion.Card;

import com.TeamHEC.LocomotionCommotion.MapActors.Game_Map_Manager;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Game_TextureManager;
import com.TeamHEC.LocomotionCommotion.UI_Elements.WarningMessage;

public class GoFasterStripesCard extends Card {

	public GoFasterStripesCard(Player player)
	{
		super(player, Game_TextureManager.getInstance().game_card_gofasterstripescard, "GoFasterStripes");
	}
	
	@Override
	public void implementCard()
	{
		
		Game_Map_Manager.goFaster = true;
		WarningMessage.fireWarningWindow("GO FASTER STRIPES", "Choose the train that you want to give go faster stripes.");
		//Need a way to select the train to upgrade
		//Train train = getOwner().getTrains().get(0);
		//SpeedUpgrade speedUpgrade = new SpeedUpgrade(train);
		//train.addUpgrade(speedUpgrade);
	}
}