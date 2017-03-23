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

public class GameWindow{

	private JFrame frmMazeGame;
	private static Game g = new Game(0, "Rookie");
	private static JButton btnRight;
	private static JButton btnUp;
	private static JButton btnLeft;
	private static JButton btnDown;
	private JTextArea GameTxtArea;
	private GameMapArea GameMap;

	private ImageIcon background;
	private JPanel menuImage;
	
	private GamePanel gameP;

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
		frmMazeGame.setBounds(100, 100, 587, 489);
		frmMazeGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		background = new ImageIcon(this.getClass().getResource("res/keep.png"));
		Image bg = background.getImage();
		Image newimg = bg.getScaledInstance(300, 300,  java.awt.Image.SCALE_FAST);

		menuImage = new JPanel();
		menuImage.setBackground(Color.BLACK);
		menuImage.setBounds(0, 0, 581, 454);
		menuImage.setForeground(Color.BLACK);


		//GameMap = new GameMapArea( 251, 251);
		//GameMap.setBounds(115, 81, 368, 368);

		frmMazeGame.getContentPane().setLayout(null);
	
		frmMazeGame.getContentPane().add(menuImage);
		
		
		JLabel label = new JLabel(new ImageIcon(newimg));
		label.setBounds(new Rectangle(400, 400, 251, 251));
		label.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
		label.setMaximumSize(new Dimension(400, 400));
		label.setFocusTraversalPolicyProvider(true);
		label.setDoubleBuffered(true);
		label.setFocusCycleRoot(true);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		

			JButton btnNewButton = new JButton("New Game");
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				String guard;
				String ogres_number;
					
				GameMap = new GameMapArea( 251, 251);
				//GameMap.setBounds(115, 81, 368, 368);
				GameMap.setBounds(0, 0, 581, 581);

				frmMazeGame.getContentPane().add(GameMap);
						
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

					
					GameMap.update();



					GameMap.update();
					GameMap.requestFocus();
					
				}
			});
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}
		});
		
		JButton btnCreateGame = new JButton("Create Game");
		
		JButton btnSaveGame = new JButton("Save Game");
		GroupLayout gl_menuImage = new GroupLayout(menuImage);
		gl_menuImage.setHorizontalGroup(
			gl_menuImage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuImage.createSequentialGroup()
					.addGap(144)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(137))
				.addGroup(gl_menuImage.createSequentialGroup()
					.addGap(51)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnCreateGame)
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(btnSaveGame)
					.addGap(18)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		gl_menuImage.setVerticalGroup(
			gl_menuImage.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_menuImage.createSequentialGroup()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
					.addGap(39)
					.addGroup(gl_menuImage.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCreateGame)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSaveGame))
					.addGap(22))
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



