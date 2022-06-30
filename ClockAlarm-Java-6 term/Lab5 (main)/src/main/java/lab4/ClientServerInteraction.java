package lab4;

import Alarm.Alarm;
import Alarm.AlarmO;
import ClockManage.ClockManage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Print.Print;
import lab5.Translation;
import lab5.TranslationFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// WCS
public class ClientServerInteraction extends Thread implements IObserver {
    Socket cs; // Клиентский сокет
    Model m;

    OutputStream os;
    InputStream is;
    DataInputStream dis;
    DataOutputStream dos;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ClientServerInteraction(Socket cs, Model m) {
        this.cs = cs;
        this.m = m;
        try {
            os = cs.getOutputStream();
            dos = new DataOutputStream(os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        m.addO(this);
        this.start();
        String str = Integer.toString(m.all_0.size());
       // send("Всем привет я клиент" + str);
        Print.print("Всем привет я клиент" + str);
        m.last_code = 0;
        send(m.getAll_set_alarms());


    }

    @Override
    public void run() {
        try {
            is = cs.getInputStream();
            dis = new DataInputStream(is);
            os = cs.getOutputStream();
            dos = new DataOutputStream(os);
            while (true) {
                String obj = dis.readUTF();
                Msg msg = gson.fromJson(obj, Msg.class);
                m.add(msg);

            }

        } catch (IOException e) {
            e.printStackTrace();

        }


    }


    @Override
    public void update(Model m) {

        if (m.last_code == 0) {
            send(m.last_alarm());
        }
        else if (m.last_code == 1) {
            send(m.last());
        }
        else if (m.last_code == 2) {
            int[] cur = m.parser(m.last_command().getMsg());
            // this.m.db.delete(new Translation(cur[0], cur[1], cur[2]));
            session_delete(cur);

            // Удалить сработавшие будильники чтобы новые клиенты не брали их
            ArrayList<Msg> new_msg_set_alarms = new ArrayList<Msg>();
            for (Msg msg: m.all_set_alarms) {
                if (msg.getMsg().equals(m.last_command().getMsg())) {
                }
                else {
                    new_msg_set_alarms.add(msg);
                }
            }
            m.all_set_alarms = new_msg_set_alarms;
            send(m.last_command());
        }
        else if(m.last_code == 3) {
            int[] cur = m.parser(m.delete_alarm);
           // this.m.db.delete(new Translation(cur[0], cur[1], cur[2]));
            session_delete(cur);
            String new_str = m.delete_alarm.substring(0, 8);
            m.delete_alarm = new_str;


            // Удалить сработавшие будильники чтобы новые клиенты не брали их
            ArrayList<Msg> new_msg_set_alarms = new ArrayList<Msg>();
            for (Msg msg: m.all_set_alarms) {
                if (msg.getMsg().equals(new_str)) {
                }
                else {
                    new_msg_set_alarms.add(msg);
                }
            }
            m.all_set_alarms = new_msg_set_alarms;

            m.clock.GetWatch().removealarm(cur[0], cur[1], cur[2]); // Выключить будильник
            send(new Msg(m.delete_alarm, 3));

        }

    }

    public void send(Msg s) {
        try {
            Resp r = new Resp();
            r.add(s);
            String s_string = gson.toJson(r);
            dos.writeUTF(s_string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void send(ArrayList<Msg> aMgs) {
        try {
            Resp r = new Resp();
            for ( Msg Amg: aMgs) {
                r.add(Amg);
            }
            String s_string = gson.toJson(r);
            dos.writeUTF(s_string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void session_delete(int[] time) {
        Session session = TranslationFactory.getSession();
        Transaction trans = session.beginTransaction();
        try {
            Query query = session.createQuery("delete Translation where hours =:p_h and minutes=:p_m and seconds =: p_s");
            query.setParameter("p_h", time[0]);
            query.setParameter("p_m", time[1]);
            query.setParameter("p_s", time[2]);
            query.executeUpdate();
            trans.commit();
        } finally {
            session.close();
        }
    }
}
