package Alarm;

public interface Alarm {
    public int GetNum();
    public int[] GetTime();
    public  boolean GetWork();
    public void SetTime(int hour_, int minute_);
    public void work(boolean mode);
    public void Ring();
    public void Ring(Runnable callback);
}
