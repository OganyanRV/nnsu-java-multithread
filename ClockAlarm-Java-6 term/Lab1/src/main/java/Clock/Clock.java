package Clock;
import MyException.MyException;
import Print.Print;

public class Clock {
    protected String name;
    protected int price;
    protected int hour;
    protected int minute;

    public Clock() {
        name = "Not defined";
        price = hour = minute = 0;
    }

    public Clock(String name_, int price_) {
        name = name_;
        try {
            if (price_ < 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
        price = price_;
    }
    public Clock(String name_, int price_, int hour_, int minute_) {
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
    }

    public String GetName() { return name;}
    public int GetPrice() { return price; }

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
        return;
    }


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

        return;
    }

    public void TimeForward(int time_, char type) {
        if (type == 'm') TimeForward(time_);
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
        return;
    }

    public void print() {
        Print.print("------------------------");
        Print.print("Clock's name: " + name);
        Print.print(name + "'s price: " + price);
        Print.print(name + "'s hours: " + hour);
        Print.print(name + "'s minutes: " + minute);
    }

}
