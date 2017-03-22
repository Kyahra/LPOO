package gui;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.prism.paint.Color;

public class GameMapArea extends JPanel {

	private ImageIcon grass;
	
	public GameMapArea() {
		super();
		
//		int rows = 	GameWindow.getMap().getRows();
//		int cols = 	GameWindow.getMap().getCols();
		
	
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new GridLayout(10, 10));
		this.setBackground(java.awt.Color.LIGHT_GRAY);
		
		grass = new ImageIcon(this.getClass().getResource("Resources/grass.png"));
		
		add(new JLabel(grass));
		
		 }

}