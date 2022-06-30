package Client;

import TestingSystem.*;
import TestingSystem.Server;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    static TestingSystem service_port;
    public static final String url = "http://127.0.0.1:8080/TestingSystemOganyan";

    public static void main(String[] args) throws Exception {
        service_port = new TestingSystemService().getTestingSystemPort();
        System.out.println("Hello student!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
            System.out.println();
            System.out.println("To choose command type:");
            System.out.println("1 to see list of tests");
            System.out.println("2 to start test");
            System.out.println("3 to get next task(question) of test");
            System.out.println("4 to answer the question");
            System.out.println("5 to finish the test");
            System.out.println("6 to get results of test");
            System.out.println("7 to quit");
            System.out.println("Your input: ");

            String input = scanner.nextLine();
            if (input.equals("1")) {

                List<PairTestId> list = service_port.getTestsList();
                System.out.println("List of all available tests");
                for (int i = 0; i < list.size(); ++i) {
                    System.out.println("Test " + "'" + list.get(i).getName() + "'"
                            + " with id: " + list.get(i).getId());
                }
                list.get(0).getId();

            } else if (input.equals("2")) {
                System.out.println("Enter test's id to start the test ");
                int id = Integer.parseInt(scanner.nextLine());
                service_port.startTest(id);
                System.out.println();
            } else if (input.equals("3")) {
                System.out.println("Enter test's id to get next question");
                int id = Integer.parseInt(scanner.nextLine());
                DataNextQuestion  question = service_port.getNextQuestionOfTest(id);
                System.out.println("Q: " + question.getQuestion() + " Id: " + question.getIdQuestion());
                System.out.println("Possible Answers: ");
                for (int i = 0; i < question.getAnswers().size(); ++i) {
                    System.out.println(question.getAnswers().get(i).getId() + ". " +
                            question.getAnswers().get(i).getText());
                }
            } else if (input.equals("4")) {
                System.out.println("Enter question's id to answer it");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter right answers: ");
                String answers = scanner.nextLine();

                String[] strArray = answers.split(" ");
                int[] intArray = new int[strArray.length];
                for(int i = 0; i < strArray.length; i++) {
                    intArray[i] = Integer.parseInt(strArray[i]);
                }
                List<Integer> kostil_for_stupid_java = new ArrayList<Integer>(){};
                for (int j = 0; j < intArray.length; ++j) {
                    kostil_for_stupid_java.add(intArray[j]);
                }
                service_port.processTheAnswer(id, kostil_for_stupid_java);
                System.out.println("Your answer has been accepted");

            } else if (input.equals("5")) {
                System.out.println("Enter test's id to finish");
                int id = Integer.parseInt(scanner.nextLine());
                service_port.finishTest(id);
                System.out.println();
            } else if (input.equals("6")) {
                System.out.println("Enter test's id to see your score");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Your score of test " + id + " is: "
                        + service_port.getPoints(id));
            } else if (input.equals("7")) {
                System.out.println("End of session...");
                break;
            } else {
                System.out.println("Wrong input. Try again");
            }
        }

    }
}
