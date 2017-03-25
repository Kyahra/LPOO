package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Character;
import logic.GameMap;
import logic.KeepMap;

public class CustomMapGrid extends Map{
	
	GameMap map;
	
	CustomMapGrid(int cols, int rows, int ogres) {
	
	
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new GridLayout(cols, rows));
		
		setBackground(java.awt.Color.BLACK);
		this.setLayout(new GridLayout(rows, cols));
		this.setVisible(true);

		loadImages();
	
		map = new KeepMap(new char[rows][cols], ogres);
		
		for(int i =0; i <rows; i++){
			for(int j =0; j<cols; j++){
				if(i==0 || i == rows-1 || j ==0 || j ==i-1)
					map.drawCharacter(new Character('X'));
					
			}
		}
		
		super.update(map);
		
		
}

}
