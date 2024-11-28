import java.util.Scanner;

public class Diamond {

    private int carats;
    private double value;

    public String toString() {
        return carats + " carats, worth $" + value;
    }


    public Diamond(int carats, double value) {
        this.carats = carats;
        this.value = value;
    }

    public int getCarats() {
        return carats;
    }

    public double getValue() {
        return value;
    }

}

class Girl {

    private String name;
    private Diamond diamond;

    public Girl(String name) {
        this.name = name;
        this.diamond = null;
    }

    public String getName() {
        return name;
    }

    public boolean acceptDiamond(Diamond newDiamond) {
        if (diamond == null || newDiamond.getValue() > diamond.getValue()) {
            diamond = newDiamond;
            return true;
        }
        return false;
    }

    public String getDiamondInfo() {
        return (diamond != null) ? "a diamond, " + diamond.toString() : "no best friend";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the girl: ");
        String name = scanner.nextLine();
        Girl girl = new Girl(name);

        while (true) {
            System.out.println(girl.getName() + " has " + girl.getDiamondInfo());

            System.out.print("Enter carats and value     : ");
            int carats = scanner.nextInt();
            double value = scanner.nextDouble();

            if (carats == 0) break;

            Diamond newDiamond = new Diamond(carats, value);
            boolean accepted = girl.acceptDiamond(newDiamond);

            if (accepted) {
                System.out.println("Woohoo, the girl took the diamond");
            } else {
                System.out.println("Aaargh, the diamond was rejected");
            }
        }

        System.out.println("\n" + girl.getName() + " has " + girl.getDiamondInfo());
        scanner.close();
    }
}