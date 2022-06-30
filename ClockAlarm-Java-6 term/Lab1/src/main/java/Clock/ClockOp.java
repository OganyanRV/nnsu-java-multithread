package Clock;

import MyException.MyException;
import Print.Print;

public class ClockOp extends Clock{
    protected int second;

    public ClockOp() {
        super();
        second = 0;
    }

    public ClockOp(String name_, int price_) {
        super(name_, price_);
        second = 0;
    }
    public ClockOp(String name_, int price_, int hour_, int minute_, int second_) {
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
        int newmin = time_/60;
        time_%=60;
        int newhour = newmin/60;
        newmin%=60;
        if (second + time_ >=60) newmin++;
        second = (second + time_) % 60;
        if (minute + newmin >=60) newhour++;
        minute = (minute + newmin) % 60;
        hour = (hour + newhour) % 24;
    }

    @Override
    public void print() {
        super.print();
        Print.print(name + "'s seconds: " + second);
    }


}
