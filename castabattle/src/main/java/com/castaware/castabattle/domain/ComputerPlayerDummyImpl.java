package com.castaware.castabattle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerPlayerDummyImpl extends ComputerPlayer 
{
	private String[] colunas = new String[]{"A","B","C","D","E","F","G","H","I","J"};
	private List<Jogada> jogadasComputador;
	
	public ComputerPlayerDummyImpl(Board boardHumano) 
	{
		super(boardHumano);
		
		// Cria as jogadas do computador
		jogadasComputador = new ArrayList<Jogada>();
		
		for (int i=1;i<=10;i++)
		{
			for (String coluna : colunas) 
			{
				jogadasComputador.add(new Jogada(i,coluna));
			}
		}
		
		Collections.shuffle(jogadasComputador);
	}

	@Override
	public void playTurn() 
	{
		Jogada jogada = jogadasComputador.remove(0);
		boardHumano.fire(jogada.coluna, jogada.linha);		
	}
}

class Jogada
{
	int	   linha;
	String coluna;
	
	public Jogada(int linha,String coluna) 
	{
		this.linha = linha;
		this.coluna = coluna;
	}		
}
