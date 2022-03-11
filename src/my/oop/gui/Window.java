package my.oop.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window extends JFrame{
    public static int boardSize=5;
    public static int mineCount=(int) Math.round(boardSize*boardSize*.1);
    public static final int gameWidth=600, gameHeight=600;

    public static String title="Alyssa's Minesweeper Game";

    public static JFrame gameFrame=new JFrame();

    public static JPanel gameSetting=new JPanel();
    public static JPanel panel=new JPanel();

    public static Font headerLabelFont=new Font("Arial", Font.BOLD,22);
    public static Font inputLabelFont=new Font("Arial", Font.PLAIN,16);

    JLabel header=new JLabel("Welcome to Alyssa's Minesweeper!", JLabel.CENTER);

    public Handler h=new Handler();

    public Window(){
        createFrame();

        gameSetting=new JPanel();
        gameSetting.setLayout(null);

        gameSetting.setPreferredSize(new Dimension(300,300));
        gameSetting.setMaximumSize(new Dimension(300,300));
        gameSetting.setMinimumSize(new Dimension(300,300));

        header.setBounds(-10,150,600,30);
        header.setFont(headerLabelFont);

        JLabel boardInputLabel=new JLabel("Enter an integer for your board dimensions:", JLabel.CENTER);
        boardInputLabel.setBounds(-10,220,600,30);
        boardInputLabel.setFont(inputLabelFont);

        final JTextField boardInputField=new JTextField();
        boardInputField.setBounds(260,300,50,30);

        JButton submitButton=new JButton("Submit");
        submitButton.setBounds(235,370,100,30);

        gameSetting.add(header);
        gameSetting.add(boardInputLabel);
        gameSetting.add(boardInputField);
        gameSetting.add(submitButton);

        gameFrame.setContentPane(gameSetting);
        gameFrame.pack();
        gameFrame.setVisible(true);

        // Key listener to force the player to only input integers
        boardInputLabel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if((e.getKeyChar()<'0' || e.getKeyChar()>'9') || e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    e.consume();
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardSize=Integer.parseInt(boardInputField.getText());
                new Window(boardSize, h);
            }
        });
    }

    // Window for game board
    public Window(int bSize, Handler handler){
        gameSetting.setVisible(false);
        panel.setVisible(true);

        mineCount=(int) Math.round(bSize*bSize*0.1);

        // Ensures that there are mines in the field. Will definitely not make the game easy on anyone >:)s
        if(mineCount==0 || mineCount==1){
            if(bSize==3){
                mineCount=2;
            }
            else if(bSize>=4){
                mineCount=3;
            }
            else{
                mineCount=1;
            }
        }

        gameFrame.setTitle(title+"  -   Mines: "+mineCount);
        panel=new Board(new GridLayout(bSize,bSize), handler);

        gameFrame.setContentPane(panel);
    }

    public static void createFrame(){
        gameFrame=new JFrame(title);

        gameFrame.setPreferredSize(new Dimension(gameWidth,gameHeight));
        gameFrame.setMaximumSize(new Dimension(gameWidth,gameHeight));
        gameFrame.setMinimumSize(new Dimension(gameWidth,gameHeight));

        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
    }

    public static void restartGame(){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();

        gameFrame.removeAll();
        gameFrame.revalidate();
        gameFrame.repaint();
        gameFrame.dispose();
    }
}
