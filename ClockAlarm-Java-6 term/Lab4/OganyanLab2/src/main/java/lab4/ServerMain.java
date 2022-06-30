package lab4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Clock.Clock;
import ClockManage.ClockManage;
import lab4.ClientServerInteraction.*;
import Print.Print;

public class ServerMain {
    int port = 3124;
    InetAddress host;

    Model m;

    public ServerMain() {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {

            ServerSocket ss = new ServerSocket(port, 0, host);
            Model m = new Model(null);
            //m.getClock().start();
            m.clock.start();
            Print.print("Server has started");
            int count = 0;

            while (true) {
                Socket cs = ss.accept();
                count++;
                Print.print("Client has been connected: " + count);

                ClientServerInteraction wcs = new ClientServerInteraction(cs, m);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new ServerMain();
    }
}
