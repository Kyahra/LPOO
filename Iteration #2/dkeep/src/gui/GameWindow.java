package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import logic.Game;
import logic.Game.GameState;
import logic.GameMap;

public class GameWindow {

	static JFrame frmMazeGame;
	static GamePanel pnlGame;
	static MenuPanel pnlMenu;
	static EndPanel pnlEnd; 


	static MapEditor pnlCustomMap;
	static JLayeredPane layeredPane;


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
		frmMazeGame.setBounds(100, 100, 549, 607);

		frmMazeGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMazeGame.getContentPane().setLayout(null);

		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 549, 620);
		frmMazeGame.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);

		pnlEnd = new EndPanel();
		pnlEnd.setBounds(0, 0, 550, 620);
		pnlEnd.setVisible(false);
		layeredPane.add(pnlEnd);
		
		
		pnlMenu = new MenuPanel();
		pnlMenu.setBounds(0, 0, 550, 584);
		layeredPane.add(pnlMenu);

		pnlMenu.setLayout(null);

		layeredPane
				.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { pnlMenu, pnlGame, pnlCustomMap,  pnlEnd }));

		pnlGame = new GamePanel(400, 400, 10, 10);
		pnlGame.setBounds(0, 0, 550, 584);
		layeredPane.add(pnlGame);

	}

	public static void EndGame() {

		GameState state = g.getState();
		g.printMap();

		switch (state) {
		case LOST:
			pnlGame.setVisible(false);
			pnlEnd.setVisible(true);
			break;
		case WON:
			pnlEnd.setWinImage();
			pnlEnd.setVisible(true);
		default:
			break;
		}

	}

	public static GameMap getMap() {
		return g.getMap();
	}

	public static void setGame(Game game) {
		g = game;

	}

	public static Game getGame() {
		return g;
	}

	public static void createEditorPanel(int size) {

		pnlCustomMap = new MapEditor(size);
		pnlCustomMap.setBounds(0, 0, 539, 609);
		layeredPane.add(pnlCustomMap);

	}
}
