package my.oop.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    private int gameBound=Window.boardSize*Window.boardSize;
    private boolean picked=false;
    private ArrayList<Integer> mines=new ArrayList<>();
    public static ArrayList<Cell> cells=new ArrayList<Cell>();

    public Board(GridLayout layout,Handler h){
        super(layout);
        createCells(h);
        addCells();
    }

    private void addCells(){
        for(int i=0;i<cells.size();i++) {
            add(cells.get(i));
        }
    }

    // Populates the board with the cells
    public void createCells(Handler h){
        for(int i=1;i<=Window.mineCount;i++){
            while(!picked){
                int position=(int) (Math.random()*gameBound);
                if(!mines.contains(position)){
                    mines.add(position);
                    picked=true;
                }
            }
            picked=false;
        }

        for(int i=0;i<gameBound;i++){
            if(mines.contains(i)){
                cells.add(new Cell(1,i,false,h));
            }

            else if((i%Window.boardSize)==0){
                if(mines.contains(i-Window.boardSize) || mines.contains(i-Window.boardSize+1) || mines.contains(i+1)
                        || mines.contains(i+Window.boardSize) || mines.contains(i+Window.boardSize+1)){
                    cells.add(new Cell(2,i,false,h));
                }
                else{
                    cells.add(new Cell(0,i,false,h));
                }
            }

            else if((i%Window.boardSize)==(Window.boardSize-1)){
                if(mines.contains(i-Window.boardSize-1) || mines.contains(i-Window.boardSize) || mines.contains(i-1)
                        || mines.contains(i+Window.boardSize-1) || mines.contains(i+Window.boardSize)){
                    cells.add(new Cell(2,i,false,h));
                }
                else{
                    cells.add(new Cell(0,i,false,h));
                }
            }

            else{
                if( mines.contains(i-Window.boardSize) || mines.contains(i-Window.boardSize-1) || mines.contains(i-Window.boardSize+1) || mines.contains(i-1) ||
                    mines.contains(i+1) || mines.contains(i+Window.boardSize) || mines.contains(i+Window.boardSize-1) || mines.contains(i+Window.boardSize+1)){
                    cells.add(new Cell(2,i,false,h));
                }
                else{
                    cells.add(new Cell(0,i,false,h));
                }
            }
        }
    }
}
