package com.castaware.castabattle.domain;

import java.util.Arrays;

import com.castaware.castabattle.control.PersonaliseBoard;
import com.castaware.castabattle.control.PersonaliseBoard.boat;
import com.castaware.castabattle.control.PersonaliseBoard.cruiser;
import com.castaware.castabattle.control.PersonaliseBoard.destroyer;


public class Board 
{
	//
	// Atributos
	//
	private static int SIZE = 10;
	private CellType[][] boardGame = new CellType[SIZE][SIZE];
	private CellType[][] boardTemplate = new CellType[SIZE][SIZE];
	private PersonaliseBoard boardPerHumano = new PersonaliseBoard();
	
	private MenssageGame menssageGame;
	private String message;
	
	//
	// Construtor
	//
	public Board()
	{
		
	}
	
	public Board(CellType[][] boardTemplate)
	{
		this.boardTemplate=boardTemplate;
	}

	//
	// Neg�cio
	//
	public CellType fire(String column,int line)
	{
		CellType target = readCellInTemplate(column, line);
		
		// Se atingiu alguma embarca��o, marca com fogo
		if (target.isShip())
		{
			writeCellInGame(column, line, CellType.FIRE);
			writeCellInTemplate(column, line, CellType.FIRE);
			message = "Navio Atingido com sucesso!!";
			menssageGame = new MenssageGame();
			menssageGame.saveMessage(message);
		}
		else if (target.isWater())
		{
			writeCellInGame(column, line, CellType.WATER);
		}
		
		return target;
	}
	
	public boolean hasShip()
	{
		for (int i=0;i<SIZE;i++)
		{
			for (int j=0;j<SIZE;j++)
			{
				if(boardTemplate[i][j].isShip())
					return true;
			}
		}
		
		return false;
	}
	
	public CellType readCellInTemplate(String column,int line)
	{
		int x = translateColumn(column);
		int y = translateLine(line);
		
		CellType target = boardTemplate[y][x];
		
		return target;
	}
	
	public CellType readCellInGame(String column,int line)
	{
		int x = translateColumn(column);
		int y = translateLine(line);
		
		CellType target = boardGame[y][x];
		
		return target;
	}
	
	public void writeCellInTemplate(String column,int line,CellType cellType)
	{
		int x = translateColumn(column);
		int y = translateLine(line);
		
		boardTemplate[y][x] = cellType;		
	}
	
	public void writeCellInGame(String column,int line,CellType cellType)
	{
		int x = translateColumn(column);
		int y = translateLine(line);
		
		boardGame[y][x] = cellType;		
	}
			
	public void clearBoard()
	{
		for (int i=0;i<SIZE;i++)
		{
			for (int j=0;j<SIZE;j++)
			{
				boardGame[i][j] = CellType.HIDDEN;
				boardTemplate[i][j] = CellType.WATER;
			}
		}
	}
	
	public void initBoard(CellType[][] newBoard)
	{
		if (newBoard.length<10 || newBoard[0].length <10)
			throw new IllegalArgumentException("O tabuleiro deve medir 10x10");		
		
		clearBoard();
		this.boardTemplate = newBoard;
	}
	
	public void initPersonaliseBoard(){
		clearBoard();
		
		
		boat primeiro = boardPerHumano.getUnico();
		cruiser segundo = boardPerHumano.getUnicoc();
		destroyer terceiro = boardPerHumano.getUnicod();

		
		boardTemplate[primeiro.getLinha()][primeiro.getColuna()] = CellType.BOAT;
		boardTemplate[segundo.getLinha()][segundo.getColuna()] = CellType.CRUISER;
		boardTemplate[terceiro.getLinha()][terceiro.getColuna()] = CellType.DESTROYER;


		
	}
	
	public void initRandomBoard()
	{
		// TODO - Implementar rotinas para popula��o aleat�ria do board
		clearBoard();
		
		boardTemplate[0][0] = CellType.BOAT;
		
		/*
		// 2 boats
		boardTemplate[3][7] = CellType.BOAT;
		boardTemplate[5][2] = CellType.BOAT;
		// 1 cruiser
		boardTemplate[9][2] = CellType.CRUISER;
		boardTemplate[9][3] = CellType.CRUISER;
		// 1 destroyer
		boardTemplate[1][4] = CellType.DESTROYER;
		boardTemplate[2][4] = CellType.DESTROYER;
		boardTemplate[3][4] = CellType.DESTROYER;	*/
	}
	
	//
	// Acesso (getters/setters)
	// 
	public CellType[][] getBoardGame() {
		return boardGame;
	}
	
	public CellType[][] getBoardTemplate() {
		return boardTemplate;
	}
	
	private int translateLine(int line) 
	{
		int y = line-1;
		return y;
	}

	private int translateColumn(String column) 
	{
		// Isto talvez funcione...
		// int x = ((int)column.toUpperCase().toCharArray()[0])-64;
		
		int x;
		
		if(column.equals("A"))
			x = 0;
		else if(column.equals("B"))
			x = 1;
		else if(column.equals("C"))
			x = 2;
		else if(column.equals("D"))
			x = 3;
		else if(column.equals("E"))
			x = 4;
		else if(column.equals("F"))
			x = 5;
		else if(column.equals("G"))
			x = 6;
		else if(column.equals("H"))
			x = 7;
		else if(column.equals("I"))
			x = 8;
		else if(column.equals("J"))
			x = 9;
		else
			throw new IllegalArgumentException("Invalid column: "+column);
		return x;
	}
	
	@Override
	public String toString()
	{
		String result =   "BOARD\n";
		result = result + "=====\n";
		
		for(int i=0;i<10;i++)
		{
			result = result + Arrays.toString(boardGame[i]) + "\n";
		}
		
		return result;
	}	
}



