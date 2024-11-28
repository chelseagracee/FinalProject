import java.util.Scanner;

    public class DentalRecord {
        private char[][][] teeth;
        private String[] familyMembers;
        private Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            DentalRecord records = new DentalRecord();
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Welcome to the Floridian Tooth Records");
            System.out.println("--------------------------------------");

            records.getFamilyInfo();

            char menuOption;
            do {

                System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it: ");
                menuOption = records.scanner.next().toUpperCase().charAt(0);

                switch (menuOption) {
                    case 'P':
                        records.printTeethRecord();
                        break;
                    case 'E':
                        records.extractTooth();
                        break;
                    case 'R':
                        records.reportRootCanals();
                        break;
                    case 'X':
                        System.out.println("Exiting the Floridian Tooth Records :-)");
                        break;
                    default:
                        System.out.print("Invalid menu option, try again: ");
                        break;
                }

            } while (menuOption != 'X');
        }

        private void getFamilyInfo() {

            int numberOfPeople = 0;

            System.out.print("Please enter number of people in the family: ");

            while (numberOfPeople < 1 || numberOfPeople > 6) {
                numberOfPeople = scanner.nextInt();
                if (numberOfPeople < 1 || numberOfPeople > 6) {
                    System.out.print("Invalid number of people, try again: ");
                }
            }

            teeth = new char[numberOfPeople][][];
            familyMembers = new String[numberOfPeople];


            final int LAYERS = 2;
            for (int person = 0; person < numberOfPeople; person++) {
                System.out.print("Please enter the name for family member " + (person + 1) + ": ");
                familyMembers[person] = scanner.next();


                teeth[person] = new char[LAYERS][];


                teeth[person][0] = getTeeth("uppers", person);

                teeth[person][1] = getTeeth("lowers", person);
            }
        }

        private char[] getTeeth(String layer, int person) {
            String teethInput;
            char[] teethArray;

            System.out.print("Please enter the " + layer + " for " + familyMembers[person] + ": ");

            while (true) {
                teethInput = scanner.next();

                if (teethInput.length() > 8) {
                    System.out.print("Too many teeth, try again: ");
                } else if (!teethInput.matches("[IBMibm]*")) {
                    System.out.print("Invalid teeth types, try again: ");
                } else {
                    teethArray = teethInput.toUpperCase().toCharArray(); // Store teeth as uppercase
                    return teethArray;  // valid input, return the teethArray
                }


            }
        }


        private void printTeethRecord() {
            for (int person = 0; person < familyMembers.length; person++) {
                System.out.println(familyMembers[person]);
                System.out.print("  Uppers: ");
                printTeeth(teeth[person][0]);
                System.out.print("  Lowers: ");
                printTeeth(teeth[person][1]);
            }
        }


        private void printTeeth(char[] teethLayer) {
            for (int i = 0; i < teethLayer.length; i++) {
                System.out.print((i + 1) + ":" + teethLayer[i] + "  ");
            }
            System.out.println();
        }

        private void extractTooth() {
            System.out.print("Which family member : ");
            String memberName = scanner.next();
            int personIndex = getMemberIndex(memberName);

            while (personIndex == -1) {
                System.out.print("Invalid family member, try again: ");
                memberName = scanner.next();
                personIndex = getMemberIndex(memberName);
            }

            System.out.print("Which tooth layer (U)pper or (L)ower : ");
            char layer = scanner.next().toUpperCase().charAt(0);
            int layerIndex = (layer == 'U') ? 0 : (layer == 'L') ? 1 : -1;

            while (layerIndex == -1) {
                System.out.print("Invalid layer, try again: ");
                layer = scanner.next().toUpperCase().charAt(0);
                layerIndex = (layer == 'U') ? 0 : (layer == 'L') ? 1 : -1;
            }

            System.out.print("Which tooth number : ");
            int toothNumber = scanner.nextInt();

            while (toothNumber < 1 || toothNumber > teeth[personIndex][layerIndex].length) {
                System.out.print("Invalid tooth number, try again: ");
                return;
            }

            if (teeth[personIndex][layerIndex][toothNumber - 1] == 'M') {
                System.out.print("Missing tooth, try again: ");
                return;  // Exit the method without prompting for a new tooth number
            }

            // Extract the tooth
            teeth[personIndex][layerIndex][toothNumber - 1] = 'M'; // Mark as missing
        } // end of extractTooth method


        private int getMemberIndex(String memberName) {
            for (int i = 0; i < familyMembers.length; i++) {
                if (familyMembers[i].equalsIgnoreCase(memberName)) {
                    return i;
                }
            }
            return -1;
        }


        private void reportRootCanals() {
            int totalI = 0, totalB = 0, totalM = 0;

            // Calculate total counts of each type of tooth
            for (char[][] personTeeth : teeth) {
                for (char[] layer : personTeeth) {
                    for (char tooth : layer) {
                        if (tooth == 'I') totalI++;
                        else if (tooth == 'B') totalB++;
                        else if (tooth == 'M') totalM++;
                    }
                }
            }

            double root1 = (-totalB + Math.sqrt(totalB * totalB - 4 * totalI * -totalM)) / (2 * totalI);
            double root2 = (-totalB - Math.sqrt(totalB * totalB - 4 * totalI * -totalM)) / (2 * totalI);
            System.out.printf("One root canal at %.2f%n", root1);
            System.out.printf("Another root canal at %.2f%n", root2);
        }
    }
