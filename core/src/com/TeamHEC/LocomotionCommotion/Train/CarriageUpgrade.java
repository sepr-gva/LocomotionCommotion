package com.TeamHEC.LocomotionCommotion.Train;

public class CarriageUpgrade extends TrainUpgrade{
	
	public CarriageUpgrade(Train train)
	{
		super(train, 200);
	}
	
	@Override
	public void addUpgrade()
	{
		train.increaseCarriageLimit(1);
	}
	
	@Override
	public void undoUpgrade()
	{
		train.increaseCarriageLimit(-1);
	}
}
