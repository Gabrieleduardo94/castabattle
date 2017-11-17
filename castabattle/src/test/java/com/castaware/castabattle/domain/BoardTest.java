package com.castaware.castabattle.domain;

import static com.castaware.castabattle.domain.CellType.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest 
{
	private Board board;
	
	@Before
	public void setUpBoard()
	{
		CellType[][] cellboard = new CellType[][] { {WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER},   
													{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER},	
													{WATER, WATER,   BOAT ,   WATER,   WATER,   WATER, WATER, WATER, WATER},		                                      
													{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER},		
													{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER},		
													{WATER, WATER,   WATER,   WATER,   WATER,   WATER, BOAT , WATER, WATER},		
													{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER},		
													{WATER, CRUISER, CRUISER, CRUISER, CRUISER, WATER, WATER, WATER, WATER},		
													{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER},		
													{FIRE,  WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER} };	
	
		board = new Board(cellboard);
	}
	
	@Test
	public void testFireInWater()
	{
		CellType target = board.fire("A", 1);
		Assert.assertEquals(target,WATER);
		
		CellType targetAfter = board.readCellInTemplate("A", 1);
		Assert.assertEquals(targetAfter,WATER);
	}
	
	@Test
	public void testFireInFire()
	{
		CellType target = board.fire("A", 10);
		Assert.assertEquals(target,FIRE);
		
		CellType targetAfter = board.readCellInTemplate("A", 10);
		Assert.assertEquals(targetAfter,FIRE);
	}
	
	@Test
	public void testFireInShip()
	{
		CellType target = board.fire("B", 8);
		Assert.assertEquals(target,CRUISER);
		
		CellType targetAfter = board.readCellInTemplate("B", 8);
		Assert.assertEquals(targetAfter,FIRE);
	}
}









