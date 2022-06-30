package MyThread;

import Clock.*;
import Print.Print;

import java.util.concurrent.atomic.AtomicBoolean;

public class MyThread extends Thread{
    Object sleep_obj;
    ClockO clock_cur;
    Runnable call_back_Cur;
    Runnable call_back2 = null;
    AtomicBoolean pause;



    public MyThread(ClockO clock_cur_, Runnable callback, AtomicBoolean pause_, Object sleep_obj) {
        clock_cur = clock_cur_;
        call_back_Cur = callback;
        pause = pause_;
        this.sleep_obj = sleep_obj;
    }

    public MyThread(ClockO clock_cur_, Runnable callback, Runnable cb_2, AtomicBoolean pause_, Object sleep_obj) {
        clock_cur = clock_cur_;
        call_back_Cur = callback;
        call_back2 = cb_2;
        pause = pause_;
        this.sleep_obj = sleep_obj;
    }


    public void run() {
        while (true) {

            if (this.pause.get() == true) {
                synchronized (sleep_obj) {
                    try {
                        sleep_obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                pause.set(false);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            this.clock_cur.TimeForward(1, 's', call_back2);
            Print.print(clock_cur.Format());
            Print.print(this.clock_cur.getList().size());
            if (call_back_Cur != null) {
                call_back_Cur.run();
            }
        }
    }
}
