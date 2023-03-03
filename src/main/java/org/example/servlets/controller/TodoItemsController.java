package org.example.servlets.controller;

import com.google.gson.Gson;
import org.example.servlets.model.TodoItem;
import org.example.servlets.repository.TodoItemsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@WebServlet("/todoitems")
public class TodoItemsController extends HttpServlet {

    private TodoItemsRepository todoItemsRepository;
    private Gson gson;

    public TodoItemsController() {
        todoItemsRepository = TodoItemsRepository.getInstance();
        gson = new Gson();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TodoItem> todoItems = todoItemsRepository.getAll();
        String todoItemsAsJson = gson.toJson(todoItems);

        response.setContentType("application/json;charset=UTF-8");

        response.getWriter().println(todoItemsAsJson);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader reader = request.getReader();

        StringBuilder buffer = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
            buffer.append(System.lineSeparator());
        }

        String json = buffer.toString();

        TodoItem todoItem = gson.fromJson(json, TodoItem.class);
        todoItemsRepository.addNew(todoItem);
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        todoItemsRepository.deleteById(id);
    }
}
