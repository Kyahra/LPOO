package gui;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;

import javax.swing.SwingConstants;



import java.awt.event.MouseListener;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;


public class CustomMap  extends JPanel implements MouseListener  {

	char c;
	
	public CustomMap(int rows, int cols) {
		super();
		setLayout(null);
		
		setWallButton();
		setExitButton();
		setKeyButton();
		setOgreButton();
		setHeroButton();
		setPlayButton();
		setBackButton();
		setBackground(java.awt.Color.BLACK);
		
		GamePanel panel = new GamePanel(350,350,rows,cols);
		panel.setBackground(Color.GREEN);
		panel.setBounds(20, 72, 317, 327);
		add(panel);
		
	
	}
	private void setBackButton() {
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBounds(170, 33, 89, 23);
		add(btnNewButton_2);
		
		
		
	}
	private void setPlayButton() {
	JButton btnNewButton_1 = new JButton("Play");
		btnNewButton_1.setBounds(44, 33, 89, 23);
		add(btnNewButton_1);
		
	}
	

	private void setHeroButton() {
		JButton button_3 = new JButton("Hero");
		button_3.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconHero.png")));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c='H';
			}
		});
		button_3.setBounds(367, 340, 49, 59);
		add(button_3);
		
	
	}

	private void setOgreButton() {
		JButton button_2 = new JButton("Ogre");
		button_2.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconOgre.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c='O';
			}
		});
		button_2.setBounds(367, 265, 49, 52);
		add(button_2);
		
	}

	private void setKeyButton() {
		JButton button_1 = new JButton("Key");
		button_1.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconKey.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c= 'k';
			}
		});
		button_1.setBounds(367, 187, 49, 52);
		add(button_1);
		
		
	}



	private void setExitButton() {
		JButton button = new JButton("Exit");
		button.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconDoor.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c='I';
			}
		});
		button.setBounds(367, 122, 49, 54);
		add(button);
		
	}

	private void setWallButton() {
		JButton btnNewButton = new JButton("");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconWall.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c='X';
			}
		});
		btnNewButton.setBounds(357, 74, 59, 52);
		add(btnNewButton);
		
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
//		public Point getMousePosition(boolean allowChildren)
//                throws HeadlessException
		
//		public Component getComponentAt(Point p);
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
