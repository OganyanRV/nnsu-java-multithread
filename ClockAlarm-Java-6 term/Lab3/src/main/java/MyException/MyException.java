package MyException;

public class MyException extends Exception {
    // переопределить метод toString(), описывающий исключение
    public String toString() {
        return "Incorrect data";
    }
}
