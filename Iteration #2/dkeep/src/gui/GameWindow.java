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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class GameWindow {

	private JFrame frmMazeGame;
	private static Game g = new Game(0, "Rookie");
	private static JButton btnRight;
	private static JButton btnUp;
	private static JButton btnLeft;
	private static JButton btnDown;
	private JTextArea GameTxtArea;
	private GamePanel Map;

	private ImageIcon background;
	private JPanel menuImage;

	private int ogres_number;
	private String guard_type;
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
		frmMazeGame.setBounds(100, 100, 546, 566);
		frmMazeGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		background = new ImageIcon(this.getClass().getResource("res/keep.png"));
		Image bg = background.getImage();
		Image newimg = bg.getScaledInstance(300, 300, java.awt.Image.SCALE_FAST);

		menuImage = new JPanel();
		menuImage.setBackground(Color.BLACK);
		menuImage.setBounds(0, 0, 540, 540);
		menuImage.setForeground(Color.BLACK);

		Map= new GamePanel(545, 545);
		
		Map.setBounds(0, 0, 545, 545);

		frmMazeGame.getContentPane().setLayout(null);
		frmMazeGame.getContentPane().add(menuImage);
		
				JButton btnCustomMap = new JButton("Custom Map");
				btnCustomMap.addActionListener(new ActionListener() {
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
		
				JButton btnExit = new JButton("Exit");
				btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						System.exit(0);
					}
				});
		
				JButton btnNewButton = new JButton("New Game");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String guard;
						String ogres_number;

						Map = new GamePanel(540, 540);
						Map.setBounds(0, 0, 540, 540);

						frmMazeGame.getContentPane().add(Map);

						Object[] g_options = { "Rookie", "Druken", "Suspicious" };

						Object[] o_options = { "1", "2", "3", "4", "5" };

						guard = (String) JOptionPane.showInputDialog(frmMazeGame, "                Chose Guard's Personality.",
								"", JOptionPane.PLAIN_MESSAGE, null, g_options, "Rookie");

						ogres_number = (String) JOptionPane.showInputDialog(frmMazeGame,
								"             Chose the Number of Ogres", "", JOptionPane.PLAIN_MESSAGE, null, o_options, "1");

						g = new Game(Integer.parseInt(ogres_number), guard);

						Map.update();
						
						btnNewButton.setVisible(false);
						btnExit.setVisible(false);
						btnCustomMap.setVisible(false);
						
						Map.update();
						Map.revalidate();
						Map.requestFocus();
						
					}
				});
				
				
		GroupLayout gl_menuImage = new GroupLayout(menuImage);
		gl_menuImage.setHorizontalGroup(
			gl_menuImage.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_menuImage.createSequentialGroup()
					.addGap(56)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnCustomMap, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(64)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_menuImage.setVerticalGroup(
			gl_menuImage.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_menuImage.createSequentialGroup()
					.addContainerGap(473, Short.MAX_VALUE)
					.addGroup(gl_menuImage.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnCustomMap)
						.addComponent(btnExit))
					.addGap(33))
		);
		menuImage.setLayout(gl_menuImage);

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

	public static Game getGame() {
		return g;
	}
}
