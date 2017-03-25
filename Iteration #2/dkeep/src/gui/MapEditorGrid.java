package gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.border.EmptyBorder;

import logic.Character;
import logic.GameMap;
import logic.KeepMap;

public class MapEditorGrid extends Map {

	GameMap map;
	int size;



	MapEditorGrid(int width, int height,int  size) {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new GridLayout(size, size));
		this.setSize(width, height);
		this.setBackground(java.awt.Color.BLACK);
		this.setVisible(true);
		this.size =size;


		loadImages();

		map = new KeepMap(new char[size][size], 0);

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == 0 || i == size - 1 || j == 0 || j == size - 1)
					map.drawCharacter(new Character(new Point(j,i),'X'));

			}
		}

		super.update(map);

	}

	public void setNewChar(int x, int y, char c) {
		map.drawCharacter(new Character( new Point(x,y), c));
		
	}
	
	public void update(){
		super.update(map);
	}
	
	public boolean isValid(){
		return (checkHero() && checkKeys() && checkBorder());
		
		
	}

	// verifica que existe 1 e 1 só herói
	
	public boolean checkHero(){
		int hero_cnt=0;
		
		for(int i =0; i <size; i++)
			for(int j =0; j<size; j++)
				if(map.getChar(new Point(i,j))== 'H') hero_cnt++;
			
		
		if(hero_cnt ==1) return true;
		return false;
	}
	
	// verifica que existe pelo menos uma chave
	
	public boolean checkKeys(){
		
		for(int i =0; i <size; i++)
			for(int j =0; j <size; j++)
				if(map.getChar(new Point(i,j)) == 'k') return true;
		
		return false;
		
	}
	
	
	public int numberOfOgres(){
		
		int ogre_cnt=0;
		
		for(int i =0; i <size; i++)
			for(int j=0; j <size; j++)
				if(map.getChar(new Point(i,j)) == 'O') ogre_cnt++;
		
		return ogre_cnt;
	}
	
	// verificar a moldura de parede
	
	public boolean checkBorder() {
	
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (i == 0 || j == 0 || i == size - 1 || j == size - 1)
					if (map.getChar(new Point(i,j)) != 'X') return false;
						
		return true;
		
	}
	
	public boolean hasSquare(char[][] square) {
		
		for (int i = 0; i < size - square.length; i++)
			for (int j = 0; j < size - square.length; j++) {
				boolean match = true;
				for (int x = 0; x < square.length; x++)
					for (int y = 0; y < square.length; y++) {
						if (map.getChar(new Point(i+x,j+y)) != square[x][y])
							match = false;
					}
				if (match)
					return true;
			}		
		return false; 
	}
	
	
	public boolean checkExitReachable() {
		
		
		for(int i =0; i <size; i++)
			for(int j=0; j< size; j++){
				if(map.getChar(new Point(i,j)) == 'S'){
					char [][] m = deepClone(map.getMatrix());
					
					visit(m, i, j);
					
					for (int k = 0; k < m.length; k++)
						for (int l = 0; l < m.length; l++) {				
							if (m[k][l] != 'X' && m[k][l] != 'V') return false;
							
						}
					
				}
			}
		
		return true;
		

		
	}

	
	public void visit(char[][] m, int i, int j) {
		if (i < 0 || i >= m.length || j < 0 || j >= m.length)
			return;
		if (m[i][j] == 'X' || m[i][j] == 'V')
			return;
		m[i][j] = 'V';
		visit(m, i-1, j);
		visit(m, i+1, j);
		visit(m, i, j-1);
		visit(m, i, j+1);
	}


	public char[][] deepClone(char[][] m) {
		char[][] c = m.clone();
		for (int i = 0; i < m.length; i++)
			c[i] = m[i].clone();
		return c;
	}
	

}
