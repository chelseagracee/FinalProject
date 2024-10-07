import java.util.Scanner;

public class Nitrox_Scuba {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final int FEET_PER_ATMOSPHERE = 33;
    private static final double MAX_PARTIAL_PRESSURE= 1.4;
    private static final double CONTINGENCY_MAX_PRESSURE = 1.6;

    public static void main(String[] args) {

        System.out.println("WEEK 4 - LAB 3");
        double ambientPressure;
        double  o2Pressure;
        int depth;
        int percentageO2;
        char o2Group;
        boolean exceedsMaxPressure;
        boolean exceedsContingencyPressure;

        System.out.print("Enter depth and pressure 02; ");
        depth = keyboard.nextInt();
        percentageO2 = keyboard.nextInt();

        ambientPressure = (double) depth / FEET_PER_ATMOSPHERE + 1;

        o2Pressure = ambientPressure * (double) percentageO2 / 100;

        o2Group = (char)((int)(o2Pressure * 10)+(int)'A');

        exceedsMaxPressure = o2Pressure > MAX_PARTIAL_PRESSURE;
        exceedsContingencyPressure = o2Pressure > CONTINGENCY_MAX_PRESSURE;

        System.out.printf("Ambient pressure: %.1f%n", ambientPressure);
        System.out.printf("O2 pressure: %.2f%n", o2Pressure );
        System.out.printf("O2 group: %c%n", o2Group);
        System.out.printf("Exceeds maximal O2 pressure: %b%n", exceedsMaxPressure);
        System.out.printf("Exceeds contingency O2 pressure: %b%n", exceedsContingencyPressure);



    }// end of the main method




}// end of the Nitrox_Scuba class
