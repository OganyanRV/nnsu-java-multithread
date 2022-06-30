package Server;

public class DataNextQuestion {
    String question;
    int id_question;
    PairStringInt[] answers;

    DataNextQuestion(String text, int id_question, Answer[] answers) {
        this.question = text;
        this.id_question=id_question;
        this.answers = new PairStringInt[answers.length];
        for (int i = 0; i <answers.length; ++i) {
            this.answers[i] = new PairStringInt(answers[i].getText(), i);
        }
    }

    public String getQuestion() {
        return question;
    }

    public int getId_question() {
        return id_question;
    }

    public PairStringInt[] getAnswers() {
        return answers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public void setAnswers(PairStringInt[] answers) {
        this.answers = answers;
    }
}
