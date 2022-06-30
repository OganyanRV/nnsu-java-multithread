package Alarm;

import MyException.MyException;
import Print.Print;

import javax.swing.*;

public class AlarmO implements Alarm {
    static int cntO = 0;
    protected int num;
    protected int hour;
    protected int minute;
    protected int second;
    protected boolean work;


    public AlarmO() {
        cntO++;
        num = cntO;
        hour = minute = second = 0;
        work = false;
    }

    public AlarmO(String time) {
        cntO++;
        num = cntO;
        char hour_fi = time.charAt(0);
        char hour_se = time.charAt(1);
        int hour =( hour_fi - '0') * 10 + (hour_se - '0');

        char m_fi = time.charAt(3);
        char m_se = time.charAt(4);
        int m_ =( m_fi - '0') * 10 + (m_se - '0');

        char s_fi = time.charAt(6);
        char s_se = time.charAt(7);
        int s =( s_fi - '0') * 10 + (s_se - '0');

        this.hour = hour;
        this.minute = m_;
        this.second = s;
        work = true;

        try {
            if (hour >= 24 || hour < 0 || minute >= 60 || minute < 0 || second >= 60 || second < 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
    }

    public AlarmO(int hour_, int minute_, int second_, boolean work_) {
        cntO++;
        num = cntO;
        try {
            if (hour_ >= 24 || hour_ < 0 || minute_ >= 60 || minute_ < 0 || second_ >= 60 || second_ < 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
        hour = hour_;
        minute = minute_;
        second = second_;
        work = work_;
    }


    @Override
    public int GetNum() {
        return num;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    @Override
    public int[] GetTime() {
        int[] time = new int[]{hour, minute, second};
        return time;
    }

    @Override
    public boolean GetWork() {
        return work;
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
    }

    public void SetTime(int hour_, int minute_, int second_) {
        try {
            if (hour_ >= 24 || hour_ < 0 || minute_ >= 60 || minute_ < 0 || second_ >= 60 || second_ < 0) {
                throw new MyException();
            }
        } catch (MyException exp) {
            Print.print(exp.toString());
            System.exit(1);
        }
        hour = hour_;
        minute = minute_;
        second = second_;
    }

    @Override
    public void work(boolean wrk) {
        work = wrk;
    }

    @Override
    public void Ring() {

        Print.print("Alarm " + num + " works at time " + hour + " : " + minute + " : " + second);
        JOptionPane.showMessageDialog(null, "Alarm " + num + " works at time " + hour + " : " + minute + " : " + second);

    }

    @Override
    public void Ring(Runnable callback) {

        Print.print("Alarm " + num + " works at time " + hour + " : " + minute + " : " + second);
        JOptionPane.showMessageDialog(null, "Alarm " + num + " works at time " + hour + " : " + minute + " : " + second);
        //callback.run();
    }


}
