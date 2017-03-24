package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Image;


import logic.Game;
import logic.Game.GameState;
import logic.GameMap;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;



public class GameWindow {

	static JFrame frmMazeGame;
	static GamePanel pnlGame;
	static MenuPanel pnlMenu;

	private static Game g = new Game(0, "Rookie");

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
		frmMazeGame.setBounds(100, 100, 555, 676);

		frmMazeGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMazeGame.getContentPane().setLayout(null);
		
		
		JPanel iniPanel = new JPanel();	
		iniPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		iniPanel.setBackground(Color.BLACK);
		iniPanel.setBounds(0, 0, 550, 545);	
		ImageIcon init = new ImageIcon(this.getClass().getResource("res/keep.png"));
		iniPanel.add(new JLabel(init));
		frmMazeGame.getContentPane().add(iniPanel);

				
		pnlGame= new GamePanel(400, 400);
		pnlGame.setBounds(0, 0, 550, 545);
		frmMazeGame.getContentPane().add(pnlGame);
		
		
		pnlMenu= new MenuPanel();
		pnlMenu.setBounds(0, 544, 550, 105);
		frmMazeGame.getContentPane().add(pnlMenu);
		pnlMenu.setLayout(null);
		
		

	}

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

	}

	public static GameMap getMap() {
		return g.getMap();
	}

	public static void setGame(Game game) {
		g= game;
		
	}

	public static Game getGame() {	
		return g;
	}
}
