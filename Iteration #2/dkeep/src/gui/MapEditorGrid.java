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
	int ogres;


	MapEditorGrid(int width, int height,int  size, int ogres) {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new GridLayout(size, size));
		this.setSize(width, height);
		this.setBackground(java.awt.Color.BLACK);
		this.setVisible(true);
		this.size =size;
		this.ogres = ogres;

		loadImages();

		map = new KeepMap(new char[size][size], ogres);

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
		//return (checkHero() && checkKeys() && checkExit() && check);
		return false;
		
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
	
	
	
	
	

}
