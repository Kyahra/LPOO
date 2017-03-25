package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class EndPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EndPanel() {

		JPanel endPanel = new JPanel();	
		endPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		endPanel.setBackground(Color.BLACK);
		ImageIcon end = new ImageIcon(this.getClass().getResource("res/speedLimit.png"));
		JLabel label = new JLabel(end);
		label.setBackground(Color.BLACK);
		endPanel.add(label);
		endPanel.setVisible(false);
		endPanel.setBounds(0, 0, 550, 545);
		
	}

}
