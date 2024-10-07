import java.util.Scanner;

public class DurbanCityCouncil {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Week 7 - Lab 6");
        System.out.print("How many houses in the street?");
        int numberOfHouses = keyboard.nextInt();

        int[] houseNumbers = new int[numberOfHouses];
        int index;
        for (index = 0; index < houseNumbers.length; index++) {
            for (index = 0; index < houseNumbers.length; index++) {

                System.out.print("What is the next house number? ");
                houseNumbers[index] = keyboard.nextInt();

            } // end of the for loop

            int[][] houseAges = new int[numberOfHouses][];

            //Update Array
            int rowIndex;
            int colIndex;

            for (rowIndex = 0; rowIndex < houseAges.length; rowIndex++) {

                System.out.print("How many people live in " + houseNumbers[rowIndex] + ":");
                int peopleInHouse = keyboard.nextInt();
                houseAges[rowIndex] = new int[peopleInHouse];

                for (colIndex = 0; colIndex < houseAges[rowIndex].length; colIndex++) {

                    System.out.print("What is the age of person" + (colIndex + 1)+ ": ");
                    houseAges[rowIndex][colIndex] = keyboard.nextInt();

                } // end of the inner for loop -> column

            }// end of the outer for loop -> row

            //COUNTING


            for (rowIndex = 0; rowIndex < houseAges.length; rowIndex++) {
                int totalAge = 0;


                for (colIndex = 0; colIndex < houseAges[rowIndex].length; colIndex++) {

                    totalAge = totalAge + houseAges[rowIndex][colIndex];

                } // end of the inner loop -> column

                System.out.println("House" + (houseNumbers[rowIndex]) + "has a total age of" + totalAge);

            }// end of the inner for loop -> row

        }
    }
}