package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


import logic.Game;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;



import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import java.awt.BorderLayout;


public class GameWindow {

    private JFrame frmGame;

    private JTextField fldOgresNumber;
    private JLabel lblNewLabel;
    private JButton btnNewGame;
    private JButton btnExit;

    private JTextField textField;
    private JTextArea txtrGame;

    private JButton btnUp;
    private JButton btnDown;
    private JButton btnRigth;
    private JButton btnLeft;
    private Box verticalBox;
    private Component verticalStrut;
    private Box verticalBox_1;
    private Component verticalStrut_3;
    private Component verticalStrut_4;
    private Box horizontalBox;
    private Box horizontalBox_1;
    private Box verticalBox_2;
    private Component verticalStrut_6;
    private Component verticalStrut_7;
    private Component horizontalStrut_1;
    private Component horizontalStrut_2;
    private Component horizontalStrut_3;
    private Component verticalStrut_8;
    private Box horizontalBox_2;
    private Component horizontalStrut_8;
    private Component horizontalStrut_10;
    private JComboBox comboBox;

    private JTextArea textAreaMap;
    private Component verticalStrut_2;



   
    

  
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GameWindow window = new GameWindow();
                    window.frmGame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GameWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmGame = new JFrame();
        frmGame.setBackground(UIManager.getColor("CheckBox.darkShadow"));

        frmGame.setTitle("Maze Game");

        frmGame.setBounds(100, 100, 816, 607);
        frmGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmGame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        verticalBox_2 = Box.createVerticalBox();
        frmGame.getContentPane().add(verticalBox_2);
        
        verticalStrut_7 = Box.createVerticalStrut(40);
        verticalBox_2.add(verticalStrut_7);
        
        horizontalBox = Box.createHorizontalBox();
        verticalBox_2.add(horizontalBox);
        
        JLabel lblNumberOfOgres = new JLabel("Number of Ogres");
        horizontalBox.add(lblNumberOfOgres);
        
        horizontalStrut_3 = Box.createHorizontalStrut(20);
        horizontalBox.add(horizontalStrut_3);
        

        fldOgresNumber = new JTextField();
        horizontalBox.add(fldOgresNumber);
        fldOgresNumber.setColumns(1);

        
        horizontalStrut_1 = Box.createHorizontalStrut(500);
        horizontalBox.add(horizontalStrut_1);
        
        verticalStrut_8 = Box.createVerticalStrut(20);
        verticalBox_2.add(verticalStrut_8);
        
        horizontalBox_2 = Box.createHorizontalBox();
        verticalBox_2.add(horizontalBox_2);
        
        lblNewLabel = new JLabel("Guard Personality");
        horizontalBox_2.add(lblNewLabel);
        lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        horizontalStrut_8 = Box.createHorizontalStrut(20);
        horizontalBox_2.add(horizontalStrut_8);
        //frmGame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, lblNumberOfOgres, lblNewLabel, comboBox, txtrGame, btnNewGame, btnExit}));
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rookie", "Suspicious", "Drunken"}));
        comboBox.setToolTipText("");
        horizontalBox_2.add(comboBox);
        

        horizontalStrut_10 = Box.createHorizontalStrut(500);
        horizontalBox_2.add(horizontalStrut_10);
        
        verticalStrut_6 = Box.createVerticalStrut(60);

        verticalBox_2.add(verticalStrut_6);
        
        horizontalBox_1 = Box.createHorizontalBox();
        verticalBox_2.add(horizontalBox_1);
        

        textAreaMap = new JTextArea();
        textAreaMap.setWrapStyleWord(true);
        textAreaMap.setTabSize(10);
        textAreaMap.setEditable(false);
        textAreaMap.setFont(new Font("Courier New", Font.PLAIN, 28));
        textAreaMap.setColumns(5);
        textAreaMap.setRows(5);
        horizontalBox_1.add(textAreaMap);
        
        horizontalStrut_2 = Box.createHorizontalStrut(160);
        horizontalBox_1.add(horizontalStrut_2);
        
        btnLeft = new JButton("  Left ");
        btnLeft.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });

        horizontalBox_1.add(btnLeft);
        btnLeft.setEnabled(false);
        btnLeft.setVerticalAlignment(SwingConstants.BOTTOM);
        
        verticalBox_1 = Box.createVerticalBox();
        horizontalBox_1.add(verticalBox_1);
        
        btnNewGame = new JButton("New Game");
        btnNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox_1.add(btnNewGame);
        btnNewGame.setVerticalAlignment(SwingConstants.TOP);
        
        verticalStrut_3 = Box.createVerticalStrut(100);
        verticalBox_1.add(verticalStrut_3);
        
        verticalBox = Box.createVerticalBox();
        verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox_1.add(verticalBox);
        
        btnUp = new JButton("  Up  ");
        btnUp.setHorizontalAlignment(SwingConstants.LEADING);
        btnUp.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnUp.setEnabled(false);
        verticalBox.add(btnUp);
        btnUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            //direction  = "W";
            }
        });
        
        verticalStrut = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut);
        
        btnDown = new JButton("Down");
        btnDown.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDown.setEnabled(false);
        verticalBox.add(btnDown);
        
        verticalStrut_4 = Box.createVerticalStrut(100);
        verticalBox_1.add(verticalStrut_4);
        
        btnExit = new JButton("Exit Game");
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox_1.add(btnExit);
        btnExit.setVerticalAlignment(SwingConstants.BOTTOM);
        btnExit.setForeground(new Color(0, 0, 0));
        
        btnRigth = new JButton("Rigth");
        horizontalBox_1.add(btnRigth);
        btnRigth.setEnabled(false);
        

        verticalStrut_2 = Box.createVerticalStrut(40);
        frmGame.getContentPane().add(verticalStrut_2);
        
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	System.exit(0);
            }
        });
        btnNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            
            	int ogres_number=1;
                char guard_type='R';
            	int idx;
            	
            	try{
           		ogres_number = Integer.parseInt(fldOgresNumber.getText());
           		if(ogres_number <=0 || ogres_number >5)
           			throw new NumberFormatException();
        
            	}catch(NumberFormatException ex){
            		JOptionPane.showMessageDialog(frmGame,"N�mero de Ogres inv�lido");
            	}
            	
            	idx = comboBox.getSelectedIndex();
                
                switch(idx){
                case 0:
                    guard_type = 'r';
                    break;
                case 1:
                    guard_type  = 's';
                    break;
                case 2:
                    guard_type = 'd';
                    break;
                default:
                        break;
                } 
                
                Game g = new Game(ogres_number, guard_type);
                
                btnDown.setEnabled(true);
                btnUp.setEnabled(true);
                btnLeft.setEnabled(true);
                btnRigth.setEnabled(true);
                
                textAreaMap.append(g.printMap());
           		
            	
            	
            
            }
        });
    }

}

