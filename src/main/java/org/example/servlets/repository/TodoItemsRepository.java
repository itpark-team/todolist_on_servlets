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
        }
        return instance;
    }

    private List<TodoItem> todoItems;
    private int globalId;

    private TodoItemsRepository() {
        todoItems = new ArrayList<>();
        globalId = 0;

        addNew(new TodoItem(0, "2003-10-25", "aaa"));
        addNew(new TodoItem(0, "2005-12-21", "bbb"));
        addNew(new TodoItem(0, "2018-01-24", "ccc"));
    }

    public void addNew(TodoItem todoItem) {
        globalId++;
        todoItem.setId(globalId);

        todoItems.add(todoItem);
    }

    public List<TodoItem> getAll() {
        return todoItems;
    }
}
