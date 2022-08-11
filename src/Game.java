import org.w3c.dom.css.RGBColor;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame implements ActionListener{

    ImageIcon image = new ImageIcon("Source/sailing-ship-pirate-ship-ship-42420.png");
    JPanel Panel = new JPanel();
    ImageIcon gameBackground = new ImageIcon("Source/Game_field.png");
    JLabel backgroundJLabel = new JLabel();
    JButton start = new  JButton();
    JButton ships = new JButton();

    ImageIcon startIcon = new ImageIcon("Source/start.png");
    ImageIcon shipsIcon = new ImageIcon("Source/ships.png");

   JButton[][] plrfield = new JButton[10][10];
   JButton[][] botfield = new JButton[10][10];
    int points = 0;
    int bpoint = 0;

    Game(){
        int x = 129,y = 120;
        for(int row = 0; row < 10; row++){
            for(int col = 0; col < 10; col++){
                plrfield[row][col] = new JButton();
                plrfield[row][col].setBounds(x,y,36,36);
                plrfield[row][col].setFocusable(false);
                plrfield[row][col].setBackground(Color.lightGray);
                plrfield[row][col].setBorder(null);
                plrfield[row][col].setOpaque(false);
                this.add(plrfield[row][col]);
                x+=38;
            }
            x = 130;
            y+=38;
        }
        int bx = 795,by = 120;
        for(int row = 0; row < 10; row++){
            for(int col = 0; col < 10; col++){
                botfield[row][col] = new JButton();
                botfield[row][col].setBounds(bx,by,36,36);
                botfield[row][col].setFocusable(false);
                botfield[row][col].setBackground(Color.BLUE);
                botfield[row][col].setBorder(null);
                botfield[row][col].setOpaque(false);
                this.add(botfield[row][col]);
                bx+=38;
            }
            bx = 795;
            by+=38;
        }

        backgroundJLabel.setIcon(gameBackground);
        backgroundJLabel.setOpaque(true);
        backgroundJLabel.setBounds(0, 0, 1280, 725);
        Panel.setBounds(0,0,1280,725);
        Panel.add(backgroundJLabel);

        start.setBounds(148,620,313,72);
        start.setFocusable(false);
        start.addActionListener(this);
        start.setBackground(null);
        start.setBorder(null);
        start.setIcon(startIcon);
        start.setOpaque(false);

        ships.setBounds(818,620,313,72);
        ships.setFocusable(false);
        ships.addActionListener(this);
        ships.setToolTipText("Кількість кораблів: 1 4-х місний, 2 3-х місних, 3 2-х місних, 4 1-но місних. Кораблі повинні розташовуватись по прамій лінії горизонтально чи вертикально.");
        ships.setBackground(null);
        ships.setBorder(null);
        ships.setIcon(shipsIcon);
        ships.setOpaque(false);

        this.setLayout(null);
        this.setTitle("Game");
        this.add(start);
        this.add(ships);
        this.add(Panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);//static window or not
        this.setBounds(500, 100, 1280, 725);
        this.setVisible(true);

        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == ships) {
            //JButton btn = (JButton) e.getSource();
            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    plrfield[row][col].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            for (int row = 0; row < 10; row++) {
                                for (int col = 0; col < 10; col++) {
                                    if(e.getSource() == plrfield[row][col]) {
                                        plrfield[row][col].setVisible(true);
                                        plrfield[row][col].setFocusable(true);
                                        plrfield[row][col].setOpaque(true);
                                        plrfield[row][col].setBackground(Color.BLUE);
                                        plrfield[row][col].setVisible(true);
                                    }

                                }
                            }
                        }
                    });
                }
            }
        }
        if(e.getSource() == start){

            for(int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    try {
                        if ((row == 1 && col == 1) || (row == 4 && col == 2) || (row == 5 && col == 2) || (row == 8 && col == 0) || (row == 9 && col == 3) ||
                                (row == 7 && col == 8) || (row == 7 && col == 6) || (row == 8 && col == 6) || (row == 7 && col == 2) || (row == 7 && col == 3) || (row == 4 && col == 6) ||
                                (row == 4 && col == 7) || (row == 4 && col == 8) || (row == 2 && col == 6) || (row == 2 && col == 7) || (row == 2 && col == 8) || (row == 2 && col == 4) ||
                                (row == 3 && col == 4) || (row == 4 && col == 4) || (row == 5 && col == 4))
                        {
                            botfield[row][col].setBackground(Color.GREEN);

                        }
                        else continue;
                    }
                    catch (NullPointerException pointerException){
                        System.out.println(pointerException.getMessage());
                    }
                    botfield[row][col].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton rbttn = (JButton) e.getSource();
                            for (int row = 0; row < 10; row++) {
                                for (int col = 0; col < 10; col++) {

                                    if(playerTurn(rbttn) == 20){
                                        Win wn = new Win();
                                        break;
                                    }
                                    if(botTurn() == 20){
                                        Lose ls = new Lose();
                                        break;
                                    }

                                }
                            }
                        }



                    });

                }
            }
        }
    }

    public  int playerTurn(JButton rbttn){
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (rbttn.getBackground() == Color.GREEN) {
                    rbttn.setBackground(Color.YELLOW);
                    rbttn.setVisible(true);
                    rbttn.setFocusable(true);
                    rbttn.setOpaque(true);
                    points++;
                    System.out.println("You " + points);
                    break;
                }

            }
            botTurn();
        }
        return points;
    }
    public int botTurn(){

        int br = (int) (Math.random() * (9));
        int bc = (int) (Math.random() * (9));

        for (int row = 0; row < 10; row++) {
            for(int col = 0; col < 10; col++) {
                if (row == br && col == bc && plrfield[row][col].getBackground() == Color.BLUE) {
                    bpoint++;
                    plrfield[row][col].setBackground(Color.RED);
                    plrfield[row][col].setVisible(true);
                    System.out.println("Bot " + bpoint);

                }
                break;
            }
        }

        return bpoint;
    }


}