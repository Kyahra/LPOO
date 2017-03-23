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
		menuImage.setBounds(122, 81, 368, 368);
		menuImage.setForeground(Color.BLACK);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}
		});
		btnExit.setBounds(496, 23, 66, 23);


		GameMap = new GameMapArea( 251, 251);
		GameMap.setBounds(115, 81, 368, 368);
	

		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String guard;
			String ogres_number;
				
			GameMap = new GameMapArea( 251, 251);
			GameMap.setBounds(115, 81, 368, 368);

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
		btnNewButton.setBounds(76, 23, 101, 23);

		frmMazeGame.getContentPane().setLayout(null);
		
		frmMazeGame.getContentPane().add(btnNewButton);
	
	frmMazeGame.getContentPane().add(btnExit);
	
		frmMazeGame.getContentPane().add(menuImage);
		
		
		JLabel label = new JLabel(new ImageIcon(newimg));
		label.setBounds(new Rectangle(400, 400, 251, 251));
		label.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
		label.setMaximumSize(new Dimension(400, 400));
		label.setFocusTraversalPolicyProvider(true);
		label.setDoubleBuffered(true);
		label.setFocusCycleRoot(true);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		GroupLayout gl_menuImage = new GroupLayout(menuImage);
		gl_menuImage.setHorizontalGroup(
			gl_menuImage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuImage.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_menuImage.setVerticalGroup(
			gl_menuImage.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_menuImage.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
					.addContainerGap())
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



