package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public void addTodo(String caption) {
        Todo newTodo = new Todo(caption);
        todos.add(newTodo);
    }

    public void finishTodos(String caption) {
        for (Todo t: todos
             ) {
            if (t.getCaption().equals(caption)) {
                t.finish();
            }
        }
    }

    public void finishAllTodos (List<String> todosToFinish) {
        for (String s:todosToFinish
             ) {
            finishTodos(s);
        }
    }

    public  List<String> todosToFinish() {
        List<String> todosToFinishList = new ArrayList<>();
        todosToFinishList.add("találkozó");
        todosToFinishList.add("bevásárlás");
        todosToFinishList.add("fogorvos");
        return todosToFinishList;
    }

    public int numberOfFinishedTodos() {
        int number = 0;
        for (Todo t: todos
             ) {
            if (t.isFinished()) {
                number ++;
            }
        }
        return number;
    }
}
