package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception{
        // Using try-with resources to automatically close the BufferedReader after executing code blocks
        try(BufferedReader in=new BufferedReader(new InputStreamReader(System.in))){
            boolean running=true;
            boolean choice=true;

            System.out.print("Welcome to my Painter Calculator!");

            // Using while to keep the code running till user wants to quit at the end
            while(running){
                choice=true;

                System.out.println();
                System.out.println("===============================");
                System.out.print("How many walls do you wish to paint? ");
                int numOfWalls=0;

                // Using while loop to continue to ask the user to enter a numeric value
                while(choice){
                    String input=in.readLine();

                    try{
                        numOfWalls=Integer.parseInt(input);
                        choice=false;
                    }
                    catch(NumberFormatException e){
                        System.out.print("Enter a valid numerical input: ");
                    }
                }

                choice=true;

                HashMap<Integer, Double> wallAreas=new HashMap<>();

                for(int i=0; i<numOfWalls; i++){
                    double length=0;
                    double width=0;
                    double height=0;

                    // Room dimensions are in feet
                    ////////////////////////////////////////////////////////////////

                    System.out.println();
                    System.out.print("Enter length of wall "+(i+1)+" in feet: ");
                    while(choice){
                        String input=in.readLine();
                        try{
                            length=Double.parseDouble(input);
                            choice=false;
                        }
                        catch(NumberFormatException e){
                            System.out.print("Enter a valid numerical input: ");
                        }
                    }

                    choice=true;

                    ////////////////////////////////////////////////////////////////

                    System.out.print("Enter width of wall "+(i+1)+" in feet: ");
                    while(choice){
                        String input=in.readLine();
                        try{
                            width=Double.parseDouble(input);
                            choice=false;
                        }
                        catch(NumberFormatException e){
                            System.out.print("Enter a valid numerical input: ");
                        }
                    }

                    choice=true;

                    ////////////////////////////////////////////////////////////////

                    System.out.print("Enter height of wall "+(i+1)+" in feet: ");
                    while(choice){
                        String input=in.readLine();
                        try{
                            height=Double.parseDouble(input);
                            choice=false;
                        }
                        catch(NumberFormatException e){
                            System.out.print("Enter a valid numerical input: ");
                        }
                    }

                    choice=true;

                    // Surface area of wall
                    // Refer to this link: https://www.teachoo.com/9374/2122/Ex-11.3--5/category/Ex-11.3/
                    double surfaceAreaWall=2*((length*width)+(width*height)+(height*length));

                    wallAreas.put(i+1, surfaceAreaWall);
                }

                // Assume that a gallon of paint can paint 400 square feet of wall
                // 1:400 ratio
                double gallonPerSquareFeet=400;

                System.out.println();
                System.out.print("How many gallons of paint do you have? ");
                double paintgallons=0;
                while(choice){
                    String input=in.readLine();
                    try{
                        paintgallons=Double.parseDouble(input);
                        choice=false;
                    }
                    catch(NumberFormatException e){
                        System.out.print("Enter a valid numerical input: ");
                    }
                }

                choice=true;

                double paintSquareFeetCoverage=paintgallons*gallonPerSquareFeet;
                double totalArea=0;

                for(Double x: wallAreas.values()){
                    totalArea+=x;
                }

                double paintNeeded=totalArea/paintSquareFeetCoverage;

                System.out.println();
                System.out.println("===============================");
                System.out.println();
                if(paintNeeded>paintgallons){
                    double additionalpaint=paintNeeded-paintgallons;

                    System.out.println(paintNeeded +" gallons of paint is needed to cover "+wallAreas.size()+" wall/s with a total wall area of "+totalArea+" ft^2");
                    System.out.println("You need an addtional "+Math.abs(Math.round(additionalpaint*100.0)/100.0)+" gallon/s of paint");
                }
                else if(paintNeeded==paintgallons){
                    System.out.println("Your "+paintgallons+" gallon/s of paint is enough to cover " +wallAreas.size()+" wall/s with a total wall area of "+totalArea+" ft^2");
                }
                else{
                    System.out.println(Math.round(paintNeeded*100.0)/100.0 +" gallons of paint is needed to cover "+wallAreas.size()+" wall/s with a total wall area of "+totalArea+" ft^2 from "+paintgallons+" gallon/s of paint");
                }

                System.out.println();
                int i=0;

                for(Double x: wallAreas.values()){
                    i+=1;
                    System.out.println("Area of wall "+i+" is "+x+" ft^2");
                }

                System.out.println();
                System.out.println("===============================");
                System.out.println();
                System.out.println("Do you wish to continue?\nPress [Q] to quit       Press [Y] to continue");
                System.out.print("choice: ");

                while(choice){
                    String input=in.readLine();

                    switch(input){
                        case "Q": case "q":
                            running=false;
                            choice=false;
                            System.out.println();
                            System.out.print("Thank you! Please come again.");
                            break;

                        case "Y": case "y":
                            choice=false;
                            break;

                        default:
                            System.out.print("Please input a valid option: ");
                            break;
                    }
                }
            }
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
}
