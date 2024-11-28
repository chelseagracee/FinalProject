import java.util.ArrayList;

public class ExceptionalIntegers {

    public static void main(String[] args) {
        System.out.println("WEEK 12 - LAB 10");

        ArrayList<Integer> integerList = new ArrayList<>();

        for (String arg : args) {
            try {
                Integer integerObject = convertToInt(arg);
                System.out.println("Converter method says integer OK - " + integerObject);
                integerList.add(integerObject);
            } catch (NumberFormatException e) {
                System.out.println("Catch block says the argument \"" + arg + "\" is ignored because " + arg);
            }
        }

        System.out.println("\nThe ArrayList contents are:");
        for (int i = 0; i < integerList.size(); i++) {
            System.out.println("Item " + i + " is " + integerList.get(i));
        }
    }

    private static Integer convertToInt(String str) throws NumberFormatException {
        int num = Integer.parseInt(str);
        return Integer.valueOf(num);
    }

} // end of the IntegersAreExceptional class}
