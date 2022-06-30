package Client;

import TestingSystem.*;
import TestingSystem.Server;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher {
    static TestingSystem service_port;
    public static final String url = "http://127.0.0.1:8080/TestingSystemOganyan";

    public static void main(String[] args) throws Exception {
        service_port = new TestingSystemService().getTestingSystemPort();
        System.out.println("Hello teacher!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
            System.out.println();
            System.out.println("To choose command type: ");
            System.out.println("1 to create new test");
            System.out.println("2 to add new question");
            System.out.println("3 to add answers list to the question");
            System.out.println("4 to quit");
            System.out.println("Your input: ");

            String input = scanner.nextLine();
            if (input.equals("1")) {
                System.out.println("Enter name of new test");
                String name = scanner.nextLine();
                System.out.println("Id of " + name + " is: " + service_port.createTest(name));
            } else if (input.equals("2")) {
                System.out.println("Enter the content of new question");
                String content = scanner.nextLine();
                System.out.println("Enter id of test");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Id of new question is: " + service_port.addNewTask(content, id));
            } else if (input.equals("3")) {
                System.out.println("Enter id of task(question)");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter count of possible answers");
                int cnt = Integer.parseInt(scanner.nextLine());
                ArrayList<String> texts = new ArrayList<String>();
                ArrayList<Boolean> right = new ArrayList<Boolean>();
                ArrayList<ArrayList<Integer>> points = new ArrayList<ArrayList<Integer>>();
                for (int i = 0; i < cnt; ++i) {
                    System.out.printf("Enter answer number %d 's data (text, right or wrong, 4 sets of points): \n",
                            i + 1);
                    System.out.println("Enter text: ");
                    String content = scanner.nextLine();
                    texts.add(content);

                    System.out.println("Enter right (1) or wrong (0)");
                    Boolean right_or_wrong = "1".equals(scanner.nextLine());
                    right.add(right_or_wrong);

                    System.out.println("Enter 4 sets of points");
                    ArrayList kostil_for_stupid_java = new ArrayList(4);
                    points.add(kostil_for_stupid_java);
                    for (int j = 0; j < 4; ++j) {
                        points.get(points.size() - 1).add(Integer.parseInt(scanner.nextLine()));
                    }

                }
                ArrayList<IntArray> CYKAEBANAYA = new ArrayList<IntArray>(4);
                ArrayList<IntArray> points_for_stupid_java = new ArrayList<IntArray>();
                for (int i = 0; i < points.size(); ++i) {
                    points_for_stupid_java.add(new IntArray());
                    for (int j = 0; j < 4; ++j) {
                        points_for_stupid_java.get(i).getItem().add(points.get(i).get(j));
                    }
                }
                service_port.addAnswersToQuestion(id, texts,
                        right, points_for_stupid_java);

            } else if (input.equals("4")) {
                System.out.println("End of session...");
                break;
            } else {
                System.out.println("Wrong input. Try again");
            }
        }
    }
}
