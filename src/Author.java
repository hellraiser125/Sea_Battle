import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

public class Author extends JFrame{

    ImageIcon authorsBackground = new ImageIcon("Source/Author_frame.png");
    JLabel backgroundJLabel = new JLabel();


    Author(){

        backgroundJLabel.setIcon(authorsBackground);
        backgroundJLabel.setOpaque(true);
        backgroundJLabel.setBounds(0, 0, 800, 600);

        this.add(backgroundJLabel);
        this.setTitle("Authors");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);//static window or not
        this.setBounds(500, 100, 800, 600);
        this.setVisible(true);
        ImageIcon image = new ImageIcon("Source/sailing-ship-pirate-ship-ship-42420.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);


    }

}
