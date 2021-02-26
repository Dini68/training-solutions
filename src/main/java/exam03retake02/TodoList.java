package exam03retake02;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return todos;
    }


    public void addTodo (String text, int priority) {
        todos.add(new Todo(text, priority));
    }

    public int getNumberOfItemsLeft() {
        int number = 0;
        for (Todo t: getTodos()) {
            if (t.getState() == State.NON_COMPLETED) {
                number ++;
            }
        }
        return number;
    }

    public List<Todo> getMostImportantTodosText() {
        List<Todo> result = new ArrayList<>();
        int prior = 6;
        for (Todo t: getTodos()) {
            if (t.getPriority() < prior) {
                prior = t.getPriority();
            }
        }
        for (Todo t: getTodos()) {
            if (t.getPriority() == prior) {
                result.add(t);
            }
        }
        return result;
    }

    public void deleteCompleted() {
        List<Todo> result = new ArrayList<>();
        for (Todo t: getTodos()) {
            if (t.getState() == State.NON_COMPLETED) {
                result.add(t);
            }
        }
        todos = result;
    }
}
