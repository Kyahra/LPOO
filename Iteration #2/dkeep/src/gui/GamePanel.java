package gui;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

import com.sun.prism.paint.Color;

public class GamePanel extends Map implements KeyListener{


	
	
	public GamePanel(int width, int height, int rows, int cols) {
		super();

		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		setBackground(java.awt.Color.BLACK);
		this.setSize(width, height);
		this.setLayout(new GridLayout(rows, cols));
		this.setVisible(true);

		loadImages();
		
		addKeyListener(this);
		
	}

	
	public void update(){
		super.update(GameWindow.getMap());
	}
	
	private void playGameRound(String direction) throws InterruptedException{

		if (GameWindow.getGame().isOver()){
			TimeUnit.SECONDS.sleep(1);
			GameWindow.EndGame();
			
		}
		GameWindow.getGame().setDirection(direction);
		GameWindow.getGame().update();
		update();
		
		
			
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		try{
		
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
		
		}catch (InterruptedException e1){
			
		}
		
	}
	
	public void fillWalls(){
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}