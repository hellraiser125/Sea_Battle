import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    JPanel MainPanel = new JPanel();
    JLabel label =  new JLabel();
    ImageIcon image = new ImageIcon("C:/Users/hellraizer/Desktop/SB/Sea_Battle/Source/Main_menu.png");
    JButton play = new JButton();
    JButton author = new JButton();
    JButton about = new JButton();
    JButton exit = new JButton();

    ImageIcon playIcon = new ImageIcon("Source/Play_bttn.png");
    ImageIcon authorIcon = new ImageIcon("Source/Author_bttn.png");
    ImageIcon aboutIcon = new ImageIcon("Source/About_bttn.png");
    ImageIcon exitIcon = new ImageIcon("Source/Exit_bttn.png");
    Menu(){

        label.setIcon(image);
        label.setIconTextGap(100);
        label.setOpaque(true);
        label.setBounds(0,0,1280,720);
        MainPanel.setBounds(0,0,1280,720);
        MainPanel.add(label);

        play.setBounds(500,390,295,65);
        play.setFocusable(false);
        play.addActionListener(this);
        play.setBackground(null);
        play.setBorder(null);
        play.setIcon(playIcon);
        play.setOpaque(false);

        author.setBounds(500,470,295,65);
        author.setFocusable(false);
        author.addActionListener(this);
        author.setBackground(null);
        author.setBorder(null);
        author.setIcon(authorIcon);
        author.setOpaque(false);

        about.setBounds(500,540,295,65);
        about.setFocusable(false);
        about.addActionListener(this);
        about.setBackground(null);
        about.setBorder(null);
        about.setIcon(aboutIcon);
        about.setOpaque(false);

        exit.setBounds(500,620,295,65);
        exit.setFocusable(false);
        exit.addActionListener(this);
        exit.setBackground(null);
        exit.setBorder(null);
        exit.setIcon(exitIcon);
        exit.setOpaque(false);

        MainPanel.setBounds(0,0,1280,720);
        MainPanel.add(label);


        this.setLayout(null);
        this.add(play);
        this.add(author);
        this.add(about);
        this.add(exit);
        this.add(MainPanel);
        this.setTitle("Sea Battle");
        this.setDefaultCloseOperation(Menu.EXIT_ON_CLOSE);
        this.setResizable(false);//static window or not
        this.setSize(1280,720);
        this.setVisible(true);
        ImageIcon image = new ImageIcon("Source/sailing-ship-pirate-ship-ship-42420.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==play){
            Game gm = new Game();
            this.setState(JFrame.ICONIFIED);
        }
        if(e.getSource() == about){
            About ab = new About();
        }
        if(e.getSource()==author){
            Author au = new Author();
        }
        if(e.getSource()==exit){
            System.exit(0);
        }


    }
}
