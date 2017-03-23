
package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JPanel;
import java.awt.Window.Type;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import logic.Game;
import logic.Game.GameState;
import logic.GameMap;
import java.awt.Panel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class GameWindow{

	private JFrame frmMazeGame;
	private static Game g = new Game(0, "Rookie");
	private static JButton btnRight;
	private static JButton btnUp;
	private static JButton btnLeft;
	private static JButton btnDown;
	private JTextArea GameTxtArea;
	private GameMapArea GameMap;

	private GamePanel gameP;

	// Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
					window.frmMazeGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application.

	public GameWindow() {
		initialize();
	}

	// Initialize the contents of the frame.

	private void initialize() {
		
		frmMazeGame = new JFrame();
		frmMazeGame.setResizable(false);
		frmMazeGame.setTitle("Maze Game");
		frmMazeGame.setBounds(100, 100, 587, 489);
		frmMazeGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}
		});
		btnExit.setBounds(496, 23, 66, 23);

		GameMap = new GameMapArea( 251, 251);
		GameMap.setBounds(115, 81, 368, 368);
	
	

		JLabel label = new JLabel("");
		label.setBounds(29, 368, 46, 14);

		btnUp = new JButton("Up");
		btnUp.setBounds(310, 11, 83, 23);
		btnUp.setEnabled(false);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				g.setDirection("W");
				g.update();
				GameMap.update();
				if (g.isOver())
					EndGame();
			}
		});

		btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				g.setDirection("S");
				g.update();
				GameMap.update();
				if (g.isOver())
					EndGame();

			}
		});
		btnDown.setBounds(310, 45, 83, 23);
		btnDown.setEnabled(false);

		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				g.setDirection("A");
				g.update();
				GameMap.update();

				if (g.isOver())
					EndGame();

			}
		});
		btnLeft.setBounds(215, 23, 85, 23);
		btnLeft.setEnabled(false);

		btnRight = new JButton("Right");
		btnRight.setBounds(403, 23, 83, 23);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		

				g.setDirection("D");
				g.update();
				GameMap.update();

				if (g.isOver())
					EndGame();

			}
		});
		btnRight.setEnabled(false);

		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String guard;
			String ogres_number;
				
			Object[] g_options = {"Rookie",
	                    "Druken",
	                    "Suspicious"};
			
			 Object[] o_options = {"1",
	                    "2",
	                    "3",
	                    "4",
	                    "5"};
			
			guard = (String)JOptionPane.showInputDialog(
					frmMazeGame,
					"                Chose Guard's Personality.",
					"",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    g_options,
                    "Rookie");
			
			 ogres_number =(String)JOptionPane.showInputDialog(
						frmMazeGame,
						"             Chose the Number of Ogres",
						"",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    o_options,
	                    "1");

				

				g = new Game(Integer.parseInt(ogres_number), guard);

				// GameTxtArea.setText(g.printMap());

				btnsSetEnable(true);
				
				//setGame();


				GameMap.update();
				GameMap.requestFocus();
				
			
				

				
			}
		});
		btnNewButton.setBounds(76, 23, 101, 23);

		frmMazeGame.getContentPane().setLayout(null);
		frmMazeGame.getContentPane().add(btnRight);
		frmMazeGame.getContentPane().add(btnUp);
		frmMazeGame.getContentPane().add(btnNewButton);
		frmMazeGame.getContentPane().add(btnDown);
		frmMazeGame.getContentPane().add(btnExit);
		frmMazeGame.getContentPane().add(btnLeft);
		frmMazeGame.getContentPane().add(label);
		frmMazeGame.getContentPane().add(GameMap);

	}

//	public void setGame() {
///*
//		gameP.setEnabled(true);
//		gameP.setVisible(true);
//		gameP.setFocusable(true);
//		gameP.requestFocus();
//	//	gameP.setG(g);*/
//
//	}

	public static void EndGame() {

		GameState state = g.getState();
		g.printMap();

		switch (state) {
		case LOST:
			break;
		case WON:
		default:
			break;
		}

		btnsSetEnable(false);

	}

	public static void btnsSetEnable(boolean value) {
		btnUp.setEnabled(value);
		btnDown.setEnabled(value);
		btnLeft.setEnabled(value);
		btnRight.setEnabled(value);

	}
	
	private void playGameRound(String direction){

		g.setDirection(direction);
		g.update();
		GameMap.update();
		if (g.isOver())
			EndGame();
			
	}

	public static GameMap getMap() {
		return g.getMap();
	}
	
	public static Game getGame() {
		return g;
	}

	

}
