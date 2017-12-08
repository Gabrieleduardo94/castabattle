package com.castaware.castabattle.domain;

public enum CellType 
{
	WATER(false),
	BOAT(true),
	CRUISER(true),
	DESTROYER(true),
	SUBMARINE(true),
	BATTLESHIP(true),
	FIRE(false),
	HIDDEN(false);
	
	private boolean ship;
	
	private CellType(boolean ship)
	{
		this.ship = ship;		
	}
	
	public boolean isShip()
	{
		return ship;
	}
	
	public boolean isWater() 
	{
		return this==WATER;
	}
	
	public boolean isBoat() 
	{
		return this==BOAT;
	}
	
	public boolean isCruiser() 
	{
		return this==CRUISER;
	}
	
	public boolean isDestroyer() 
	{
		return this==DESTROYER;
	}
}