package com.castaware.castabattle.domain;

public abstract class ComputerPlayer 
{
	protected Board boardHumano;
	
	public ComputerPlayer(Board boardHumano)
	{
		this.boardHumano=boardHumano;
	}
	
	public abstract void playTurn();
}
