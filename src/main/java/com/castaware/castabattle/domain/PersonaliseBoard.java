package com.castaware.castabattle.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component
@ManagedBean
@SessionScoped
public class PersonaliseBoard implements Serializable{
	
	private int vertical;
	private int horizontal;
	private boolean fimSelecao = false;
	
	private boat unico = new boat();
	private cruiser unicoc = new cruiser();
	private destroyer unicod = new destroyer();
	
	public List vetor = new ArrayList();
	
	private static int boat = 1;
	private static int cruiser = 1;
	private static int destroyer = 1;
	
	private static PersonaliseBoard instance;
	
	public static PersonaliseBoard getInstance(){
		if(instance == null)
			instance = new PersonaliseBoard();
		boat = 1;
		cruiser = 1;
		destroyer = 1;
		instance.fimSelecao = false;
		System.out.println(instance);
		return instance;
	}
	
	public PersonaliseBoard(){
		vetor.add("1");
	}
	
	public void fire(String coluna,int linha)
	{
		fimSelecao = false;
		System.out.println("apareceu aqui");
		if (boat >= 1){
			
			vertical = translateColumn(coluna);
			horizontal = translateLine(linha);
			
			instance.unico.setBoat(horizontal, vertical);
			
			boat = boat - 1;
		}else{
			if (cruiser >= 1){
				
				vertical = translateColumn(coluna);
				horizontal = translateLine(linha);
				
				instance.unicoc.setCruiser(horizontal, vertical);
				
				cruiser = cruiser - 1;
			}else{
				if (destroyer >= 1){
					
					vertical = translateColumn(coluna);
					horizontal = translateLine(linha);
					
					instance.unicod.setDestroyer(horizontal, vertical);
					
					destroyer = destroyer - 1;
					fimSelecao = true;
				}else{
					
					throw new IllegalArgumentException("Insercao nao pode ultrapassar do limite");
				}
								
			}
		}
		
	}
	
	public boolean isFimSelecao() {
		return fimSelecao;
	}

	public void setFimSelecao(boolean fimSelecao) {
		this.fimSelecao = fimSelecao;
	}
	
	public static int getDestroyer() {
		return destroyer;
	}
		
	public cruiser getUnicoc() {
		return unicoc;
	}

	public destroyer getUnicod() {
		return unicod;
	}

	public boat getUnico() {
		return unico;
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
	
	
public class boat{
		
		private int coluna = 2;
		private int linha = 2;
		
		private boat instance;
		
		public boat getInstance(){
			if(instance == null)
				instance = new boat();
			
			return instance;
		}
		
		private boat(){
			
		}
		
		public int getColuna() {
			return coluna;
		}
		
		public int getLinha(){
			return linha;
		}

		public void setBoat(int linha, int coluna) {
			this.linha = linha;
			this.coluna = coluna;
		}
		
	}
	
public class cruiser{
		
		private int coluna = 1;
		private int linha = 1;
		
		private cruiser instance;
		
		public cruiser getInstance(){
			if(instance == null)
				instance = new cruiser();
			
			return instance;
		}
		
		private cruiser(){
			
		}
		
		public int getColuna() {
			return coluna;
		}
		
		public int getLinha(){
			return linha;
		}

		public void setCruiser(int linha, int coluna) {
			this.linha = linha;
			this.coluna = coluna;
			System.out.println(getColuna());
			System.out.println(getLinha());

		}
		
	}
public class destroyer{
	
	private int coluna = 0;
	private int linha = 0;
	private destroyer instance;
	
	public destroyer getInstance(){
		if(instance == null)
			instance = new destroyer();
		
		return instance;
	}
	
	private destroyer(){
		
	}
	
	public int getColuna() {
		return coluna;
	}
	
	public int getLinha(){
		return linha;
	}

	public void setDestroyer(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
}



	
}
