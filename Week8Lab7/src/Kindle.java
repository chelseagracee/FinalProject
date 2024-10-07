import java.util.Scanner;

public class Kindle {

    private static final Scanner keyboard = new Scanner(System.in);
    private int totalPages;
    private int currentPage;

    public Kindle(int theTotalPages) {

        totalPages = theTotalPages;
        currentPage = 1;


    }// end of the constructor with 1 parameter

    public String toString(){

        return String.format("Page " + currentPage + " out of " + totalPages);

    }

    public void turnPages(){
        turnPages( 1);
    }

    public void turnPages(int pagesToTurn) {
        if (currentPage + pagesToTurn > totalPages) {
            System.out.println("You were on                :" + toString());
            System.out.println("Turning 8 pages would take you past the last page.");
            currentPage = totalPages;
        } else {
            currentPage += pagesToTurn;
        }
    }
        public static void main(String[] args){

            Kindle aBook;
            int numberOfPages;

//----Get person information
            System.out.print("How many pages in the book : ");
            numberOfPages = keyboard.nextInt();

//----Create object
            aBook = new Kindle(numberOfPages);
            System.out.print("Initially                  : ");
            System.out.println(aBook);

//----Do some reading
            aBook.turnPages();
            aBook.turnPages();
            aBook.turnPages();
            aBook.turnPages();
            System.out.print("A bit later                : ");
            System.out.println(aBook);

//----Skip ahead
            aBook.turnPages(27);
            System.out.print("After skipping 27 pages    : ");
            System.out.println(aBook);

//----Try skip past the end of the book
            aBook.turnPages(8);
        }

}// end of the Kindle class

