import java.util.Scanner;

    public class Kangarooskill {

        private static final double roadWidthM = 10;
        private static final double roadWidthKm = roadWidthM / 1000;
        private static final double roadkillProb = 1.47;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter side of square in km       : ");
            double sideLengthKm = scanner.nextDouble();

            System.out.print("Enter roads length in km         : ");
            double roadLengthKm = scanner.nextDouble();

            System.out.print("Enter number of 'roos            : ");
            int numberOfRoos = scanner.nextInt();


            int[] results = calculateRoadkill(sideLengthKm, roadLengthKm, numberOfRoos);
            int kills = results[0];
            int injuries = results[1];

            System.out.println("Expected number of kills is      : " + kills);
            System.out.println("Expected number of injuries is   : " + injuries);
        }

        private static int[] calculateRoadkill(double sideLengthKm, double roadLengthKm, int numberOfRoos) {

            double landAreaKm2 = sideLengthKm * sideLengthKm;

            double rooDensity = numberOfRoos / landAreaKm2;

            double roadSurfaceAreaKm2 = roadLengthKm * roadWidthKm;

            double expectedKills = rooDensity * roadSurfaceAreaKm2 * roadkillProb;

            int intKills = (int) expectedKills;
            int fraction = (int) ((expectedKills - intKills) > 0 ? 1 : 0);

            return new int[] {intKills, fraction};
        }
    }
