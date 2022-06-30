package lab4;

public class Msg {
    String msg;
    int code;
    // 0 - set alarm, 1 - time, 2 - alarm working

    public Msg(String msg) {
        this.msg = msg;
        code = 0;
    }
    public Msg(String msg,int code) {
        this.msg = msg;
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

//    public void setCode(int code) {
//        this.code = code;
//    }
}
