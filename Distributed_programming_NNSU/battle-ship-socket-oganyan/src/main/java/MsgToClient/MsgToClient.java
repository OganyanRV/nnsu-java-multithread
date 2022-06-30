package MsgToClient;


import java.io.Serializable;

public class MsgToClient implements Serializable {
    int player;
    // 0 - first
    // 1 - second;
    int code;
    //  -1 - init fields
    //  0 - Begin of your turn
    //  1 - U hit the ship, still your turn
    //  2 - U killed the ship, still your turn
    //  3 - end of turn
    //  4 - end of the game, u win
    //  5 - end of the game, u lose
    int[][][] fields = new int[2][10][10];

    public MsgToClient(int code) {
        this.code = code;
    }

    public MsgToClient(int player, int code, int[][][] fields) {
        this.player = player;
        this.code = code;
        this.fields = fields;
    }

    public int getCode() {
        return code;
    }

    public int[][][] getFields() {
        return fields;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public void setFields(int[][][] fields) {
        this.fields = fields;
    }
}



