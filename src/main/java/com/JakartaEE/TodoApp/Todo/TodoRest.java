package com.JakartaEE.TodoApp.Todo;

import com.JakartaEE.TodoApp.Todos.Entity.Todo;
import com.JakartaEE.TodoApp.Todos.boundary.TodoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {

    @Inject
    TodoService todoService;

    @Path("new")
    @POST
    public Response createTodo(Todo todo){
        //api/v1/todo/new
        todoService.creatTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("update")
    @PUT
    public Response updateTodo(Todo todo){
        //api/v1/todo/update
        todoService.updateTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("{todoId}")
    @GET
    public Todo findTodoById(@PathParam("todoId")Long id){
        //api/v1/todo/find
        return todoService.findTodoById(id);
    }

    @Path("findAll")
    @GET
    public List<Todo> findAllTodo(){
        //api/v1/todo/findAll
        return todoService.findAllTodo();
    }

    @Path("setCompleted")
    @PUT
    public Response setCompleted(@QueryParam("todoId") Long id){
        //api/v1/todo/setCompleted
        return Response.ok(todoService.setCompleted(id)).build();
    }
}
