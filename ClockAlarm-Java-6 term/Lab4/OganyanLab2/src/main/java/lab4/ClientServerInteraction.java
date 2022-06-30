package lab4;

import Alarm.Alarm;
import Alarm.AlarmO;
import ClockManage.ClockManage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Print.Print;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

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
              //  Print.print(msg.getMsg() + msg.getCode());

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
            send(m.last_command());
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
}
