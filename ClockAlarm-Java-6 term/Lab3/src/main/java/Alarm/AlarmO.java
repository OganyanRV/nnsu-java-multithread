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

    public AlarmO(int hour_, int minute_, int second_, boolean work_) {
        cntO++;
        num = cntO;
        try {
            if (hour_ >= 24 || hour_ < 0 || minute_ >= 60 || minute_ < 0 || second_ >=60 || second_ < 0) {
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
            if (hour_ >= 24 || hour_ < 0 || minute_ >= 60 || minute_ < 0 || second_ >=60 || second_ < 0) {
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


}
