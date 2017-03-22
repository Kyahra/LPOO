package gui;

import logic.Character;
import logic.Drunken;
import logic.DungeonMap;
import logic.Game;
//more...

import javax.swing.ImageIcon;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GamePanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	} 



	
}
