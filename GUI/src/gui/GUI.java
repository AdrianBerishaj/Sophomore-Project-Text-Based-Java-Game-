package gui;

/**
 *
 * @author jbyfo_000
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class GUI {

    JFrame window;
    Container cont;
    JPanel titleNamePanel, startButtonPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Arial", Font.PLAIN, 50);
    Font textFont = new Font("Arial", Font.PLAIN, 30);
    JButton startButton;
    
    public static void main(String[] args) {
        new GUI();
        
    }
    
    public GUI(){
        
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        cont = window.getContentPane();
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 250);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Hour Of Devastation");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(textFont);

        
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        cont.add(titleNamePanel);
        cont.add(startButtonPanel);
        
    }
    
    
    
}
