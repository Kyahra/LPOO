package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public EndPanel() {

		super();
		setBackground(Color.BLACK);
		ImageIcon init = new ImageIcon(this.getClass().getResource("res/thumbsDown2.png"));
		JLabel label = new JLabel(init);
		this.add(label);
				
	}
	
	public void setWinImage(){
		
		ImageIcon init = new ImageIcon(this.getClass().getResource("res/thumbsUp3.png"));
		JLabel label = new JLabel(init);
		this.add(label);
	}

}
