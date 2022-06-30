package Clock;
import Alarm.Alarm;
import MyException.MyException;
import Print.Print;

import java.util.ArrayList;

public class ClockN implements Clock {
    protected String name;
    protected int price;
    protected int hour;
    protected int minute;

    private ArrayList<Alarm> list;

    public ClockN() {
        name = "Not defined";
        price = hour = minute = 0;
        list = new ArrayList<Alarm>(0);
    }

    public ClockN(String name_, int price_) {
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
        list = new ArrayList<Alarm>(0);
    }
    public ClockN(String name_, int price_, int hour_, int minute_) {
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
        list = new ArrayList<Alarm>(0);
    }

    @Override
    public String GetName() { return name;}
    @Override
    public int GetPrice() { return price; }

    @Override
    public int[] GetTime() {
        int[] time_ = new int[] {hour, minute};
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
        if (type == 'm') {
            TimeForward(time_);
            return;
        }
        else if (type == 'h') {
            try {
                if (time_ >= 24 || time_ <= 0) {
                    throw new MyException();
                }
            } catch (MyException exp) {
                Print.print(exp.toString());
                System.exit(1);
            }
            hour = (hour + time_) % 24;
        }
        FindAlarm();

        return;
    }


    @Override
    public void Print() {
        Print.print("------------------------");
        Print.print("Clock's name: " + name);
        Print.print(name + "'s price: " + price);
        Print.print(name + "'s hours: " + hour);
        Print.print(name + "'s minutes: " + minute);
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

    @Override
    public void Addalarm(Alarm alarm_) {
        list.add(alarm_);
        FindAlarm();
    }

    public String Format() {
        return (String.format("%02d : %02d", this.hour, this.minute));
    }

}
