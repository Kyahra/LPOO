package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CustomMap extends JPanel{
	
	public CustomMap() {
		super();


		setBackground(java.awt.Color.BLACK);
		setLayout(null);
		
		JButton btnWall = new JButton("");
		btnWall.setHorizontalTextPosition(SwingConstants.CENTER);
		btnWall.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconWall.png")));
		btnWall.setBackground(Color.BLACK);
		btnWall.setBounds(35, 40, 49, 49);
		add(btnWall);
		
		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconDoor.png")));
		btnExit.setBounds(111, 40, 49, 49);
		add(btnExit);
		
		JButton btnKey = new JButton("");
		btnKey.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconKey.png")));
		btnKey.setBounds(198, 40, 49, 49);
		add(btnKey);
		
		JButton btnHero = new JButton("");
		btnHero.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconHero.png")));
		btnHero.setBounds(275, 40, 49, 49);
		add(btnHero);
		
		JButton btnOgre = new JButton("");
		btnOgre.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconOgre.png")));
		btnOgre.setBounds(361, 40, 49, 49);
		add(btnOgre);

		
		this.setVisible(true);
		
	}
}
