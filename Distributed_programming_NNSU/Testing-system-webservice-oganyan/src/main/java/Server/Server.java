package Server;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;


public class Server {
    public static final String url = "http://127.0.0.1:8080/TestingSystemOganyan";

    public static void main(String[] args) {
        TestingSystem testing_system = new TestingSystem();
        Endpoint.publish(url, testing_system);
        System.out.println("WebService started");
    }


}
