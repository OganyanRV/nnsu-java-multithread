package Print;

public class Print {
    static public <T extends Number> void print(T params) {
        System.out.println(params);
    }

    static public <T extends String> void print(T params) {
        System.out.println(params);
    }
}
