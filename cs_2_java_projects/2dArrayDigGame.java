// Trew Smith
//2D Arrays Dig Program
//5-24-24
import java.util.Scanner;
public class Main
{
    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("How many rows would you like in your array?");
        int rows = input.nextInt();
        System.out.println("How many columns would you like in your array?");
        int columns = input.nextInt();
        int grid [][] = new int[rows][columns];
        boolean treasureFound = false;
        int chance = grid.length * grid[0].length;
        System.out.println("chance" + chance);
        System.out.println("Select one of the following");
        System.out.println("1 - Fill Grid");
        System.out.println("2 - Show Grid (For testing)");
        System.out.println("3 - Dig (The user will enter a row and column to dig for treasure)");
        System.out.println("-1 - Quit");
        int choice = input.nextInt();
        while ((treasureFound!= true) && (choice != -1))
        {
            if (choice == 1)
            {
                for(int rowNum = 0; rowNum < grid.length; rowNum +=1) {
                    for(int colNum = 0; colNum < grid[rowNum].length; colNum += 1) {
                        grid[rowNum][colNum] = fillSquare(chance);
                    }
                }
            } else if (choice == 2)
            {
                for(int rowNum = 0; rowNum < grid.length; rowNum +=1) {
                    for(int colNum = 0; colNum < grid[rowNum].length; colNum += 1) {
                        System.out.print(grid[rowNum][colNum] + " ");
                    }
                    System.out.println(" ");
                }
            } else if (choice == 3)
            {
                System.out.println("Time to guess! Enter what row your guess is on.");
                int rowGuess = input.nextInt();
                System.out.println("Time to guess! Enter what column your guess is on.");
                int columnGuess = input.nextInt();
                if(grid[rowGuess - 1][columnGuess - 1] == 1) {
                    System.out.println("You found treasure!");
                    treasureFound = true;
                }
                else {
                    System.out.println("No treasure there.");
                    treasureFound = false;
                }
            }
            if (treasureFound == false) {
                System.out.println("Select one of the following");
                System.out.println("1 - Fill Grid");
                System.out.println("2 - Show Grid (For testing)");
                System.out.println("3 - Dig (The user will enter a row and column to dig for treasure)");
                System.out.println("-1 - Quit");
                choice = input.nextInt();
            }
            else {
                System.out.println("");
            }
            
        }
        
    }
    public static int fillSquare(int chance) {
        int randNum = (int)((Math.random() * chance) + 1);
        if (randNum == 9) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
