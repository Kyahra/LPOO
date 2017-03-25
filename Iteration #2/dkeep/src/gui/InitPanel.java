package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InitPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public InitPanel() {

		
		super();
		setBackground(Color.BLACK);
		ImageIcon init = new ImageIcon(this.getClass().getResource("res/keep.png"));
		JLabel label = new JLabel(init);
		this.add(label);
		
	}

}
