package gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Character;
import logic.GameMap;
import logic.KeepMap;

public class CustomMapGrid extends Map {

	GameMap map;

	CustomMapGrid(int width, int height,int  size, int ogres) {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new GridLayout(size, size));
		this.setSize(width, height);
		setBackground(java.awt.Color.BLACK);
		this.setLayout(new GridLayout(size, size));
		this.setVisible(true);

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

	public void insertNewChar(int x, int y, char c) {
		map.drawCharacter(new Character(new Point(x,y),c));
		
	}
	
	public void update(){
		super.update(map);
	}



}
