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
        label.setBounds(10, 0, 512, 400);
        
        JButton menuBtn = new JButton("");
        menuBtn.setBounds(129, 406, 122, 45);
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
        exitBtn.setBounds(310, 406, 103, 45);
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        exitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        exitBtn.setIcon(new ImageIcon(VictoryPanel.class.getResource("/gui/res/rsz_exit.png")));
        setLayout(null);
        add(label);
        add(menuBtn);
        add(exitBtn);
        
    }

}



