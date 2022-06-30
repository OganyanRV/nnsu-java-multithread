package ClockManage;

import Alarm.AlarmO;
import Clock.*;
import MyThread.MyThread;
import Print.Print;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClockManage {
    Object sleep_obj = new Object();
    private ClockO clock_this;
    MyThread t;
    Runnable callback_this;
    Runnable callback_this_2 = null;
    AtomicBoolean is_sleeping = new AtomicBoolean(false);


    public ClockManage(Runnable callback) {
        clock_this = new ClockO("Rolex", 3800, 0, 0, 0);
        AlarmO al1 = new AlarmO(0, 0, 5, true);
        AlarmO al2 = new AlarmO(0, 0, 10, true);
        AlarmO al3 = new AlarmO(0, 0, 15, true);
        AlarmO al4 = new AlarmO(0, 0, 20, true);
        clock_this.Addalarm(al1);
        clock_this.Addalarm(al2);
        clock_this.Addalarm(al3);
        clock_this.Addalarm(al4);
        callback_this = callback;

    }
    public ClockManage(Runnable callback, Runnable callback2) {
        clock_this = new ClockO("Rolex", 3800, 0, 0, 0);
//          AlarmO al3 = new AlarmO(0, 0, 8, true);
//         clock_this.Addalarm(al3);
//        al3 = new AlarmO(0, 0, 12, true);
//        clock_this.Addalarm(al3);
//        al3 = new AlarmO(0, 0, 15, true);
//        clock_this.Addalarm(al3);
        callback_this_2 = callback2;
        callback_this = callback;
    }



    public ClockO GetWatch() {
        return this.clock_this;
    }

    public void add_al(AlarmO alarm) {
        this.clock_this.Addalarm(alarm);
    }

    // лаба 3
//    public void start() {
//        if (t == null) {
//            t = new MyThread(clock_this, this.callback_this, is_sleeping, sleep_obj);
//            t.start();
//        }
//
//    }

    // Лаба 4
    public void start() {
        if (t == null) {
            t = new MyThread(clock_this, this.callback_this, this.callback_this_2, is_sleeping, sleep_obj);
            t.start();
        }

    }



    public void pause() {
        if (t == null) {
            return;
        }
        is_sleeping.set(true);
    }

    public void resume() {
        synchronized (sleep_obj) {
            sleep_obj.notifyAll();
        }
    }

    public void stop() {
        if (t != null) {
            if (is_sleeping.get() == false) {
                t.interrupt();
                t = null;
            }
        }
    }
}
