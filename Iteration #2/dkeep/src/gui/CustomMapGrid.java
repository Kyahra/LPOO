package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CustomMapGrid extends Map{
	
	CustomMapGrid(int cols, int rows) {
		super();
	
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new GridLayout(cols, rows));
		loadImages();

	
	
	for(int i = 0; i < cols; i++)
		for(int j =0; j < rows; j++){
			
		}
	
}

}
