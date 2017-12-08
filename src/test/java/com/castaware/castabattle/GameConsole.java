package com.castaware.castabattle;

import static com.castaware.castabattle.domain.CellType.BOAT;
import static com.castaware.castabattle.domain.CellType.CRUISER;
import static com.castaware.castabattle.domain.CellType.FIRE;
import static com.castaware.castabattle.domain.CellType.WATER;

import java.util.Scanner;

import com.castaware.castabattle.domain.Board;
import com.castaware.castabattle.domain.CellType;

public class GameConsole 
{
	public static void main(String[] args)
	{
		CellType[][] cellboard = new CellType[][] { {WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},   
													{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},	
													{WATER, WATER,   BOAT ,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},		                                      
													{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},		
													{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},		
													{WATER, WATER,   WATER,   WATER,   WATER,   WATER, BOAT , WATER, WATER, WATER},		
													{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},		
													{WATER, CRUISER, CRUISER, CRUISER, CRUISER, WATER, WATER, WATER, WATER, WATER},		
													{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},		
													{FIRE,  WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER} };	
																											
		// Inicializa��o do tabuleiro											
		Board board = new Board();
		board.initBoard(cellboard);

		// Leitura Teclado
		Scanner sc = new Scanner(System.in);
		
		// Processamento do jogo
		while(board.hasShip())
		{
			System.out.println(board+"/n");
			System.out.println("Line: ");
			int line = sc.nextInt();
			sc.nextLine(); // Gasta o buffer de leitura... Arf.
			System.out.println("Column: ");
			String column = sc.nextLine().toUpperCase();
			
			CellType target = board.fire(column, line);
			
			if (target.isShip())
				System.out.println("FOGO!");
			else
				System.out.println("�GUA!");
			
			System.out.println();
		}
		
		// Fim do Jogo
		System.out.println("Frota Destru�da, Uau - GAME OVER!");
	}
}


















