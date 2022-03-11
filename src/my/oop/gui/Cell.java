package my.oop.gui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JButton {
    private int type;
    private int position;
    private boolean revealed;

    private Handler handler;

    public Cell(int t,int p,boolean r,Handler h){
        this.type=t;
        this.position=p;
        this.revealed=r;
        this.handler=h;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickButton();
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    public void clickButton() {
        handler.click(this);
    }

    public int getCellType() {
        // 0 = Empty, 1 = Mine, 2 = Number of adjacent mines
        return type;
    }

    public int getPosition() {
        return position;
    }

    public boolean revealed() {
        return revealed;
    }

    public void setRevealed(boolean in) {
        this.revealed=in;
    }
}
