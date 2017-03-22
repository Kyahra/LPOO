package gui;

import logic.Character;
import logic.Drunken;
import logic.DungeonMap;
import logic.Game;
//more...
import logic.Game.GameState;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class GamePanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	private Game g;
	private JLabel lblGameStatus;
/*
	public void keyPressed(KeyEvent e, Game g) {
		
		int key = e.getKeyCode();
		
		switch( key ) { 
		case KeyEvent.VK_UP:
			g.setDirection("W");

			break;
		case KeyEvent.VK_DOWN:
			g.setDirection("S");

			break;
		case KeyEvent.VK_LEFT:
			g.setDirection("A");

			break;
		case KeyEvent.VK_RIGHT :
			g.setDirection("D");

			break;
		}
}
*/
	public GamePanel(Game g) {
		
		this.g = g;
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		
		
	} 

	public void paintComponent(Graphics graph) {
		
		super.paintComponent(graph);
		
		
	
	}
	

	@Override
	public void keyPressed(KeyEvent e) {

		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT: 
			playGameRound("A");  
			break;
		case KeyEvent.VK_RIGHT:
			playGameRound("D");  
			break;
		case KeyEvent.VK_UP: 
			playGameRound("W");   
			break;
		case KeyEvent.VK_DOWN: 
			playGameRound("S");  
			break;
		 }	
	}
	
	
	private void playGameRound(String direction){

		g.setDirection(direction);
		g.update();
		if (g.isOver())
			EndGame();
			
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

		//btnsSetEnable(false);

	}
	
	public void setG(Game g) {
		this.g = g;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	} 


	
	
}
