package com.JakartaEE.TodoApp.Todos.Entity;

import javax.enterprise.inject.Default;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

//Convert PO-JO object to prescience object
@Entity
public class Todo {
    //Make the field id primary key
    @Id
    //Auto generate the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long todoId;

    //validate the field is not Empty "null"
    @NotEmpty(message = "please set the value of this field")
    //validate the value assined to the field is more than 3 character
    @Size(min = 3,message = "please enter a word that is mor than 3 character")
    private String task;

    //validate that the value is not null
    @NotNull(message = "please set the value of this field")
    //validate that the date is in the future of the present
    @FutureOrPresent(message = "the date must be present or future date ")
    //validate the format of the date entered
    @JsonbDateFormat(value = "dd/MM/yyyy")
    private LocalDate dueDate;

    private boolean isCompleted;

    private LocalDate dateCompleted;

    private LocalDate dateCreated;

    //Convert method to callback method in the jpa life cycle
    @PrePersist
    private void init(){
        setDateCreated(LocalDate.now());
    }

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
