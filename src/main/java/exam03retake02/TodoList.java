package exam03retake02;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<Todo> todoList = new ArrayList<>();

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void addTodo (Todo todo) {
        todoList.add(todo);
    }

    public void addTodo (String text, int priority) {
        todoList.add(new Todo(text, priority));
    }

    public int getNumberOfItemsLeft() {
        int number = 0;
        for (Todo t: getTodoList()) {
            if (t.getState() == State.NON_COMPLETED) {
                number ++;
            }
        }
        return number;
    }
}
