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
import java.awt.Color;
import javax.swing.border.MatteBorder;

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
		btnNewButton_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setIcon(new ImageIcon(MenuPanel.class.getResource("/gui/res/rsz_createmap.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cols;
				String rows;
				String ogres;
				
				pnlGame.setVisible(false);

				Object[] options = { "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
						"19", "20" };
				
				Object[] o_options = {"1","2","3","4","5"};

				cols = (String) JOptionPane.showInputDialog(frmMazeGame, "Number of Collums?", "",
						JOptionPane.PLAIN_MESSAGE, null, options, "5");

				rows = (String) JOptionPane.showInputDialog(frmMazeGame, "Number of Collums?", "",
						JOptionPane.PLAIN_MESSAGE, null, options, "5");
				
				ogres = (String) JOptionPane.showInputDialog(frmMazeGame, "Number of Ogres?", "",
						JOptionPane.PLAIN_MESSAGE, null, o_options, "1");
				
				GameWindow.pnlGame.setVisible(false);
				GameWindow.pnlMenu.setVisible(false);
				
			
				GameWindow.createEditorPanel(Integer.parseInt(rows),Integer.parseInt(cols));
				GameWindow.pnlCustomMap.setVisible(true);
				

			}
		});
		btnNewButton_1.setBounds(192, 550, 236, 45);
		add(btnNewButton_1);
		
	}


	private void setExitButton() {
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setIcon(new ImageIcon(MenuPanel.class.getResource("/gui/res/rsz_exit.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(430, 550, 102, 45);
		add(btnNewButton_2);
		

		
	}


	public void setNewGameButton(){
		
		btnNewGame  = new JButton("");
		btnNewGame.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewGame.setBackground(Color.BLACK);
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
		btnNewGame.setBounds(10, 550, 174, 45);
		add(btnNewGame);
		
		
		
	}
}
