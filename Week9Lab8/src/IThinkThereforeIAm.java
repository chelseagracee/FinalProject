import java.util.Scanner;

public class IThinkThereforeIAm {
    public static Scanner keyboard = new Scanner(System.in);

   public static void main(String[] args) {

       System.out.println("WEEK 9 - LAB 8");

       String qualities = "The qualities are ";

       System.out.println("Please enter sentences, . to end.");

       String input = keyboard.nextLine();

       while (!input.equals(".")) {

           if (input.startsWith("I am ")) {
               qualities = qualities + input.substring(5) + ", ";
           }

           input = keyboard.nextLine();

       }

       System.out.println(qualities);
   }
} // end of the IThinkThereforeIAm class
