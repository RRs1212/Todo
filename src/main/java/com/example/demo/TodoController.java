package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos/api")
public class TodoController {

    Todoservice todoservice;

    private List<Todo> TodoList;

    TodoController(Todoservice ts){
        TodoList=new ArrayList<>();
        TodoList.add(new Todo(1,true,"asdf,",123));
        TodoList.add(new Todo(2,true,"fire",121));
        TodoList.add(new Todo(3,false,"fire",234));
        this.todoservice=ts;


    }
    @GetMapping()
    public ResponseEntity<List<Todo>> getTodoList() {
        todoservice.dosomething();



        return ResponseEntity.ok(TodoList);

    }

    @PostMapping()
    public Todo CreateTodo(@RequestBody Todo newTodo){
        TodoList.add(newTodo);
        return newTodo;
    }

    @GetMapping("/{id}")
    public Todo GetTodoById(@PathVariable long id) {

        for (Todo todo : TodoList) {
            if (todo.getId() == id) {
                return todo;
            }
        }

        return null;
//    }
//    @GetMapping("/todos/{todoId}")
//    public ResponseEntity<Todo> getTodoById(@PathVariable long todoId) {
//        for (Todo todo : TodoList) {
//            if (todo.getId() == todoId) {
//                return ResponseEntity.ok(todo);
//            }
//        }
//        // HW: Along with 404 status code, try to send a json {message: Todo not found}
//        return ResponseEntity.notFound().build();
//    }

    }


}
