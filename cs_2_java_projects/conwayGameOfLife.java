//Trew Smith
//EC Conway's Game of Life 
//6-14-2024 

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int [] [] universe = new int [8][8];
        System.out.println("Each cell in the first generation will have a one in __ chance of being alive(Fill in the blank):");
        int nChance = input.nextInt();
        
        universe = populateArray(universe, nChance);
        System.out.println("First Generation:");
        showUniverse(universe);
        
        
        System.out.println("How many generations would you like to see?");
        int genCount = input.nextInt();
        
        for (int count = 0; count < genCount; count +=1) {
            universe = fillNextGen(universe);
            System.out.println("Next Generation: ");
            showUniverse(universe);
        }
        
        
    }
    public static void showUniverse(int[][] universe) {
        for(int count = 0; count < 8; count += 1) {
            for(int count2 = 0; count2 < 8; count2 += 1) {
                System.out.print(universe[count][count2] + " ");
            }
            System.out.println(" ");
        }
    }
    public static int[][] populateArray(int[][] uni, int chance ) {
        for(int count = 0; count < 8; count += 1) {
            for(int count2 = 0; count2 < 8; count2 += 1) {
                int roll = ((int)(Math.random() * chance)) + 1;
                if (roll == 1) {
                    uni[count][count2] = 1;
                } else {
                    uni[count][count2] = 0;
                }
            }
        }
        return uni;
    }
    public static int[][] fillNextGen(int[][] firstGen) {
        
        //Creating an additional array for the new generation allows us to change the next gerneration without affecting the amount of alive neighbors for every cell.
        
        int [][] nextGen = new int[8][8];
        
        
        for(int count = 0; count < 8; count+= 1) {
            for (int count2 = 0; count2 < 8; count2 +=1) {
                int neighbors = 0;
                for(int num = -1; num <= 1; num +=1 ) {
                    for(int num2 = -1; num2 <= 1; num2 +=1 ) {
                        if ( ((count + num >= 0) && (count + num < 8)) && ((count2 + num2 >= 0) && (count2 + num2 < 8)) ) { //Checks to make sure it isn't checking for neighbors that are out of bounds.
                            neighbors += firstGen[count + num][count2 + num2];
                            //adds 1 if populated, else adds 0
                        }
                        
                        
                    }
                }
                neighbors -= firstGen[count][count2]; //subtracts itself from the count of neighbors
                        
                if ((firstGen[count][count2] == 1) &&(neighbors < 2)) {
                    nextGen[count][count2] = 0;
                }
                if ((firstGen[count][count2] == 1) && ((neighbors ==2) || (neighbors ==3))) {
                    nextGen[count][count2] = 1;
                }
                if ((firstGen[count][count2] == 1) &&(neighbors > 3)) {
                    nextGen[count][count2] = 0;
                }
                if ((firstGen[count][count2] == 0) &&(neighbors == 3)) {
                    nextGen[count][count2] = 1;
                }
               
            } 
            
        }
        return nextGen;
        
    }
    
}
