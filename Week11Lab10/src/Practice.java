import java.util.ArrayList;

public class Practice {
    public static void main(String[] args) throws Exception {
        System.out.println("Week 11 - Lab 10");

        ArrayList<String> myInfoList = new ArrayList<String>();

        myInfoList.add("Chelsea Munro");
        myInfoList.add("Computer Science");
        myInfoList.add("4.0");

        double currentGPA = Double.parseDouble(myInfoList.get(2));

        System.out.println(myInfoList);

        for (int index = 0; index < myInfoList.size(); index++) {
            System.out.println(myInfoList.get(index));

        }



    }
}
