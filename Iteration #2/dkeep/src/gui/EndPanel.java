package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import logic.Game;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;

public class EndPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public EndPanel() {

		super();
		setBackground(Color.BLACK);
		JLabel label = new JLabel(new ImageIcon(EndPanel.class.getResource("/gui/res/thumbsDownCut.png")));
		label.setBackground(Color.BLACK);
		
		JButton exitBtn = new JButton("");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		exitBtn.setIcon(new ImageIcon(EndPanel.class.getResource("/gui/res/rsz_exit.png")));
		
		JButton menuBtn = new JButton("");
		menuBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		menuBtn.setIcon(new ImageIcon(EndPanel.class.getResource("/gui/res/rsz_menu.png")));
		menuBtn.setBackground(Color.BLACK);
		menuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow.pnlEnd.setVisible(false);
				GameWindow.pnlMenu.setVisible(true);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(124)
					.addComponent(menuBtn)
					.addGap(48)
					.addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(140, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(label)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(label)
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(menuBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);
				
	}
	
	public void setWinImage(){
		
		ImageIcon init = new ImageIcon(this.getClass().getResource("res/thumbsUp3.png"));
		JLabel label = new JLabel(init);
		this.add(label);
	}
}
