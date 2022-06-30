package MyThread;

import Clock.Clock;

import java.util.concurrent.atomic.AtomicBoolean;

public class MyThread extends Thread{
    Object sleep_obj;
    Clock clock_cur;
    Runnable call_back_Cur;
    AtomicBoolean pause;



    public MyThread(Clock clock_cur_, Runnable callback, AtomicBoolean pause_, Object sleep_obj) {
        clock_cur = clock_cur_;
        call_back_Cur = callback;
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
            this.clock_cur.TimeForward(1, 's');
            call_back_Cur.run();
        }
    }
}
