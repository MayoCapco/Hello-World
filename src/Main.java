import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        // Room dimensions are in meters
        double length=28;
        double width=5;
        double height=8;

        // Area of a room with 4 walls
        double FourwallsArea=2*(length+width)*height;

        // Assume that a gallon can paint 150 square meters of wall
        double squareFeetGallon=150;
        double paintNeeded=FourwallsArea/squareFeetGallon;
        System.out.println(paintNeeded+" gallons of paint is needed to cover a wall area of "+FourwallsArea+" m^2");
    }
}