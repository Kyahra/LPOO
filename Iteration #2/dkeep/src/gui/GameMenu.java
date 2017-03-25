package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.Game;
import logic.GameMap;

public class GameMenu extends JPanel {
	
	private GamePanel MapPannel;
	private JFrame frmMazeGame = GameWindow.frmMazeGame;
	private JButton btnNewButton;
	
	
	public GameMenu(int width, int height) {
		setLocation(200, 100);
        
		setBackground(java.awt.Color.BLACK);
		this.setSize(428, 117);
		setLayout(null);
		
		setNewButton();
		setExitButton();
		setCustomButton();

	
        setVisible(true);

		
	}
	
	
	private void setCustomButton() {
		JButton btnCustomGame = new JButton("Custom Game");
		btnCustomGame.addActionListener(new ActionListener() {
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
		btnCustomGame.setBounds(145, 72, 107, 34);
		add(btnCustomGame);
		this.setVisible(true);
		
	}


	public void setNewButton(){
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String guard;
				String ogres_number;
				
				setVisible(false);

				MapPannel = GameWindow.getMapPannel();

				Object[] g_options = { "Rookie", "Druken", "Suspicious" };

				Object[] o_options = { "1", "2", "3", "4", "5" };

				guard = (String) JOptionPane.showInputDialog(frmMazeGame, "                Chose Guard's Personality.",
						"", JOptionPane.PLAIN_MESSAGE, null, g_options, "Rookie");

				ogres_number = (String) JOptionPane.showInputDialog(frmMazeGame,
						"             Chose the Number of Ogres", "", JOptionPane.PLAIN_MESSAGE, null, o_options, "1");

				GameWindow.setGame(new Game(Integer.parseInt(ogres_number), guard));

					

				MapPannel.setVisible(true);
				MapPannel.update();
				MapPannel.requestFocus();
			
			}
		});
		btnNewButton.setBounds(34, 22, 89, 30);
		add(btnNewButton);
		
	}
	
	public void setExitButton(){
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnExit.setBounds(262, 24, 107, 27);
		add(btnExit);
		
		
		
	}
	
	
	
	
	
}

	
