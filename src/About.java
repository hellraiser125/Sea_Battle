import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

public class About extends JFrame{

    ImageIcon aboutBackground = new ImageIcon("Source/About_frame.png");
    JLabel backgroundJLabel = new JLabel();


    About(){

        backgroundJLabel.setIcon(aboutBackground);
        backgroundJLabel.setOpaque(true);
        backgroundJLabel.setBounds(0, 0, 800, 600);

        this.add(backgroundJLabel);
        this.setTitle("About");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);//static window or not
        this.setBounds(500, 100, 800, 600);
        this.setVisible(true);
        ImageIcon image = new ImageIcon("Source/sailing-ship-pirate-ship-ship-42420.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);

    }

}