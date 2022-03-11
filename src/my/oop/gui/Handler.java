package my.oop.gui;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

public class Handler extends WindowAdapter {
    private final ArrayList<Cell> currentField=new ArrayList<>();
    private final ArrayList<Cell> queue=new ArrayList<>();

    public boolean gameWin=true; // False when player clicks on a mine

    public void click(Cell c){
        int revealedCells=0;
        c.setEnabled(false);
        c.setRevealed(true);
        int position=c.getPosition();

        // 0 = Empty,
        // 1 = Mine,
        // 2 = Number of adjacent mines

        // Empty cell
        if(c.getCellType()==0){
            // Conditional checkers to check if the position that the player clicked on is a valid position
            // Then saves the position to a queue before adding the new positions and revealing them on the current field or player board
            if(position<Window.boardSize){
                if(position%Window.boardSize==0){
                    queue.add(Board.cells.get((position+Window.boardSize)));
                    queue.add(Board.cells.get((position+Window.boardSize+1)));
                    queue.add(Board.cells.get((position+1)));
                }
                else if((position%Window.boardSize)==(Window.boardSize-1)){
                    queue.add(Board.cells.get((position+Window.boardSize)));
                    queue.add(Board.cells.get((position+Window.boardSize-1)));
                    queue.add(Board.cells.get((position-1)));
                }
                else{
                    queue.add(Board.cells.get((position+Window.boardSize)));
                    queue.add(Board.cells.get((position+Window.boardSize+1)));
                    queue.add(Board.cells.get((position+Window.boardSize-1)));
                    queue.add(Board.cells.get((position+1)));
                    queue.add(Board.cells.get((position-1)));
                }
            }

            else if(position>=(Window.boardSize*(Window.boardSize-1))){
                if(position%Window.boardSize==0){
                    queue.add(Board.cells.get((position-Window.boardSize)));
                    queue.add(Board.cells.get((position-Window.boardSize+1)));
                    queue.add(Board.cells.get((position+1)));
                }
                else if((position%Window.boardSize)==(Window.boardSize-1)){
                    queue.add(Board.cells.get((position-Window.boardSize)));
                    queue.add(Board.cells.get((position-Window.boardSize-1)));
                    queue.add(Board.cells.get((position-1)));
                }
                else{
                    queue.add(Board.cells.get((position-Window.boardSize)));
                    queue.add(Board.cells.get((position-Window.boardSize+1)));
                    queue.add(Board.cells.get((position-Window.boardSize-1)));
                    queue.add(Board.cells.get((position+1)));
                    queue.add(Board.cells.get((position-1)));
                }
            }

            else if(position%Window.boardSize==0){
                queue.add(Board.cells.get((position-Window.boardSize)));
                queue.add(Board.cells.get((position+Window.boardSize)));
                queue.add(Board.cells.get((position-Window.boardSize+1)));
                queue.add(Board.cells.get((position+Window.boardSize+1)));
                queue.add(Board.cells.get((position+1)));
            }

            else if((position%Window.boardSize)==(Window.boardSize-1)){
                queue.add(Board.cells.get((position-Window.boardSize)));
                queue.add(Board.cells.get((position+Window.boardSize)));
                queue.add(Board.cells.get((position-Window.boardSize-1)));
                queue.add(Board.cells.get((position+Window.boardSize-1)));
                queue.add(Board.cells.get((position-1)));
            }
            else{
                queue.add(Board.cells.get((position-Window.boardSize)));
                queue.add(Board.cells.get((position+Window.boardSize)));
                queue.add(Board.cells.get((position-Window.boardSize-1)));
                queue.add(Board.cells.get((position+Window.boardSize-1)));
                queue.add(Board.cells.get((position-Window.boardSize+1)));
                queue.add(Board.cells.get((position+Window.boardSize+1)));
                queue.add(Board.cells.get((position-1)));
                queue.add(Board.cells.get((position+1)));
            }
        }

        // Numbered cell
        else if(c.getCellType()==2){
            int mineCount=0;

            if(position<Window.boardSize){
                if(position%Window.boardSize==0){
                    // Counts number of adjacent mines
                    if(Board.cells.get(position+Window.boardSize).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position+Window.boardSize+1).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position+1).getCellType()==1){
                        mineCount++;
                    }
                }
                else if(position%Window.boardSize==Window.boardSize-1){
                    // Counts number of adjacent mines
                    if(Board.cells.get(position+Window.boardSize).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position+Window.boardSize-1).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position-1).getCellType()==1){
                        mineCount++;
                    }
                }
                else{
                    // Counts number of adjacent mines
                    if(Board.cells.get(position+Window.boardSize).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position+Window.boardSize+1).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position+Window.boardSize-1).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position+1).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position-1).getCellType()==1){
                        mineCount++;
                    }
                }
            }

            else if(position>=(Window.boardSize*(Window.boardSize-1))){
                if(position%Window.boardSize==0){
                    // Counts number of adjacent mines
                    if(Board.cells.get(position-Window.boardSize).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position-Window.boardSize+1).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position+1).getCellType()==1){
                        mineCount++;
                    }
                }
                else if(position%Window.boardSize==Window.boardSize-1){
                    // Counts number of adjacent mines
                    if(Board.cells.get(position-Window.boardSize).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position-Window.boardSize-1).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position-1).getCellType()==1){
                        mineCount++;
                    }
                }
                else{
                    // Counts number of adjacent mines
                    if(Board.cells.get(position-Window.boardSize).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position-Window.boardSize+1).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position-Window.boardSize-1).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position+1).getCellType()==1){
                        mineCount++;
                    }
                    if(Board.cells.get(position-1).getCellType()==1){
                        mineCount++;
                    }
                }
            }

            else if(position%Window.boardSize==0){
                // Counts number of adjacent mines
                if(Board.cells.get(position-Window.boardSize).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position+Window.boardSize).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position-Window.boardSize+1).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position+Window.boardSize+1).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position+1).getCellType()==1){
                    mineCount++;
                }
            }

            else if((position%Window.boardSize)==(Window.boardSize-1)){
                // Counts number of adjacent mines
                if(Board.cells.get(position-Window.boardSize).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position+Window.boardSize).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position-Window.boardSize-1).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position+Window.boardSize-1).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position-1).getCellType()==1){
                    mineCount++;
                }
            }

            else{
                // Counts number of adjacent mines
                if(Board.cells.get(position-Window.boardSize).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position+Window.boardSize).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position-Window.boardSize+1).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position+Window.boardSize+1).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position-Window.boardSize-1).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position+Window.boardSize-1).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position-1).getCellType()==1){
                    mineCount++;
                }
                if(Board.cells.get(position+1).getCellType()==1){
                    mineCount++;
                }
            }
            c.setText(String.valueOf(mineCount));
        }

        // Mine cell
        else if(c.getCellType()==1){
            for(int i=0;i<Board.cells.size();i++){
                Board.cells.get(i).setEnabled(false);
                Board.cells.get(i).setText("");
                if(Board.cells.get(i).getCellType()==1){
                    Board.cells.get(i).setText("B");
                }
            }
            c.setText("L");
            gameWin=false;
        }

        // Reveals the discovered cells and puts them on the current field that the user has
        for(int i=0;i<queue.size();i++){
            if(!queue.get(i).revealed()){
                currentField.add(queue.get(i));
                queue.get(i).setRevealed(true);
            }
        }
        queue.clear();

        // Removes whatever positions have been saved prior to button click to reveal the position
        while(!currentField.isEmpty()){
            Cell t=currentField.get(0);
            currentField.remove(0);
            t.clickButton();
        }

        for(int i=0;i<Board.cells.size();i++){
            if(Board.cells.get(i).revealed()){
                revealedCells++;
            }
        }

        if(revealedCells==(Board.cells.size()-Window.mineCount)){
            for(int i=0;i<Board.cells.size();i++){
                if(Board.cells.get(i).getCellType()==1){
                    Board.cells.get(i).setEnabled(false);
                    Board.cells.get(i).setText("B");
                }
                else{
                    Board.cells.get(i).setEnabled(false);
                }
            }

            if(gameWin){
                gameEnd(gameWin);
            }
        }

        // Confirm dialog to ask the user if they wish to restart or not if they have stepped on the mine
        if(!gameWin){
            gameEnd(gameWin);
        }
    }

    public void gameEnd(boolean result){
        int a;

        if(result==true){
            a=JOptionPane.showConfirmDialog(null, "YOU WIN!\nDo you want to play again?", "WINNER", JOptionPane.YES_NO_OPTION);
        }
        else{
            a=JOptionPane.showConfirmDialog(null,"YOU LOSE!\nDo you want to play again?","LOSER", JOptionPane.YES_NO_OPTION);
        }

        if(a==JOptionPane.YES_OPTION){
            Window.restartGame();

            // Removes all recorded cells and player moves to avoid it being carried over to the next board
            Board.cells.clear();
            currentField.clear();
            queue.clear();

            // Initializes a new game
            new Minesweeper();
        }
        else if(a==JOptionPane.NO_OPTION){
            System.exit(0);
        }
    }
}
