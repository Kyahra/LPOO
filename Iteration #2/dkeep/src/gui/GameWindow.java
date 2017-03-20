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
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import logic.Game;
import logic.Game.GameState;

public class GameWindow {

	private JFrame frmMazeGame;
	private JTextField OgresTxtField;
	private Game g;
	private JLabel lblGameStatus;
	private JButton btnRight;
	private JButton btnUp;
	private JButton btnLeft;
	private JButton btnDown;
	private JTextArea GameTxtArea;

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
		frmMazeGame.setBounds(100, 100, 549, 394);
		frmMazeGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Number of Ogres");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(29, 23, 93, 18);

		OgresTxtField = new JTextField();
		OgresTxtField.setBounds(132, 21, 34, 20);
		OgresTxtField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		OgresTxtField.setColumns(10);

		JLabel lblGuardPersonality = new JLabel("Guard Personality");
		lblGuardPersonality.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGuardPersonality.setBounds(29, 55, 93, 17);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(132, 52, 87, 20);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { " Rookie", " Drunken", " Suspicious" }));
		comboBox.setToolTipText("");
		comboBox.setMaximumRowCount(3);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}
		});
		btnExit.setBounds(401, 294, 66, 23);

		GameTxtArea = new JTextArea();
		GameTxtArea.setEditable(false);
		GameTxtArea.setBounds(29, 90, 251, 228);
		GameTxtArea.setFont(new Font("Courier New", Font.PLAIN, 20));

		JLabel label = new JLabel("");
		label.setBounds(29, 368, 46, 14);

		lblGameStatus = new JLabel("You can start a new game.");
		lblGameStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGameStatus.setBounds(29, 329, 281, 14);

		btnUp = new JButton("Up");
		btnUp.setBounds(391, 154, 83, 23);
		btnUp.setEnabled(false);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblGameStatus.setText("Moved Up.");
				g.setDirection("W");
				g.update();
				GameTxtArea.setText(g.printMap());
				if (g.isOver())
					EndGame();
			}
		});

		btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGameStatus.setText("Moved Down.");
				
				g.setDirection("S");
				g.update();
				GameTxtArea.setText(g.printMap());
				
				if (g.isOver())
					EndGame();

				
			}
		});
		btnDown.setBounds(391, 222, 83, 23);
		btnDown.setEnabled(false);

		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGameStatus.setText("Moved Left");
				
				g.setDirection("A");
				g.update();
				GameTxtArea.setText(g.printMap());
				

				if (g.isOver())
					EndGame();
				

			}
		});
		btnLeft.setBounds(343, 188, 85, 23);
		btnLeft.setEnabled(false);

		btnRight = new JButton("Right");
		btnRight.setBounds(441, 188, 83, 23);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblGameStatus.setText("Moved Right");

				g.setDirection("D");
				g.update();
				GameTxtArea.setText(g.printMap());
				

				if (g.isOver())
					EndGame();
		

			}
		});
		btnRight.setEnabled(false);

		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int ogres_number = 1;
				char guard_type = 'R';
				int idx;

				try {
					ogres_number = Integer.parseInt(OgresTxtField.getText());
					if (ogres_number <= 0 || ogres_number > 5)
						throw new NumberFormatException();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frmMazeGame, "Número de Ogres inválido");
					return;
				}

				idx = comboBox.getSelectedIndex();

				switch (idx) {
				case 0:
					guard_type = 'R';
					break;
				case 1:
					guard_type = 'S';
					break;
				case 2:
					guard_type = 'D';
					break;
				default:
					break;
				}
				
				ogres_number = 1;

				g = new Game(ogres_number, guard_type);

				GameTxtArea.setText(g.printMap());

				btnsSetEnable(true);

				lblGameStatus.setText("You can play now.");

			}
		});
		btnNewButton.setBounds(381, 90, 101, 23);

		frmMazeGame.getContentPane().setLayout(null);
		frmMazeGame.getContentPane().add(lblNewLabel);
		frmMazeGame.getContentPane().add(OgresTxtField);
		frmMazeGame.getContentPane().add(lblGuardPersonality);
		frmMazeGame.getContentPane().add(comboBox);
		frmMazeGame.getContentPane().add(GameTxtArea);
		frmMazeGame.getContentPane().add(btnRight);
		frmMazeGame.getContentPane().add(btnUp);
		frmMazeGame.getContentPane().add(btnNewButton);
		frmMazeGame.getContentPane().add(btnDown);
		frmMazeGame.getContentPane().add(btnExit);
		frmMazeGame.getContentPane().add(btnLeft);
		frmMazeGame.getContentPane().add(label);
		frmMazeGame.getContentPane().add(lblGameStatus);

	}

	public void EndGame() {

		GameState state = g.getState();
		g.printMap();

		switch (state) {
		case LOST:
			lblGameStatus.setText("DEFEAT.");
			break;
		case WON:
			lblGameStatus.setText("VICTORY.");

		default:
			break;
		}
		
	
		btnsSetEnable(false);
		

	}
	
	public void btnsSetEnable(boolean value){
		btnUp.setEnabled(value);
		btnDown.setEnabled(value);
		btnLeft.setEnabled(value);
		btnRight.setEnabled(value);
		
	}

}
