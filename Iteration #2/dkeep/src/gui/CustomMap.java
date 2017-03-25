package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import logic.KeepMap;

import java.awt.event.MouseListener;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;


public class CustomMap extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = -6282798323298335606L;
	char c;
	
	

	public CustomMap(int rows, int cols, int ogres) {
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

		/*
		JButton btnWall = new JButton("");
		btnWall.setHorizontalTextPosition(SwingConstants.CENTER);
		btnWall.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconWall.png")));
		btnWall.setBackground(Color.BLACK);
		btnWall.setBounds(38, 40, 49, 49);
		getContentPane().add(btnWall);
		
		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconDoor.png")));
		btnExit.setBounds(120, 40, 49, 49);
		getContentPane().add(btnExit);
		
		JButton btnKey = new JButton("");
		btnKey.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconKey.png")));
		btnKey.setBounds(197, 40, 49, 49);
		getContentPane().add(btnKey);


		GamePanel panel = new GamePanel(350, 350, rows, cols);
		panel.setBounds(64, 67, 403, 380);
		add(panel);
*/
		

	}

	private void setBackButton() {
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBounds(285, 22, 89, 23);
		add(btnNewButton_2);

	}

	private void setPlayButton() {
		JButton btnNewButton_1 = new JButton("Play");
		btnNewButton_1.setBounds(151, 22, 89, 23);
		add(btnNewButton_1);

	}

	private void setHeroButton() {
		JButton btnHero = new JButton("");
		btnHero.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconHero.png")));

		btnHero.setBounds(341, 488, 49, 49);
		btnHero.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = 'H';
			}
		});

		add(btnHero);


	}

	private void setOgreButton() {
		  JButton btnOgre = new JButton("");
	        btnOgre.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconOgre.png")));
	        btnOgre.setBounds(250, 488, 49, 49);
	        btnOgre.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnOgre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = 'O';
			}
		});
	
		add(btnOgre);

	}

	private void setKeyButton() {
		JButton btnKey = new JButton("");
		btnKey.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconKey.png")));
		btnKey.setBounds(414, 488, 52, 49);
		btnKey.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = 'k';
			}
		});

		add(btnKey);

	}

	private void setExitButton() {
		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconDoor.png")));
		btnExit.setBounds(164, 488, 49, 49);
		btnExit.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = 'I';
			}
		});

		add(btnExit);

	}

	private void setWallButton() {
		JButton btnWall = new JButton("");
		btnWall.setHorizontalTextPosition(SwingConstants.CENTER);
		btnWall.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconWall.png")));
		btnWall.setBackground(Color.BLACK);
		btnWall.setBounds(84, 488, 49, 49);
		btnWall.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnWall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = 'X';
			}
		});

		add(btnWall);

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
		// public Point getMousePosition(boolean allowChildren)
		// throws HeadlessException

		// public Component getComponentAt(Point p);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
