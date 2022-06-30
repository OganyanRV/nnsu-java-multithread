package lab4;

import Alarm.*;
import ClockManage.ClockManage;

import java.util.ArrayList;

import lab5.Translation;
import lab5.TranslationFactory;
import org.hibernate.Session;

public class Model {
    // Database db;
    Session db;
    ArrayList<Msg> all_msg = new ArrayList<>(); //  Сообщения о времени
    ArrayList<Msg> all_set_alarms = new ArrayList<>(); //  сообщения о новых будильниках
    int last_code = 0;
    ArrayList<Msg> all_commands = new ArrayList<>(); //  Сообщения о играющем будильнике
    ArrayList<IObserver> all_0 = new ArrayList<>();
    String delete_alarm;
    public ClockManage clock;


    public ClockManage getClock() {
        return clock;
    }


    public Model(Runnable callback) {

        db = TranslationFactory.getSession();

        clock = new ClockManage(() -> {
            all_msg.add(new Msg(clock.GetWatch().Format(), 1));
            this.last_code = 1;
            this.update();
        }, () -> {
            all_commands.add(new Msg(clock.GetWatch().Format(), 2));
            this.last_code = 2;
            this.update();
        });

    }

    int[] parser(String time) {
        int nums[] = new int[3];
        char hour_fi = time.charAt(0);
        char hour_se = time.charAt(1);
        int hour =( hour_fi - '0') * 10 + (hour_se - '0');

        char m_fi = time.charAt(3);
        char m_se = time.charAt(4);
        int m_ =( m_fi - '0') * 10 + (m_se - '0');

        char s_fi = time.charAt(6);
        char s_se = time.charAt(7);
        int s =( s_fi - '0') * 10 + (s_se - '0');

        nums[0] = hour;
        nums[1] = m_;
        nums[2] = s;
        return nums;
    }


    public void add(Msg m) {
        if (m.getCode() == 0) {
            all_set_alarms.add(m);
            String time = m.getMsg();
            AlarmO al = new AlarmO(time);
            this.clock.add_al(al);
            last_code = 0;

            // Лаба 5
            int[] obj = parser(m.getMsg());
            this.db.save(new Translation(obj[0], obj[1], obj[2]));
        } else if (m.getCode() == 1) {
            all_msg.add(m);
            last_code = 1;
        }
        else if (m.getCode() == 3) {
            delete_alarm = m.getMsg();
            last_code = 3;
        }

        update();
    }

    public ArrayList<Msg> getAll_msg() {
        return all_msg;
    }

    public ArrayList<Msg> getAll_set_alarms() {
        return all_set_alarms;
    }

    void update() {
        for (IObserver o : all_0) {
            o.update(this);
        }

    }

    public Msg last() {
        return all_msg.get(all_msg.size() - 1);
    }

    public Msg last_alarm() {
        return all_set_alarms.get(all_set_alarms.size() - 1);
    }

    public Msg last_command() {
        return all_commands.get(all_commands.size() - 1);
    }


    public void addO(IObserver o) {
        all_0.add(o);
    }
}
