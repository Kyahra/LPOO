package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameBar extends JPanel {

	static GamePanel pnlGame;
	
	/**
	 * Create the panel.
	 */
	public GameBar() {
		setBackground(Color.BLACK);
		
		JButton up = new JButton("");
		up.setBounds(437, 507, 33, 33);
		up.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		up.setIcon(new ImageIcon(GameBar.class.getResource("/gui/res/arrowUp.png")));
		up.setBackground(Color.BLACK);
		
		JButton left = new JButton("");
		left.setBounds(410, 533, 33, 33);
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		left.setIcon(new ImageIcon(GameBar.class.getResource("/gui/res/arrowLeft.png")));
		left.setBackground(Color.BLACK);
		left.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JButton down = new JButton("");
		down.setBounds(440, 559, 29, 25);
		down.setIcon(new ImageIcon(GameBar.class.getResource("/gui/res/arrowDown.png")));
		down.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		down.setBackground(Color.BLACK);
		
		JButton right = new JButton("");
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		right.setBounds(465, 533, 33, 33);
		right.setAlignmentX(Component.CENTER_ALIGNMENT);
		right.setBackground(Color.BLACK);
		right.setIcon(new ImageIcon(GameBar.class.getResource("/gui/res/arrowRight.png")));
		right.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		
		
		setLayout(null);
		
		pnlGame = new GamePanel(400, 400, 10, 10);
		pnlGame.setBounds(0, 0, 550, 495);
		this.add(pnlGame);
		add(down);
		add(left);
		add(up);
		add(right);
		
		JButton howToPlay = new JButton("");
		howToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(GameWindow.frmMazeGame, " Press keyboard arrow keys to move your hero\n "
																	+ " around the maze. You can also click on the buttons.\n"
																	+ " Your goal is to catch the key and then reach the doors.\n"
																	+ "                                                        \n"
																	+ "                  Good luck!!!              ");
			}
		});
		howToPlay.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		howToPlay.setIcon(new ImageIcon(GameBar.class.getResource("/gui/res/rsz_2howtoplay.png")));
		howToPlay.setBackground(Color.BLACK);
		howToPlay.setBounds(170, 522, 188, 44);
		add(howToPlay);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon(GameBar.class.getResource("/gui/res/rsz_menu.png")));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(30, 517, 111, 49);
		add(btnNewButton);
		

	}

	public void update() {
		pnlGame.update();
		
	}
}
