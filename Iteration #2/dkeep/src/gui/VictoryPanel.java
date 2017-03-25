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
import java.awt.Graphics;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import java.awt.Component;

public class VictoryPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public VictoryPanel() {
        
        setBackground(Color.BLACK);
        ImageIcon victory = new ImageIcon(this.getClass().getResource("res/thumbsUpCut.png"));
        JLabel label = new JLabel(victory);
        
        JButton menuBtn = new JButton("");
        menuBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameWindow.pnlVictory.setVisible(false);
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
    
    public void setWinImage(){
        
        ImageIcon init = new ImageIcon(this.getClass().getResource("res/thumbsUpCut.png"));
        JLabel label = new JLabel(init);
        this.add(label);
    }
}





















