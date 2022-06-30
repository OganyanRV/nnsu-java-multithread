package Server;

import ClientServerInteraction.ClientServerInteraction;
import Model.Model;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.TimeUnit;

public class Server {
    int port = 3124;
    InetAddress host;

    Model shared_data;

    public Server() {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            ServerSocket ss = new ServerSocket(port, 0, host);
            Model shared_data = new Model();
            System.out.println("Server has started" + "\n");
            int count = 0;


            while (true) {
                if (count < 2) {
                    System.out.println("Waiting for players...");
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Socket cs = ss.accept();
                count++;
                if (count > 2) {
                    System.out.println("Too much players! Error");
                    throw new Exception("Too much of players");
                }
                System.out.print("Client has been connected: " + count + "\n");

                ClientServerInteraction wcs = new ClientServerInteraction(cs, shared_data, count - 1);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) {
        new Server();
    }
}