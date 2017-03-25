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

	CustomMapGrid(int width, int height,int  cols, int rows, int ogres) {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new GridLayout(cols, rows));
		this.setSize(width, height);
		setBackground(java.awt.Color.BLACK);
		this.setLayout(new GridLayout(rows, cols));
		this.setVisible(true);

		loadImages();

		map = new KeepMap(new char[rows][cols], ogres);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1)
					map.drawCharacter(new Character(new Point(j,i),'X'));

			}
		}

		super.update(map);

	}

}
