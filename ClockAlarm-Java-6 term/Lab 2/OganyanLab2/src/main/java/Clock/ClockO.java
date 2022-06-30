package Clock;

import Alarm.Alarm;
import MyException.MyException;
import Print.Print;

import java.util.ArrayList;

public class ClockO extends ClockN {
    protected int second;
    private ArrayList<Alarm> list;

    public ClockO() {
        super();
        second = 0;
        list = new ArrayList<Alarm>(0);
    }

    public ClockO(String name_, int price_) {
        super(name_, price_);
        second = 0;
        list = new ArrayList<Alarm>(0);
    }

    public ClockO(String name_, int price_, int hour_, int minute_, int second_) {
        super(name_, price_, hour_, minute_);
        try {
            if (second_ >= 60 || second_ < 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
        second = second_;
        list = new ArrayList<Alarm>(0);
    }

    @Override
    public int[] GetTime() {
        int[] time_ = new int[]{hour, minute, second};
        return time_;
    }

    public void SetTime(int hour_, int minute_, int second_) {
        super.SetTime(hour_, minute_);
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
    public void TimeForward(int time_, char type) {
        if (type != 's') {
            super.TimeForward(time_, type);
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

        FindAlarm();
    }

    @Override
    public void Print() {
        super.Print();
        Print.print(name + "'s seconds: " + second);
    }


}
