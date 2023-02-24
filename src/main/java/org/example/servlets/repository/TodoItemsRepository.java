package org.example.servlets.repository;

import org.example.servlets.model.TodoItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoItemsRepository {
    private static TodoItemsRepository instance = null;

    public static TodoItemsRepository getInstance() {
        if (instance == null) {
            instance = new TodoItemsRepository();

            Collections.addAll(instance.todoItems,
                    new TodoItem(1,"2003-10-25","aaa"),
                    new TodoItem(2,"2005-12-21","bbb"),
                    new TodoItem(3,"2018-01-24","ccc")
            );
        }
        return instance;
    }

    private List<TodoItem> todoItems;

    public TodoItemsRepository() {
        todoItems = new ArrayList<>();
    }

    public void addNew(TodoItem todoItem) {
        todoItems.add(todoItem);
    }

    public List<TodoItem> getAll() {
        return todoItems;
    }
}
