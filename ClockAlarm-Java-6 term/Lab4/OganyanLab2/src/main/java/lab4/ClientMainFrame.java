package lab4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import Print.Print;
import ThreadForm.MainForm;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ClientMainFrame extends JFrame {
    private JPanel panel;
    private JTextArea list_alarm;
    private JTextArea time;
    private JButton join;
    private JButton set;
    private JTextArea alarm;

    Thread t;


    int port = 3124;
    InetAddress host;

    Socket cs;
    OutputStream os;
    InputStream is;

    DataOutputStream dos;
    DataInputStream dis;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    boolean IsStarted = false;


    void addString(String s) {

        list_alarm.setLineWrap(true);
        String tmp = list_alarm.getText();
        tmp += s + "\n";
        list_alarm.setText(tmp);

        return;
    }

    public ClientMainFrame() {
        //initComponents();


        join.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (!IsStarted) {
                    IsStarted = true;

                    try {
                        host = InetAddress.getLocalHost();
                    } catch (UnknownHostException unknownHostException) {
                        unknownHostException.printStackTrace();
                    }

                    // cs = null;
                    try {
                        cs = new Socket(host, port);
                        os = cs.getOutputStream();
                        dos = new DataOutputStream(os);

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    t = new Thread() {
                        @Override
                        public void run() {

                            InputStream is = null;
                            try {
                                is = cs.getInputStream();
                                dis = new DataInputStream(is);

                                while (true) {
                                    String s = dis.readUTF();

                                    Resp r = gson.fromJson(s, Resp.class);
                                    for (Msg msg : r.getListMsg()) {
                                        if (msg.getCode() == 0) {
                                            addString(msg.getMsg());
                                        }
                                    }

                                    if (r.size() == 1) {
                                        int cur_code = r.getListMsg().get(0).getCode();
                                        Print.print("Recieved" + cur_code);
                                        if (cur_code == 1) {
                                            time.setText(r.getListMsg().get(0).getMsg());
                                        } else if (cur_code == 2) {
                                            Thread print = new Thread() {
                                                Runnable interrupt_t = () -> {
                                                    this.interrupt();
                                                };

                                                @Override
                                                public void run() {
                                                    Make_window(interrupt_t, r.getListMsg().get(0).getMsg());
                                                }
                                            };
                                            print.start();
                                        }
                                    }

//

                                }
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }


                        }
                    };

                    t.start();
                }

            }
        });

        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t != null) {
                    try {
                        Msg msg = new Msg(alarm.getText(), 0);
                        String s_string = gson.toJson(msg);
                        dos.writeUTF(s_string);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("ClientMainFrame");
        frame.setContentPane(new ClientMainFrame().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    void Make_window(Runnable call_back, String s) {
        Print.print("Alarm " + s);
        JOptionPane.showMessageDialog(null, "Alarm " + s);
        call_back.run();
    }


}
