package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class CustomMapInterface extends JPanel{
	
	public CustomMapInterface() {
		super();


		setBackground(java.awt.Color.BLACK);
		setLayout(null);
		
		JButton btnWall = new JButton("Wall");
		btnWall.setBounds(24, 39, 63, 43);
		add(btnWall);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(104, 40, 63, 40);
		add(btnExit);
		
		JButton btnKey = new JButton("key");
		btnKey.setBounds(198, 40, 76, 40);
		add(btnKey);
		
		JButton btnHero = new JButton("hero");
		btnHero.setBounds(302, 40, 63, 40);
		add(btnHero);
		
		JButton btnOgre = new JButton("Ogre\r\n");
		btnOgre.setBounds(401, 40, 63, 40);
		add(btnOgre);

		
		this.setVisible(true);
		
	}
}
