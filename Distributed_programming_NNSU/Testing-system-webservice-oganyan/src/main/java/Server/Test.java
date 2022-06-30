package Server;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Test {
    String name;
    int id;
    HashMap<Integer, Task> tasks;
//    ArrayList<Task> tasks;

    public Test() {
        tasks = new HashMap<Integer, Task>();
    }

    public Test(String name, int id) {
        this.id = id;
        this.name = name;
        tasks = new HashMap<Integer, Task>();
    }

    Task GetTask(int id) {
        return tasks.get(id);
    }

    int AddNewTask(String question) {
        int task_id = this.id * 1000 + this.tasks.size();

        tasks.put(task_id, new Task(question, task_id));
        return task_id;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

}
