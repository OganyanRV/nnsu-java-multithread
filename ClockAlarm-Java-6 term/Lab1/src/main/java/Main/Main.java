package Main;
import Clock.*;
import Print.Print;

/**
 * @autor Oganyan Robert
 * @version 1
 */

public class Main {
    public static void main(String[] arg) {
        Clock fi = new Clock("Gucci", 2300, 10,20);
        ClockOp se = new ClockOp("GucciOp", 3800);

        fi.print();
        se.print();
        Print.print("---------------");

        Print.print(fi.GetPrice());
        Print.print("---------------");
        Print.print(se.GetName());


        fi.TimeForward(230, 'm');
        fi.print();

        se.SetTime(5, 37, 59);
        se.print();

        se.TimeForward(3491, 's');
        se.print();
    }

}
