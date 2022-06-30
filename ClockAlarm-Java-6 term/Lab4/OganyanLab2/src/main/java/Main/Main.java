package Main;
import Alarm.AlarmN;
import Alarm.AlarmO;
import Clock.*;
import Print.Print;

/**
 * @autor Oganyan Robert
 * @version 1
 */

public class Main {
    public static void main(String[] arg) {

        Print.print("LAB 1 ---------------------------------------");
        ClockN fi = new ClockN("Gucci", 2300, 10,20);
        ClockO se = new ClockO("Rolex", 3800);

        fi.Print();
        se.Print();
        Print.print("---------------");

        Print.print(fi.GetPrice());
        Print.print("---------------");
        Print.print(se.GetName());


        fi.TimeForward(230, 'm');
        fi.Print();

        se.SetTime(5, 37, 59);
        se.Print();

        se.TimeForward(3491, 's');
        se.Print();

        Print.print("LAB 2 ---------------------------------------");
        AlarmO al1 = new AlarmO(6,36,10, true);
        AlarmO al2 = new AlarmO(6,54,5, true);
        se.Addalarm(al1);
        se.Addalarm(al2);

        se.SetTime(6, 45, 50);
        int seconds = 600;
        while(seconds > 0) {
            se.TimeForward(1,'s');
            seconds--;
        }

        AlarmN all1 = new AlarmN(14, 10, false);
        fi.Addalarm(all1);

       AlarmN all2 = new AlarmN(14, 10, true);
       fi.Addalarm(all2);

        AlarmN all3 = new AlarmN(14, 50, true);
        fi.Addalarm(all3);

        fi.TimeForward(40, 'm');
    }

}
