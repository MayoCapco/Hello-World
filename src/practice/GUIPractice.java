package practice;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Practice and test code for GUI functions

/* Links for references:
https://www.guru99.com/java-swing-gui.html
https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html
https://www.javatpoint.com/java-swing
https://www.informit.com/articles/article.aspx?p=2995363

https://www.youtube.com/watch?v=lwt3SJRuHGw
https://www.youtube.com/playlist?list=PL_QPQmz5C6WUMB0xEMZosWbyQo_Kil0Fb

 */

public class GUIPractice extends JFrame {
    public GUIPractice(){
        super("Alyssa's Minesweeper");
        setSize(300,700);
        super.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // formats the board into a 2 column layout
        JPanel panel=new JPanel(new GridLayout(0,3));
        JTextField count=new JTextField(100);
        ArrayList<JButton> buttons=new ArrayList<>();

        for(int i=0;i<4;i++){
            buttons.add(new JButton(String.valueOf(i)));
        }

        for(JButton x: buttons){
            panel.add(x);
        }

        add(panel);

        setVisible(true);
    }

    private static void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        setLookAndFeel();
        GUIPractice sf=new GUIPractice();
    }
}
