package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import logic.Game;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MenuPanel extends JPanel{
	
	private JButton btnNewGame;
	private JButton btnExit;
	private JButton btnCustom;
	
	private GamePanel pnlGame = GameWindow.pnlGame;
	private JFrame frmMazeGame = GameWindow.frmMazeGame;
	
	public MenuPanel() {
		super();

		

		setBackground(java.awt.Color.BLACK);
		setLayout(null);
		
		setNewGameButton();
		setExitButton();
		setCustomButton();
	
		
		this.setVisible(true);
		
	}
	
	
	private void setCustomButton() {
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(MenuPanel.class.getResource("/gui/res/rsz_createmap.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cols_str;
				String rows_str;

				Object[] options = { "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
						"19", "20" };

				cols_str = (String) JOptionPane.showInputDialog(frmMazeGame, "Number of Collums?", "",
						JOptionPane.PLAIN_MESSAGE, null, options, "5");

				rows_str = (String) JOptionPane.showInputDialog(frmMazeGame, "Number of Collums?", "",
						JOptionPane.PLAIN_MESSAGE, null, options, "5");

			}
		});
		btnNewButton_1.setBounds(221, 39, 174, 36);
		add(btnNewButton_1);
		
	}


	private void setExitButton() {
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(MenuPanel.class.getResource("/gui/res/rsz_exit.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(431, 44, 66, 31);
		add(btnNewButton_2);
		

		
	}


	public void setNewGameButton(){
		
		btnNewGame  = new JButton("");
		btnNewGame.setIcon(new ImageIcon(MenuPanel.class.getResource("/gui/res/rsz_newgame.png")));
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String guard;
				String ogres_number;

				Object[] g_options = { "Rookie", "Druken", "Suspicious" };

				Object[] o_options = { "1", "2", "3", "4", "5" };

				guard = (String) JOptionPane.showInputDialog(frmMazeGame, "                Chose Guard's Personality.",
						"", JOptionPane.PLAIN_MESSAGE, null, g_options, "Rookie");

				ogres_number = (String) JOptionPane.showInputDialog(frmMazeGame,
						"             Chose the Number of Ogres", "", JOptionPane.PLAIN_MESSAGE, null, o_options, "1");

				GameWindow.setGame(new Game(Integer.parseInt(ogres_number), guard));

				pnlGame.update();
				pnlGame.requestFocus();
				pnlGame.setVisible(true);
				
			}
		});
		btnNewGame.setBounds(26, 30, 168, 45);
		add(btnNewGame);
		
		
		
	}
}
