package com.castaware.castabattle.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

import com.castaware.castabattle.domain.Board;
import com.castaware.castabattle.domain.CellType;
import com.castaware.castabattle.domain.ComputerPlayer;
import com.castaware.castabattle.domain.ComputerPlayerDummyImpl;
import com.castaware.castabattle.domain.MenssageGame;

@Component
@ManagedBean
@SessionScoped
public class GameBean extends _Bean
{   
	//
	// Atributos com Binding
	//
	private boolean endGame;
	private boolean endGameH;
	private boolean endGameC;
	private boolean soundFire;
	private boolean soundBack;
	
	private Board boardHumano;
	private Board boardComputador;
	
	private List<List<Object>> tableHumano;
	private List<List<Object>> tableComputador;		
	
	private ComputerPlayer cpuPlayer;

	
	public GameBean()
	{
		reset();
	}
	
	//
	// Operações de Tela
	//
	public void reset()
	{
		// Cria os tabuleiros
		endGame = false;
		endGameH = false;
		endGameC = false;
		soundFire = false;
		soundBack = false;
		
		boardComputador = new Board();
		boardComputador.initRandomBoard();
		
		boardHumano = new Board();
		boardHumano.initPersonaliseBoard();
		
		tableHumano = new ArrayList<List<Object>>();
		tableComputador = new ArrayList<List<Object>>();
		
		boardToTable(boardHumano,tableHumano);
		boardToTable(boardComputador,tableComputador);
		
		cpuPlayer = new ComputerPlayerDummyImpl(boardHumano);
	}
	

	public void fire(String coluna,int linha)
	{
		
		soundFire = true;
		
		// Jogada do ser humano
		boardComputador.fire(coluna, linha);

		// Jogada do computador
		cpuPlayer.playTurn();
		
		tableHumano = new ArrayList<List<Object>>();
		tableComputador = new ArrayList<List<Object>>();
		
		boardToTable(boardHumano,tableHumano);
		boardToTable(boardComputador,tableComputador);	
		
		if (!boardComputador.hasShip())
		{
			endGame = true;
			endGameH = true;
		}
		else if (!boardHumano.hasShip())
		{
			endGame = true;
			endGameC = true;
		}
		
		
		
	}
	
	private void boardToTable(Board board, List<List<Object>> table) 
	{
		// Cria o cabeçalho
		List<Object> firstRow = Arrays.asList(new String[]{null,"A","B","C","D","E","F","G","H","I","J"});
		table.add(firstRow);
		
		CellType[][] cells = board.getBoardGame();
		
		for (int rowIndex=0;rowIndex < cells.length;rowIndex++) 
		{
			List<Object> row = new ArrayList<Object>();
			
			row.add(rowIndex+1);
			
			for (int columnIndex=0;columnIndex < cells[rowIndex].length ; columnIndex++)
			{
				row.add(cells[rowIndex][columnIndex]);
			}
			
			table.add(row);
		}
	}

	//
	// Métodos de Acesso
	//		
	public List<List<Object>> getTableHumano() {
		return tableHumano;
	}

	public void setTableHumano(List<List<Object>> tableHumano) {
		this.tableHumano = tableHumano;
	}

	public List<List<Object>> getTableComputador() {
		return tableComputador;
	}

	public void setTableComputador(List<List<Object>> tableComputador) {
		this.tableComputador = tableComputador;
	}

	public boolean isEndGameH() {
		return endGameH;
	}

	public void setEndGameH(boolean endGameH) {
		this.endGameH = endGameH;
	}

	public boolean isEndGameC() {
		return endGameC;
	}

	public void setEndGameC(boolean endGameC) {
		this.endGameC = endGameC;
	}

	public boolean isEndGame() {
		return endGame;
	}

	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}
	
	public boolean isSoundFire() {
		return soundFire;
	}
	
	public boolean isSoundBack() {
		return soundBack;
	}

	public void setSoundBack(boolean soundBack) {
		this.soundBack = soundBack;
	}
}  













