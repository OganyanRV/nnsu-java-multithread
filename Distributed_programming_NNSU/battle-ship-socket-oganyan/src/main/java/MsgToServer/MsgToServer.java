package MsgToServer;

import java.io.Serializable;

public class MsgToServer implements Serializable {
    String move;

    public MsgToServer(String move) {
        this.move = move;
    }


    public String GetMove() {
        return move;
    }

    public void SetMove(String move) {
        this.move = move;
    }
}


