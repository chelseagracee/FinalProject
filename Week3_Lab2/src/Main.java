import java.util.Scanner,
public class KangaroosKill {
    private static KangaroosKill {
        System.out.print("Enter side of square in km  : ");
        double side = scanner.nextDouble();

        System.out.print("Enter roads length in km    : ");
        double roadsLength = scanner.nextDouble();

        System.out.print("Enter number of 'roos       : ");
        int numKangaroos = scanner.nextInt();

        public static void main(String[] args)

        double areaOfLand = side * side;
        double kangarooDensity = numKangaroos / areaOfLand;
        double roadWidth = 0.01; // in kilometers
        double roadSurfaceArea = roadsLength * roadWidth;
        double roadkillConstant = 1.47;

        double expectedKills = kangarooDensity * roadSurfaceArea * roadkillConstant;
        int kills = (int) expectedKills;
        int injuries = (int) Math.floor(expectedKills) != kills ? 1 : 0;

        System.out.println("Expected number of kills is : " + kills);
        System.out.println("Expected number of injuries : " + injuries);

    }
}