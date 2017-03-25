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
	static VictoryPanel pnlVictory;
	static DefeatPanel pnlDefeat;


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

        pnlVictory = new VictoryPanel();
        pnlVictory.setBounds(0, 0, 550, 620);
        pnlVictory.setVisible(false);
        layeredPane.add(pnlVictory);
        
        
        pnlDefeat = new DefeatPanel();
        pnlDefeat.setBounds(0, 0, 550, 620);
        pnlDefeat.setVisible(false);
        layeredPane.add(pnlDefeat);
        
        
        pnlMenu = new MenuPanel();
        pnlMenu.setBounds(0, 0, 550, 584);
        layeredPane.add(pnlMenu);

        pnlMenu.setLayout(null);

        layeredPane
                .setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { pnlMenu, pnlGame, pnlCustomMap,  pnlVictory, pnlDefeat }));

        pnlGame = new GamePanel(400, 400, 10, 10);
        pnlGame.setBounds(0, 0, 550, 584);
        layeredPane.add(pnlGame);


	}

	public static void EndGame() {

		GameState state = g.getState();
		g.printMap();

		switch (state) {
		case LOST:
			pnlDefeat.setVisible(true);
			break;
		case WON:
			pnlVictory.setVisible(true);
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

	public static void createEditorPanel(int size, int ogres) {

		pnlCustomMap = new MapEditor(size,ogres);
		pnlCustomMap.setBounds(0, 0, 539, 609);
		layeredPane.add(pnlCustomMap);

	}
}
