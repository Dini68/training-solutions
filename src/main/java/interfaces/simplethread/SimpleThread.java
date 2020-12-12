package interfaces.simplethread;

import java.util.ArrayList;
import java.util.List;

public class  SimpleThread implements Runnable {

    private List<String> tasks = new ArrayList<>();

    public void run() {
        while (nextStep()) {
            nextStep();
        }
    }

    public List<String> getTasks() {
        return tasks;
    }

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }

    private boolean nextStep() {
        tasks.remove(tasks.lastIndexOf(tasks));
        return tasks.size() > 0;
    }
}
