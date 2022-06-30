package ClientServerInteraction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.*;
import MsgToClient.MsgToClient;
import MsgToServer.MsgToServer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ClientServerInteraction extends Thread {
    DataInputStream dis;
    DataOutputStream dos;
    Socket cs;
    Model data;
    int player_number;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ClientServerInteraction(Socket cs, Model sd, int player_number) {
        this.cs = cs;
        this.player_number = player_number;
        this.data = sd;
        try {
            this.dis = new DataInputStream(cs.getInputStream());
            this.dos = new DataOutputStream(cs.getOutputStream());
            System.out.println("Sent notification that player " + (this.player_number + 1) + " has been connected" + "\n");
            String s_string = gson.toJson("You have been connected to the server");
            try {
                dos.writeUTF(s_string);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            this.data.getReady_to_play()[player_number] = true;
            this.start();
        } catch (IOException ex) {
            Logger.getLogger(ClientServerInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void run() {

        while (!(data.Ready())) {
            System.out.println("Waiting for players...");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Starting the game...");

        System.out.println("Sending to clients their randomly generated feilds");
        MsgToClient msg_init = new MsgToClient(this.player_number, -1, data.get_fields(this.player_number));
        try {
            dos.writeUTF(gson.toJson(msg_init));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (!(data.GameIsEnd())) {
            while (this.player_number != data.getTurn() && !(data.GameIsEnd())) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.GameIsEnd()) {
                break;
            }
            boolean has_changed = false;
            while (true) {
                if (has_changed) {
                    break;
                }
                try {
                    MsgToClient msg = new MsgToClient(data.getTurn(), 0, data.get_fields(data.getTurn()));
                    dos.writeUTF(gson.toJson(msg));
                } catch (IOException ex) {
                }
                while (true) {

                    MsgToServer msg = null;
                    try {
                        msg = gson.fromJson(dis.readUTF(), MsgToServer.class);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    MsgToClient response_to_move = data.ProcessMove(msg);
                    try {
                        dos.writeUTF(gson.toJson(response_to_move));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }

                    if (response_to_move.getCode() == 3) {
                        // this.data.getTurn() = 1 - this.data.getTurn(); ???? Java dura?
                        if (this.data.getTurn() == 0) {
                            this.data.setTurn(1);
                        } else {
                            this.data.setTurn(0);
                        }
                        has_changed = true;
                        break;
                    }

                    if (response_to_move.getCode() == 4) {
                        has_changed = true;
                        break;
                    }
                }
            }
        }

        if (data.GameIsEnd()) {
            if (player_number == data.GetWinner()) {
                System.out.println("Sending to player " + player_number + " that he won");
                MsgToClient msg = new MsgToClient(player_number, 4, data.get_fields(player_number));
                try {
                    dos.writeUTF(gson.toJson(msg));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Sending to player " + player_number + " that he lost");
                MsgToClient msg = new MsgToClient(player_number, 5, data.get_fields(player_number));
                try {
                    dos.writeUTF(gson.toJson(msg));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
