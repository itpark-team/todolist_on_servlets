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
        response.setContentType("application/json;charset=UTF-8");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Expose-Headers", "*");
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        List<TodoItem> todoItems = todoItemsRepository.getAll();
        String todoItemsAsJson = gson.toJson(todoItems);

        response.getWriter().println(todoItemsAsJson);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Expose-Headers", "*");
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

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

        response.getWriter().println("sss");
    }

//    @Override
//    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        setAccessControlHeaders(resp);
//        resp.setStatus(HttpServletResponse.SC_OK);
//    }
//
//    private void setAccessControlHeaders(HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//    }
}
