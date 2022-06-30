package Client;

import MsgToClient.MsgToClient;
import MsgToServer.MsgToServer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.util.ISO8601Utils;

import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Client {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Thread t;
    DataInputStream dis;
    DataOutputStream dos;

    int port = 3124;

    InetAddress host;
    Socket s;

    public Client() {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        try {
            s = new Socket(host, port);
            System.out.println("Client has been connected to " + InetAddress.getLocalHost().getHostAddress());
            this.dis = new DataInputStream(s.getInputStream());
            this.dos = new DataOutputStream(s.getOutputStream());
            // Expect to receive "You have been connected to the server"
            String msg = null;
            msg = gson.fromJson(this.dis.readUTF(), String.class);
            System.out.println("Received from server: " + msg + "\n");
            assert (msg.equals("You have been connected to the server"));

            while (true) {
                MsgToClient msgg = null;
                try {
                    msgg = gson.fromJson(this.dis.readUTF(), MsgToClient.class);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("My field");
                VisualizeField(msgg.getFields()[0]);
                System.out.println("Enemys field");
                VisualizeField(msgg.getFields()[1]);
                break;
            }
            t = new Thread() {
                @Override
                public void run() {
                    Scanner scanner = new Scanner(System.in);

                    while (true) {
                        MsgToClient msg = null;
                        try {
                            msg = gson.fromJson(dis.readUTF(), MsgToClient.class);
                        } catch (IOException e) {
                            System.out.println("Didnt get message from server bruh");
                            try {
                                TimeUnit.MILLISECONDS.sleep(2000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            continue;
                        }
                        System.out.println("Your turn");
                        if (msg.getCode() == 0) {
                            System.out.println("My field");
                            VisualizeField(msg.getFields()[0]);
                            System.out.println("Enemys field");
                            VisualizeField(msg.getFields()[1]);
                        } else if (msg.getCode() == 1) {
                            System.out.println("Enemys field");
                            VisualizeField(msg.getFields()[1]);
                            System.out.println("Wound!");
                            VisualizeField(msg.getFields()[1]);
                        } else if (msg.getCode() == 2) {
                            System.out.println("Enemys field");
                            VisualizeField(msg.getFields()[1]);
                            System.out.println("Killed!");
                        } else if (msg.getCode() == 3) {
                            System.out.println("Missed. Your current situation:");
                            System.out.println("My field");
                            VisualizeField(msg.getFields()[0]);
                            System.out.println("Enemys field");
                            VisualizeField(msg.getFields()[1]);
                            try {
                                TimeUnit.MILLISECONDS.sleep(2000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            continue;
                        } else if (msg.getCode() == 4) {
                            System.out.println("You win!");
                            System.out.println("My field");
                            VisualizeField(msg.getFields()[0]);
                            System.out.println("Enemys field");
                            VisualizeField(msg.getFields()[1]);
                            System.out.println("Winner winner chicken dinner");
                            while (true) {

                            }
//                            return;
                        } else if (msg.getCode() == 5) {
                            System.out.println("You lose!");
                            System.out.println("My field");
                            VisualizeField(msg.getFields()[0]);
                            System.out.println("Enemys field");
                            VisualizeField(msg.getFields()[1]);
                            System.out.println("Enjoy being loser");
                            while (true) {

                            }
//                            return;
                        }
                        String move;
                        while (true) {
                            System.out.println("Enter your move: ");
                            move = scanner.nextLine();
                            if (CheckIfMoveIsValid(move) == true) {
                                break;
                            }
                        }
                        MsgToServer msg_move = new MsgToServer(move);
                        try {
                            dos.writeUTF(gson.toJson(msg_move));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            };
            t.start();
        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        }
    }

    public static void main(String args[]) {
        new Client();
    }

    public void VisualizeField(int[][] field) {
        int[][] new_field = new int[field.length][];
        for (int i = 0; i < field.length; i++) {
            new_field[i] = Arrays.copyOf(field[i], field[i].length);
        }
        char[] mask = new char[]{'.', '@', '#', 'x'};
        char[] alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        for (int x = -1; x < 10; ++x) {
            if (x == -1) {
                System.out.printf("%4c", ' ');
                continue;
            }
            System.out.printf("%4c", alphabet[x]);
        }
        System.out.println();
        for (int y = 0; y < 10; ++y) {
            for (int x = 0; x < 10; ++x) {
                new_field[y][x] = mask[field[y][x]];
                if (x == 0) {
                    System.out.printf("%4d", y + 1);
                }
                System.out.printf("%4c", new_field[y][x]);
            }
            System.out.println();
        }
    }

    public boolean CheckIfMoveIsValid(String move) {
        String[] message_split = move.split(" ");
        if (message_split.length != 2) {
            return false;
        }
        message_split[0] = message_split[0].toUpperCase();
        int[] coords = new int[2];
        coords[1] = message_split[0].toCharArray()[0] - 'A';
        coords[0] = Integer.parseInt(String.valueOf(message_split[1].toCharArray())) - 1;

        for (int i = 0; i < 2; ++i) {
            if (coords[i] < 0 || coords[i] >= 10) {
                return false;
            }
        }
        return true;
    }
}