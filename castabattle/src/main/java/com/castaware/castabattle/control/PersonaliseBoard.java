package com.castaware.castabattle.control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component
@ManagedBean
@SessionScoped
public class PersonaliseBoard {
	
	private int vertical;
	private int horizontal;
	
	private boat unico = new boat();
	private cruiser unicoc = new cruiser();
	private destroyer unicod = new destroyer();
	
	private static int boat = 1;
	private static int cruiser = 1;
	private static int destroyer = 1;
	
	public PersonaliseBoard(){
		
	}

	public void fire(String coluna,int linha)
	{
		
		if (boat >= 1){
			
			vertical = translateColumn(coluna);
			horizontal = translateLine(linha);
			
			unico.setBoat(horizontal, vertical);
			
			boat = boat - 1;
		}else{
			if (cruiser >= 1){
				
				vertical = translateColumn(coluna);
				horizontal = translateLine(linha);
				
				unicoc.setCruiser(horizontal, vertical);
				
				cruiser = cruiser - 1;
			}else{
				
				vertical = translateColumn(coluna);
				horizontal = translateLine(linha);
				
				unicod.setDestroyer(horizontal, vertical);
				
				destroyer = destroyer - 1;
			}
		}
		
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
		
		public int getColuna() {
			return coluna;
		}
		
		public int getLinha(){
			return linha;
		}

		public void setCruiser(int linha, int coluna) {
			this.linha = linha;
			this.coluna = coluna;
		}
		
	}
public class destroyer{
	
	private int coluna = 0;
	private int linha = 0;
	
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
