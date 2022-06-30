package Server;

import javax.jws.WebService;
import java.util.ArrayList;

public class Task {
    String question;
    int id;
    ArrayList<Answer> answers;

    public Task() {
        answers = new ArrayList<Answer>();
    }

    public Task(String text, int id) {
        this.id = id;
        question = text;
        answers = new ArrayList<Answer>();
    }

    public void AddAnswers(String[] answers_str,
                      Boolean[] right, int[][] points) {
        for (int i = 0; i < answers_str.length; ++i) {
            Answer ans = new Answer(answers_str[i], right[i], points[i]);
            this.answers.add(ans);
        }

    }

}
