package org.example.servlets.repository;

import org.example.servlets.model.TodoItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoItemsRepository {

    private SessionFactory sessionFactory;

    public TodoItemsRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNew(TodoItem todoItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(todoItem);

        transaction.commit();
        session.close();
    }

    public List<TodoItem> getAll() throws ServletException {
        return (List<TodoItem>) sessionFactory.openSession().createQuery("FROM TodoItem ORDER BY id").list();
    }

    public void deleteById(int id) {
        TodoItem todoItem = TodoItem.builder().id(id).build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(todoItem);

        transaction.commit();
        session.close();
    }
}
