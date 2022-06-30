package Alarm;

import MyException.MyException;
import Print.Print;

import javax.swing.*;

public class AlarmN implements Alarm {
    static int cntN = 0;
    protected int num;
    protected int hour;
    protected int minute;
    protected boolean work;

    public AlarmN() {
        cntN++;
        num = cntN;
        hour = minute = 0;
        work = false;
    }

    public AlarmN(int hour_, int minute_, boolean work_) {
        cntN++;
        num = cntN;
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
        work = work_;
    }


    @Override
    public int GetNum() {
        return num;
    }

    @Override
    public int[] GetTime() {
        int[] time = new int[]{hour, minute};
        return time;
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

    @Override
    public void work(boolean wrk) {
        work = wrk;
    }

    @Override
    public boolean GetWork() {
        return work;
    }

    @Override
    public void Ring() {
        JOptionPane.showMessageDialog(null, "Alarm " + num + " works at time " + hour + " : " + minute);
        Print.print("Alarm " + num + " works at time " + hour + " : " + minute);
    }
}
