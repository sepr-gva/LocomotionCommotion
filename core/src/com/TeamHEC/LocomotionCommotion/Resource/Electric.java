package com.TeamHEC.LocomotionCommotion.Resource;

public class Electric extends Fuel{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Electric(int value)
	{
		super(value, "Electric");
		cost = 100;
	}
}
