package my.oop.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Tutorial:
https://www.youtube.com/watch?v=aIdIXsi1qTU


 */
public class MainFrame extends JFrame{
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JButton btSubmit;
    private JButton btClear;
    private JPanel mainPanel;
    private JLabel lbWelcome;

    public MainFrame(){
        setContentPane(mainPanel);
        setTitle("Welcome");
        setSize(450,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        btSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname=tfFirstName.getText();
                String lastname=tfLastName.getText();
                lbWelcome.setText("Welcome "+firstname+" "+lastname);
            }
        });

        btClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfFirstName.setText("");
                tfLastName.setText("");
                lbWelcome.setText("");
            }
        });
    }

    public static void main(String[] args){
        MainFrame myFrame=new MainFrame();
    }
}
