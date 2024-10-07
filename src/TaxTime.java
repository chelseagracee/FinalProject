import java.util.Scanner;


public class TaxTime {
    private int income = 0;
    private int deduction = 0;

    private void getInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput = -1;

        do {
            System.out.print("Enter next amount  : ");
            userInput = scanner.nextInt();

            if (userInput > 0) {
                income += userInput;
            } else {
                deduction += Math.abs(userInput);
            }
        } while(userInput != 0);
    };

    private int computeTaxableIncome() {
        if (income >= deduction) {
            return income - deduction;
        } else {
            return 0;
        }
    };

    private char computeTaxGroup(int taxableIncome) {
        if (taxableIncome >= 500000) {
            return 'S';
        } else if (taxableIncome >= 200000) {
            return 'Q';
        } else if (taxableIncome >= 100000) {
            return 'M';
        } else if (taxableIncome >= 50000) {
            return 'A';
        } else if (taxableIncome >= 20000) {
            return 'R';
        } else {
            return 'P';
        }
    };

    private double computeTax(int taxGroup, int taxableIncome) {
        if (taxGroup == 'S' || taxGroup == 'Q') {
            return taxableIncome * 0.25;
        } else if (taxGroup == 'M') {
            return taxableIncome * 0.10;
        } else if (taxGroup == 'A' || taxGroup == 'R') {
            return taxableIncome * 0.03;
        } else if (taxGroup == 'P') {
            return 0;
        } else {
            throw new Error("Unknown tax group!");
        }
    };

    private void displayTaxInfo(double tax, int taxableIncome, int taxGroup) {
        System.out.printf(
                """
                        
                        Income         = $%d.0
                        Deductions     = $%d.0
                        Taxable income = $%d.0
                        Tax group      = %c
                        Tax owed       = $%.2f
                        """,
                income, deduction, taxableIncome, taxGroup, tax);
    }

    public static void main(String[] args) {
        TaxTime taxTime = new TaxTime();

        taxTime.getInput();

        int taxableIncome = taxTime.computeTaxableIncome();

        char taxGroup = taxTime.computeTaxGroup(taxableIncome);

        double tax = taxTime.computeTax(taxGroup, taxableIncome);

        taxTime.displayTaxInfo(tax, taxableIncome, taxGroup);
    }

}

