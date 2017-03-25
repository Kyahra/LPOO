package gui;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;



public class CustomMap  extends JFrame  {

	
	public CustomMap(int cols, int rows) {
		super();
		getContentPane().setBackground(Color.BLACK);



		setBackground(java.awt.Color.BLACK);
		getContentPane().setLayout(null);
		
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
		
		JButton btnHero = new JButton("");
		btnHero.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconHero.png")));
		btnHero.setBounds(279, 40, 49, 49);
		getContentPane().add(btnHero);
		
		JButton btnOgre = new JButton("");
		btnOgre.setIcon(new ImageIcon(CustomMap.class.getResource("/gui/res/iconOgre.png")));
		btnOgre.setBounds(356, 40, 49, 49);
		getContentPane().add(btnOgre);

	
	}
}
