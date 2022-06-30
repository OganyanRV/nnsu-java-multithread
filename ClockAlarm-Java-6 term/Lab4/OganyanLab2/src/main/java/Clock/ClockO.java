package Clock;

import Alarm.*;
import MyException.MyException;
import Print.Print;
import lab4.Resp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ClockO implements Clock {
    protected String name;
    protected int price;
    protected int hour;
    protected int minute;
    protected int second;
    private ArrayList<AlarmO> list;

    public ClockO() {
        name = "Not defined";
        price = hour = minute = 0;
        second = 0;
        list = new ArrayList<AlarmO>(0);
    }

    public ClockO(String name_, int price_) {
        name = name_;
        try {
            if (price_ < 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
        hour = 0;
        minute = 0;
        price = price_;
        second = 0;
        list = new ArrayList<AlarmO>(0);
    }

    public ClockO(String name_, int price_, int hour_, int minute_, int second_) {
        this(name_, price_);
        try {
            if (hour_ >= 24 || hour_ < 0 || minute_ >= 60 || minute_ < 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
        hour = hour_;
        minute = minute_;
        try {
            if (second_ >= 60 || second_ < 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
        second = second_;
        list = new ArrayList<AlarmO>(0);
    }

    @Override
    public String GetName() {
        return name;
    }

    @Override
    public int GetPrice() {
        return price;
    }

    @Override
    public int[] GetTime() {
        int[] time_ = new int[]{hour, minute, second};
        return time_;
    }

    @Override
    public void SetTime(int hour_, int minute_) {
        try {
            if (hour_ >= 24 || hour_ < 0 || minute_ >= 60 || minute_ < 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
        hour = hour_;
        minute = minute_;

        FindAlarm();

        return;
    }

    public void SetTime(int hour_, int minute_, int second_) {
        try {
            if (hour_ >= 24 || hour_ < 0 || minute_ >= 60 || minute_ < 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
        hour = hour_;
        minute = minute_;
        try {
            if (second_ >= 60 || second_ < 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
        second = second_;

        FindAlarm();
        return;
    }

    @Override
    public void TimeForward(int m_) {
        try {
            if (m_ >= 1440 || m_ <= 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
        int newhour = m_ / 60;
        m_ %= 60;
        if (minute + m_ >= 60) newhour++;
        hour = (hour + newhour) % 24;

        minute = (minute + m_) % 60;

        FindAlarm();

        return;
    }

    @Override
    public void TimeForward(int time_, char type) {
        if (type != 's') {
            try {
                if (time_ >= 1440 || time_ <= 0) {
                    throw new MyException();
                }
            } catch (MyException exp) {
                Print.print(exp.toString());
                System.exit(1);
            }
            int newhour = time_ / 60;
            time_ %= 60;
            if (minute + time_ >= 60) newhour++;
            hour = (hour + newhour) % 24;
            minute = (minute + time_) % 60;
            FindAlarm();
            return;
        }


        try {
            if (time_ >= 86400 || time_ <= 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
        int newmin = time_ / 60;
        time_ %= 60;
        int newhour = newmin / 60;
        newmin %= 60;
        if (second + time_ >= 60) newmin++;
        second = (second + time_) % 60;
        if (minute + newmin >= 60) newhour++;
        minute = (minute + newmin) % 60;
        hour = (hour + newhour) % 24;
    }

    // @Override
    public void TimeForward(int time_, char type, Runnable callback) {
        if (type != 's') {
            try {
                if (time_ >= 1440 || time_ <= 0) {
                    throw new MyException();
                }
            } catch (MyException exp) {
                Print.print(exp.toString());
                System.exit(1);
            }
            int newhour = time_ / 60;
            time_ %= 60;
            if (minute + time_ >= 60) newhour++;
            hour = (hour + newhour) % 24;
            minute = (minute + time_) % 60;
            FindAlarm();
            return;
        }


        try {
            if (time_ >= 86400 || time_ <= 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
        int newmin = time_ / 60;
        time_ %= 60;
        int newhour = newmin / 60;
        newmin %= 60;
        if (second + time_ >= 60) newmin++;
        second = (second + time_) % 60;
        if (minute + newmin >= 60) newhour++;
        minute = (minute + newmin) % 60;
        hour = (hour + newhour) % 24;

        FindAlarm(callback);
//        Thread t = new Thread() {
//
//            @Override
//            public void run() {
//                FindAlarm(callback);
//            }
//        };
//        t.start();
//       t.interrupt();
    }

    @Override
    public void Print() {
        Print.print("------------------------");
        Print.print("Clock's name: " + name);
        Print.print(name + "'s price: " + price);
        Print.print(name + "'s hours: " + hour);
        Print.print(name + "'s minutes: " + minute);
        Print.print(name + "'s seconds: " + second);
    }

    @Override
    public String Format() {
        return (String.format("%02d : %02d : % 02d", this.hour, this.minute, this.second));
    }

    public void Addalarm(AlarmO alarm_) {
        list.add(alarm_);
        FindAlarm();
    }

    //@Override
    public ArrayList<AlarmO> getList() {
        return list;
    }

    @Override
    public void FindAlarm() {
        for (int i = 0; i < list.size(); ++i) {
            Alarm cur = list.get(i);
            boolean found = true;
            for (int j = 0; j < cur.GetTime().length; ++j) {
                if (cur.GetTime()[j] != this.GetTime()[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                if (cur.GetWork()) {
                    cur.Ring();
                }
            }

        }
    }

    public void FindAlarm(Runnable callback) {
        for (int i = 0; i < list.size(); ++i) {
            Alarm cur = list.get(i);
            boolean found = true;
            for (int j = 0; j < cur.GetTime().length; ++j) {
                if (cur.GetTime()[j] != this.GetTime()[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                if (cur.GetWork()) {
                    //cur.Ring(callback);
                    if (callback != null)
                        callback.run();
                }
            }

        }
    }

}
