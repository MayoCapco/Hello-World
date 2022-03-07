package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Conditions {
    public static void main(String[] args){
        try(BufferedReader in=new BufferedReader(new InputStreamReader(System.in))){
            boolean running=true;

            while(running){
                System.out.print("Enter value for x: ");
                int x=Integer.parseInt(in.readLine());
                System.out.print("Enter value for y: ");
                int y=Integer.parseInt(in.readLine());

                // Condition checker
                if(x==y){
                    System.out.println(1);
                }
                else if(x>y){
                    System.out.println(2);
                }
                else{
                    System.out.println(3);
                }

                // Condition to continue running program
                System.out.println("==============================================");
                System.out.println("Do you wish to quit? \nPress [Q] to quit. Otherwise press any other key to continue.");
                String choice=in.readLine();
                System.out.println("==============================================");
                if(choice.equalsIgnoreCase("Q")){
                    System.out.println();
                    System.out.println("Come again!");
                    running=false;
                }
            }

        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
}
