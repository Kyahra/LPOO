package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

public class DefeatPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DefeatPanel() {

		setBackground(Color.BLACK);
		ImageIcon defeat = new ImageIcon(this.getClass().getResource("res/thumbsDownCut.png"));
		JLabel label = new JLabel(defeat);
		
		JButton menuBtn = new JButton("");
		menuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow.pnlDefeat.setVisible(false);
				GameWindow.pnlMenu.setVisible(true);
			}
		});
		menuBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		menuBtn.setIcon(new ImageIcon(VictoryPanel.class.getResource("/gui/res/rsz_menu.png")));
		
		JButton exitBtn = new JButton("");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		exitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		exitBtn.setIcon(new ImageIcon(VictoryPanel.class.getResource("/gui/res/rsz_exit.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(129)
							.addComponent(menuBtn, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(2, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(menuBtn, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
						.addComponent(exitBtn, 0, 0, Short.MAX_VALUE))
					.addGap(111))
		);
		setLayout(groupLayout);
		
	}

}
