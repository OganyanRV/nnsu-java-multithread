package Server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@WebService
public class TestingSystem {
    HashMap<Integer, Test> tests;
    HashMap<Integer, Integer> final_scores;
    HashMap<Integer, Integer> current_scores;

    HashMap<Integer, Iterator> current_tasks;


    boolean test_in_process = false;
    Test cur_test;


    public TestingSystem() {
        tests = new HashMap<Integer, Test>();
        final_scores = new HashMap<Integer, Integer>();
        current_scores = new HashMap<Integer, Integer>();
        current_tasks = new HashMap<Integer, Iterator>();
    }

    //  For Teachers

    @WebMethod
    public int CreateTest(String name) {
        Integer id = tests.size();
        tests.put(id, new Test(name, id));
        final_scores.put(id, -1);
        current_scores.put(id, 0);
        current_tasks.put(id, tests.get(id).tasks.entrySet().iterator());
        return id;
    }

    @WebMethod
    public int AddNewTask(String question, int test_id) {
        return tests.get(test_id).AddNewTask(question);
    }

    @WebMethod
    public void AddAnswersToQuestion(int task_id, String[] answers,
                                     Boolean[] right, int[][] points) {
        int test_id = task_id / 1000;
        Test cur_test = tests.get(test_id);
        Task cur_task = cur_test.tasks.get(task_id);
        cur_task.AddAnswers(answers, right, points);
    }

    //  For Students

    @WebMethod
    public ArrayList<PairTestId> GetTestsList() {
        ArrayList<PairTestId> test_list = new ArrayList<PairTestId>();
        Iterator it = tests.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            test_list.add(new PairTestId((Integer) (entry.getKey()),
                    ((Test) (entry.getValue())).getName()));
        }
        return test_list;
    }

    @WebMethod
    public void StartTest(int test_id) {
        current_scores.put(test_id, 0);
        current_tasks.put(test_id, tests.get(test_id).tasks.entrySet().iterator());
    }

    @WebMethod
    public DataNextQuestion GetNextQuestionOfTest(int test_id) {
        Iterator it = current_tasks.get(test_id);
        DataNextQuestion ans = new DataNextQuestion("Something went wrong", 0, new Answer[]{});
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Task cur_task = (Task) (entry.getValue());
            ans = new DataNextQuestion(cur_task.question, (int) (entry.getKey()),
                    cur_task.answers.toArray(new Answer[]{}));
        }
        return ans;
    }

    @WebMethod
    public void ProcessTheAnswer(int task_id, int[] ans) {
        int test_id = task_id / 1000;
        Test cur_test = tests.get(test_id);
        Task cur_task = cur_test.tasks.get(task_id);
        Answer[] answers = cur_task.answers.toArray(new Answer[]{});

        // 1 - ans is correct and student chose it. +points
        // 2 - ans is correct and student didnt choose it. -points
        // 3 - ans is wrong and student chose it. -points
        // 4 - ans is wrong and student didnt choose it. + points

        int cur_points = 0;

        for (int i = 0; i < ans.length; ++i) {
            for (int j = 0; j < answers.length; ++j) {
                // student chose answer
                if (ans[i] == j) {
                    // ans is correct
                    if (answers[j].right) {
                        cur_points += answers[j].points[0];
                    }
                    // ans is wrong
                    else {
                        cur_points -= answers[j].points[2];
                    }
                }
                //  Student didnt choose answer
                else {
                    // ans is correct
                    if (answers[j].right) {
                        cur_points -= answers[j].points[1];
                    }
                    // ans is wrong
                    else {
                        cur_points += answers[j].points[3];
                    }

                }
            }
        }

        this.current_scores.put(test_id, this.current_scores.get(test_id) + cur_points);
    }

    @WebMethod
    public void FinishTest(int test_id) {
        final_scores.put(test_id, current_scores.get(test_id));
        current_scores.put(test_id, 0);
        current_tasks.put(test_id, tests.get(test_id).tasks.entrySet().iterator());
    }

    @WebMethod
    public int GetPoints(int test_id) {
        return final_scores.get(test_id);
    }
}
