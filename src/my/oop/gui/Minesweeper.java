package my.oop.gui;

import javax.swing.*;

import static my.oop.gui.Window.createFrame;

public class Minesweeper {

    public Window window;

    public Minesweeper(){
        new Window();
    }

    public static void main(String[] args)throws Exception{
        try{
            // Works similar to a theme. Using the Windows 10 look and Feel to better connect with the player.
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        }
        catch(Exception e){
        }
        JFrame.setDefaultLookAndFeelDecorated(true);

        new Minesweeper();
    }
}
