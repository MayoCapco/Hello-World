package my.oop.text;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws Exception{
        // Using try-with resources to automatically close BufferedReader when user quits the game
        try(BufferedReader in=new BufferedReader(new InputStreamReader(System.in))){
            // https://www.instructables.com/How-to-play-minesweeper/
            // https://minesweepergame.com/strategy.php
            System.out.println();
            System.out.println("Welcome to Alyssa's Scuffed Minesweeper! I don't personally know how this game plays but after reading some articles I kinda get it.");
            System.out.println("NOTE: If there's any mistakes here then blame Abu for making me do this :)");

            // Initializes the board with default values
            Minesweeper game=new Minesweeper();
            boolean incorrect_input=true;
            int board_width=5;
            int board_height=5;
            int numberOfMines=5;

            System.out.print("Enter the board dimension (Inputs should be formatted as 'x y' indicating the number of columns and rows): ");
            String input=in.readLine();
            while(incorrect_input){
                try{
                    String[] dimensions=input.split(" ");

                    board_width=Integer.parseInt(dimensions[0]);
                    board_height=Integer.parseInt(dimensions[1]);

                    incorrect_input=false;
                }
                catch(Exception e){
                    System.out.print("Error: Invalid coordinates provided. Please enter two valid integers separated by a space: ");
                    input=in.readLine();
                }
            }

            incorrect_input=true;
            System.out.print("Enter the number of mines (more mines = higher difficulty): ");
            input=in.readLine();
            while(incorrect_input){
                try{
                    numberOfMines=Integer.parseInt(input);
                    incorrect_input=false;
                }
                catch(NumberFormatException e){
                    System.out.print("Error: Invalid number provided. Please enter a valid integer for the number of mines on the board: ");
                    input=in.readLine();
                }
            }

            // Initializes the board with user defined values
            game=new Minesweeper(board_width,board_height,numberOfMines);

            game.displayBoard();

            int x;
            int y;

            System.out.println("Inputs should be formatted this way: 'x y' which are the horizontal and vertical coordinates.");
            while(!game.getGameStatus()){
                System.out.print("Enter coordinates: ");
                String coord=in.readLine();
                boolean input_check=true;
                do{
                    try{
                        String[] coordinates=coord.split(" ");

                        x=Integer.parseInt(coordinates[0]);
                        y=Integer.parseInt(coordinates[1]);

                        // Condition checking if user inputted a coordinate thats not located within the board dimensions.
                        if(x>board_width || y>board_height){
                            System.out.print("Error: Coordinates provided cannot be found within the board. Please enter another coordinate: ");
                            coord=in.readLine();
                        }

                        else if(x<0 || y<0){
                            System.out.print("Error: Coordinates provided cannot be found within the board. Please enter another coordinate: ");
                            coord=in.readLine();
                        }

                        else{
                            game.uncoverPosition(x,y);
                            game.displayBoard();
                            input_check=false;
                        }
                    }
                    catch(Exception e){
                        System.out.print("Error: Invalid coordinates provided. Please enter two valid integers separated by a space: ");
                        coord=in.readLine();
                    }
                }while(input_check);
            }

            game.getGameResult();

            System.out.println("GAME OVER. THANK YOU FOR PLAYING!");
        }
        catch(Exception e){
            System.out.println("Error: Something went wrong.");
            e.printStackTrace();
        }
    }
}
