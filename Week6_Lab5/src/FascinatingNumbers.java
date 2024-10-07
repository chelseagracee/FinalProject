import java.util.Scanner;

public class FascinatingNumbers {

    public static void main(String[] args){

        System.out.println("WEEK 6 - LAB 5");
        int[] numbers = new int[10];
        int count = getNumbers(numbers);

        for (int i = 0; i < count; i++) {
            int number = numbers[i];
            boolean isFibonacci = isFibonacci(number);
            boolean isPrime = isPrime(number);

            System.out.print(number + " is ");
            if (isFibonacci && isPrime) {
                System.out.print(" is Fibonacci and is prime");
            } else if (isFibonacci) {
                System.out.print("Fibonacci and is not prime");
            } else if (isPrime) {
                System.out.print("not Fibonacci and is prime");
            } else {
                System.out.print("not Fibonacci and not prime");
            }
        }
    }// end of the main method


    private static boolean isPrime(int candidate) {

        int divisor = 2;

        while (divisor <= Math.sqrt(candidate)) {
            if (candidate % divisor == 0) {

                return(false);
            }
            divisor++;
        }
        return(true);
    }// end of isPrime method

    private static boolean isFibonacci(int candidate) {

        int previous = 1;
        int current = 0;
        int next;

        while (current < candidate) {
            next = current + previous;
            previous = current;
            current = next;
        }

        if (current == candidate) {
            return (true);

        } else return (false);
    }

        public static int getNumbers(int[] numbers){
            Scanner keyboard = new Scanner(System.in);
            int numCount = 0;
            int userInput;

            System.out.print("Please enter numbers (0 to stop): ");

            do {
                userInput = keyboard.nextInt();

                if (userInput > 0) {
                    numbers[numCount] = userInput;
                    numCount++;
                }
            } while (userInput != 0 && numCount < 10);

            return numCount;


    }
}
