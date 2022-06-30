package Clock;

import Alarm.Alarm;

public interface Clock {
    public String GetName();
    public int GetPrice();
    public int[] GetTime();
    public void SetTime(int hour_, int minute_);
    public void TimeForward(int m_);
    public void TimeForward(int time_, char type);
    public void Print();
    public void FindAlarm();
    public void Addalarm(Alarm alarm_);
    public String Format();
}
