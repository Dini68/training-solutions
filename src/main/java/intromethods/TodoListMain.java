package intromethods;

import java.util.ArrayList;
import java.util.Arrays;

public class TodoListMain {

    public static void main(String[] args) {

        TodoList todoList = new TodoList();

        todoList.addTodo("Tanulás");
        todoList.addTodo("Bevásárlás");
        todoList.addTodo("Foci");
        todoList.addTodo("Megbeszélés");
        todoList.addTodo("Fogorvos");

        System.out.println(todoList.numberOfFinishedTodos());

        System.out.println(todoList.todosToFinish());

        todoList.finishTodos("Megbeszélés");

        System.out.println(todoList.numberOfFinishedTodos());

        System.out.println(todoList.todosToFinish());

        todoList.finishAllTodos(Arrays.asList("Fogorvos","Foci"));

        System.out.println(todoList.todosToFinish());

        System.out.println(todoList.numberOfFinishedTodos());

        System.out.println(todoList.toString());


    }
}
