import java.util.Scanner;

public class Practice {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] arg) {

        System.out.println("Pratice Arrrays");

        System.out.println("How many elements if the array do you want?");
        int arraySize = keyboard.nextInt();

        //Declaring an Array
        int[] myArray = new int[arraySize];

        //Declaring 2D Array
        int[][] yourArray = new int[3][2];

        //Update Array
        int rowIndex;
        int colIndex;

        for(rowIndex = 0; rowIndex < yourArray.length; rowIndex++){

            for(colIndex = 0; colIndex < yourArray[rowIndex].length; colIndex++){

                    System.out.println("At index[" + rowIndex + "][" + colIndex + "]: Enter a number ");
                    yourArray[rowIndex][colIndex] = keyboard.nextInt();

            } // end of the inner for loop -> column
        }// end of the outer for loop -> row


        //DISPLAY

        System.out.println("DISPLAYING THE RESULT.....");

        for(rowIndex = 0; rowIndex < yourArray.length; rowIndex++){

            for(colIndex = 0; colIndex < yourArray[rowIndex].length; colIndex++){

                System.out.println("At index[" + rowIndex + "][" + colIndex + "]: The value is:  ");

            } // end of the inner for loop -> column
        }// end of the outer for loop -> row
        // Updating the array
        int index;

        for (index = 0; index < myArray.length; index++); {

        System.out.println("At index [" + index + "], Enter a number: ");
        myArray[index] = keyboard.nextInt();

    }// end of the for loop

 // display the array

        for (index = 0; index < myArray.length; index++) {

        System.out.println("At index [" + index + "], Enter a number: ");
    }

} // end of the main method

    private static void updateMyArray(int [] myArray){

        // Updating the array
        int index;

        for (index = 0; index < myArray.length; index++); {

            System.out.println("At index [" + index + "], Enter a number: ");
            myArray[index] = keyboard.nextInt();

        }// end of the for loop

    }

} // end of the practice class
