package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;


import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import logic.KeepMap;

import java.awt.event.MouseListener;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;


public class MapEditor extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = -6282798323298335606L;
	
	private char c= ' ';
	private MapEditorGrid game_panel;
	private double MAP_SIZE = 350;
	private double DIVISOR;
	
	private int size;

	

	public MapEditor(int size) {
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

		addMouseListener(this);
		
		this.size =size;
	
		
		setGamePanel();
		
		DIVISOR = MAP_SIZE/size;
		

		

	}

	private void setGamePanel() {
		game_panel = new MapEditorGrid(400, 400, size);
		game_panel.setBounds(75, 75, 400, 400);
		add(game_panel);
		
	}

	private void setBackButton() {
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBounds(303, 22, 89, 23);
		add(btnNewButton_2);

	}

	private void setPlayButton() {
		JButton btnNewButton_1 = new JButton("Play");
		btnNewButton_1.setBounds(169, 22, 89, 23);
		add(btnNewButton_1);

	}

	private void setHeroButton() {
		JButton btnHero = new JButton("");
		btnHero.setIcon(new ImageIcon(MapEditor.class.getResource("/gui/res/iconHero.png")));

		btnHero.setBounds(343, 506, 49, 49);

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
	        btnOgre.setIcon(new ImageIcon(MapEditor.class.getResource("/gui/res/iconOgre.png")));
	        btnOgre.setBounds(258, 506, 49, 49);
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
		btnKey.setIcon(new ImageIcon(MapEditor.class.getResource("/gui/res/iconKey.png")));
		btnKey.setBounds(410, 506, 52, 49);
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
		btnExit.setIcon(new ImageIcon(MapEditor.class.getResource("/gui/res/iconDoor.png")));
		btnExit.setBounds(165, 506, 52, 49);
		btnExit.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = 'S';
			}
		});

		add(btnExit);

	}

	private void setWallButton() {
		JButton btnWall = new JButton("");
		btnWall.setHorizontalTextPosition(SwingConstants.CENTER);
		btnWall.setIcon(new ImageIcon(MapEditor.class.getResource("/gui/res/iconWall.png")));
		btnWall.setBackground(Color.BLACK);
		btnWall.setBounds(89, 506, 49, 49);
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
		
		
		
		int x = (int) Math.floor((e.getX()-100)/DIVISOR);
		int y = (int) Math.floor((e.getY()-100)/DIVISOR);
		
		if(c != ' ' && x >0 && y>0 && x<size && y <size){
			game_panel.setNewChar(x,y,c);
			game_panel.update();
		}
		
		
		
		
		// throws HeadlessException

		// public Component getComponentAt(Point p);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
