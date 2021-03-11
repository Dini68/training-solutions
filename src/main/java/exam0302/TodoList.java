package exam0302;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return new ArrayList<>(todos);
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public int getNumberOfItemsLeft() {
        int number = 0;
        for (Todo t: todos) {
            if (t.getState() == State.NON_COMPLETED) {
                number ++;
            }
        }
        return number;
    }

    public List<String> getMostImportantTodosText() {
        List<String> result = new ArrayList<>();
        int prior = 5;
        for (Todo t: todos) {
            if (t.getPriority() < prior) {
                prior = t.getPriority();
            }
        }
        for (Todo t: todos) {
            if (t.getPriority() == prior) {
                result.add(t.getText());
            }
        }

        return result;
    }

    public void deleteCompleted() {

//        for (Todo todo: todos) {
//            if (todo.getState() == State.COMPLETED) {
//                todos.remove(todo);
//            }
//        }
        Iterator<Todo> it = todos.iterator();
        while (it.hasNext()) {
            Todo next = it.next();
            if (next.getState() == State.COMPLETED) {
                it.remove();
            }
        }
    }
}
