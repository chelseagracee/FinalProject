import java.util.Scanner;

public class Tax_Calculator {

    private static final Scanner keyboard = new Scanner(System.in);

    private static final double STINKING_RICH = 500000;
    private static final double QUITE_RICH = 200000;
    private static final double MIAMI_POOR = 100000;
    private static final double AVERAGE = 50000;
    private static final double REALISTIC = 20000;
    private static final double HIGHRATE = 0.25;
    private static final double MEDRATE = 0.10;
    private static final double LOWRATE = 0.03;


    public static void main(String[] args) {

        double amount;
        double income = 0;
        double deductions = 0;
        double taxableIncome;
        char taxGroup;
        double tax;
        double taxOwed;

        System.out.println("Enter ")



        System.out.println("WEEK 5 - LAB 4");


    }// end of the main method

    private static double computeTaxableIncome(double income, double deductions) {
        if (income >= deductions) {
            return income - deductions;
        } else {
            return 0;
        }
    } // end of the computeTaxableIncome method


    private static char chooseTaxGroup(double taxable) {
        if (taxable >= 500000) {
            return 'S';
        } else if (taxable >= 200000) {
            return 'Q';
        } else if (taxable >= 100000) {
            return 'M';
        } else if (taxable >= 50000) {
            return 'A';
        } else if (taxable >= 20000) {
            return 'R';
        } else {
            return 'P';
        }
    }// end of the chooseTaxGroup method

        private static double computeTax(double taxable, char group) {
            if (group == 'S' || group == 'Q') {
                return taxable * 0.25;
            } else if (group == 'M') {
                return taxable * 0.10;
            } else if (group == 'A' || group == 'R') {
                return taxable * 0.03;
            } else if (group == 'P') {
                return 0;
            } else {
                throw new Error("Unknown tax group!");
            }
        }// end of the computeTax method


    private static void displayTaxInfo(double tax, double deductions, double taxable, int income, int group, int taxOwed) {
    System.out.println( income = $%d.0);
    System.out.println( deductions = $%d.0);
    System.out.println( taxable = $%d.0);
    System.out.println( group = %c);
    System.out.println( taxOwed = $%.2f);
            income, deductions , taxable, group, taxOwed);
}

    }








}// end of the Tax_Calculator class
