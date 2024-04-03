package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class AmotherTodoService implements Todoservice {


    @Override
    public void dosomething() {
        System.out.println("doing something another");

    }
}
