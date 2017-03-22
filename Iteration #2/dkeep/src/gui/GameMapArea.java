package gui;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Image;



import com.sun.prism.paint.Color;

public class GameMapArea extends JPanel {

	private ImageIcon wall;
	
	public GameMapArea(int width, int height) {
		super();
		
		setBackground(java.awt.Color.BLACK);
		this.setSize(width, height);
		this.setLayout(new GridLayout(10, 10));
		
		wall = new ImageIcon(this.getClass().getResource("res/wall.png"));
	
		ImageIcon scaled_wall= scaleImage(wall);
		
			for (int i = 0; i < GameWindow.getMap().getRows(); i++)
				
				//for (int j = 0; j <GameWindow.getMap().getCols(); j++)
					this.add(new JLabel(scaled_wall));
			
			repaint();	
		
		 }
	
	
	private ImageIcon scaleImage(ImageIcon im) {
		
		Image img = im.getImage();
		Image newimg = img.getScaledInstance(this.getWidth()/10,this.getHeight()/10, Image.SCALE_FAST);
		
		return new ImageIcon(newimg);
	}
	

	

}