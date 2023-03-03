package org.example.servlets.model;

public class TodoItem {
    private int id;
    private String date;
    private String description;

    public TodoItem(int id, String date, String description) {
        this.id = id;
        this.date = date;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
