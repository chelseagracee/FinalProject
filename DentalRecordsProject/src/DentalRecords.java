import java.util.Scanner;

public class DentalRecords {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int familyCount = 0;
        String[] familyNames = new String[6];
        char[][][] teethData = new char[6][2][8]; // 6 members, 2 rows (uppers/lowers), 8 teeth each

        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");
        familyCount = getFamilyCount(scnr);

        for (int i = 0; i < familyCount; i++) {
            getFamilyMemberData(scnr, familyNames, teethData, i);
        }

        while (true) {
            System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it          : ");
            String option = scnr.next().toUpperCase();
            switch (option) {
                case "P":
                    printTeethRecord(familyNames, teethData, familyCount);
                    break;
                case "E":
                    extractTooth(scnr, familyNames, teethData, familyCount);
                    break;
                case "R":
                    reportRootCanals(teethData, familyCount);
                    break;
                case "X":
                    System.out.println("\nExiting the Floridian Tooth Records :-)");
                    scnr.close();
                    return;
                default:
                    System.out.println("Invalid menu option, try again.");
            }
        }
    }

    static int getFamilyCount(Scanner scnr) {
        int familyCount;

        System.out.print("Please enter number of people in the family : ");
        familyCount = scnr.nextInt();

        while (familyCount < 1 || familyCount > 6) {
            System.out.print("Invalid number of people, try again         : ");
            familyCount = scnr.nextInt();
        }

        return familyCount;
    }

    static void getFamilyMemberData(Scanner scnr, String[] familyNames, char[][][] familyTeeth, int memberIndex) {
        System.out.print("Please enter the name for family member " + (memberIndex + 1) + "   : ");
        familyNames[memberIndex] = scnr.next();

        familyTeeth[memberIndex][0] = getTeeth(scnr, familyNames[memberIndex], "uppers");
        familyTeeth[memberIndex][1] = getTeeth(scnr, familyNames[memberIndex], "lowers");
    }

    static char[] getTeeth(Scanner scnr, String name, String layer) {
        String input;
        char[] teethArray;

        System.out.print("Please enter the " + layer + " for " + name + "       : ");

        while (true) {
            input = scnr.next().toUpperCase();  // Read input and convert to uppercase

            if (input.length() > 8) {
                System.out.print("Too many teeth, try again                   : ");
            } else if (!input.matches("[IBM]*")) {
                System.out.print("Invalid teeth types, try again              : ");
            } else {
                teethArray = input.toUpperCase().toCharArray(); // Store teeth as uppercase
                return teethArray;
            }
        }
    }

    static void printTeethRecord(String[] familyNames, char[][][] familyTeeth, int familyCount) {
        System.out.println();
        for (int i = 0; i < familyCount; ++i) {
            System.out.println(familyNames[i]);
            System.out.print("  Uppers:  ");
            printTeeth(familyTeeth[i][0]);
            System.out.print("  Lowers:  ");
            printTeeth(familyTeeth[i][1]);
            System.out.println();
        }
    }

    static void printTeeth(char[] teeth) {
        for (int j = 0; j < teeth.length; ++j) {
            System.out.print((j + 1) + ":" + teeth[j] + " ");
        }
        System.out.println();
    }

    static void extractTooth(Scanner scnr, String[] familyNames, char[][][] familyTeeth, int familyCount) {
        System.out.print("Which family member                         : ");
        String memberName = scnr.next().trim();
        int memberIndex = getMemberIndex(familyNames, memberName, familyCount);

        if (memberIndex == -1) {
            System.out.print("Invalid family member, try again.");
            return;
        }

        System.out.print("Which tooth layer (U)pper or (L)ower        : ");
        char layer;
        int layerIndex;

        while (true) {
            layer = scnr.next().toUpperCase().charAt(0);
            if (layer == 'U') {
                layerIndex = 0;
                break;
            } else if (layer == 'L') {
                layerIndex = 1;
                break;
            } else {
                System.out.print("Invalid layer, try again                    : ");
            }
        }

        System.out.print("Which tooth number                          : ");
        int toothNumber;

        while (true) {
            toothNumber = scnr.nextInt() - 1;
            if (toothNumber >= 0 && toothNumber < 8) {
                break;
            } else {
                System.out.print("Invalid tooth number, try again             : ");
            }
        }

        if (familyTeeth[memberIndex][layerIndex][toothNumber] == 'M') {
            System.out.println("Missing tooth, try again                    : ");
        } else {
            familyTeeth[memberIndex][layerIndex][toothNumber] = 'M';
        }
    }

    static int getMemberIndex(String[] familyNames, String name, int familyCount) {
        for (int i = 0; i < familyCount; ++i) {
            if (familyNames[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    static void reportRootCanals(char[][][] familyTeeth, int familyCount) {
        int incisors = 0;
        int bicuspids = 0;
        int missing = 0;

        for (int i = 0; i < familyCount; ++i) {
            for (int j = 0; j < 2; ++j) {
                for (char tooth : familyTeeth[i][j]) {
                    if (tooth == 'I') {
                        incisors++;
                    } else if (tooth == 'B') {
                        bicuspids++;
                    } else if (tooth == 'M') {
                        missing++;
                    }
                }
            }
        }

        double discriminant = Math.sqrt(bicuspids * bicuspids + 4 * incisors * missing);
        double root1 = (-bicuspids + discriminant) / (2 * incisors);
        double root2 = (-bicuspids - discriminant) / (2 * incisors);

        System.out.printf("One root canal at     %.2f\n", root1);
        System.out.printf("Another root canal at %.2f\n", root2);
    }
}

