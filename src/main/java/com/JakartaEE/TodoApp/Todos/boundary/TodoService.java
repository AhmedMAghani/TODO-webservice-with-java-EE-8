package com.JakartaEE.TodoApp.Todos.boundary;

import com.JakartaEE.TodoApp.Todos.Entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TodoService {
    final String selectAllStmt ="SELECT t FROM Todo t";
    private Todo currentTodo;

    @PersistenceContext
    EntityManager entityManager;

    public Todo creatTodo(Todo todo){
        //persist into DB
        entityManager.persist(todo);
        return todo;
    }

    public Todo updateTodo(Todo todo){
        //persist into DB
        entityManager.merge(todo);
        return todo;
    }

    public Todo setCompleted(Long id){
        currentTodo = findTodoById(id);
        currentTodo.setCompleted(true);
        entityManager.merge(currentTodo);
        return currentTodo;
    }

    public Todo findTodoById(Long id){
        return entityManager.find(Todo.class,id);
    }

    public List<Todo> findAllTodo(){
        return entityManager.createQuery(selectAllStmt,Todo.class).getResultList();
    }
}
