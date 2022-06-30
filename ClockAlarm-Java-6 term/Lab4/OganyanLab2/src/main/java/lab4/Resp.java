package lab4;

import java.util.ArrayList;
import java.util.List;

public class Resp {
    ArrayList<Msg> ListMsg= new ArrayList<>();

    void add(Msg s) {
        ListMsg.add(s);
    }

    public ArrayList<Msg> getListMsg() {
        return ListMsg;
    }

    public int size() {
        return ListMsg.size();
    }
}
