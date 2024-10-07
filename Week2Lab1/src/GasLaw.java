import java.util.Scanner;

//=============================================================================
public class GasLaw {
    //-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    //----The gas constant in Joules/mole/K
    private static double gasConstant = 8.3143;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold system values
        double Volume, Moles, Temp;
        double pressure;

//----Get data
        System.out.print("Enter volume, moles, temperature : ");
        Volume = keyboard.nextDouble();
        Moles = keyboard.nextDouble();
        Temp = keyboard.nextDouble();

//----Calculate pressure
        pressure = Moles * gasConstant * Temp / Volume;

//----Display final answer
        System.out.println("Pressure is " + pressure);
    }
//-----------------------------------------------------------------------------
}
//=============================================================================