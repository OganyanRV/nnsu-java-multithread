package lab4;

import Alarm.*;
import Clock.*;
import ClockManage.ClockManage;

import java.util.ArrayList;

import lab5.Database;
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
    public ClockManage clock;


    public ClockManage getClock() {
        return clock;
    }


    public Model(Runnable callback) {

        db = TranslationFactory.getSession();
        //  db = new Database();
        // db.connect();
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

    public void add(Msg m) {
        if (m.getCode() == 0) {
            all_set_alarms.add(m);
            String time = m.getMsg();
            AlarmO al = new AlarmO(time);
            this.clock.add_al(al);
            last_code = 0;
        } else if (m.getCode() == 1) {
            all_msg.add(m);
            last_code = 1;
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
